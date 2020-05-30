package com.mytask.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mytask.test.Model.Resul;
import com.mytask.test.Model.Result;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.vieholder> {
    Context context;
    List<Result> resuls;
    RecyclerViewItemClickListener recyclerViewItemClickListener;

    public Adapter(Context context, List<Result> resuls,RecyclerViewItemClickListener listener) {
        this.context = context;
        this.resuls = resuls;
        this.recyclerViewItemClickListener = listener;
    }

    class  vieholder extends RecyclerView.ViewHolder  {
ImageView imageView;
TextView title;
RelativeLayout relative;
        public vieholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.persons);
            title=itemView.findViewById(R.id.title);
            relative=itemView.findViewById(R.id.relative);
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewItemClickListener.clickOnItem(resuls.get(getAdapterPosition()));
            }
        });
        }


    }

    @NonNull
    @Override
    public Adapter.vieholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);
        return new vieholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.vieholder holder, int position) {
holder.title.setText(resuls.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+resuls.get(position).getPosterPath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resuls.size();
    }
    public interface RecyclerViewItemClickListener {
        void clickOnItem(Result result);
    }
}
