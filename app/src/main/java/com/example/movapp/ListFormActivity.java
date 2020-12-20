package com.example.movapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

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
        setContentView(R.layout.activity_list_form);
        ButterKnife.bind(this);
        db = new DatabaseHelper(this);


        submitButton.setOnClickListener(this);
        ListButton.setOnClickListener(this);

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