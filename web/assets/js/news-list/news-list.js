import { getNews } from '../services/api/news.js';
import { loadTemplate } from "../utils/dom-functions.js";
import { timer } from "../utils/helpers.js";
import { removeSkeleton, prepareNewsElement } from "../utils/news-functions.js";

let page = 1;

const newsList = document.getElementById('news-list');
newsList.innerHTML = await loadTemplate('./assets/templates/news-skeleton.html');


let news = await getNews(page);

async function createNewsItem(newsItem) {

    let newsContent = document.createElement('div');
    const isAd = newsList.childElementCount % 8;

    newsContent = await prepareNewsElement(newsContent, newsItem);

    newsList.appendChild(newsContent);

    if (isAd == 0) {
        // cria um ad a cada 8 elementos
        const loadAd = await loadTemplate('./assets/templates/ad.html');
        const adContent = document.createElement('div');
        adContent.innerHTML = loadAd;
        newsList.appendChild(adContent);
    }
}

const loadMoreButton = document.getElementById('load-more');
loadMoreButton.style.display = 'none';

// simula timer API
await timer(3000)

for (const newsItem of news) {
    await createNewsItem(newsItem)
}

// remove skeleton ao final do processamento
removeSkeleton(newsList, '.news-skeleton')

loadMoreButton.style.display = 'block';

// faz a paginação
loadMoreButton.addEventListener('click', async () => {
    page = page + 1;
    news = await getNews(page);
    for (const newsItem of news) {
        await createNewsItem(newsItem)
    }
})