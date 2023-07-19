package com.codegym.blogapi.service.impl;

import com.codegym.blogapi.model.Blog;
import com.codegym.blogapi.repository.IBlogRepository;
import com.codegym.blogapi.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Blog> findBlogByTitle(String title) {
        return repository.findBlogByTitle(title);
    }

    @Override
    public Page<Blog> findAllAndCategoryId(Pageable pageable, Long id) {
        return repository.findBlogByCategoryId(pageable, id);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
