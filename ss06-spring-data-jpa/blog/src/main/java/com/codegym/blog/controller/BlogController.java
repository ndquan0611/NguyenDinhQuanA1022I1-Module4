package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(
            @PageableDefault(page = 0, size = 4)
                    Pageable pageable,
            Model model
    ) {
//        Page<Blog> pages = blogService.findAll(pageable);
        List<Blog> pages = blogService.findAll();
        model.addAttribute("pages", pages);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showDetail(
            @RequestParam int id,
            Model model
    ) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/detail";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(
            @PathVariable int id,
            Model model
    ) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String doUpdate(
            @ModelAttribute Blog blog
    ) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(
            @PathVariable int id
    ) {
        blogService.remove(id);
        return "redirect:/blog";
    }
}
