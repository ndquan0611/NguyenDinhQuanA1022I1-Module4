package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from Blogs b join Categories c on b.category_id = c.id order by b.id", nativeQuery = true)
    List<Blog> findAllByBlogAndCategory();
}
