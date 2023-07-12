package com.kodilla.stream.immutable;

import java.util.Objects;

public final class ForumUser {

    private final String username;
    private final String realName;

    public ForumUser(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser forumUser)) return false;
        return Objects.equals(username, forumUser.username) && Objects.equals(realName, forumUser.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, realName);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
