package com.kodilla.patterns2.observer.homework;

public class Mentor implements MentorObserver {

    private final String name;

    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(StudentsTaskQueue studentsTaskQueue) {
        System.out.println(name + " : New tasks in queue: " + studentsTaskQueue.getName() + "\n" +
        " (total: " + studentsTaskQueue.getMessageList().size() + " tasks)");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
