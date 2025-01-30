import java.util.Objects;
import java.util.Scanner;

import entities.Task;
import view.Cli;
import utils.TaskManager;

public class Main {
    public static void main(String[] args) {
        Task test = new Task("Terminar ToDo List", "Projeto louco da ZG", "GZ-Hero");
        //System.out.println(test);



        Scanner input = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();
        taskManager.addTask(test);

        String name = "";
        String description = "";
        String category = "";
        int priorityLevel = 0;
        boolean confirmation = false;


        System.out.println(Cli.START);
        System.out.println(Cli.MAIN_MENU);
        String userInput = input.nextLine();

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("name"));
        name = input.nextLine();

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("description"));
        description = input.nextLine();

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("category"));
        category = input.nextLine();

        System.out.println(Cli.CREATE_TASK_OPTIONS.get("priorityLevel"));
        priorityLevel = Integer.parseInt(input.nextLine());

        Task newTask = new Task(name, description, category);
        newTask.setPriorityLevel(priorityLevel);
        System.out.println(Cli.CREATE_TASK_OPTIONS.get("confirmation"));
        System.out.println(newTask);
        String confirmed = input.nextLine();
        confirmation = Objects.equals(confirmed, "s");

        if (confirmation){
            taskManager.addTask(newTask);
            taskManager.listTasks();
        }

    }
}