package com.example.movapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    @BindView(R.id.toListFormButton)
    Button toListFormButton;
    @BindView(R.id.ListmoviesButton) Button ListmoviesButton;
    @BindView(R.id.textView)
    TextView textview1;
    @BindView(R.id.textView3) TextView textview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);
        ButterKnife.bind(this);


        toListFormButton.setOnClickListener(this);
        ListmoviesButton.setOnClickListener(this);

        /*Typeface customFont = Typeface.createFromAsset(getAssets(),"assets/Winterland.ttfjjj");
        Typeface customFont2 = Typeface.createFromAsset(getAssets(),"assets/Romantica.otf");
        textview1.setTypeface(customFont);
        textview2.setTypeface(customFont2);*/

        NavigationView navigationView = findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_home){
                    startActivity (new Intent(MainActivity.this, MainActivity.class));

                }
                else if(item.getItemId()==R.id.nav_movie){
                    startActivity(new Intent(MainActivity.this, MovieActivity.class));

                }
                else if(item.getItemId()==R.id.nav_watchlist){
                    startActivity(new Intent(MainActivity.this, ListFormActivity.class));

                }
                else if(item.getItemId()==R.id.nav_form){
                    startActivity (new Intent(MainActivity.this, WatchListActivity.class));

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
        if(view == ListmoviesButton){

            Intent intent = new Intent(MainActivity.this, MovieActivity.class);
            startActivity(intent);
        }

    }
}