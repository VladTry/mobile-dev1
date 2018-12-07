package com.example.vlados.vlados5.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("books")
    private List<Book> books = null;

    public List<Book> getBooks() {
        return books;
    }


}