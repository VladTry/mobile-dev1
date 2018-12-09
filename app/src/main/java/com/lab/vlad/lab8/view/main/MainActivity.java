package com.lab.vlad.lab8.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import com.lab.vlad.lab8.R;
import com.lab.vlad.lab8.adapter.MainAdapter;
import com.lab.vlad.lab8.model.Article;
import com.lab.vlad.lab8.presenter.ArticlePresenter;
import com.lab.vlad.lab8.view.webview.WebViewActivity;

public class MainActivity extends AppCompatActivity implements MainInterface {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("WSJ - Recent");

        recyclerView = findViewById(R.id.rv_main);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArticlePresenter articlePresenter = new ArticlePresenter(this);
        articlePresenter.getArticle();
    }

    @Override
    public void showList(List<Article> articles) {
        adapter = new MainAdapter(this, articles, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showArticle(String url) {
        Intent mIntent = new Intent(this, WebViewActivity.class);
        mIntent.putExtra("URL", url);
        startActivity(mIntent);
    }
}

