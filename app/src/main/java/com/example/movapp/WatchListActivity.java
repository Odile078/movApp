package com.example.movapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
        setContentView(R.layout.activity_watch_list);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String movieName = intent.getStringExtra("movieName");
        String movieCategory = intent.getStringExtra("movieCategory");
        String movieDetail = intent.getStringExtra("movieDetail");
        movienameTextView.setText("Here are all the movie: " + movieName);
        moviecategoryTextView.setText("Here are all the Category: " + movieCategory);
        moviedetailTextView.setText("Here are all the Detail: " + movieDetail);
    }
}