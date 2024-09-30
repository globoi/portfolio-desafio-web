import { formatDateByTime, formatTimeByMs } from '../../../js/utils/dates-functions.js';

describe('Testando as funções de datas e horas do arquivo dates-functions.js', () => {
    beforeAll(() => {
        // Fixa a data atual
        jest.useFakeTimers().setSystemTime(new Date('2024-09-29T12:00:00Z'));
    });

    afterAll(() => {
        // Reseta os timers após os testes
        jest.useRealTimers();
    });

    it.each`
        expectString             | checkMessage                                     | expectedValueString | dateValue
        ${'Há X segundos'}       | ${'para diferença inferior a 1 minuto'}          | ${'Há 30 segundos'}      | ${'2024-09-29T11:59:30Z'}
        ${'Há X minutos'}        | ${'para diferença inferior a 1 hora'}            | ${'Há 30 minutos'}       | ${'2024-09-29T11:30:00Z'}
        ${'Há X horas'}          | ${'para diferença inferior a 1 dia'}             | ${'Há 3 horas'}          | ${'2024-09-29T09:00:00Z'}
        ${'Há X dias'}           | ${'para diferença inferior a 1 semana'}          | ${'Há 4 dias'}           | ${'2024-09-25T12:00:00Z'}
        ${'Há X semanas'}        | ${'para diferença inferior a 1 mês'}             | ${'Há 2 semanas'}        | ${'2024-09-10T12:00:00Z'}
        ${'Em mês e ano'}        | ${'para datas com diferença maior que 1 mês'}    | ${'Em agosto de 2024'}   | ${'2024-08-01T12:00:00Z'}
        ${'Em mês e ano'}        | ${'para diferença maior que 1 ano'}              | ${'Em setembro de 2022'} | ${'2022-09-01T12:00:00Z'}
    `('formatDateByTime: deve retornar "$expectString" $checkMessage)', async ({ expectedValueString, dateValue }) => {
        const result = formatDateByTime(dateValue);
        expect(result).toBe(expectedValueString);
    });

    it.each`
        expectString             | checkMessage                                     | expectedValueString | msValue
        ${'X horas'}       | ${'quando o valor for superior a 60 minutos'}          | ${'2 horas'}      | ${7200000}
        ${'X minuto(s)'}        | ${'quando o valor for inferior a 60 minutos'}            | ${'7 minutos'}       | ${450000}
        ${'1 minuto'}          | ${'corretamente'}             | ${'1 minuto'}          | ${60000}
        ${'1 hora'}           | ${'corretamente'}          | ${'1 hora'}           | ${3600000}
    `('formatTimeByMs: deve retornar "$expectString" $checkMessage)', async ({ expectedValueString, msValue }) => {
        const result = formatTimeByMs(msValue);
        expect(result).toBe(expectedValueString);
    });
});