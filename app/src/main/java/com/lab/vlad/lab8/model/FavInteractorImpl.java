package com.lab.vlad.lab8.model;

import com.lab.vlad.lab8.entity.children.Children;
import com.lab.vlad.lab8.repositories.SharedPreferencesRepository;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class FavInteractorImpl implements FavInteractor {

    SharedPreferencesRepository preferences;

    public FavInteractorImpl(SharedPreferencesRepository preferences) {
        this.preferences = preferences;
    }

    public void getHitArrayList(FavInteractor.OnFinishedListener onFinishedListener) {
        ArrayList<Children> children = new ArrayList<>();
        Map<String, ?> map = preferences.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Children hit = new Gson().fromJson(entry.getValue().toString(), Children.class);
            children.add(hit);
        }
        onFinishedListener.addData(children);
    }
}