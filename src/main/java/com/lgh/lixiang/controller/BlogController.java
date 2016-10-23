package com.lgh.lixiang.controller;

import com.lgh.lixiang.entity.*;
import com.lgh.lixiang.model.web.WebBlogBaseModel;
import com.lgh.lixiang.model.web.WebBlogDetailModel;
import com.lgh.lixiang.repository.*;
import com.lgh.lixiang.service.*;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.apache.log4j.Logger;


/**
 * Created by lenovo on 2015/6/26.
 */


@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
public class BlogController {

    private Log log = LogFactory.getLog(BlogController.class);

    @Autowired
    private BlogService blogService;


    @Autowired
    private SpliderService spliderService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;


    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogHotRepository blogHotRepository;

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request) {
//        log.info("enter index");
        return index(request, 1);
//        return test(request);
    }


    public ModelAndView test(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("test");
        return view;
    }

    @RequestMapping(value = "/{page}")
    public ModelAndView index(HttpServletRequest request, @PathVariable("page") Integer page) {
//        log.info("enter index page" + page);
        ModelAndView view = new ModelAndView("index");
        request.setAttribute("list", blogService.getIndexList(page, 20));
        setSideBar(request);
        setNearlist(request);
        return view;
    }


    /**
     * 分类页面
     *
     * @param request
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/category/{id}")
    public ModelAndView category(HttpServletRequest request, @PathVariable("id") long id) throws SQLException {
//        log.info("enter category id " + id);
        return category(request, id, 1);
    }

    @RequestMapping(value = "/category/{id}/{page}")
    public ModelAndView category(HttpServletRequest request
            , @PathVariable("id") long categoryId, @PathVariable("page") Integer page) throws SQLException {
//        log.info("enter category id " + categoryId + " page " + page);
        ModelAndView view = new ModelAndView("category");
        request.setAttribute("list", categoryService.list(categoryId, page, 10));

        setSideBar(request);
        setNearlist(request);
        return view;
    }


    /**
     * 具体详情页
     *
     * @param request
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/v/{id}", method = RequestMethod.GET)
    public ModelAndView blog(HttpServletRequest request, @PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("blog");
        WebBlogDetailModel blog = blogService.findOne(id);
        request.setAttribute("item", blog);

        setSideBar(request);
        setNearlist(request);
        return view;
    }

//    @RequestMapping(value = "/links")
//    public ModelAndView links(HttpServletRequest request) {
//        ModelAndView view = new ModelAndView("links");
//        return view;
//    }


    /**
     * 页面浏览计数
     *
     * @param id
     */
    @RequestMapping(value = "/viewcount", method = RequestMethod.GET)
    @ResponseBody
    public void viewcount(@RequestParam Long id) throws Exception {
        log.info("enter viewcount " + id);
        Blog blog = blogRepository.findOne(id);
        if (blog != null) {
            blog.setViews(blog.getViews() + 1);
            blogRepository.save(blog);
        }
    }

    @RequestMapping(value = "/about")
    public ModelAndView about(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("about");

        setSideBar(request);
        setNearlist(request);
        return view;
    }

    @RequestMapping(value = "/as")
    public ModelAndView as(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("as");
        setSideBar(request);
        setNearlist(request);
        return view;
    }

    @RequestMapping(value = "/links")
    public ModelAndView links(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("links");
        setSideBar(request);
        setNearlist(request);
        return view;
    }


    @RequestMapping(value = "/404error")
    public ModelAndView error(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("404error");
        setSideBar(request);
        setNearlist(request);
        return view;
    }


    @RequestMapping("/init")
    public
    @ResponseBody
    long init() throws Exception {
        if (categoryRepository.count() == 0) {
            //初始化分类
            categoryRepository.save(Arrays.asList(
                    new Category("互联网", "", ""),
                    new Category("移动互联网", "", ""),
                    new Category("游戏娱乐", "", ""),
                    new Category("电子商务", "", ""),
                    new Category("健康时尚", "", "")
            ));
        }

//        Category category = categoryRepository.findOne(7L);
//
//        category.setTitle("热点");
//        categoryRepository.save(category);
//
//        List<Blog> blogs = blogRepository.findAll();
//        for (Blog blog : blogs) {
//            String processSummary = blog.getSummary();
//            if (processSummary.length() > 150) processSummary = processSummary.substring(0, 150);
//            if (processSummary.lastIndexOf("。") > 0) {
//                processSummary = processSummary.substring(0, processSummary.lastIndexOf("。") + 1);
//            } else if (processSummary.lastIndexOf("！") > 0) {
//                processSummary = processSummary.substring(0, processSummary.lastIndexOf("！") + 1);
//            }
//            blog.setSummary(processSummary);
//
//            blogRepository.save(blog);
//        }

        return categoryRepository.count();
    }

    @RequestMapping("/repeat")
    public
    @ResponseBody
    List<String> repeat() throws Exception {
        List<String> list = blogRepository.listRepeatTitle();
        return list;
    }

    @RequestMapping("/inithot")
    public
    @ResponseBody
    String inithot() throws Exception {
        blogService.countHot();
        return "finished";
    }

    @RequestMapping("/picture")
    public
    @ResponseBody
    String picture() throws Exception {
        Integer count = 0;
        List<Blog> blogs = blogRepository.findAll();
        for (Blog blog : blogs) {
            String pictureUrl = "";
            String content = blog.getContent();

            if (!StringUtils.isEmpty(content)) {
                Source source = new Source(content);
                StartTag startTag = source.getFirstStartTag("img");
                if (startTag != null) {
                    pictureUrl = startTag.getAttributeValue("src");
                    if (pictureUrl.length() > 200) pictureUrl = "";
                    count++;
                }
            }

            blogRepository.updatePictureUrlById(pictureUrl, blog.getId());
        }
        return count.toString();
    }

    @RequestMapping("/splider")
    public
    @ResponseBody
    String splider() throws Exception {
        spliderService.start();
        return "finished";
    }


    private void setSideBar(HttpServletRequest request) {
        List<BlogHot> list = blogHotRepository.findAll();
        list.forEach(p -> p.getBlog().setTitle(p.getBlog().getTitle().length() > 15 ? p.getBlog().getTitle().substring(0, 15) : p.getBlog().getTitle()));
        request.setAttribute("sidebar", list);
    }

    private void setNearlist(HttpServletRequest request) {
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "id"));
        Page<Blog> blogs = blogRepository.findAll(pageable);
        List<WebBlogBaseModel> webBlogBaseModels = new ArrayList<>();
        blogs.forEach(x -> {
            WebBlogBaseModel blogBaseModel = new WebBlogBaseModel();
            blogBaseModel.setId(x.getId());
            blogBaseModel.setTitle(x.getTitle().length() > 15 ? x.getTitle().substring(0, 15) : x.getTitle());
            webBlogBaseModels.add(blogBaseModel);
        });
        request.setAttribute("nearlist", webBlogBaseModels);
    }
}
