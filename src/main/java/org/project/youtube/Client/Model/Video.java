package org.project.youtube.Client.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Video {
    private UUID id;
    private String title;
    private String description;
    private String createdDateTime;
    private int likes;
    private List<Comment> comments;
    private boolean isAgeRestricted;
    private List<String> tags;
    private byte[] thumbnail;
    private String videoHandle;
    private int views;

    public Video(UUID id, String title, String description, String createdDateTime, int likes,
                 List<Comment> comments, boolean isAgeRestricted, List<String> tags, byte[] thumbnail, String videoHandle,
                 int views) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDateTime = createdDateTime;
        this.likes = likes;
        this.comments = comments;
        this.isAgeRestricted = isAgeRestricted;
        this.tags = tags;
        this.thumbnail = thumbnail;
        this.videoHandle = videoHandle;
        this.views = views;
    }

    public Video(UUID id, String title, String description, String createdDateTime, boolean isAgeRestricted,
                 List<String> tags, byte[] thumbnail, String videoHandle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDateTime = createdDateTime;
        this.isAgeRestricted = isAgeRestricted;
        this.tags = tags;
        this.thumbnail = thumbnail;
        this.videoHandle = videoHandle;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime == null ? null : LocalDateTime.parse(createdDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isAgeRestricted() {
        return isAgeRestricted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        isAgeRestricted = ageRestricted;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoHandle() {
        return videoHandle;
    }

    public void setVideoHandle(String videoHandle) {
        this.videoHandle = videoHandle;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
