package com.example.smartmart.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartmart.ProductDetailsActivity;
import com.example.smartmart.R;

import java.util.List;

public class MarketProductsAdapter extends RecyclerView.Adapter<MarketProductsAdapter.MyViewHolder> {


    private final Activity activity;
    private final List<Integer> imageList;
    private final List<String> nameList;
    private final List<String> descriptionList;


    public MarketProductsAdapter(Activity activity, List<Integer> imageList, List<String> nameList, List<String> descriptionList) {
        this.activity = activity;
        this.imageList = imageList;
        this.nameList = nameList;
        this.descriptionList = descriptionList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_market_products, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int imageRes = imageList.get(position);
        String productName = nameList.get(position);

        holder.imgProduct.setImageResource(imageRes);
        holder.txtProductName.setText(productName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ProductDetailsActivity.class);
                intent.putExtra("imageRes", imageRes);
                intent.putExtra("productName", productName);
                intent.putExtra("productDescription", descriptionList.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtProductName;

        MyViewHolder(View view) {
            super(view);
            imgProduct = view.findViewById(R.id.imgProduct);
            txtProductName = view.findViewById(R.id.txtProductName);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
