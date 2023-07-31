package com.codegym.blogapi.controller;

import com.codegym.blogapi.model.Blog;
import com.codegym.blogapi.model.ResponseObject;
import com.codegym.blogapi.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/Blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    /* List
    List<Blog> showPage() {
        return blogService.findAll();
    }
    */

    @GetMapping("")
    Page<Blog> showPage(
            @RequestParam(defaultValue = "0") Long searchCategory,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Blog> blogs;
        if (searchCategory == 0) {
            blogs = blogService.findAll(pageable);
        } else {
            blogs = blogService.findAllAndCategoryId(pageable, searchCategory);
        }
        return blogs;
    }

    /*
    @GetMapping("")
    Page<Blog> showPage(
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 6);
        return blogService.findAll(pageable);
    }
    */

    // Detail
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Blog> foundBlogs = blogService.findById(id);
        return foundBlogs.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query blog successfully", foundBlogs)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find blog with id = " + id, "")
                );
    }

    // Insert
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertBlog(@RequestBody Blog newBlog) {
        List<Blog> foundBlogs = blogService.findBlogByTitle(newBlog.getTitle().trim());
        if (foundBlogs.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Blog title already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert Blog successfully", blogService.save(newBlog))
        );
    }

    // update
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateBlog(
            @PathVariable Long id,
            @RequestBody Blog newBlog
    ) {
        Blog updateBlog = blogService.findById(id)
                .map(blog -> {
                    blog.setTitle(newBlog.getTitle());
                    blog.setPostTime(newBlog.getPostTime());
                    blog.setAuthor(newBlog.getAuthor());
                    blog.setContent(newBlog.getContent());
                    blog.setCategory(newBlog.getCategory());
                    return blogService.save(blog);
                }).orElseGet(() -> {
                    newBlog.setId(id);
                    return blogService.save(newBlog);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Blog successfully", updateBlog)
        );
    }

    // delete
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteBlog(@PathVariable Long id) {
        boolean exist = blogService.existsById(id);
        if (exist) {
            blogService.delete(id);
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("ok", "Delete Blog successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product to delete", "")
        );
    }
}
