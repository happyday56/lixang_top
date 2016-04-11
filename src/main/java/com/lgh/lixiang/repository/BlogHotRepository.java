package com.lgh.lixiang.repository;

import com.lgh.lixiang.entity.BlogHot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015/8/9.
 */

@Repository
public interface BlogHotRepository extends JpaRepository<BlogHot, Long>, JpaSpecificationExecutor<BlogHot> {
    
}
