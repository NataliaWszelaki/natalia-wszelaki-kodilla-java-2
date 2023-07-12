package com.kodilla.testing.forum.statistics;


import java.util.List;

public class AdvancedStatistics {

    private Statistics statistics;
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;


    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        averageNumberOfPostsPerUser = calculateAverageNumberOfPostsPerUser();
        averageNumberOfCommentsPerUser = averageNumberOfCommentsPerUser();
        averageNumberOfCommentsPerPost = averageNumberOfCommentsPerPost();

    }

    public double calculateAverageNumberOfPostsPerUser() {
        if (numberOfUsers > 0) {
            return (double)numberOfPosts / (double)numberOfUsers;
        } else {
            return 0.0;
        }
    }

    public double averageNumberOfCommentsPerUser() {
        if (numberOfUsers > 0) {
            return (double)numberOfComments / (double)numberOfUsers;

        } else {
            return 0.0;
        }
    }
    public double averageNumberOfCommentsPerPost() {
        if (numberOfPosts > 0) {
            return (double)numberOfComments / (double)numberOfPosts;

        } else {
            return 0.0;
        }
    }


    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public double getNumberOfPosts() {
        return numberOfPosts;
    }

    public double getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public void showStatistics() {
        System.out.println("Advanced statistics");
        System.out.println("Number of Users: " + numberOfUsers);
        System.out.println("Number of Posts: " + numberOfPosts);
        System.out.println("Number of Comments: " + numberOfComments);
        System.out.println("Average number of Posts per User: " + averageNumberOfPostsPerUser);
        System.out.println("Average number of Comments per User: " + averageNumberOfCommentsPerUser);
        System.out.println("Average number of Comments per Post: " + averageNumberOfCommentsPerPost);

    }
}
