package com.example.movapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    @BindView(R.id.toListFormButton)
    Button toListFormButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);
        ButterKnife.bind(this);


        toListFormButton.setOnClickListener(this);

        NavigationView navigationView = findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    case R.id.nav_movie:
                        startActivity(new Intent(MainActivity.this, MovieActivity.class));
                        //Intent intent2 = new Intent(MainActivity.this, ListFormActivity.class);
                    case R.id.nav_watchlist:
                        Intent intent3 = new Intent(MainActivity.this, ListFormActivity.class);
                    case R.id.nav_form:
                        Intent intent4 = new Intent(MainActivity.this, WatchListActivity.class);
                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;


            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == toListFormButton){

            Intent intent = new Intent(MainActivity.this, ListFormActivity.class);
            startActivity(intent);
        }

    }
}