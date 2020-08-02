package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;
// devrim şafak ilhan tarfından yazıldı

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<String> stars = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rview);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        /*stars.add("Star one");
        stars.add("Star two");
        stars.add("Star tree");
        stars.add("Star four");
        stars.add("Star five");*/


        for (int i = 0; i <= 1; i++){

            stars.add("Star "+ i);
        }

        rv.setAdapter(new StarAdapter(stars, new StarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String star) {
                Toast.makeText(MainActivity.this,"Şuanda tıkladığınız item :   "+ star, LENGTH_SHORT).show();
            }
        }));
    }
}