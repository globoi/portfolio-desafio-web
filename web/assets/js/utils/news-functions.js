import { loadTemplate } from "./dom-functions.js";
import { formatDateByTime, formatTimeByMs } from "./dates-functions.js";

export function prepareLink(newsContent, newsItem) {
    // trata os links
    const links = newsContent.querySelectorAll('a')

    if (!newsItem.video) {
        links.forEach(linkElement => {
            linkElement.href = newsItem.url;
            linkElement.addEventListener("click", linkOpen)
        })
    } else {
        links.forEach(linkElement => {
            linkElement.setAttribute('video-source', newsItem.video.source)
            linkElement.setAttribute('program-title', newsItem.video.programTitle)
            linkElement.addEventListener("click", linkOpen)
        });
    }
}

export async function linkOpen(event) {
    if (this.hasAttribute('video-source')) {
        event.preventDefault();
        prepareModal(this);
    }
};

async function prepareModal(linkElement) {
    const modalContent = document.createElement('div');
    const templateTextModal = await loadTemplate('./assets/templates/news-video-modal.html');
    modalContent.innerHTML = templateTextModal;

    // coloca diretamente no body
    document.body.insertBefore(modalContent, document.body.lastChild);

    // prepara o vídeo
    const modalElement = modalContent.querySelector('#modal-video');
    const video = modalContent.querySelector('source');
    video.src = linkElement.getAttribute('video-source');

    const caption = modalContent.querySelector('#caption');
    caption.textContent = linkElement.getAttribute('program-title');

    openModal(modalElement);
    prepareCloseModalEvent(modalContent, modalElement);
}

function openModal(modalElement) {
    modalElement.style.display = 'block';
}

function closeModal(modalElement) {
    modalElement.style.display = 'none';
}

function prepareCloseModalEvent(modalContent, modalElement) {
    const closeModalButton = modalContent.querySelector('.close')

    closeModalButton.addEventListener('click', () => {
        closeModal(modalElement)
        modalContent.remove()
    })
}

export function removeSkeleton(mainElement, querySelectorName) {
    const skeleton = mainElement.querySelector(querySelectorName);
    skeleton.remove()
}


export async function prepareNewsElement(newsContent, newsItem) {
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

    return newsContent;
}