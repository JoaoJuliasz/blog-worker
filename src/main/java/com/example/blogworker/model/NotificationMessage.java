package com.example.blogworker.model;

import java.util.List;

public class NotificationMessage {
    private List<Long> usersIds;
    private String title;
    private Long postId;

    public NotificationMessage(){}

    public NotificationMessage(List<Long> usersIds, String title, Long postId) {
        this.usersIds = usersIds;
        this.title = title;
        this.postId = postId;
    }

    public List<Long> getUsersIds() {
        return usersIds;
    }

    public void setUsersIds(List<Long> usersIds) {
        this.usersIds = usersIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
