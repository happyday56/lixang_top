package com.lgh.lixiang.model.web;

import com.lgh.lixiang.model.common.WebBlogModel;

import java.util.List;

/**
 * Created by lenovo on 2015/7/11.
 */
public class WebIndexModel {
    private List<WebBlogModel> blogs;

    public List<WebBlogModel> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<WebBlogModel> blogs) {
        this.blogs = blogs;
    }

    public String getPagebar() {
        return pagebar;
    }

    public void setPagebar(String pagebar) {
        this.pagebar = pagebar;
    }

    private String pagebar;
}
