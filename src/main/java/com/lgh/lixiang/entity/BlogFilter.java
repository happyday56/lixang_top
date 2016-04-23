package com.lgh.lixiang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lenovo on 2015/7/12.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogFilter {
    /**
     * 标题
     */
    @Column(length = 200)
    @Id
    private String title;
}
