package com.lgh.lixiang.model.web;

import com.lgh.lixiang.model.common.WebNavModel;

import java.util.Date;

/**
 * 博客详情页
 * Created by lenovo on 2015/7/11.
 */
public class WebBlogDetailModel {
    private Long id;
    private String title;
    private String content;
    private String keywords;
    private String description;
    private Date uploadTime;
    private Long views;
    private String prevTitle;
    private String nextTitle;
    private WebNavModel nav;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getPrevTitle() {
        return prevTitle;
    }

    public void setPrevTitle(String prevTitle) {
        this.prevTitle = prevTitle;
    }

    public String getNextTitle() {
        return nextTitle;
    }

    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }

    public WebNavModel getNav() {
        return nav;
    }

    public void setNav(WebNavModel nav) {
        this.nav = nav;
    }
}
