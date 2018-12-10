package com.lab.vlad.lab8.presenter;

import android.app.Activity;

import com.lab.vlad.lab8.entity.children.Children;
import com.lab.vlad.lab8.fragments.FavouriteFragment;
import com.lab.vlad.lab8.model.ListInteractor;
import com.lab.vlad.lab8.view.main.ListView;

import java.util.ArrayList;

public class ListPrisenterImpl extends ArticlePresenter implements ListPresenter,
        ListInteractor.OnFinishedListener {

    private ListView view;

    public ListPrisenterImpl(ListView listView) {
        this.view = listView;
    }

    @Override
    public void requestDataFromServer(Activity activity) {
        getApplicationInstance(activity).getMainInteractor()
                .getHitArrayList(this, false);
    }

    @Override
    public void updateDataFromServer(Activity activity) {
        getApplicationInstance(activity).getMainInteractor()
                .getHitArrayList(this, true);
    }

    @Override
    public void onFinishedLoad(ArrayList <Children> childrenArrayList) {
        if (view != null) {
            view.setDataToRecyclerView(childrenArrayList);
        }
    }

    @Override
    public void onFinishedReload(ArrayList <Children> childrenArrayList) {
        if (view != null) {
            view.refreshData(childrenArrayList);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        if (view != null) {
            view.onResponseFailure(throwable);
        }
    }

    @Override
    public void goToFavourites(Activity activity) {
        getApplicationInstance(activity).getFragmentHandler().setFragment(new FavouriteFragment());
    }
}