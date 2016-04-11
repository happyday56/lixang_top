package com.lgh.lixiang.model.web;

import com.lgh.lixiang.model.common.WebBlogModel;
import com.lgh.lixiang.model.common.WebCatetoryModel;
import com.lgh.lixiang.model.common.WebNavModel;

import java.util.List;

/**
 * 栏目分页页面
 * Created by lenovo on 2015/7/11.
 */
public class WebCatetoryPageModel {
    private WebNavModel nav;
    private List<WebBlogModel> blogs;
    private String pagebar;

    public WebCatetoryModel getCategory() {
        return category;
    }

    public void setCategory(WebCatetoryModel category) {
        this.category = category;
    }

    private WebCatetoryModel category;

    public WebNavModel getNav() {
        return nav;
    }

    public void setNav(WebNavModel nav) {
        this.nav = nav;
    }

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
}
