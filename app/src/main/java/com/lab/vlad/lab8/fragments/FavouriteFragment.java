package com.lab.vlad.lab8.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lab.vlad.lab8.R;
import com.lab.vlad.lab8.entity.children.Children;
import com.lab.vlad.lab8.model.Article;
import com.lab.vlad.lab8.presenter.FavPresenter;
import com.lab.vlad.lab8.presenter.FavPresenterImpl;
import com.lab.vlad.lab8.view.FavouritesView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteFragment extends Fragment implements FavouritesView {

    public final static String FAVOURITE = "Favourite";
    private ArticleAdapter adapter;

    private FavPresenter presenter;
    @BindView(R.id.favorite_recycler_view)
    protected RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        ButterKnife.bind(this, view);
        presenter = new FavPresenterImpl(this);
        initRecyclerView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.requestDataFromStorage(getActivity());
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void setDataToRecyclerView(ArrayList <Children> childrenArrayList) {
        adapter = new ArticleAdapter(getActivity(), childrenArrayList);
        recyclerView.setAdapter(adapter);
    }
}