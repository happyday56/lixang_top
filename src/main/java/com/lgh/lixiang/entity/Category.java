package com.lgh.lixiang.entity;

import javax.persistence.*;

/**
 * Created by lenovo on 2015/6/26.
 */
@Entity
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

//    /**
//     * 包含的博文
//     */
//    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
//    private List<Blog> blogs;
//
    public Category(String title, String keywords, String description) {
        this.title = title;
        this.keywords = keywords;
        this.description = description;
    }

    public Category() {
    }

//    public List<Blog> getBlogs() {
//        return blogs;
//    }
//
//    public void setBlogs(List<Blog> blogs) {
//        this.blogs = blogs;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
