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

3. Desenvolvimento Frontend
Descrição:
O desenvolvimento da interface do usuário (UI) foi a próxima etapa, onde construímos a parte visual e interativa da aplicação.

Passos:
Criação de wireframes ou mockups para visualização.
Implementação das páginas principais (ex: lista de tarefas, página de adicionar tarefa).
Implementação de funcionalidades interativas (ex: adicionar, editar e excluir tarefas).
Ferramentas utilizadas:
HTML, CSS, JavaScript (ou frameworks como React, Vue, etc.).

4. Desenvolvimento Backend
Descrição:
Agora, focamos na criação do backend, onde lidamos com a lógica de negócios e com o armazenamento de dados.

Passos:
Criação de APIs RESTful para comunicação entre o frontend e o banco de dados.
Implementação de autenticação de usuários (se necessário).
Testes de integração e comunicação com o banco de dados.
Ferramentas utilizadas:
Node.js, Express, MongoDB, etc.

5. Testes
Descrição:
A fase de testes foi fundamental para garantir que todas as funcionalidades do sistema estivessem funcionando corretamente.

Passos:
Testes unitários e de integração.
Testes manuais para validação das funcionalidades.
Testes de usabilidade e interface do usuário.

6. Desdobramento e Deploy
Descrição:
Depois de finalizado o desenvolvimento e os testes, o próximo passo foi a implantação do sistema.

Passos:
Configuração de ambiente de produção.
Deploy no servidor ou plataforma de hospedagem.
Monitoramento e ajustes pós-implantação.

7. Manutenção e Atualizações
Descrição:
Após o lançamento, o trabalho não terminou. A manutenção contínua foi necessária para corrigir erros, melhorar o desempenho e adicionar novas funcionalidades.

Passos:
Correção de bugs reportados pelos usuários.
Atualizações de segurança.
Adição de novos recursos conforme feedback dos usuários.
Conclusão
Resumo das lições aprendidas, desafios enfrentados e as etapas futuras planejadas para o projeto.




-------------------------------------------------------------------------------
