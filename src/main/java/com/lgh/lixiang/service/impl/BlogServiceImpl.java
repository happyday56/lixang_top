package com.lgh.lixiang.service.impl;

import com.lgh.lixiang.entity.*;
import com.lgh.lixiang.model.common.WebBlogModel;
import com.lgh.lixiang.model.common.WebNavModel;
import com.lgh.lixiang.model.web.WebBlogDetailModel;
import com.lgh.lixiang.model.web.WebIndexModel;
import com.lgh.lixiang.repository.BlogHotRepository;
import com.lgh.lixiang.repository.BlogRepository;
import com.lgh.lixiang.service.BlogService;
import com.lgh.lixiang.common.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2015/6/26.
 */

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogHotRepository blogHotRepository;


    public WebBlogDetailModel findOne(Long id) {
        WebBlogDetailModel result = null;

        Blog blog = blogRepository.findOne(id);
        if (blog != null) {
            result = new WebBlogDetailModel();
            result.setTitle(blog.getTitle());
            result.setDescription(blog.getDescription());
            result.setKeywords(blog.getKeywords());
            result.setUploadTime(blog.getUploadTime());

            result.setContent(blog.getContent());
            result.setId(blog.getId());
            result.setViews(blog.getViews());


            if (id > 1) {
                Blog blog1 = blogRepository.findOne(id - 1);
                if (blog1 != null)
                    result.setPrevTitle(blog1.getTitle());
            }

            Blog blog2 = blogRepository.findOne(id + 1);
            if (blog2 != null)
                result.setNextTitle(blog2.getTitle());

            WebNavModel nav = new WebNavModel();
            nav.setUrl("/category/" + blog.getCategory().getId());
            nav.setTitle(blog.getCategory().getTitle());
            result.setNav(nav);
        }
        return result;
    }


//    public WebIndexModel getIndexList(Integer current, Integer length) {
//        WebIndexModel result = new WebIndexModel();
//
//        Page<Blog> blogs = blogRepository.findAll(new PageRequest(current - 1, length, new Sort(Sort.Direction.DESC, "id")));
//
//        List<WebBlogModel> blogModels = new ArrayList<WebBlogModel>();
//        for (Blog blog : blogs) {
//            blogModels.add(new WebBlogModel(blog.getId()
//                    , blog.getTitle()
//                    , blog.getSummary()
//                    , blog.getKeywords()
//                    , blog.getDescription()
//                    , blog.getUploadTime()
//                    , blog.getViews()));
//        }
//        result.setBlogs(blogModels);
//
//        result.setPagebar(StringHelper.getPagebar(blogs.getTotalElements(), current
//                , length, "/"));
//
//        return result;
//    }

    public WebIndexModel getIndexList(Integer current, Integer length) {
        WebIndexModel result = new WebIndexModel();
        Specification<Blog> specification = new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return query.getRestriction();
            }
        };
        Page<Blog> blogs = blogRepository.findAll(specification
                , new PageRequest(current - 1, length, new Sort(Sort.Direction.DESC, "id")));

        List<WebBlogModel> blogModels = new ArrayList<WebBlogModel>();
        for (Blog blog : blogs) {
            blogModels.add(new WebBlogModel(blog.getId()
                    , blog.getTitle()
                    , blog.getSummary()
                    , blog.getKeywords()
                    , blog.getDescription()
                    , blog.getUploadTime()
                    , blog.getViews()
                    , blog.getPictureUrl()));
        }

        result.setBlogs(blogModels);

        result.setPagebar(StringHelper.getPagebar(blogs.getTotalElements(), current
                , length, "/"));

        return result;
    }

    @Override
    public void countHot() {

        blogHotRepository.deleteAll();
//        blogHotRepository.flush();

        Specification<Blog> specification = new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return query.getRestriction();
            }
        };
        Page<Blog> blogs = blogRepository.findAll(specification
                , new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "views")));

        List<BlogHot> blogHots = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogHot blogHot = new BlogHot();
            blogHot.setBlog(blog);
            blogHots.add(blogHot);
        }
        blogHotRepository.save(blogHots);
    }


}
