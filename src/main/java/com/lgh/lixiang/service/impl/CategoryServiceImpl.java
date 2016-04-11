package com.lgh.lixiang.service.impl;

import com.lgh.lixiang.entity.Blog;
import com.lgh.lixiang.entity.Category;
import com.lgh.lixiang.model.common.WebBlogModel;
import com.lgh.lixiang.model.common.WebCatetoryModel;
import com.lgh.lixiang.model.common.WebNavModel;
import com.lgh.lixiang.model.web.WebCatetoryPageModel;
import com.lgh.lixiang.repository.BlogRepository;
import com.lgh.lixiang.repository.CategoryRepository;
import com.lgh.lixiang.service.CategoryService;
import com.lgh.lixiang.common.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2015/7/11.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public WebCatetoryPageModel list(Long categoryId, Integer current, Integer length) {
        WebCatetoryPageModel result = new WebCatetoryPageModel();

        //导航
        Category category = categoryRepository.findOne(categoryId);
        WebNavModel nav = new WebNavModel();
        nav.setUrl("/category/" + categoryId);
        nav.setTitle(category.getTitle());
        result.setNav(nav);

        //查找分页数据
        Specification<Blog> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            predicates.add(cb.equal(root.get("category").as(Category.class), category));
            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return query.getRestriction();
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

        WebCatetoryModel webCatetoryModel = new WebCatetoryModel();
        webCatetoryModel.setTitle(category.getTitle());
        webCatetoryModel.setDescription(category.getDescription());
        webCatetoryModel.setKeywords(category.getKeywords());
        webCatetoryModel.setId(category.getId());
        result.setCategory(webCatetoryModel);

        result.setPagebar(StringHelper.getPagebar(blogs.getTotalElements(), current
                , length, "/category/" + categoryId + "/"));

        return result;
    }
}
