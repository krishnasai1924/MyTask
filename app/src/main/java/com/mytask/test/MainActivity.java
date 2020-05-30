package com.mytask.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.mytask.test.Helper.RetrofitClient;
import com.mytask.test.Helper.UserService;
import com.mytask.test.Model.Resul;
import com.mytask.test.Model.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerview;
    UserService userService;
    List<Result> resulslist;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview=findViewById(R.id.recyclerview);
        resulslist=new ArrayList<>();
        adapter=new Adapter(MainActivity.this, resulslist, new Adapter.RecyclerViewItemClickListener() {
            @Override
            public void clickOnItem(Result result) {
                startActivity(new Intent(MainActivity.this,OverView.class).putExtra("data", (Parcelable) result));
            }
        });
        recyclerview.setAdapter(adapter);

        getdata();

    }

    private void getdata() {
        RetrofitClient client = new RetrofitClient("https://api.themoviedb.org/3/discover/");

        client.getServies().getlist().enqueue(new Callback<Resul>() {
            @Override
            public void onResponse(Call<Resul> call, Response<Resul> response) {
                for (int i=0;i<response.body().getResults().size();i++)
                {

                    Result resul=new Result();
                    resul.setTitle(response.body().getResults().get(i).getTitle());
                    resul.setVoteAverage(response.body().getResults().get(i).getVoteAverage());
                    resul.setOverview(response.body().getResults().get(i).getOverview());
                    resul.setId(response.body().getResults().get(i).getId());
                    resul.setPosterPath(response.body().getResults().get(i).getPosterPath());
                    resul.setReleaseDate(response.body().getResults().get(i).getReleaseDate());
                    resulslist.add(resul);
                }
adapter.notifyDataSetChanged();



            }
            @Override
            public void onFailure(Call<Resul> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
