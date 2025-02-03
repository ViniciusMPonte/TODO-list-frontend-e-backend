package view;

import entities.Task;
import utils.DateTime;
import utils.TaskManager;

import java.util.*;

public class Cli {
    public final static String START = "To-Do List CLI\n\nNavegue pelos menus digitando o número correspondente e pressionando Enter.";
    public final static String MAIN_MENU = """
            1. Criar uma nova tarefa
            2. Editar uma tarefa
            3. Deletar uma tarefa
            4. Listar todas as Tarefas
            5. Listar tarefas de forma personalizada
            
            0. Sair
            Digite a opção:\s
            """;
    public final static String TASKS_MENU = """
            Listar tarefas por:
            
            1. Categoria
            2. Prioridade
            3. Status
            
            0. Voltar
            
            Digite a opção:\s
            """;
    public final static String CATEGORY_LIST_MENU = """
            Todas as categorias ou categoria especifica:
            
            1. Todas as categorias
            2. Categoria especifica
            
            0. Voltar
            
            Digite a opção:\s
            """;
    public final static String PRIORITY_LIST_MENU = """
            Todas as prioridades ou prioridade especifica (de 1 a 5):
            
            1. Todas as prioridades
            2. Prioridade especifica
            
            0. Voltar
            
            Digite a opção:\s
            """;
    public final static String STATUS_LIST_MENU = """
            Todas os status ou status especifico:
            
            1. Todos os status
            2. Status especifico
            
            0. Voltar
            
            Digite a opção:\s
            """;
    public static final Map<String, String> CREATE_TASK_OPTIONS = new HashMap<>();

    static {
        CREATE_TASK_OPTIONS.put("name", "Digite o nome da sua nova tarefa: ");
        CREATE_TASK_OPTIONS.put("description", "Digite a descrição: ");
        CREATE_TASK_OPTIONS.put("category", "Digite a categoria: ");
        CREATE_TASK_OPTIONS.put("priorityLevel", "Digite o número da prioridade (de 1 a 5): ");
        CREATE_TASK_OPTIONS.put("confirmation", "Confirma a criação da tarefa com as informações abaixo? (S/N)");
        CREATE_TASK_OPTIONS.put("successTaskCreation", "Tarefa criada com sucesso!");
        CREATE_TASK_OPTIONS.put("abortTaskCreation", "Criação cancelada.");
    }

    public static final Map<String, String> TASK_VALIDATIONS = new HashMap<>();

    static {
        TASK_VALIDATIONS.put("repeatedName", "Já há uma tarefa com esse nome! Digite algo diferente: ");
        TASK_VALIDATIONS.put("emptyName", "Nome vazio! Digite algo diferente: ");
        TASK_VALIDATIONS.put("repeatedDescription", "Já há uma tarefa com essa descrição! Digite algo diferente: ");
        TASK_VALIDATIONS.put("emptyDescription", "Descrição vazia! Digite algo diferente: ");
        TASK_VALIDATIONS.put("emptyCategory", "Categoria vazia! Digite algo diferente: ");
        TASK_VALIDATIONS.put("invalidPriorityLevel", "Nível de prioridade inválido! Digite o número da prioridade (de 1 a 5): ");
        TASK_VALIDATIONS.put("priorityLevelOutOfRange", "Nível de prioridade fora do intervalo! Digite o número da prioridade (de 1 a 5): ");
    }

    public static final Map<String, String> SELECT_BY_CATEGORY = new HashMap<>();

    static {
        SELECT_BY_CATEGORY.put("instructionsSelect", "Digite o nome da categoria para filtrar: ");
        SELECT_BY_CATEGORY.put("notFound", "Categoria não encontrada, tente novamente: ");
    }

    public static final Map<String, String> SELECT_BY_PRIORITY = new HashMap<>();

    static {
        SELECT_BY_PRIORITY.put("instructionsSelect", "Digite o numero da prioridade para filtrar (de 1 a 5): ");
        SELECT_BY_PRIORITY.put("emptyPriority", "Não há tarefas com esse nível de prioridade");
        SELECT_BY_PRIORITY.put("invalidPriority", "Prioridade inválida, tente novamente");
        SELECT_BY_PRIORITY.put("notFound", "Prioridade não encontrada, tente novamente");
    }

    public static final Map<String, String> SELECT_BY_STATUS = new HashMap<>();

