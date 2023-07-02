package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    /*
    */
    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogs = blogService.findAll();
        List<Category> categories = categoryService.findAll();
        LocalDate date = LocalDate.now();

        model.addAttribute("date", date);
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categories);
        return "/blog/list";
    }

    /*
     * C1
     * 
     * @GetMapping("")
     * public String showList(
     * 
     * @PageableDefault(page = 0, size = 4) Pageable pageable,
     * Model model
     * ) {
     * Page<Blog> blogs = blogService.findAll(pageable);
     * List<Category> categories = categoryService.findAll();
     * LocalDate date = LocalDate.now();
     * 
     * model.addAttribute("date", date);
     * model.addAttribute("blog", new Blog());
     * model.addAttribute("blogs", blogs);
     * model.addAttribute("categories", categories);
     * return "/blog/list";
     * }
     */

    /* C2 */
    // @GetMapping("")
    // public String showList(
    // @RequestParam(defaultValue = "0") int page,
    // Model model
    // ) {
    // Pageable pageable = PageRequest.of(page, 4);
    // Page<Blog> blogs = blogService.findAll(pageable);
    // List<Category> categories = categoryService.findAll();
    // LocalDate date = LocalDate.now();

    // model.addAttribute("date", date);
    // model.addAttribute("blog", new Blog());
    // model.addAttribute("blogs", blogs);
    // model.addAttribute("categories", categories);
    // return "/blog/list";
    // }

    @PostMapping("/create")
    public String doCreate(
            @ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @PostMapping("/update")
    public String doUpdate(
            @ModelAttribute Blog blog) {
        blogService.update(blog.getId(), blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/blog";
    }
}
