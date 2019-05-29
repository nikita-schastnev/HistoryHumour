package com.example.nik_schastnev.historyhumour.recyclerview;

public class Post {
    private String author;
    private String description;
    private String source;
    private String title;

    public Post() {
    }

    public Post(String author, String description, String source, String title) {
        this.author = author;
        this.description = description;
        this.source = source;
        this.title = title;
    }

    // Getters and setters
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
