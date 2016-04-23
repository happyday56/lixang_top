package com.lgh.lixiang.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 热门文章
 * Created by Administrator on 2015/8/9.
 */
@Entity
@Getter
@Setter
public class BlogHot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Blog blog;
}
