package com.codegym.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "Blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "DATE")
    private String postTime;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(String title, String postTime, String author, String content) {
        this.title = title;
        this.postTime = postTime;
        this.author = author;
        this.content = content;
    }

    public Blog(String title, String postTime, String author, String content, Category category) {
        this.title = title;
        this.postTime = postTime;
        this.author = author;
        this.content = content;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
