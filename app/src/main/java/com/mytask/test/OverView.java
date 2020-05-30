package com.mytask.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mytask.test.Model.Result;

public class OverView extends AppCompatActivity {
TextView overview,title,avrgrating,date;
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view);
        image=findViewById(R.id.image);
        title=findViewById(R.id.title);
        avrgrating=findViewById(R.id.avrgrating);
        date=findViewById(R.id.date);
        overview=findViewById(R.id.overview);
        Intent intent=getIntent();
        Result result=intent.getParcelableExtra("data");

        title.setText(result.getTitle());
        date.setText(result.getReleaseDate());
        overview.setText(result.getOverview());
        avrgrating.setText(String.valueOf(result.getVoteAverage()));
        Glide.with(OverView.this).load("https://image.tmdb.org/t/p/w500"+result.getPosterPath()).into(image);
    }
}
