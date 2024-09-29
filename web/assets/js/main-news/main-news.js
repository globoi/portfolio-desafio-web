import { loadTemplate } from "../utils/dom-functions.js";
import { getMainNews } from '../services/api/news.js'
import { timer } from "../utils/helpers.js";
import { prepareLink, removeSkeleton } from "../utils/news-functions.js";

const mainNews = await getMainNews();

const mainList = document.getElementById('main-news-box');

mainList.innerHTML = await loadTemplate('./assets/templates/main-news-skeleton.html');

// Função para criar elementos de uma notícia
async function createNewsItem(newsItem) {

    const newsContent = document.createElement('div');

    try {
        const templateText = await loadTemplate('./assets/templates/main-news.html');
        newsContent.innerHTML = templateText;

        const secondItem = mainList.childElementCount;

        if (secondItem == 2) {
            const card = newsContent.querySelector('.main-news-box__card');
            card.classList.add('main-news-box__card--full-image');
            card.style.backgroundImage = `url(${newsItem.image})`;
        }

        // trata a imagem
        const image = newsContent.querySelector('.main-news-box__img-tag');
        image.src = newsItem.image;
        image.alt = newsItem.title;

        // trata o figcaption
        const figcaptionImage = newsContent.querySelector('figcaption');
        figcaptionImage.textContent = newsItem.title;

        // trata as informações da noticia
        const label = newsContent.querySelector('.main-news-box__label');
        label.textContent = newsItem.section;

        const title = newsContent.querySelector('.main-news-box__title');
        title.textContent = newsItem.title;

        const description = newsContent.querySelector('.main-news-box__description');
        description.textContent = newsItem.summary;

        prepareLink(newsContent, newsItem);

    } catch (error) {
        newsContent.textContent = "Erro ao carregar as noticias, por favor tente novamente mais tarde.";
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
