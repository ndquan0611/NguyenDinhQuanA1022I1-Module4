package com.codegym.blogapi.controller;

import com.codegym.blogapi.model.Category;
import com.codegym.blogapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Categories")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
