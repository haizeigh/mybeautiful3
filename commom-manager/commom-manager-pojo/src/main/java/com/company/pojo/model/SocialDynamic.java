package com.company.pojo.model;

import java.io.Serializable;
import java.util.Date;

public class SocialDynamic implements Serializable {
    private Integer id;

    private String username;

    private String content;

    private String picture;

    private String multiMedia;

    private Date time;

    private String commented;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getMultiMedia() {
        return multiMedia;
    }

    public void setMultiMedia(String multiMedia) {
        this.multiMedia = multiMedia == null ? null : multiMedia.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCommented() {
        return commented;
    }

    public void setCommented(String commented) {
        this.commented = commented == null ? null : commented.trim();
    }
}
