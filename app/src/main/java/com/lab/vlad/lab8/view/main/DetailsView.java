package com.lab.vlad.lab8.view.main;

import com.lab.vlad.lab8.entity.children.Children;

public interface DetailsView {
    void addToFavourite();

    void removeFromFavourite();

    void markFavourite(boolean favourite);

    void setItems(Children hit);
}