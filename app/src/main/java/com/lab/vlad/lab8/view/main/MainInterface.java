package com.lab.vlad.lab8.view.main;

import java.util.List;

import com.lab.vlad.lab8.model.Article;

public interface MainInterface {
    void showList(List<Article> articles);
    void showArticle(String url);
}