# Histórico do desafio

Documentação do Processo de Desenvolvimento
Introdução
Descrição geral do projeto, seu propósito e os objetivos principais que você queria atingir.

Exemplo:
Nome do projeto: Aplicativo de To-Do List
### Objetivo: Desenvolver um feed de notícias. Com ele podemos acompanhar as notícias mais recentes do Brasil e do mundo.

1. Definição dos Requisitos

Descrição:
A primeira etapa foi definir os requisitos e funcionalidades principais. Essa fase envolveu quais frameworks iria usar, se teria supor para a API 21 e se seria fácil o seu uso.

Passos: dsdddddd

2. Planejamento da Arquitetura

Descrição:
Nessa fase, definimos como a aplicação seria estruturada, incluindo tecnologias a serem utilizadas, banco de dados e arquitetura geral.

Passos:

  - Criação do projeto, e estruturação da arquitetura.

-- Primeiro esboço da arquitetura -- 

![image](https://github.com/user-attachments/assets/3d8ecc72-bbe4-4f23-a5b3-2fc764b738e7)

- A arquitetura dos módulos seguiria o clean, organizando todas as camadas no mesmo módulo, visando uma melhor escalabilidade e organização, tendo tudo no mesmo contexto.
- Estruturação do fluxo de dados e integração de componentes.
- Teria um módulo da feature principal, o Feed, e outro para centralizar os componentes, ter as extentions e possiveis interfaces.
- O módulo app seria apenas para centralizar as telas.

``
Inicialmente o projeto foi criado usando `dynamic feature` para o módulo do feed, no entanto acabei tendo diversos problemas de compatibilidade com o as versões da `JVM` com o `Kotlin`, exibindo a seguinte stack : 
``

````
Caused by: org.gradle.api.InvalidUserCodeException: Inconsistent JVM-target compatibility detected for tasks 'compileDebugJavaWithJavac' (1.8) and 'compileDebugKotlin' (21).
Consider using JVM Toolchain: https://kotl.in/gradle/jvm/toolchain
````

``
Mesmo aplicando as correções sugeridas pela documentação não tive sucesso, a principal motivação para o uso de `dynamic feature` no projeto, foi visando deixar o módulo com uma melhor flexibilidade na hora de integrar a qualquer outro projeto.
``

Com isso parti para o desenvolvimento do módulo do feed.

Escolha das tecnologias .

3. Desenvolvimento 
Descrição:
O desenvolvimento da interface do usuário (UI) foi a próxima etapa, onde construímos a parte visual e interativa da aplicação.

Objetivos:

O aplicativo deve mostrar em uma tela inicial a lista de notícias mais recentes, com título, foto e descrição. A primeira página do feed está disponível através da URL: https://native-leon.globo.com/feed/g1

O aplicativo deve lidar com a paginação do feed, fazendo requisição para a próxima página e exibindo mais itens à medida que o usuário faz o scroll. Para saber mais como funciona a paginação, acesse o link da documentação da API DocNativeLeon.

Devem ser considerados apenas os itens com o campo "type" definido como "basico" ou "materia".

Cada item deve exibir o campo "chapeu" se ele existir, além do título, imagem e resumo.

Em cada item também deve ser exibido o tempo em que ele foi publicado, usando o campo "metadata".

Ao clicar em um item, o aplicativo deve levar à uma nova tela com uma webview exibindo a matéria clicada. Para isso você usará o campo "url" do item. Desta tela deve ser possível que o usuário volte à tela inicial.

Deve ser possível que o usuário faça um "Pull to Refresh", para recarregar o feed.

Além da tela inicial, deve existir uma outra tab com um outro feed disponível através da URL: "https://native-leon.globo.com/feed/https://g1.globo.com/economia/agronegocios". Este feed deve seguir também os requisitos dos itens 2 ao 7, com as mesmas features de paginação, posts, etc.

Por fim, uma última tab com um menu, com itens do json Menu.json. É opcional o json estar embarcado ou em algum endpoint, fica a critério do desenvolvimento.

Ao clicar em um item do menu, o aplicativo deve levar à uma nova tela com uma webview, carregando a URL do item selecionado.

-------------------------------------------------------------------------------
