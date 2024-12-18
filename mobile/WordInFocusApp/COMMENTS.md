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
