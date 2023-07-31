package com.codegym.blogapi.repository;

import com.codegym.blogapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
