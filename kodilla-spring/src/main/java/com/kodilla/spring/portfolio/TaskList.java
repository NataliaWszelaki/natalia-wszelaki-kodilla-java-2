package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private final List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public List<String> getTasks() {

        return tasks;
    }

    public void taskAdd(int index, String task) {

        tasks.add(index, task);
        System.out.println("Task:" + task + " has been added to the list.");
    }
}