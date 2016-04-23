package com.lgh.lixiang.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2015/6/26.
 */
@Getter
@Setter
@Entity
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(length = 200)
    private String title;

    @Column(length = 200)
    private String pictureUrl;
    /**
     * 内容
     */
    @Lob
    private String content;

    /**
     * 摘要
     */
    @Column(length = 500)
    private String summary;
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

    /**
     * 分类
     */
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Category category;

    /**
     * 上传时间
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date uploadTime;

    /**
     * 浏览次数
     */
    private Long views;
}
