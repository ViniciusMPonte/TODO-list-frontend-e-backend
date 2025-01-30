import java.util.Objects;
import java.util.Scanner;

import entities.Task;
import view.Cli;
import utils.TaskManager;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        //Simulação do database (remover depois)
        Task test = new Task(
                "Terminar ToDo List",
                "Projeto louco da ZG",
                "GZ-Hero"
        );
        taskManager.addTask(test);
        //--------------------

        String name = "";
        String description = "";
        String category = "";
        int priorityLevel = 0;
        boolean confirmation = false;


        System.out.println(Cli.START);
        System.out.println(Cli.MAIN_MENU);
        String userInput = input.nextLine();

        Task newTask = new Task();

        boolean isValidated = false;

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("name"));
        while (!isValidated) {
            name = input.nextLine();

            if (!taskManager.validateNewTaskName(name)) {
                System.out.println(Cli.TASK_VALIDATIONS.get("repeatedName"));
                continue;
            } else if (!newTask.setName(name)) {
                System.out.println(Cli.TASK_VALIDATIONS.get("emptyName"));
                continue;
            }
            isValidated = true;
        }
        isValidated = false;

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("description"));
        while (!isValidated) {
            description = input.nextLine();

            if (!taskManager.validateNewTaskDescription(description)) {
                System.out.println(Cli.TASK_VALIDATIONS.get("repeatedDescription"));
                continue;
            } else if (!newTask.setDescription(description)) {
                System.out.println(Cli.TASK_VALIDATIONS.get("emptyDescription"));
                continue;
            }
            isValidated = true;
        }
        isValidated = false;

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("category"));
        while (!isValidated) {
            category = input.nextLine();

            if (!newTask.setCategory(category)) {
                System.out.println(Cli.TASK_VALIDATIONS.get("emptyCategory"));
                continue;
            }
            isValidated = true;
        }
        isValidated = false;

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("priorityLevel"));

        while (!isValidated) {
            try {
                priorityLevel = Integer.parseInt(input.nextLine());

                if (!newTask.setPriorityLevel(priorityLevel)) {
                    System.out.println(Cli.TASK_VALIDATIONS.get("priorityLevelOutOfRange"));
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println(Cli.TASK_VALIDATIONS.get("invalidPriorityLevel"));
                continue;
            }

            isValidated = true;
        }

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("confirmation"));
        System.out.println(newTask);
        String confirmed = input.nextLine();
        confirmation = Objects.equals(confirmed, "s");

        if (confirmation) {
            taskManager.addTask(newTask);
            taskManager.listTasks();
        }

    }
}