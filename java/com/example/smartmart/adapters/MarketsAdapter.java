package com.example.smartmart.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartmart.MarketProductsActivity;
import com.example.smartmart.R;

import java.util.List;

public class MarketsAdapter extends RecyclerView.Adapter<MarketsAdapter.MyViewHolder> {

    private Activity activity;
    private List<Integer> imageList;
    private List<String> nameList;

    public MarketsAdapter(Activity activity, List<Integer> imageList, List<String> nameList) {
        this.activity = activity;
        this.imageList = imageList;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_markets, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int imageRes = imageList.get(position);
        String placeName = nameList.get(position);



        holder.imgPlace.setImageResource(imageRes);
        holder.txtPlaceName.setText(placeName);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, MarketProductsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlace;
        TextView txtPlaceName;

        MyViewHolder(View view) {
            super(view);
            imgPlace = view.findViewById(R.id.imgPlace);
            txtPlaceName = view.findViewById(R.id.txtPlaceName);

        }
    }
}
