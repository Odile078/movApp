package com.example.movapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MovieActivity extends AppCompatActivity {
    int[] images = {R.drawable.cenolaholmes, R.drawable.charvie, R.drawable.christmaschrinicals, R.drawable.cmagicmoonlight, R.drawable.cmagictoafrica, R.drawable.cnightmuseum, R.drawable.cspiderwickk, R.drawable.ctheoldguard, R.drawable.chisdarkmaterials, R.drawable.cgrownish, R.drawable.csuits, R.drawable.ctinyprettythings, R.drawable.cemilyinparis, R.drawable.cgodmothered};

    String[] movie = {"Enola Holmes", "Harvie", "Christmas Chronicals", "MAgic Moonlight", "Magic Of Africa", "Night Museum", "Spider Wick", "The Old Guard", "His Dark Materials", "Grownish", "Suits", "Tiny Pretty Things", "Emily In PAris", "Godmothered"};

    String[] genre = {"Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama", "Adventure,Drama,Dance", "Adventure,Drama", "Adventure,fantasy"};

    ListView lView;

    ListAdapter lAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_movie);

        NavigationView navigationView = findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_home){
                    startActivity (new Intent(MovieActivity.this, MainActivity.class));

                }
                else if(item.getItemId()==R.id.nav_movie){
                    startActivity(new Intent(MovieActivity.this, MovieActivity.class));

                }
                else if(item.getItemId()==R.id.nav_watchlist){
                    startActivity(new Intent(MovieActivity.this, ListFormActivity.class));

                }
                else if(item.getItemId()==R.id.nav_form){
                    startActivity (new Intent(MovieActivity.this, WatchListActivity.class));

                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;


            }
        });

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