package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentsTaskQueue implements TaskQueue {

    private final String name;
    private final List<String> messageList;
    private final List<MentorObserver> mentorObserverList;

    public StudentsTaskQueue(String name) {
        this.name = name;
        messageList = new ArrayList<>();
        mentorObserverList = new ArrayList<>();
    }

    public void addTask(String task) {
        messageList.add(task);
        notifyMentor();
    }

    @Override
    public void registerMentor(MentorObserver mentorObserver) {
        mentorObserverList.add(mentorObserver);
    }

    @Override
    public void notifyMentor() {
        for (MentorObserver mentorObserver : mentorObserverList) {
            mentorObserver.update(this);
        }
    }

    @Override
    public void removeMentor(MentorObserver mentorObserver) {
        mentorObserverList.remove(mentorObserver);
    }

    public String getName() {
        return name;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public List<MentorObserver> getMentorObserverList() {
        return mentorObserverList;
    }
}
