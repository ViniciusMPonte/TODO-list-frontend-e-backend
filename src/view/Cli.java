package view;
import java.util.HashMap;
import java.util.Map;

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



}