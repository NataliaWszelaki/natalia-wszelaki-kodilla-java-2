package com.kodilla.patterns2.observer.homework;

public interface TaskQueue {

    void registerMentor(MentorObserver mentorObserver);
    void notifyMentor();
    void removeMentor(MentorObserver mentorObserver);
}
