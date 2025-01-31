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


        System.out.println(Cli.START);

        boolean end = false;
        while (!end){
            end = Cli.mainMenu(input, taskManager);
        }
        input.close();
    }
}