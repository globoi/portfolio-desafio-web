import { loadTemplate } from '../../../js/utils/dom-functions.js';

// Mock para fetch
global.fetch = jest.fn();

describe('Testando as funções de manipulação do DOM no arquivo dom-functions.js', () => {
    beforeEach(() => {
        fetch.mockClear();
    });

    it('deve retornar o template quando a resposta for bem-sucedida', async () => {
        const mockTemplate = '<div>Template</div>';
        fetch.mockResolvedValue({
            ok: true,
            text: jest.fn().mockResolvedValue(mockTemplate),
        });

        const result = await loadTemplate('http://example.com/template.html');
        expect(result).toBe(mockTemplate);
    });

    it('deve lançar um erro quando a resposta não for bem-sucedida', async () => {
        fetch.mockResolvedValue({
            ok: false,
            statusText: 'Not Found',
        });

        console.error = jest.fn(); // Mock console.error

        const result = await loadTemplate('http://example.com/template.html');
        expect(result).toBeUndefined();
        expect(console.error).toHaveBeenCalledWith('Erro:', new Error('Erro ao carregar o template: Not Found'));
    });

    it('deve capturar e exibir um erro em caso de exceção', async () => {
        fetch.mockRejectedValue(new Error('Erro de conexão'));

        console.error = jest.fn(); // Mock console.error

        const result = await loadTemplate('http://example.com/template.html');
        expect(result).toBeUndefined();
        expect(console.error).toHaveBeenCalledWith('Erro:', new Error('Erro de conexão'));
    });
});