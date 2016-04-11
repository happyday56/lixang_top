package com.lgh.lixiang.model.common;

import java.util.List;

/**
 * Created by lenovo on 2015/7/14.
 */
public class PageListModel {
    private List<?> list;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Paging getPage() {
        return page;
    }

    public void setPage(Paging page) {
        this.page = page;
    }

    private Paging page;
}
