export function formatDateByTime(dataISO) {
    const data = new Date(dataISO);
    const now = new Date();
    const diffMs = now - data;
    const diffSec = Math.floor(diffMs / 1000);
    const diffMin = Math.floor(diffSec / 60);
    const diffHour = Math.floor(diffMin / 60);
    const diffDays = Math.floor(diffHour / 24);
    const diffWeeks = Math.floor(diffDays / 7);
    const diffMonths = now.getMonth() - data.getMonth() + (12 * (now.getFullYear() - data.getFullYear()));

    if (diffMin < 1) {
        return `Há ${diffSec} segundos`;
    } else if (diffHour < 1) {
        return `Há ${diffMin} minutos`;
    } else if (diffDays < 1) {
        return `Há ${diffHour} horas`;
    } else if (diffDays < 7) {
        return `Há ${diffDays} dias`;
    } else if (diffWeeks < 4) {
        return `Há ${diffWeeks} semanas`;
    } else if (diffMonths < 12) {
        const optionsMonthYear = { month: 'long', year: 'numeric' };
        return `Em ${data.toLocaleDateString('pt-BR', optionsMonthYear)}`;
    } else {
        const optionsMonthYear = { month: 'long', year: 'numeric' };
        return `Em ${data.toLocaleDateString('pt-BR', optionsMonthYear)}`;
    }
}

export function formatTimeByMs(milliseconds) {
    const minutes = Math.floor(milliseconds / 60000);
    const hours = Math.floor(minutes / 60);

    if (hours > 0) return `${hours} hora${hours > 1 ? 's' : ''}`;
    else return `${minutes} minuto${minutes > 1 ? 's' : ''}`;

}
