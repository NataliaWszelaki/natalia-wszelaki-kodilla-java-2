package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(001, "Jan Kowalski", 'M',
                1981, 12, 12, 234));
        forumUserList.add(new ForumUser(002, "Janina Kowalska", 'F',
                1990, 03, 19, 4));
        forumUserList.add(new ForumUser(003, "Anna Kwiatkowska", 'F',
                2011, 05, 27, 15));
        forumUserList.add(new ForumUser(004, "Marek Lipowski", 'M',
                1991, 11, 17, 19));
        forumUserList.add(new ForumUser(005, "Zbigniew Jakiśtam", 'M',
                1981, 03, 07, 1));
        forumUserList.add(new ForumUser(005, "Leon Omnifarius", 'M',
                2021, 04, 20, 0));
        forumUserList.add(new ForumUser(006, "Jadwiga Kowalska", 'F',
                2001, 12, 18, 109));
        forumUserList.add(new ForumUser(007, "Maria Grabowska", 'F',
                2005, 10, 11, 0));

    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }


}
