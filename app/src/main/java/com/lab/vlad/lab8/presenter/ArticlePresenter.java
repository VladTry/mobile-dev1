package com.lab.vlad.lab8.presenter;

import android.util.Log;

import java.util.List;

import com.lab.vlad.lab8.Service.NewsapiService;
import com.lab.vlad.lab8.model.Article;
import com.lab.vlad.lab8.model.Data;
import com.lab.vlad.lab8.view.main.MainInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter {
    private NewsapiService newsapiService;
    private MainInterface mainInterface;

    public ArticlePresenter(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        if(this.newsapiService == null) this.newsapiService = new NewsapiService();
    }

    public void getArticle(){
        newsapiService.getAPI().getResults().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data data = response.body();

                if(data != null && data.getArticles() != null){
                    List<Article> articles = data.getArticles();
                    mainInterface.showList(articles);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                // try {
                Log.e("error!", t.toString());
                //     throw new InterruptedException("Something went wrong!");
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        });
    }
}
