package com.nopearino.libraryapp.model;

import java.io.Serializable;

public class BookModel implements Serializable {
    private String title;
    private String author;
    private String isbn;
    private int cover;
    private String description;

    public BookModel(String title, String author, String isbn, int cover, String description) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.cover = cover;
        this.description = description;
    }

    public BookModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
