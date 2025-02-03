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
        Task test1 = new Task(
                "Implementar pesistência",
                "Adicionar a funcionalidade de manter todas as tarefas",
                "Banco de dados"
        );
        test1.setPriorityLevel(1);
        taskManager.addTask(test1);

        Task test2 = new Task(
                "Criar front-end",
                "Criar uma interface web para integrar ao sistema",
                "Front-end"
        );
        test2.setPriorityLevel(2);
        taskManager.addTask(test2);

        Task test3 = new Task(
                "Implementar filtragem por data",
                "Criar um novo filtro que permita filtrar por data",
                "Utilitários"
        );
        test3.setPriorityLevel(4);
        taskManager.addTask(test3);
        taskManager.sortByPriority();
        //--------------------

        System.out.println(Cli.START);

        boolean end = false;
        while (!end){
            end = Cli.mainMenu(input, taskManager);
        }
        input.close();
    }
}