package com.example.vlados.vlados5.Retrofit;

import com.example.vlados.vlados5.Entity.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServise {

    @GET("new")
    Call <Result> getData();
}