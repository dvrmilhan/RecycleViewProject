package com.example.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {
    public List<String> stars;
    public Context starContext;
    private final OnItemClickListener listener;

    public StarAdapter(List<String> stars,OnItemClickListener listener) {
        this.listener = listener;
        this.stars= stars;
    }

    public interface OnItemClickListener{
        void onItemClick(String star);
    }

    public class StarViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_star;
        public ImageView imageView_star;
        public CardView cardView_star;

        public StarViewHolder(@NonNull View view) {
            super(view);
            textView_star = view.findViewById(R.id.star_text);
            imageView_star = view.findViewById(R.id.star_image);
            cardView_star = view.findViewById(R.id.star_card);
        }

        public void callBackMethod(final String star, final OnItemClickListener listener){
            cardView_star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(star);
                }
            });
        }
    }


    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adepter,parent, false);
        return new StarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        holder.callBackMethod(stars.get(position),listener);
       // String star = stars.get(position);
       holder.textView_star.setText(stars.get(position));
    }

    @Override
    public int getItemCount() {
        return stars.size();
    }


}
