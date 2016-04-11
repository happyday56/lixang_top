package com.lgh.lixiang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lenovo on 2015/7/12.
 */

@Entity
public class BlogFilter {
    /**
     * 标题
     */
    @Column(length = 200)
    @Id
    private String title;

    public BlogFilter(String title) {
        this.title = title;
    }

    public BlogFilter() {
    }
}
