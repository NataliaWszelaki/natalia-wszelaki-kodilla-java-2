package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{

    private  String taskName;
    private  String where;
    private  String  using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        String dependency = "I would like to stay at home";
        System.out.println(dependency);
        return dependency;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        boolean decision = false;
        if(!using.equals("tram") && !where.startsWith("W")) {
            decision = true;
        }
        return decision;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}
