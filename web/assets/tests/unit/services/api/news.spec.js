import { getNews, getNewsGroup, getMainNews } from '../../../../js/services/api/news';
import { BASE_URL, ENDPOITS } from '../../../../js/utils/services/api-urls';

// Mock para fetch
global.fetch = jest.fn();

describe('Testando as funções de datas e horas do arquivo helpers.js', () => {
    beforeEach(() => {
        fetch.mockClear();
    });

    it('deve buscar notícias e filtrar pelo tipo', async () => {
        const mockNews = [
            { id: 1, type: 'materia', title: 'Notícia 1' },
            { id: 2, type: 'agrupador-materia', title: 'Agrupador' },
            { id: 3, type: 'materia', title: 'Notícia 2' },
        ];

        fetch.mockResolvedValueOnce({
            ok: true,
            json: jest.fn().mockResolvedValue(mockNews),
        });

        const result = await getNews(1, 'materia');
        expect(fetch).toHaveBeenCalledWith(`${BASE_URL}${ENDPOITS.FEED}/${ENDPOITS.PAGE}/1`);
        expect(result).toEqual([
            { id: 1, type: 'materia', title: 'Notícia 1' },
            { id: 3, type: 'materia', title: 'Notícia 2' },
        ]);
    });

    it('deve retornar um array vazio quando nenhum dado corresponder ao tipo', async () => {
        const mockNews = [
            { id: 1, type: 'agrupador-materia', title: 'Agrupador' },
        ];

        fetch.mockResolvedValueOnce({
            ok: true,
            json: jest.fn().mockResolvedValue(mockNews),
        });

        const result = await getNews(1, 'materia');
        expect(result).toEqual([]);
    });
});

describe('getNewsGroup', () => {
    it('deve retornar notícias do tipo "agrupador-materia"', async () => {
        const mockNews = [
            { id: 1, type: 'agrupador-materia', title: 'Agrupador 1' },
            { id: 2, type: 'materia', title: 'Notícia 1' },
        ];

        fetch.mockResolvedValueOnce({
            ok: true,
            json: jest.fn().mockResolvedValue(mockNews),
        });

        const result = await getNewsGroup();
        expect(result).toEqual([{ id: 1, type: 'agrupador-materia', title: 'Agrupador 1' }]);
    });
});

describe('getMainNews', () => {
    it('deve retornar as duas primeiras notícias do tipo "materia"', async () => {
        const mockNews = [
            { id: 1, type: 'materia', title: 'Notícia 1' },
            { id: 2, type: 'materia', title: 'Notícia 2' },
            { id: 3, type: 'materia', title: 'Notícia 3' },
        ];

        fetch.mockResolvedValueOnce({
            ok: true,
            json: jest.fn().mockResolvedValue(mockNews),
        });

        const result = await getMainNews();
        expect(result).toEqual([
            { id: 1, type: 'materia', title: 'Notícia 1' },
            { id: 2, type: 'materia', title: 'Notícia 2' },
        ]);
    });

    it('deve retornar apenas as notícias disponíveis se houver menos de 2', async () => {
        const mockNews = [
            { id: 1, type: 'materia', title: 'Notícia 1' },
        ];

        fetch.mockResolvedValueOnce({
            ok: true,
            json: jest.fn().mockResolvedValue(mockNews),
        });

        const result = await getMainNews();
        expect(result).toEqual([{ id: 1, type: 'materia', title: 'Notícia 1' }]);
    });
});