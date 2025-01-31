package utils;
import java.util.*;
import entities.Task;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskManager() {

    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public boolean validateNewTaskName(String name) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateNewTaskDescription(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                return false;
            }
        }
        return true;
    }

    public boolean removeTask(String taskName) {
        return tasks.removeIf(task -> task.getName().equalsIgnoreCase(taskName));
    }

    public void sortByName() {
        Collections.sort(tasks, Comparator.comparing(Task::getName));
    }

    public void sortByPriority() {
        Collections.sort(tasks, Comparator.comparing(Task::getPriorityLevel));
    }

    public void sortByStatus() {
        Collections.sort(tasks, Comparator.comparing(Task::getStatus));
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }

    public List<String> listCategories() {
        Set<String> uniqueCategories = new HashSet<>();

        for (Task task : tasks) {
            if (task.getCategory() != null) {
                uniqueCategories.add(task.getCategory());
            }
        }

        List<String> sortedCategories = new ArrayList<>(uniqueCategories);
        Collections.sort(sortedCategories);

        for (String category : sortedCategories) {
            System.out.println(category);
        }
        return sortedCategories;
    }

    public List<Task> filterByCategory(String category) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getCategory().contains(category)) {
                result.add(task);
            }
        }
        return result;
    }

}