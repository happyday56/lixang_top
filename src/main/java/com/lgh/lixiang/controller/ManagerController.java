package com.lgh.lixiang.controller;


import com.lgh.lixiang.entity.Blog;
import com.lgh.lixiang.model.admin.AdminBlogEditRequest;
import com.lgh.lixiang.model.admin.AdminBlogListRequest;
import com.lgh.lixiang.model.admin.AdminBlogSaveRequest;
import com.lgh.lixiang.model.common.*;
import com.lgh.lixiang.model.common.PageListModel;
import com.lgh.lixiang.repository.BlogRepository;
import com.lgh.lixiang.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2015/7/14.
 */
@Controller
@RequestMapping("/man")
public class ManagerController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("manager/main");

        return view;
    }

    @RequestMapping("/bloglist")
    public ModelAndView bloglist(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("manager/bloglist");
        return view;
    }


    @RequestMapping("/bloglist.do")
    public
    @ResponseBody
    PageListModel bloglistdo(@RequestBody AdminBlogListRequest data) {

        PageListModel result = new PageListModel();

        Specification<Blog> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (!StringUtils.isEmpty(data.getKey())) {
                predicates.add(cb.like(root.get("title").as(String.class), '%' + data.getKey() + '%'));
            }
            if (data.getIsContentNull() == 1) {
                predicates.add(cb.isNull(root.get("content").as(String.class)));
            }
            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return query.getRestriction();
        };

        Page<Blog> blogs = blogRepository.findAll(specification
                , new PageRequest(data.getCurrent() - 1, data.getLength(), new Sort(Sort.Direction.DESC, "id")));

        List<AdminBlogModel> list = new ArrayList<>();

        blogs.forEach(blog -> {
            list.add(new AdminBlogModel(blog.getId(), blog.getTitle()
                    , blog.getKeywords()
                    , blog.getDescription()
                    , blog.getUploadTime()
                    , blog.getViews()
                    , blog.getCategory().getTitle()
                    ,blog.getPictureUrl()));
        });
        result.setList(list);


        Paging page = new Paging();
        page.setCurrent(data.getCurrent());
        page.setLength(data.getLength());
        page.setCount(blogs.getTotalElements());
        result.setPage(page);

        return result;
//        return AdminResult.resultWith(CommonEnum.AdminCode.SUCCESS);
    }

    @RequestMapping("/blogedit")
    public ModelAndView blogedit(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("manager/blogedit");
        return view;
    }

    @RequestMapping("/blogedit.do")
    public
    @ResponseBody
    Object blogeditdo(Long id) {

        if (id == null) {
            return categoryRepository.findAll();
        } else {
            AdminBlogEditRequest result = new AdminBlogEditRequest();
            Blog blog = blogRepository.findOne(id);
            if (blog != null) {
                result.setId(blog.getId());
                if (blog.getCategory() != null)
                    result.setCategoryId(blog.getCategory().getId());
                result.setContent(blog.getContent());
                result.setSummary(blog.getSummary());
                result.setDescription(blog.getDescription());
                result.setKeywords(blog.getKeywords());
                result.setTitle(blog.getTitle());
                result.setUploadTime(blog.getUploadTime());
                result.setViews(blog.getViews());

                result.setPictureUrl(blog.getPictureUrl());
                result.setCategories(categoryRepository.findAll());
            }
            return result;
        }

    }

    @RequestMapping("/blogedit.save")
    public
    @ResponseBody
    Integer blogeditsave(@RequestBody AdminBlogSaveRequest request) {

        if ("add".equals(request.getOperType())) {
            Blog blog = new Blog();
            blog.setContent(request.getContent());
            blog.setSummary(request.getSummary());
            blog.setDescription(request.getDescription());
            blog.setKeywords(request.getKeywords());
            blog.setTitle(request.getTitle());
            blog.setUploadTime(request.getUploadTime());
            blog.setViews(request.getViews());
            blog.setCategory(categoryRepository.findOne(request.getCategoryId()));
            blog.setPictureUrl(request.getPictureUrl());
            blogRepository.save(blog);
        } else {
            Blog blog = blogRepository.findOne(request.getId());
            blog.setContent(request.getContent());
            blog.setSummary(request.getSummary());
            blog.setDescription(request.getDescription());
            blog.setKeywords(request.getKeywords());
            blog.setTitle(request.getTitle());
            blog.setUploadTime(request.getUploadTime());
            blog.setViews(request.getViews());
            blog.setCategory(categoryRepository.findOne(request.getCategoryId()));
            blog.setPictureUrl(request.getPictureUrl());
            blogRepository.save(blog);
        }

        return 1;
    }

}
