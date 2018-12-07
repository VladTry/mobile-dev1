package com.example.vlados.vlados5;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.vlados.vlados5.Entity.Book;
import com.example.vlados.vlados5.Entity.Result;
import com.example.vlados.vlados5.Retrofit.APIServise;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<Result> {

    private final static String BASE_URL = "https://api.itbook.store/1.0/";
    private final static String TAG = "Controller";


    public void start() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIServise apiServise = retrofit.create(APIServise.class);
        Call<Result> call = apiServise.getData();
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call <Result> call, @NonNull Response<Result> response) {
        Log.d(TAG, "onResponse: Server Response: " + response.toString());
        Log.d(TAG, "onResponse: received information: " +
                Objects.requireNonNull(response.body()).toString());
        List<Book> books = response.body().getBooks();
        displayData(books);
    }

    @Override
    public void onFailure(@NonNull Call <Result> call, @NonNull Throwable t) {
        Log.e("onFailure", t.getMessage());
    }

    private void displayData(List <Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Log.d("Data", books.get(i).toString() +
                    "\n--------------------------------------");
        }
    }
}
