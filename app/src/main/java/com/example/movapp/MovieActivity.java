package com.example.movapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MovieActivity extends AppCompatActivity {
    int[] images = {R.drawable.cenolaholmes, R.drawable.charvie, R.drawable.christmaschrinicals, R.drawable.cmagicmoonlight, R.drawable.cmagictoafrica, R.drawable.cnightmuseum, R.drawable.cspiderwickk, R.drawable.ctheoldguard, R.drawable.chisdarkmaterials, R.drawable.cgrownish, R.drawable.csuits, R.drawable.ctinyprettythings, R.drawable.cemilyinparis, R.drawable.cgodmothered};

    String[] movie = {"Enola Holmes", "Harvie", "Christmas Chronicals", "MAgic Moonlight", "Magic Of Africa", "Night Museum", "Spider Wick", "The Old Guard", "His Dark Materials", "Grownish", "Suits", "Tiny Pretty Things", "Emily In PAris", "Godmothered"};

    String[] genre = {"Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama,Dance", "Adventure,Drama", "Adventure,fantasy"};

    ListView lView;

    ListAdapter lAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new ListAdapter(MovieActivity.this, movie, genre, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MovieActivity.this, movie[i]+" "+genre[i], Toast.LENGTH_SHORT).show();

            }
        });
    }
}