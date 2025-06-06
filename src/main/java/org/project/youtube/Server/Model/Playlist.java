package org.project.youtube.Server.Model;

import java.util.List;
import java.util.UUID;

public class Playlist {
    private UUID id;
    private String name;
    private String channelHandle;
    private String description;
    private List<Video> videos;
    private List<Short> shorts;
    private byte[] image;
    private boolean isPublic;

    public Playlist(List<Video> videos, UUID id, String name, String channelHandle, String description, List<Short> shorts,
                    byte[] image) {
        this.videos = videos;
        this.id = id;
        this.name = name;
        this.channelHandle = channelHandle;
        this.description = description;
        this.shorts = shorts;
        this.image = image;
    }

    public Playlist(UUID id, String name, String channelHandle, String description, List<Video> videos, List<Short> shorts,
                    byte[] image, boolean isPublic) {
        this.id = id;
        this.name = name;
        this.channelHandle = channelHandle;
        this.description = description;
        this.videos = videos;
        this.shorts = shorts;
        this.image = image;
        this.isPublic = isPublic;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelHandle() {
        return channelHandle;
    }

    public void setChannelHandle(String channelHandle) {
        this.channelHandle = channelHandle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Short> getShorts() {
        return shorts;
    }

    public void setShorts(List<Short> shorts) {
        this.shorts = shorts;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
