package com.lab.vlad.lab8;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsRes {

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("Title")
    @Expose
    private String Title;

    @Override
    public String toString() {
        return "NewsRes{" +
                "author='" + author + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
}
