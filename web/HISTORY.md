# Iniciando o histórico da solução

## Resumo

Este arquivo será responsável por documentar as decisões tomadas durante o desenvolvimento deste desafio. Tentarei manter um histórico dos planos iniciais e, ao final do desafio, irei refatorar este arquivo, resumindo as decisões e desafios.

## Primeiro dia

Estudei o enunciado do desafio e verifiquei que poderia usar qualquer framework para resolvê-lo. Meu framework de especialidade atualmente é o Vue.js, porém, ao analisar, percebi que o foco do teste é JavaScript puro. Ainda não sei qual caminho seguirei.

Decidi, então, focar no primeiro dia no CSS e HTML da página de forma estática, com as possíveis variantes.

### Dificuldades:

Nunca utilizei JavaScript puro para criar Web Components. Estou avaliando se tenho tempo para aprender e executar algo nesse sentido.

## Segundo dia

Neste caso, tive alguns problemas pessoais e fui pouco produtivo, fazendo apenas a parte mobile e alguns testes com o serviço do backend.

## Terceiro dia

Nesse ponto, já havia desconsiderado o uso de Web Components, focando em priorizar JavaScript com templates HTML externos. Criei os templates e comecei a implementar a lógica para inserir os valores no HTML.

## Quarto dia

Nesse dia, precisei me ausentar para resolver assuntos pessoais. Trabalhei apenas no período noturno, realizando a refatoração de alguns códigos e do player de vídeo.

## Quinto dia

Mais refatorações e separação dos arquivos.

# Resultado final

## Decisão final

Optei por utilizar JavaScript puro com o objetivo de demonstrar meu conhecimento dos fundamentos da linguagem. Inicialmente, considerei a possibilidade de gerar todo o HTML por meio de JavaScript, mas julguei mais adequado utilizar templates HTML externos.

Essa abordagem permite a reutilização dos templates em outros projetos. No entanto, a necessidade de realizar uma requisição para cada template pode sobrecarregar a rede do navegador, dificultando a depuração.

Conforme mencionado anteriormente, avaliei a utilização do Vue.js devido à minha familiaridade com a ferramenta. Contudo, decidi me desafiar a reaprender o JavaScript puro, já que havia um tempo que não o utilizava.

## Sobre o teste

Encontrei algumas dificuldades na etapa de design desktop do Figma. As camadas não estavam devidamente alinhadas, o que dificultou a definição precisa dos espaçamentos entre elas. Ajustei os espaçamentos de forma visual.

No desenvolvimento do backend, como havia apenas uma única chamada à API, precisei tomar algumas decisões para resolver os problemas mais urgentes.

Por exemplo, a mesma chamada retornava tanto as notícias quanto os grupos de notícias. Para separar os dados, foi necessário realizar uma nova chamada à API, aplicando um filtro na data de retorno.

Outro ponto a ser considerado foram as notícias principais. Ao remover as duas primeiras notícias da primeira página para destacar as principais, o número total de notícias disponíveis para gerar o anúncio falso diminuiu. Por esse motivo, decidi duplicá-las logo abaixo.


## Pontos de melhoria

A implementação CSS poderia ter sido otimizada. Estava habituado a utilizar frameworks CSS que abstraem algumas funcionalidades, como convenções de nomenclatura e utilitários, mas acredito ter alcançado o resultado esperado. A utilização de um pré-processador CSS, como o SASS, seria benéfica para aumentar a organização e a manutenibilidade do código. No entanto, a proposta inicial era utilizar CSS puro.

A tipagem com TypeScript poderia melhorar a qualidade do código JavaScript e facilitar a manutenção. Essa não era uma exigência do projeto.

A manipulação das exceções nas chamadas ao backend poderia ser mais robusta. Seria necessário dedicar mais tempo ao estudo de melhores práticas para o tratamento de erros.

A documentação do código é fundamental para facilitar a compreensão e a manutenção futura. A falta de tempo impediu a implementação de uma documentação completa.

A utilização de Web Components ou a criação de micro frontends são abordagens interessantes para modularizar a aplicação. No entanto, a exploração dessas tecnologias exigiriam mais tempo de estudo.

Os testes unitários não foram concluídos. A função prepareNewsElement ainda precisa ser testada. Para agilizar o desenvolvimento inicial, utilizei a assistência de ferramentas de IA para gerar a base dos testes, que posteriormente foram refinados. A cobertura de testes completa exigirá mais tempo e dedicação.

## Observações

Já criei um sistema de noticias para um jornal local da Ilha do Governador, lembro que nos baseamos no G1 da época. Utilizei PHP com Laravel, Jquery, HTML, CSS e Bootstrap. 

Se pode verificar o trabalho executado em  https://ilhanoticias.com.br/, o mesmo não sofreu modificação após ser construído. Creio eu que foi criado no ano de 2017 na época que ainda era Full-stack.

Outra observação foi que para rodar o back precisei mudar a nomenclatura das pastas referente a esse [commit](https://github.com/felipebiel/portfolio-desafio/commit/4615f2574d41a515148c6741677c5a1e67f04f81).

## Rodar o projeto

Rodar o back-end na pasta web/Api:
> Geralmente porta 3000

```shell
npm run start
```

Rodar o front-end na pasta web/:
> Porta 8080 do localhost

```shell
npm install

npm run start
```  

Rodar os testes unitários:
```shell
npm run test:unit
```

## Considerações finais

Idependente do resultado gostaria de agradecer ao desafio imposto. Espero que tenha conseguido demostrar meus conhecimentos em JS. Como mencionado tinha um tempo consideravel que não desenvolvia algo em JS puro. Agradeço desde já também o tempo da analise da equipe e espero o feedback sincero sobre o que foi produzido.

Att: Felipe Biel de Souza Silva.