package com.lab.vlad.lab8.model;

import com.lab.vlad.lab8.entity.children.Children;

import java.util.ArrayList;

public interface FavInteractor {
    interface OnFinishedListener {
        void addData(ArrayList<Children> hits);
    }
    void getHitArrayList(FavInteractor.OnFinishedListener onFinishedListener);
}
