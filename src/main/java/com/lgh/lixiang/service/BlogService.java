package com.lgh.lixiang.service;


import com.lgh.lixiang.model.web.WebBlogDetailModel;
import com.lgh.lixiang.model.web.WebIndexModel;

/**
 * Created by lenovo on 2015/6/26.
 */

public interface BlogService {
    WebBlogDetailModel findOne(Long id);

    WebIndexModel getIndexList(Integer current, Integer length);

    /**
     * 统计热门
     */
    void countHot();
}
