package com.studyjam.ucsynoticeboard.model;

import com.google.gson.annotations.Expose;

/**
 * Created by winthanhtike on 3/2/16.
 */
public class Post {

    @Expose
    private int id;

    @Expose
    private String title;

    @Expose
    private String content;

    @Expose
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
