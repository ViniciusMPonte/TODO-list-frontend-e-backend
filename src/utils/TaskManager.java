package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import entities.Task;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskManager() {

    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
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
            System.out.println(task);
        }
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
}