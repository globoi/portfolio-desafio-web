import { getNews } from '../services/api/news.js';
import { formatDateByTime, formatTimeByMs } from "../utils/dates-functions.js";
import { loadTemplate } from "../utils/dom-functions.js";
import { timer } from "../utils/helpers.js";
import { prepareLink, removeSkeleton } from "../utils/news-functions.js";

let page = 1;

const newsList = document.getElementById('news-list');
newsList.innerHTML = await loadTemplate('./assets/templates/news-skeleton.html');


let news = await getNews(page);

async function createNewsItem(newsItem) {

    const newsContent = document.createElement('div');
    const isAd = newsList.childElementCount % 8;

    try {
        const templateText = await loadTemplate('./assets/templates/news-item.html');
        newsContent.innerHTML = templateText;

        // trata a imagem
        const image = newsContent.querySelector('.new-list-item__img-tag');
        image.src = newsItem.image ? newsItem.image : './assets/imgs/G1-placeholder.webp';
        image.alt = newsItem.title;

        // trata o figcaption
        const figcaptionImage = newsContent.querySelector('figcaption');
        figcaptionImage.textContent = newsItem.title;

        // trata as informações da noticia
        const label = newsContent.querySelector('.new-list-item__label');
        label.textContent = newsItem.section;

        const title = newsContent.querySelector('.new-list-item__title');
        title.textContent = newsItem.title;

        const description = newsContent.querySelector('.new-list-item__description');
        description.textContent = newsItem.summary;

        const createAt = newsContent.querySelectorAll('.new-list-item__when');
        createAt.forEach(when => {
            when.textContent = formatDateByTime(newsItem.created);
        })

        const player = newsContent.querySelector('.new-list-item__play');
        player.style.display = 'none';

        prepareLink(newsContent, newsItem);


        if (newsItem.video) {
            image.classList.add('new-list-item__img-tag--video')
            player.style.display = 'flex';
            const playerTime = newsContent.querySelector('.new-list-item__play-time');
            playerTime.textContent = formatTimeByMs(newsItem.video.duration);
        }
    } catch (error) {
        newsContent.textContent = "Erro ao carregar as noticias, por favor tente novamente mais tarde.";
    }

    newsList.appendChild(newsContent);

    if (isAd == 0) {
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
// HABILITAR DEPOIS

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