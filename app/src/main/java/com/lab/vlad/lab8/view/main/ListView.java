package com.lab.vlad.lab8.view.main;

import com.lab.vlad.lab8.entity.children.Children;

import java.util.ArrayList;

public interface ListView {
    void setDataToRecyclerView(ArrayList <Children> childrenArrayList);

    void refreshData(ArrayList <Children> children);

    void onResponseFailure(Throwable throwable);
}