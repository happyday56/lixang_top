package com.lgh.lixiang.repository;

import com.lgh.lixiang.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lenovo on 2015/6/26.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

//    Blog findByTitle(String title);

    @Transactional
    @Modifying
    @Query(value = "update Blog as b set b.content=?1 where b.title=?2")
    void updateContentByTitle(String content, String title);

    @Query(value = "select blog.title from Blog blog GROUP BY blog.title HAVING count(blog.title)>1 ")
    List<String> listRepeatTitle();


    @Transactional
    @Modifying
    @Query(value = "update Blog set pictureUrl=?1 where id=?2")
    void updatePictureUrlById(String pictureUrl, Long id);

//    @Transactional
//    @Modifying
//    @Query(value = "update Blog set views = views + ?2 where id=?1")
//    void updateViews(Long id, Long views);
}
