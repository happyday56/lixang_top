package com.lgh.lixiang.model.web;

/**
 * Created by Administrator on 2016/10/20.
 */
public class WebBlogBaseModel {
    private Long id;

    public WebBlogBaseModel() {
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

    private String title;
}
