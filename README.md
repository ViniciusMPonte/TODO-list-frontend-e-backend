# To-Do List: Frontend e Backend

Aplicação para gerenciar tarefas, com funcionalidades de categorização, prioridades e status.

Atualmente, o projeto está dividido em duas partes: backend e frontend. Ainda não há integração entre eles. O backend é uma aplicação Java para linha de comando, enquanto o frontend é uma aplicação web desenvolvida com HTML, CSS e JavaScript. Ambas as partes utilizam dados mockados.

# Backend - Aplicação CLI
## Funcionalidades Principais

- **Criar Tarefas**:  
  Adicione novas tarefas com nome, descrição, categoria e prioridade (1 a 5).

- **Editar Tarefas**:  
  Modifique qualquer campo de uma tarefa existente (nome, descrição, prioridade, categoria, status).

- **Excluir Tarefas**:  
  Remova tarefas pelo nome.

- **Listar Tarefas**:
    - Visualize todas as tarefas.
    - Filtre por:
        - **Categoria** (ex: trabalho, pessoal).
        - **Prioridade** (1 a 5).
        - **Status** (ToDo, Doing, Done).

- **Visualizar datas**:
    - Visualize as datas de criação, modificação e finalização.

- **Ordenação automática**:
    - Tarefas sempre ordenadas por prioridade

## Como Usar

1. **Navegação por Menus**:  
   Digite o número correspondente à opção desejada e pressione `Enter`.

2. **Menus Disponíveis**:
    - **Menu Principal**:
        - Criação, edição, exclusão e listagem de tarefas.
    - **Filtros Personalizados**:
        - Escolha entre filtrar por categoria, prioridade ou status.

### Pré-requisitos
- Java JDK 8 ou superior.

# Frontend - Aplicação Web
## Funcionalidades Principais
No frontend as tarefas são organizadas em três colunas (A Fazer, Fazendo e Feito) com ordenação automática por prioridade. É possível criar, editar e deletar tarefas utilizando os mesmos inputs do backend.