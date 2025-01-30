package entities;

import utils.DateTime;

import java.util.Arrays;
import java.util.List;

public class Task {

    final List<String> STATUS = Arrays.asList("ToDo", "Doing", "Done");

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public boolean setPriorityLevel(int priorityLevel) {

        if(priorityLevel >= 1 && priorityLevel <= 5){
            this.priorityLevel = priorityLevel;
            return true;
        } else {
            return false;
        }
    }

    public String getStatus() {
        return STATUS.get(statusIndex);
    }

    public boolean setStatusIndex(int statusIndex) {
        if(priorityLevel >= 0 && priorityLevel <= 2){
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
        return "Task{" +
                "STATUS=" + STATUS +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", statusIndex=" + statusIndex +
                ", startDate='" + startDate + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                '}';
    }
}
