package com.lab.vlad.lab8.model;

import com.lab.vlad.lab8.entity.children.Children;

import java.util.ArrayList;

public interface ListInteractor {
    interface OnFinishedListener {
        void onFinishedLoad(ArrayList<Children> hitArrayList);

        void onFinishedReload(ArrayList<Children> hitArrayList);

        void onFailure(Throwable t);
    }

    void getHitArrayList(ListInteractor.OnFinishedListener onFinishedListener, boolean dataChanged);
}