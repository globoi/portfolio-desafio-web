
import { BASE_URL, ENDPOITS } from '../../utils/services/api-urls.js'

export async function getNews(page = 1, type = 'materia') {
    let response = await fetch(`${BASE_URL}${ENDPOITS.FEED}/${ENDPOITS.PAGE}/${page}`);
    let data = await response.json();

    return data.filter(el => el.type === type);
}

export async function getNewsGroup() {
    let data = await getNews(1, 'agrupador-materia');
    return data;
}

export async function getMainNews() {
    let data = await getNews(1, 'materia');
    return data.slice(0, 2);
}