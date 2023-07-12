package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public final class ForumUser {

    private final int userId;
    private final String userName;
    private final char userSex;
    private final LocalDate userDayOfBirth;
    private final int postsQty;

    public ForumUser(final int userId, final String userName, final char userSex, final int yearOfBirth,
                     final int monthOfBirth, final int dayOfBirth, final int postsQty) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userDayOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsQty = postsQty;
    }

    public int userAge() {
        return LocalDateTime.now().getYear() - getUserDayOfBirth().getYear();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getUserDayOfBirth() {
        return userDayOfBirth;
    }

    public int getPostsQty() {
        return postsQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser forumUser)) return false;
        return userId == forumUser.userId && userSex == forumUser.userSex && postsQty == forumUser.postsQty && Objects.equals(userName, forumUser.userName) && Objects.equals(userDayOfBirth, forumUser.userDayOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSex, userDayOfBirth, postsQty);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userDayOfBirth=" + userDayOfBirth +
                ", postsQty=" + postsQty +
                '}';
    }
}
