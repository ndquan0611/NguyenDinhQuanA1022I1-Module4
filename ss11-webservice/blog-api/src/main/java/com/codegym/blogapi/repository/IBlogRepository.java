package com.codegym.blogapi.repository;

import com.codegym.blogapi.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findBlogByTitle(String title);

    Page<Blog> findBlogByTitleContaining(Pageable pageable, String title);

    Page<Blog> findBlogByCategoryId(Pageable pageable, Long id);

    Page<Blog> findBlogByTitleContainingAndCategoryId(Pageable pageable, String searchTitle, Long id);

}
