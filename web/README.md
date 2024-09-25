# Portfólio Recrutamento

## Felipe Biel
**Desafio Web - Frontend**

---
![JPG](https://github.com/globoi/portfolio-desafio/assets/7443856/90c0c5c8-c08e-4b89-974e-74056ad00f4b)

Obrigado por participar do desafio de Portfólio! Estamos muito contentes pelo seu primeiro passo para fazer parte de um time excepcional.

-------------------------------------------------------------------------------
## Considerações Gerais
Você deverá usar este repositório como o repo principal do projeto, i.e., todos os seus commits devem estar registrados aqui, pois queremos ver como você trabalha.

**Registre tudo**: ideias que gostaria de implementar se tivesse mais tempo (explique como você as resolveria, se houvesse tempo), decisões que forem tomadas e seus porquês, arquiteturas que forem testadas e os motivos de terem sido modificadas ou abandonadas. Crie um arquivo COMMENTS.md ou HISTORY.md no repositório para registrar essas reflexões e decisões.

É importante manter um histórico de commits consistente, não se sinta tentado a commitar e pushar tudo somente no último dia. Isso fere um dos princípios do desafio, que é avaliar a forma de trabalho.

-------------------------------------------------------------------------------
## O Desafio
O desafio que você irá desenvolver é um de feed de notícias. Com ele podemos acompanhar as notícias mais recentes do Brasil e do mundo.
O aplicativo deverá funcionar para todos os browsers de mercado, em suas versões mais recentes.
Disponibilizamos um guia para o layout neste [arquivo referencia](https://bit.ly/3ls3dYg), porém, todo o layout é livre.

-------------------------------------------------------------------------------
## Regras de negócio

1. O feed de notícias é disponibilizado em dois formatos (desktop e mobile), de modo a aproveitar melhor o que os dispositivos têm a oferecer para o usuário.

2. Ele é composto por 4 tipos de itens:
* Matéria;
* Vídeo;
* Grupo de matérias;
* Anúncios publicitários;

3. O item matéria deve ser exibido no feed com um label, um título, uma descrição e uma imagem de capa opcional. Ao clicar em qualquer lugar do item, o usuário deverá ser redirecionado para a página da matéria. O type é desses itens é materia.

4. O item vídeo deve ser exibido no feed com um título, uma descrição e um thumbnail do vídeo. Ao clicar em qualquer lugar do item, o usuário deverá ver o vídeo em uma modal que abre na própria página. O type é desses itens é materia.

5. O item agrupador de matérias deverá ser exibido, no desktop, na coluna da direita, com cabeçalho, rodapé e uma sublista de matérias, que terão apenas um título. No momento em que o usuário clica em um dos itens da sublista, ele é levado para a matéria correspondente. No mobile, os itens aparecem na ordem entregue pela api. O type é desses itens é agrupador-materia.

6. O anúncio publicitário deverá aparecer a cada 8 posts de conteúdo exibidos no feed. Um anúncio deve sempre conter um label de anúncio conforme demonstrado aqui. O conteúdo imagético do anúncio pode ser fixo ou gerado aleatoriamente com o uso de bancos de imagem (como, por exemplo, através do site Lorem Picsum: https://picsum.photos/). Como ele é dinâmico, não vem na api.

------------------------------------------------------------------------------
## Api
Disponibilizamos uma api para você, ela é responsável por trazer os posts já paginados. Está localizada na pasta api e basta dar um make run para executar. Para recuperar os dados, basta acessar: http://localhost:${port}/feed/page/${page}. Você precisa ter o node instalado :).

------------------------------------------------------------------------------
## Premissas

1. É importante que a página seja leve e performática. Milhares de usuários acessarão o feed de notícias, simultaneamente, e é preciso entregar o conteúdo a todos eles.

2. As publicidades, por conta de um acordo comercial, não podem ser colocadas na tela se não puderem ser visualizadas pelo usuário. Elas devem ser carregadas dinamicamente conforme as regras de negócio estabelecidas.

3. Como reforço, o [arquivo referencia](https://bit.ly/3ls3dYg) é um guia para o layout, mas você pode fazer alterações de acordo com o seu senso estético.

------------------------------------------------------------------------------
## Avaliação da solução

1. As tecnologias a serem utilizadas devem ser JavaScript, HTML 5, CSS. O uso de frameworks é opcional.

2. As funcionalidades listadas anteriormente devem estar presentes na sua solução.

3. Seu código será observado por uma equipe de desenvolvedores que avaliarão a simplicidade e clareza da solução, a arquitetura, modularização, documentação, estilo de código e a implementação do código.

4. Esperamos que o aplicativo faça o menor número de requisições possíveis para a API e seja performático.

-------------------------------------------------------------------------------
## Dicas
* Use ferramentas e bibliotecas open source, mas documente as decisões e os porquês.
* Automatize o que for possível.
* Gostamos de testes unitários!
* Em caso de dúvidas, **pergunte**.
