package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void update(Long id, Blog blog) {
        Blog existedBlog = repository.findById(id).orElse(null);
        if (existedBlog != null) {
            // update
            existedBlog.setName(blog.getName());
            existedBlog.setPostTime(blog.getPostTime());
            existedBlog.setAuthor(blog.getAuthor());
            existedBlog.setCategory(blog.getCategory());
            existedBlog.setContent(blog.getContent());

            repository.save(existedBlog);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Blog findById(Long id) {
        return null;
    }
}
