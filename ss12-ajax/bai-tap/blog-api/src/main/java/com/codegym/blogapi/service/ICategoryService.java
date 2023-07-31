package com.codegym.blogapi.service;

import com.codegym.blogapi.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