    static {
        SELECT_BY_STATUS.put("instructionsSelect", """
                Digite o numero do Status para filtrar (de 1 a 3):
                1. ToDo
                2. Doing
                3. Done
                
                """);
        SELECT_BY_STATUS.put("emptyStatus", "Não há tarefas com esse status");
        SELECT_BY_STATUS.put("invalidStatusIndex", "Status inválido, tente novamente");
        SELECT_BY_STATUS.put("notFound", "Status não encontrado, tente novamente");
    }


    public static boolean mainMenu(Scanner input, TaskManager taskManager) {
        boolean end = false;
        System.out.println(Cli.MAIN_MENU);
        String userInput = input.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("Você escolheu a opção 1");
                Cli.createNewTask(input, taskManager);
                break;
            case "2":
                System.out.println("Você escolheu a opção 2");
                editTask(input, taskManager);
                break;
            case "3":
                System.out.println("Você escolheu a opção 3");
                deleteTask(input, taskManager);
                break;
            case "4":
                System.out.println("Você escolheu a opção 4");
                listAllTasks(taskManager);
                break;
            case "5":
                System.out.println("Você escolheu a opção 5");
                tasksMenu(input, taskManager);
                break;
            case "0":
                System.out.println("Você escolheu a opção 0");
                end = true;
                break;
            default:
                System.out.println("Opção inválida!");
        }
        return end;
    }

    public static boolean tasksMenu(Scanner input, TaskManager taskManager) {
        boolean end = false;
        System.out.println(Cli.TASKS_MENU);
        String userInput = input.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("Você escolheu a opção 1");
                categoryListMenu(input, taskManager);
                break;
            case "2":
                System.out.println("Você escolheu a opção 2");
                priorityListMenu(input, taskManager);
                break;
            case "3":
                System.out.println("Você escolheu a opção 3");
                statusListMenu(input, taskManager);
                break;
            case "0":
                System.out.println("Você escolheu a opção 0");
                end = true;
                break;
            default:
                System.out.println("Opção inválida!");
        }
        return end;
    }

    public static boolean categoryListMenu(Scanner input, TaskManager taskManager) {

        boolean end = false;
        System.out.println("\nCategorias disponíveis:\n".toUpperCase());
        List<String> listCategories = taskManager.listCategories();

        for (String category : listCategories) {
            System.out.println(category);
        }


        System.out.println(CATEGORY_LIST_MENU);
        String userInput = input.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Você escolheu a opção 1");
                listAllByCategory(taskManager, listCategories);
                break;
            case "2":
                System.out.println("Você escolheu a opção 2");
                listBySelectedCategory(input, taskManager, listCategories);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        return end;
    }

    public static boolean priorityListMenu(Scanner input, TaskManager taskManager) {

        boolean end = false;
        System.out.println(PRIORITY_LIST_MENU);
        String userInput = input.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Você escolheu a opção 1");
                listAllByPriority(taskManager);
                break;
            case "2":
                System.out.println("Você escolheu a opção 2");
                listBySelectedPriority(input, taskManager);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        return end;
    }

    public static boolean statusListMenu(Scanner input, TaskManager taskManager) {

        boolean end = false;
        System.out.println(STATUS_LIST_MENU);
        String userInput = input.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Você escolheu a opção 1");
                listAllByStatus(taskManager);
                break;
            case "2":
                System.out.println("Você escolheu a opção 2");
                listBySelectedStatus(input, taskManager);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        return end;
    }

    public static void createNewTask(Scanner input, TaskManager taskManager) {
        Task newTask = new Task();

        String name, description, category;
        int priorityLevel;
        boolean confirmation;

        boolean isValidated = false;

        System.out.println(CREATE_TASK_OPTIONS.get("name"));
        while (!isValidated) {
            name = input.nextLine();

            if (!taskManager.validateNewTaskName(name)) {
                System.out.println(TASK_VALIDATIONS.get("repeatedName"));
                continue;
            } else if (!newTask.setName(name)) {
                System.out.println(TASK_VALIDATIONS.get("emptyName"));
                continue;
            }
            isValidated = true;
        }
        isValidated = false;

        System.out.println(CREATE_TASK_OPTIONS.get("description"));
        while (!isValidated) {
            description = input.nextLine();

            if (!taskManager.validateNewTaskDescription(description)) {
                System.out.println(TASK_VALIDATIONS.get("repeatedDescription"));
                continue;
            } else if (!newTask.setDescription(description)) {
                System.out.println(TASK_VALIDATIONS.get("emptyDescription"));
                continue;
            }
            isValidated = true;
        }
        isValidated = false;

        System.out.println(CREATE_TASK_OPTIONS.get("category"));
        while (!isValidated) {
            category = input.nextLine();

            if (!newTask.setCategory(category)) {
                System.out.println(TASK_VALIDATIONS.get("emptyCategory"));
                continue;
            }
            isValidated = true;
        }
        isValidated = false;

        System.out.println(CREATE_TASK_OPTIONS.get("priorityLevel"));
        while (!isValidated) {
            try {
                priorityLevel = Integer.parseInt(input.nextLine());

                if (!newTask.setPriorityLevel(priorityLevel)) {
                    System.out.println(TASK_VALIDATIONS.get("priorityLevelOutOfRange"));
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println(TASK_VALIDATIONS.get("invalidPriorityLevel"));
                continue;
            }

            isValidated = true;
        }

        System.out.println(CREATE_TASK_OPTIONS.get("confirmation"));
        System.out.println(newTask);
        String confirmed = input.nextLine();
        confirmation = Objects.equals(confirmed, "s");

        if (confirmation) {
            taskManager.addTask(newTask);
            taskManager.sortByPriority();
            listAllTasks(taskManager);
            System.out.println(CREATE_TASK_OPTIONS.get("successTaskCreation"));
        } else {
            System.out.println(CREATE_TASK_OPTIONS.get("abortTaskCreation"));
        }
    }

    public static void editTask(Scanner input, TaskManager taskManager) {
        System.out.print("Digite o nome da tarefa que deseja editar: ");
        String searchName = input.nextLine().trim();
        List<Task> filteredTasks = taskManager.filterByName(searchName);

        if (filteredTasks.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com esse nome.");
            return;
        }

        Task taskToEdit = filteredTasks.getFirst();

        editTaskDetails(input, taskToEdit);

        taskToEdit.updateModificationDate();
        if (taskToEdit.getStatusIndex() == 2) {
            taskToEdit.updateFinishDate();
        }
        taskManager.sortByPriority();
    }

    private static void editTaskDetails(Scanner input, Task task) {
        if (askConfirmation(input, "Editar nome")) {
            System.out.print("Novo nome: ");
            task.setName(input.nextLine().trim());
        }

        if (askConfirmation(input, "Editar descrição")) {
            System.out.print("Nova descrição: ");
            task.setDescription(input.nextLine().trim());
        }

        if (askConfirmation(input, "Editar prioridade (1-5)")) {
            task.setPriorityLevel(getValidPriority(input));
        }

        if (askConfirmation(input, "Editar categoria")) {
            System.out.print("Nova categoria: ");
            task.setCategory(input.nextLine().trim());
        }

        if (askConfirmation(input, "Editar status")) {
            task.setStatusIndex(getValidStatus(input));
        }
    }

    private static boolean askConfirmation(Scanner input, String action) {
        System.out.printf("%n%s? (s/n) ", action);
        return input.nextLine().trim().equalsIgnoreCase("s");
    }

    private static int getValidPriority(Scanner input) {
        while (true) {
            System.out.print("Prioridade (1-5): ");
            String response = input.nextLine().trim();

            try {
                int priority = Integer.parseInt(response);
                if (priority >= 1 && priority <= 5) {
                    return priority;
                }
                System.out.println("Prioridade inválida! Digite um valor entre 1 e 5.");
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido! Digite apenas números.");
            }
        }
    }

    private static int getValidStatus(Scanner input) {
        while (true) {
            System.out.println("\nStatus disponíveis:");
            System.out.println("1. A fazer");
            System.out.println("2. Em progresso");
            System.out.println("3. Concluído");
            System.out.print("Escolha o novo status: ");

            String response = input.nextLine().trim();
            try {
                int status = Integer.parseInt(response) - 1;
                if (status >= 0 && status <= 2) {
                    return status;
                }
                System.out.println("Status inválido! Digite um valor entre 1 e 3.");
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido! Digite apenas números.");
            }
        }
    }

    public static void deleteTask(Scanner input, TaskManager taskManager) {
        System.out.print("\nDigite o nome da tarefa que deseja excluir: ");
        String searchName = input.nextLine().trim();
        List<Task> filteredTasks = taskManager.filterByName(searchName);

        if (filteredTasks.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com esse nome.");
            return;
        }

        Task taskToDelete = filteredTasks.getFirst();

        if (confirmDelete(input, taskToDelete)) {
            taskManager.deleteTask(taskToDelete);
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }

    private static boolean confirmDelete(Scanner input, Task task) {
        System.out.println("\nTarefa selecionada para exclusão:");
        System.out.println("Nome: " + task.getName());
        System.out.println("Descrição: " + task.getDescription());
        System.out.println("Status: " + task.getStatus());

        System.out.print("\nTem certeza que deseja excluir esta tarefa? (s/n) ");
        return input.nextLine().trim().equalsIgnoreCase("s");
    }

    public static void listAllTasks(TaskManager taskManager) {
        for (Task task : taskManager.getTasks()) {
            System.out.println("\n" + task + "\n");
        }
    }

    public static void listAllByCategory(TaskManager taskManager, List<String> listCategories) {
        for (String category : listCategories) {
            System.out.println("\n" + category.toUpperCase() + "\n");
            for (Task task : taskManager.filterByCategory(category)) {
                System.out.println(task);
            }
        }
    }

    public static void listBySelectedCategory(Scanner input, TaskManager taskManager, List<String> listCategories) {
        String categorySelected;

        System.out.println(SELECT_BY_CATEGORY.get("instructionsSelect"));
        for (String category : listCategories) {
            System.out.println(category);
        }

        while (true) {
            String textInput = input.nextLine();
            if (listCategories.equals(textInput)) {
                categorySelected = textInput;
                break;
            } else {
                System.out.println(SELECT_BY_CATEGORY.get("notFound"));
                System.out.println(SELECT_BY_CATEGORY.get("instructionsSelect"));
            }
        }

        for (Task task : taskManager.filterByCategory(categorySelected)) {
            System.out.println(task);
        }
    }

    public static void listAllByPriority(TaskManager taskManager) {

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n" + "PRIORIDADE " + i + "\n");
            for (Task task : taskManager.filterByPriorityLevel(i)) {
                System.out.println(task);
            }
        }
    }

    public static void listBySelectedPriority(Scanner input, TaskManager taskManager) {
        int priorityLevelSelected;

        System.out.println(SELECT_BY_PRIORITY.get("instructionsSelect"));

        while (true) {
            String textInput = input.nextLine();

            try {
                priorityLevelSelected = Integer.parseInt(textInput);
            } catch (NumberFormatException e) {
                System.out.println(SELECT_BY_PRIORITY.get("invalidPriority"));
                System.out.println(SELECT_BY_PRIORITY.get("instructionsSelect"));
                continue;
            }

            if (priorityLevelSelected >= 0 && priorityLevelSelected <= 5) {
                break;
            } else {
                System.out.println(SELECT_BY_PRIORITY.get("notFound"));
                System.out.println(SELECT_BY_PRIORITY.get("instructionsSelect"));
            }
        }

        List<Task> tasks = taskManager.filterByPriorityLevel(priorityLevelSelected);

        if (tasks.isEmpty()) {
            System.out.println(SELECT_BY_PRIORITY.get("emptyPriority"));
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public static void listAllByStatus(TaskManager taskManager) {

        for (int i = 0; i <= 2; i++) {
            System.out.println("\n" + Task.STATUS.get(i).toUpperCase() + "\n");

            for (Task task : taskManager.filterByStatus(i)) {
                System.out.println(task);
            }
        }
    }

    public static void listBySelectedStatus(Scanner input, TaskManager taskManager) {
        int statusIndexSelected;

        System.out.println(SELECT_BY_STATUS.get("instructionsSelect"));

        while (true) {
            String textInput = input.nextLine();

            try {
                statusIndexSelected = Integer.parseInt(textInput) - 1;
            } catch (NumberFormatException e) {
                System.out.println(SELECT_BY_STATUS.get("invalidStatusIndex"));
                System.out.println(SELECT_BY_STATUS.get("instructionsSelect"));
                continue;
            }

            if (statusIndexSelected >= 0 && statusIndexSelected <= 2) {
                break;
            } else {
                System.out.println(SELECT_BY_STATUS.get("notFound"));
                System.out.println(SELECT_BY_STATUS.get("instructionsSelect"));
            }
        }

        System.out.println("\n" + Task.STATUS.get(statusIndexSelected).toUpperCase() + "\n");
        List<Task> tasks = taskManager.filterByStatus(statusIndexSelected);

        if (tasks.isEmpty()) {
            System.out.println(SELECT_BY_STATUS.get("emptyStatus"));
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}