export async function loadTemplate(url) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error('Erro ao carregar o template: ' + response.statusText);
        }
        const templateText = await response.text();

        return templateText;
    } catch (error) {
        console.error('Erro:', error);
    }
}