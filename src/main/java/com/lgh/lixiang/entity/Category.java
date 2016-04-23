package com.lgh.lixiang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * 分类
 * Created by lenovo on 2015/6/26.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(length = 20)
    private String title;
    /**
     * 关键字
     */
    @Column(length = 200)
    private String keywords;
    /**
     * 描述
     */
    @Column(length = 500)
    private String description;

    public Category(String title, String keywords, String description) {
        this.title = title;
        this.keywords = keywords;
        this.description = description;
    }
}
