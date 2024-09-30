import { loadTemplate } from "../utils/dom-functions.js";
import { getMainNews } from '../services/api/news.js'
import { timer } from "../utils/helpers.js";
import { removeSkeleton, prepareNewsElement } from "../utils/news-functions.js";

const mainNews = await getMainNews();

const mainList = document.getElementById('main-news-box');

mainList.innerHTML = await loadTemplate('./assets/templates/main-news-skeleton.html');

// Função para criar elementos de uma notícia
async function createNewsItem(newsItem) {

    let newsContent = document.createElement('div');

    newsContent = await prepareNewsElement(newsContent, newsItem);

    // colocar as classes para card 
    newsContent.classList.add('main-news-box__card')

    const secondItem = mainList.childElementCount;

    if (secondItem == 2) {
        newsContent.classList.add('main-news-box__card--full-image');
        newsContent.style.backgroundImage = `url(${newsItem.image})`;
    }

    mainList.appendChild(newsContent);
}

// simula timer API
await timer(3000);

for (const newsItem of mainNews) {
    await createNewsItem(newsItem);
}

// remove skeleton ao final do processamento
removeSkeleton(mainList, '.main-news-skeleton')
