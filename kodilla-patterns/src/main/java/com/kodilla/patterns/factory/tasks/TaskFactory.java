package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";

    public final Task doTheTask(final String taskClass) {
        return switch (taskClass) {
            case DRIVINGTASK -> new DrivingTask("pick up a friend from the airport", "airport", "bus");
            case SHOPPINGTASK -> new ShoppingTask("veggies", "carrot", 3.0);
            case PAINTINGTASK -> new PaintingTask("last task", "white", "chairs");
            default -> null;
        };
    }
}
