package com.lab.vlad.lab8.presenter;

import android.app.Activity;

import com.lab.vlad.lab8.entity.children.Children;
import com.lab.vlad.lab8.model.FavInteractor;
import com.lab.vlad.lab8.view.main.FavouritesView;

import java.util.ArrayList;

public class FavPresenterImpl extends BasePresenter implements FavPresenter,
        FavInteractor.OnFinishedListener {

    FavouritesView view;

    public FavPresenterImpl(FavouritesView view) {
        this.view = view;
    }

    public void addData(ArrayList <Children> children) {
        view.setDataToRecyclerView(children);
    }

    public void requestDataFromStorage(Activity activity) {
        getApplicationInstance(activity).getFavInteractor().
                getHitArrayList(this);
    }
}