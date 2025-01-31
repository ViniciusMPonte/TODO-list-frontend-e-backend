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
//        Task test = new Task(
//                "Terminar ToDo List",
//                "Projeto louco da ZG",
//                "GZ-Hero"
//        );
//        taskManager.addTask(test);

        Task test2 = new Task(
                "C",
                "cccc",
                "cccccc"
        );
        taskManager.addTask(test2);

        Task test3 = new Task(
                "B",
                "bbbb",
                "bbbbbb"
        );
        taskManager.addTask(test3);

        Task test4 = new Task(
                "A",
                "aaaa",
                "bbbbbb"
        );
        taskManager.addTask(test4);
        //--------------------
        //taskManager.sortByName();

        System.out.println(Cli.START);

        boolean end = false;
        while (!end){
            end = Cli.mainMenu(input, taskManager);
        }
        input.close();
    }
}