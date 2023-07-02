package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    /* List
    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
    */

    /* C1
    @GetMapping("")
    public String showList(
            @PageableDefault(page = 0, size = 5) Pageable pageable,
            Model model
    ) {
        Page<Blog> blogs = blogService.findAll(pageable);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
    */

    @GetMapping("")
    public String showList(
            @RequestParam(defaultValue = "") String searchTitle,
            @RequestParam(defaultValue = "0") Long searchCategory,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("title").ascending());
//        Page<Blog> blogs = blogService.findAll(pageable);
//        Page<Blog> blogs = blogService.findAll(pageable, searchTitle);
        Page<Blog> blogs;
        if (searchTitle.equals("") && searchCategory == 0 || !searchTitle.isEmpty() && searchCategory == 0) {
            blogs = blogService.searchTitle(pageable, searchTitle);
        } else if (searchTitle.equals("")) {
            blogs = blogService.searchCategory(pageable, searchCategory);
        } else {
            blogs = blogService.searchTitleAndCategory(pageable, searchTitle, searchCategory);
        }
        int totalPages = blogs.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages) // tạo một stream gồm số nguyên nằm từ 1 -> totalPages
                    .boxed() // chuyển stream của các số nguyên thành đối tượng Interger
                    .collect(Collectors.toList()); // thu thập các phần tử stream thành một danh sách
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchCategory", searchCategory);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(
            Model model
    ) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categories);
        return "/blog/create";
    }

    @PostMapping("/create")
    public String doCreate(
            @ModelAttribute Blog blog
    ) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(
            @PathVariable Long id,
            Model model
    ) {
        Blog blog = blogService.findById(id);
        List<Category> categories = categoryService.findAll();

        model.addAttribute("blog", blog);
        model.addAttribute("categories", categories);
        return "/blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(
            @ModelAttribute Blog blog
    ) {
        blogService.update(blog.getId(), blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showDetail(
            @RequestParam Long id,
            Model model
    ) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(
            @PathVariable Long id
    ) {
        blogService.delete(id);
        return "redirect:/blog";
    }
}
