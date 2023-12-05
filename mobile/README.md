# Portfólio Recrutamento

## Seu Nome
**Desafio Mobile**

---
![JPG](https://github.com/globoi/portfolio-desafio/assets/7443856/3414d888-70cb-49c6-a299-7a727d91740b)

Obrigado por participar do desafio de Portfólio! Estamos muito contentes pelo seu primeiro passo para fazer parte de um time excepcional.

-------------------------------------------------------------------------------
## Considerações Gerais
Você deverá usar este repositório como o repo principal do projeto, i.e., todos os seus commits devem estar registrados aqui, pois queremos ver como você trabalha.

**Registre tudo**: ideias que gostaria de implementar se tivesse mais tempo (explique como você as resolveria, se houvesse tempo), decisões que forem tomadas e seus porquês, arquiteturas que forem testadas e os motivos de terem sido modificadas ou abandonadas. Crie um arquivo COMMENTS.md ou HISTORY.md no repositório para registrar essas reflexões e decisões.

É importante manter um histórico de commits consistente, não se sinta tentado a commitar e pushar tudo somente no último dia. Isso fere um dos princípios do desafio, que é avaliar a forma de trabalho.

-------------------------------------------------------------------------------
## O Desafio

O desafio que você irá desenvolver é um aplicativo de feed de notícias. Com ele podemos acompanhar as notícias mais recentes do Brasil e do mundo.

O aplicativo deverá funcionar a partir da SDK 21 para o Android ou a versão 13 de iOS/Swift 5.

-------------------------------------------------------------------------------
## Regras de negócio
1. O aplicativo deve mostrar em uma tela inicial a lista de notícias mais recentes, com título, foto e descrição. A primeira página do feed está disponível através da URL: https://native-leon.globo.com/feed/g1

2. O aplicativo deve lidar com a paginação do feed, fazendo requisição para a próxima página e exibindo mais itens à medida que o usuário faz o scroll. Para saber mais como funciona a paginação, acesse o link da documentação da API  **[DocNativeLeon](DocNativeLeon.md)**.

3. Devem ser considerados apenas os itens com o campo "type" definido como "basico" ou "materia".

4. Cada item deve exibir o campo "chapeu" se ele existir, além do título, imagem e resumo.

5. Em cada item também deve ser exibido o tempo em que ele foi publicado, usando o campo "metadata".

6. Ao clicar em um item, o aplicativo deve levar à uma nova tela com uma webview exibindo a matéria clicada. Para isso você usará o campo "url" do item. Desta tela deve ser possível que o usuário volte à tela inicial.

7. Deve ser possível que o usuário faça um "Pull to Refresh", para recarregar o feed.

8. Além da tela inicial, deve existir uma outra tab com um outro feed disponível através da URL: "https://native-leon.globo.com/feed/https://g1.globo.com/economia/agronegocios". Este feed deve seguir também os requisitos dos itens 2 ao 7, com as mesmas features de paginação, posts, etc.

9. Por fim, uma última tab com um menu, com itens do json **[Menu.json](menu.json)**. É opcional o json estar embarcado ou em algum endpoint, fica a critério do desenvolvimento.

10. Ao clicar em um item do menu, o aplicativo deve levar à uma nova tela com uma webview, carregando a URL do item selecionado.


------------------------------------------------------------------------------
## Avaliação da solução

1. A linguagem a ser utilizada deve ser Kotlin para Android e Swift para iOS.

2. As funcionalidades listadas anteriormente devem estar presentes na sua solução.

3. Seu código será observado por uma equipe de desenvolvedores que avaliarão a simplicidade e clareza da solução, a arquitetura, modularização, documentação, estilo de código, testes automatizados e a implementação do código.

4. Esperamos que o aplicativo faça o menor número de requisições possíveis para a API.

-------------------------------------------------------------------------------
## Dicas
* Use ferramentas e bibliotecas open source, mas documente as decisões e os porquês.
* Automatize o que for possível.
* Em caso de dúvidas, **pergunte**.
* Essa é uma API real em produção, o resultado do json do feed muda constantemente, se planeje de acordo.

-------------------------------------------------------------------------------
## Diferenciais
Esses items são incrementos que podem ser desenvolvidos, caso você deseje adicionar um pouco mais de "sabor" ao seu desafio. Lembre-se que esses são itens diferenciais, mas que não têm um grande impacto, caso os items obrigatórios não estejam presentes.
* Conter testes unitários e de interface para os principais pontos do aplicativo.
* Se a API ficar indisponível ou o celular do usuário ficar sem internet, esperamos que o aplicativo continue funcionando e permita pegar a lista de matérias novamente quando a conexão for reestabelecida.
