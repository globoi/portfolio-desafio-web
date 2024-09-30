import { prepareLink, linkOpen, removeSkeleton } from '../../../js/utils/news-functions.js';
import { loadTemplate } from '../../../js/utils/dom-functions.js';

// Mocks do Jest
jest.mock('../../../js/utils/dom-functions.js', () => ({
    loadTemplate: jest.fn(),
}));
jest.mock('../../../js/utils/dates-functions.js', () => ({
    formatDateByTime: jest.fn(),
    formatTimeByMs: jest.fn(),
}));


describe('prepareLink: Testando as funções do arquivo news-functions.js', () => {
    let newsContent, newsItem;

    beforeEach(() => {
        newsContent = document.createElement('div');
        newsContent.innerHTML = '<a href="#"></a>';
        newsItem = { url: 'http://example.com/', video: null };
    });

    it('deve atualizar o href dos links com o url da notícia', () => {
        prepareLink(newsContent, newsItem);
        const linkElement = newsContent.querySelector('a');
        expect(linkElement.href).toBe(newsItem.url);
    });

    it('deve adicionar atributos relacionados a vídeos quando há vídeo no newsItem', () => {
        newsItem.video = { source: 'video.mp4', programTitle: 'Programa' };
        prepareLink(newsContent, newsItem);
        const linkElement = newsContent.querySelector('a');
        expect(linkElement.getAttribute('video-source')).toBe('video.mp4');
        expect(linkElement.getAttribute('program-title')).toBe('Programa');
    });
});

describe('linkOpen: Testando as funções do arquivo news-functions.js', () => {
    let mockEvent;

    beforeEach(() => {
        mockEvent = {
            preventDefault: jest.fn(),
        };

        // Mock do template de modal com os elementos necessários
        loadTemplate.mockResolvedValue(`
            <div id="modal-video">
                <source />
                <div id="caption"></div>
                <button class="close"></button>
            </div>
        `);
    });

    it('deve chamar preventDefault se houver "video-source" no elemento', async () => {
        const linkElement = document.createElement('a');
        linkElement.setAttribute('video-source', 'video.mp4');
        await linkOpen.call(linkElement, mockEvent);
        expect(mockEvent.preventDefault).toHaveBeenCalled();
    });

    it('não deve chamar preventDefault se não houver "video-source"', async () => {
        const linkElement = document.createElement('a');
        await linkOpen.call(linkElement, mockEvent);
        expect(mockEvent.preventDefault).not.toHaveBeenCalled();
    });
});

describe('removeSkeleton: Testando as funções do arquivo news-functions.js', () => {
    let mainElement;

    beforeEach(() => {
        mainElement = document.createElement('div');
        mainElement.innerHTML = '<div class="skeleton"></div>';
    });

    it('deve remover o elemento skeleton do mainElement', () => {
        removeSkeleton(mainElement, '.skeleton');
        expect(mainElement.querySelector('.skeleton')).toBeNull();
    });
});
