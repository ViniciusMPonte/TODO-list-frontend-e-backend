package view;

import entities.Task;
import utils.TaskManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Cli {
    public final static String START = "To-Do List CLI\n\nNavegue pelos menus digitando o número correspondente e pressionando Enter.";
    public final static String MAIN_MENU = "1. Criar uma nova tarefa\nDigite a opção: ";
    public static final Map<String, String> CREATE_TASK_OPTIONS = new HashMap<>();

    static {
        CREATE_TASK_OPTIONS.put("name", "Digite o nome da sua nova tarefa: ");
        CREATE_TASK_OPTIONS.put("description", "Digite a descrição: ");
        CREATE_TASK_OPTIONS.put("category", "Digite a categoria: ");
        CREATE_TASK_OPTIONS.put("priorityLevel", "Digite o número da prioridade (de 1 a 5): ");
        CREATE_TASK_OPTIONS.put("confirmation", "Confirma a criação da tarefa com as informações abaixo? (S/N)");
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


    public static boolean mainMenu (Scanner input, TaskManager taskManager){
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
                break;
            case "3":
                System.out.println("Você escolheu a opção 3");
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
            taskManager.listTasks();
        } else {
            System.out.println(CREATE_TASK_OPTIONS.get("abortTaskCreation"));
        }
    }

}