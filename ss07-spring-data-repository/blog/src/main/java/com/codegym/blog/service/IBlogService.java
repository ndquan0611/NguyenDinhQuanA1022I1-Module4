package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable, String title);

    Page<Blog> searchTitle(Pageable pageable, String title);

    Page<Blog> searchCategory(Pageable pageable, Long id);

    Page<Blog> searchTitleAndCategory(Pageable pageable, String title, Long id);

    void save(Blog blog);

    void update(Long id, Blog blog);

    void delete(Long id);

    Blog findById(Long id);
}
