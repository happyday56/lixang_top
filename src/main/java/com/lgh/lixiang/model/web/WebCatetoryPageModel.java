package com.lgh.lixiang.model.web;

import com.lgh.lixiang.model.common.WebBlogModel;
import com.lgh.lixiang.model.common.WebCatetoryModel;
import com.lgh.lixiang.model.common.WebNavModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 栏目分页页面
 * Created by lenovo on 2015/7/11.
 */
@Getter
@Setter
public class WebCatetoryPageModel {
    private WebNavModel nav;
    private List<WebBlogModel> blogs;
    private String pagebar;
    private WebCatetoryModel category;
}
