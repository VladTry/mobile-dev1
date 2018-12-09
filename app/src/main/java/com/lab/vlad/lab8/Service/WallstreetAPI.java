package com.lab.vlad.lab8.Service;

import com.lab.vlad.lab8.model.Data;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WallstreetAPI {
    @GET("v2/everything?domains=wsj.com&apiKey=ccdc9e113c2042549554fed8c4c7ec7e")
    Call<Data> getResults();
}

