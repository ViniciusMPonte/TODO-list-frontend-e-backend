package entities;

import utils.DateTime;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Task {

    public static final List<String> STATUS = Arrays.asList("ToDo", "Doing", "Done");

    String name;
    String description;
    String category;
    int priorityLevel;

    int statusIndex;

    String startDate;
    String modificationDate;
    String finishDate;


    public Task(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.priorityLevel = 1;

        this.statusIndex = 0;

        this.startDate = new DateTime().now();
        this.modificationDate = null;
        this.finishDate = null;
    }

    public Task() {
        this.name = "";
        this.description = "";
        this.category = "";
        this.priorityLevel = 1;
        this.statusIndex = 0;
        this.startDate = new DateTime().now();
        this.modificationDate = null;
        this.finishDate = null;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (Objects.equals(name, "")) {
            return false;
        }
        this.name = name;
        return true;
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (Objects.equals(description, "")) {
            return false;
        }
        this.description = description;
        return true;
    }

    public String getCategory() {
        return category;
    }

    public boolean setCategory(String category) {
        if (Objects.equals(category, "")) {
            return false;
        }
        this.category = category;
        return true;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public boolean setPriorityLevel(int priorityLevel) {

        if (priorityLevel >= 1 && priorityLevel <= 5) {
            this.priorityLevel = priorityLevel;
            return true;
        } else {
            return false;
        }
    }

    public String getStatus() {
        return STATUS.get(statusIndex);
    }

    public int getStatusIndex() {
        return statusIndex;
    }

    public boolean setStatusIndex(int statusIndex) {
        if (priorityLevel >= 0 && priorityLevel <= 2) {
            this.statusIndex = statusIndex;
            return true;
        } else {
            return false;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void updateModificationDate() {
        this.modificationDate = new DateTime().now();
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void updateFinishDate() {
        this.finishDate = new DateTime().now();
    }

    @Override
    public String toString() {
        return
                name + "\n" +
                        "   Descrição: " + description + "\n" +
                        "   Categoria: " + category + "\n" +
                        "   Prioridade: " + priorityLevel + "\n" +
                        "   Status: " + STATUS.get(statusIndex) + "\n" +
                        "   Data de criação: " + startDate + "\n" +
                        "   Data de modificação: " + modificationDate + "\n" +
                        "   Data de finalização: " + finishDate;
    }
}
