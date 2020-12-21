package com.example.movapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFormActivity extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper db;
    @BindView(R.id.editTextMovieName)
    EditText editTextMovieName;
    @BindView(R.id.editTextMovieCategory) EditText editTextMovieCategory;
    @BindView(R.id.editTextMovieDetail) EditText editTextMovieDetail;
    @BindView(R.id.submitButton)
    Button submitButton;
    @BindView(R.id.ListButton) Button ListButton;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_list_form_activity);
        ButterKnife.bind(this);
        db = new DatabaseHelper(this);


        submitButton.setOnClickListener(this);
        ListButton.setOnClickListener(this);

        NavigationView navigationView = findViewById((R.id.nav_view));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //int id = item.getItemId();
                if(item.getItemId()==R.id.nav_home){
                    startActivity (new Intent(ListFormActivity.this, MainActivity.class));

                }
                else if(item.getItemId()==R.id.nav_movie){
                startActivity(new Intent(ListFormActivity.this, MovieActivity.class));

                }
                else if(item.getItemId()==R.id.nav_watchlist){
                 startActivity(new Intent(ListFormActivity.this, ListFormActivity.class));

                }
                else if(item.getItemId()==R.id.nav_form){
                 startActivity (new Intent(ListFormActivity.this, WatchListActivity.class));

                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;


            }
        });

        //validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.editTextMovieName, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.editTextMovieCategory, RegexTemplate.NOT_EMPTY,R.string.invalid_category);
        awesomeValidation.addValidation(this,R.id.editTextMovieDetail, RegexTemplate.NOT_EMPTY,R.string.invalid_detail);

    }

    @Override
    public void onClick(View view) {

        if (view == submitButton) {
            //String movieName = editTextMovieName.getText().toString();
            if(awesomeValidation.validate() ) {
                // insertData(movieName);
                // editTextMovieName.setText("");

                FragmentManager fm = getSupportFragmentManager();
                FormSuccessFragment FormSuccessFragment = new FormSuccessFragment();
                FormSuccessFragment.show(fm, "sms");
            }else{
                Toast.makeText(getApplicationContext(),"Validation faild",Toast.LENGTH_LONG).show();

            }

        }
        if (view == ListButton) {
            if(awesomeValidation.validate()) {

                String movieName = editTextMovieName.getText().toString();
                String movieCategory = editTextMovieCategory.getText().toString();
                String movieDetail = editTextMovieDetail.getText().toString();

                Intent intent = new Intent(ListFormActivity.this, WatchListActivity.class);

                intent.putExtra("movieName", movieName);
                intent.putExtra("movieCategory", movieCategory);
                intent.putExtra("movieDetail", movieDetail);


                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Validation faild",Toast.LENGTH_LONG).show();
            }
        }


    }
    /*
    public void insertData(String movieName){
        boolean insertData = db.insertData(movieName);
        if(insertData == true){
            Toast.makeText(ListFormActivity.this,"Successfully saved!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ListFormActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }*/
}