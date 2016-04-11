package com.lgh.lixiang.service;

import com.lgh.lixiang.model.web.WebCatetoryPageModel;

/**
 * Created by lenovo on 2015/7/11.
 */
public interface CategoryService {
    WebCatetoryPageModel list(Long categoryId, Integer current, Integer length);
}
