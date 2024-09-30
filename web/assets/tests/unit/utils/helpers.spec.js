import { timer } from '../../../js/utils/helpers.js';

describe('Testando as funções utilitárias do arquivo helpers.js', () => {
    beforeAll(() => {
        jest.useFakeTimers();
    });

    afterAll(() => {
        jest.useRealTimers();
    });

    it('deve resolver a promessa após o tempo correto', async () => {
        const mockFn = jest.fn();

        // Inicia a função timer e não aguardamos imediatamente
        const promise = timer(1000).then(mockFn);

        // O setTimeout ainda não foi executado
        expect(mockFn).not.toHaveBeenCalled();

        // Avança o tempo em 1000ms (1 segundo)
        jest.advanceTimersByTime(1000);

        // Aguarda a resolução da promessa
        await promise;

        expect(mockFn).toHaveBeenCalledTimes(1);
    });

    it('deve funcionar corretamente para múltiplos timers', async () => {
        const mockFn1 = jest.fn();
        const mockFn2 = jest.fn();

        // Inicia dois timers com tempos diferentes
        const promise1 = timer(500).then(mockFn1);
        const promise2 = timer(1000).then(mockFn2);

        // Avança o tempo em 500ms, apenas o primeiro deve ser chamado
        jest.advanceTimersByTime(500);
        await promise1; // Aguardamos a resolução da primeira promessa
        expect(mockFn1).toHaveBeenCalledTimes(1);
        expect(mockFn2).not.toHaveBeenCalled();

        // Avança o tempo em mais 500ms (totalizando 1000ms), o segundo também deve ser chamado
        jest.advanceTimersByTime(500);
        await promise2; // Aguardamos a resolução da segunda promessa
        expect(mockFn2).toHaveBeenCalledTimes(1);
    });
});