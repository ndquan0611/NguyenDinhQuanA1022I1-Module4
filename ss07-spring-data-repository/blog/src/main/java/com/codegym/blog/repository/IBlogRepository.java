package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    @Query(value = "select * from blogs b join categories c on c.id = b.categoryID order by b.id;", nativeQuery = true)
//    List<Blog> findAllByBlogAndCategory();
//    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchTitle);

    @Query(value = "select * from blogs where title like %:title%", nativeQuery = true)
    Page<Blog> searchBlogByTitle(Pageable pageable, @Param("title") String title);

    Page<Blog> findBlogByCategoryId(Pageable pageable, Long id);

    Page<Blog> findBlogByTitleContainingAndCategoryId(Pageable pageable, String searchTitle, Long id);
}
