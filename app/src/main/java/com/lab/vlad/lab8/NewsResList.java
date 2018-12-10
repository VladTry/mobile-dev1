package com.lab.vlad.lab8;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsResList {
    @SerializedName("data")
    @Expose
    private ArrayList<NewsRes> NewsResList;

    public ArrayList<NewsRes> getNewsResList() {
        return NewsResList;
    }

    public void setNewsResList(ArrayList<NewsRes> NewsResList) {
        this.NewsResList = NewsResList;
    }

    @Override
    public String toString() {
        return "NewsResList{" +
                "NewsResList=" +NewsResList +
                '}';
    }
}
