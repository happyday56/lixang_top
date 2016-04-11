package com.lgh.lixiang.repository;

import com.lgh.lixiang.entity.BlogFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2015/7/12.
 */
@Repository
public interface BlogFilterRepository extends JpaRepository<BlogFilter, String>, JpaSpecificationExecutor<BlogFilter> {
}
