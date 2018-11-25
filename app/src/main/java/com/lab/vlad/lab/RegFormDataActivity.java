package com.lab.vlad.lab;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import com.lab.vlad.lab.CustomListView.CustomAdapter;
import com.lab.vlad.lab.CustomListView.DataModel;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

public class RegFormDataActivity extends AppCompatActivity {

    private Button btn_print_info;
    private ArrayList<DataModel> users = new ArrayList<>();
    ;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form_data);
        init();
    }

    private void load_from_pref() {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        users.add(new DataModel(sharedPreferences.getString("name", ""),
                sharedPreferences.getString("surname", ""),
                sharedPreferences.getString("email", ""),
                sharedPreferences.getString("phone", "")));
    }

    private void init() {
        btn_print_info = findViewById(R.id.btn_print_info);
        recyclerView = findViewById(R.id.rv_info);
        load_from_pref();
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        btn_print_info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                adapter = new CustomAdapter(users);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
            }
        });
    }

}