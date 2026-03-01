package com.blog.BlogingProject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name="Title")
    private String title;
    @Column(name="Content")
    private String content;
    @Column(name="Author")
    private String author;
    @Column(name="Publish_Date")
    private LocalDate date;
    public Post(int id, LocalDate date,String content, String author, String title) {
        this.id = id;
        this.date = date;

        this.author = author;
        this.content=content;
        this.title = title;
    }

    public Post() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
