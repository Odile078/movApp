package com.example.movapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WatchListActivity extends AppCompatActivity {
    @BindView(R.id.movienameTextView)
    TextView movienameTextView;
    @BindView(R.id.moviecategoryTextView) TextView moviecategoryTextView;
    @BindView(R.id.moviedetailTextView) TextView moviedetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_watch_list);

        ButterKnife.bind(this);

        NavigationView navigationView = findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(WatchListActivity.this, MainActivity.class);
                    case R.id.nav_movie:
                        startActivity(new Intent(WatchListActivity.this, MovieActivity.class));
                        //Intent intent2 = new Intent(MainActivity.this, ListFormActivity.class);
                    case R.id.nav_watchlist:
                        Intent intent3 = new Intent(WatchListActivity.this, ListFormActivity.class);
                    case R.id.nav_form:
                        Intent intent4 = new Intent(WatchListActivity.this, WatchListActivity.class);
                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;


            }
        });

        Intent intent = getIntent();
        String movieName = intent.getStringExtra("movieName");
        String movieCategory = intent.getStringExtra("movieCategory");
        String movieDetail = intent.getStringExtra("movieDetail");
        movienameTextView.setText("Here are all the movie: " + movieName);
        moviecategoryTextView.setText("Here are all the Category: " + movieCategory);
        moviedetailTextView.setText("Here are all the Detail: " + movieDetail);
    }
}