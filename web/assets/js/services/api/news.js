
import { BASE_URL, ENDPOITS } from '../../utils/services/api-urls.js'

export async function getNews(page = 1) {
    let response = await fetch(`${BASE_URL}${ENDPOITS.FEED}/${ENDPOITS.PAGE}/${page}`);
    let data = await response.json();

    return data;
}