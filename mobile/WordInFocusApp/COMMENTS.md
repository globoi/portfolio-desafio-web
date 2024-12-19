Commit History: 

- Initial implementation of the home/main screen:
    - Decisão no uso de Jetpack Compose, tanto por afinidade quanto tendências e recomendações do Google. Apesar de ter uma curva de aprendizado inicial mais alta, o Compose é bem mais intuitivo, flexivel, reutilizável, reativo e tem um desempenho muito por conta das atualizações e otimizações automaticas que ele oferece.
    - Decisão no uso da arquitetura MVVM. Por ser um projeto simples, foi cogitado o uso da MVP, mas refletindo em questão de manutenção, escalabilidade e testabilidade, além de ser a arquitetura mais recomendada para projetos mobile, a MVVM foi escolhida.
    - Implementação do escopo mínimo necessário para estar de acordo com os itens obrigatórios: Tela inicial com uma lista de noticias, com titulo, foto e descrição; Tab com outro feed e um menu.
    - Implementação de algumas personalizações extras, como a mudança do icone do app, a implementação de uma splash screen, a implementação de um HorizontalPager para melhor navegação entre tabs, uma topbar com um botao de voltar que só aparece se nao estiver na tela inicial, entre outros efeitos.
    - Estruturação de componentes e classes levando em conta os principios de SOLID, Clean Architecture e Clean Code.

  O design está bem cru, mas focarei nas demais funcionalidades por conta do tempo, e se possível, volto para dar mais uma repaginada.

- Implementation of FeedViewModel:
  - Implementação da FeedViewModel com uma estrutura inicial abrangendo gerenciamento de estados do Feed.
  - Reestruturação do projeto, com a criação de novos componentes (foco em responsabilidade única), e também com a criação das demais camadas da arquitetura. Além disso, criei umas classes para as outras camadas, que ainda estão vazias, mas é para me ajudar a mapear o caminho que quero seguir. Ia colocar em outro commit mas acabei enviando tudo nesse.

- Implement data layer with DataSource, Repository and Mappers:
  - Adição de permissão para acesso à internet.
  - Configuração da API e do Retrofit.
  - Criação do escopo do LocalDataSource (Se sobrar tempo quero atuar neste ponto para salvar noticias em cache caso o usuário fique sem internet ou o app tenha acessado a API há pouco tempo.)
  - Implementação de mappers para fazer o mapeamento de responses para models (uso nos dataSources).
  - Implementação do RemoteDataSource, com modificações temporárias para testar o acesso à API e o mapeamento dos responses usando Moshi. Também foi definido um escopo para possíveis erros, com mensagens temporárias para serem melhor elaboradas posteriormente.
  - Implementação do Repository (há um código comentado com acesso ao LocalDataSource que será aproveitado se sobrar tempo).
  - Criação do escopo do UseCase (com a conversa que tivemos, quero utilizá-lo).
  - Substituição de parâmetros a medida que as classes vão ficando mais definidas.
 
- Implement Dependency Injection for the App:
  - Implementação de Injeção de Dependência no projeto.
  - Decisão no uso do Hilt. Já trabalhei com Dagger e Hilt, mas o Hilt é mais simples, tem integração com Android e reduz boilerplate.
  - Uso de kapt ao invés de ksp: Estava usando ksp no projeto, mas ao usar com o Hilt tive alguns problemas de execução, e por falta de tempo para debuggar, mudei pro kapt que era mais certo que funcionaria.
 
- Implement menu flow:
  - Implementação da última tab com um menu, com os itens passados por um json estático. Fluxo completo: desde o dataSource que busca e mapeia as informações do json, passando por um repository, viewModel e chegando à UI.
  - Implementação da webview que exibe o conteúdo relacionado ao item do menu clicado.
  - Implementação do mesmo menu no bottomBar. Essa tinha sido minha ideia inicial, depois entendi que o menu era para estar numa tab, mas decidi manter ambos.
  - Atualização do projeto para manter todas as modificações em conformidade com o padrão de arquitetura escolhido.
