package com.codegym.blogapi.service;

import com.codegym.blogapi.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findBlogByTitle(String title);

    Page<Blog> findAllAndCategoryId(Pageable pageable, Long id);

    Optional<Blog> findById(Long id);

    boolean existsById(Long id);

    Blog save(Blog blog);

    void delete(Long id);
}
