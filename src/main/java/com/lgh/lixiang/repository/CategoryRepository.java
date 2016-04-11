package com.lgh.lixiang.repository;

import com.lgh.lixiang.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2015/6/26.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
