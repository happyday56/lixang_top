package com.lgh.lixiang.model.common;

import java.util.Date;

/**
 * Created by lenovo on 2015/7/11.
 */
public class WebBlogModel {
    private Long id;
    private String title;
    private String summary;


    private String keywords;
    private String description;
    private Date uploadTime;
    private Long views;
    private String pictureUrl;

    public WebBlogModel() {
    }

    public WebBlogModel(Long id, String title, String summary, String keywords, String description, Date uploadTime, Long views, String pictureUrl) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.keywords = keywords;
        this.description = description;
        this.uploadTime = uploadTime;
        this.views = views;
        this.pictureUrl = pictureUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }


    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
