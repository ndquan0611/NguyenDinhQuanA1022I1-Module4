package com.codegym.blogapi.service.impl;

import com.codegym.blogapi.model.Category;
import com.codegym.blogapi.repository.ICategoryRepository;
import com.codegym.blogapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
