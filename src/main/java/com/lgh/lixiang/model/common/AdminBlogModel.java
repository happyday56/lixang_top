package com.lgh.lixiang.model.common;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lenovo on 2015/7/17.
 */
public class AdminBlogModel {
    private Long id;
    private String title;
    private String keywords;
    private String description;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date uploadTime;
    private Long views;
    private String categoryTitle;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    private String pictureUrl;

    public AdminBlogModel(Long id, String title, String keywords, String description, Date uploadTime
            , Long views, String categoryTitle,String pictureUrl) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
        this.uploadTime = uploadTime;
        this.views = views;
        this.categoryTitle = categoryTitle;
        this.pictureUrl = pictureUrl;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public AdminBlogModel() {
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


}
