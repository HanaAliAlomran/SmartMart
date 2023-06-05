package com.example.smartmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smartmart.databinding.ActivityProductDetailsBinding;
import com.example.smartmart.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity {

    private ActivityProductDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Retrieve the passed data
        int imageRes = getIntent().getIntExtra("imageRes", R.drawable.product);
        String productName = getIntent().getStringExtra("productName");
        String productDescription = getIntent().getStringExtra("productDescription");

        // Update the views
        binding.imgProduct.setImageResource(imageRes);
        binding.txtCodesAndOffers.setText(productDescription);

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productName.equals("Cucumber")) {
                    startActivity(new Intent(getBaseContext(), ScheduleActivity.class));
                } else if (productName.equals("Tomato")) {
                    startActivity(new Intent(getBaseContext(), Tomato2Activity.class));
                } else {
                    startActivity(new Intent(getBaseContext(), Lettuce2Activity.class));
                }
            }
        });
    }
}