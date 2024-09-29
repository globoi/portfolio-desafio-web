import { loadTemplate } from "./dom-functions.js";

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
