package com.example.smartmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.smartmart.adapters.CodesAdapter;
import com.example.smartmart.databinding.ActivitySpecialOffersBinding;

public class SpecialOffersActivity extends AppCompatActivity {

    private ActivitySpecialOffersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpecialOffersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.recCodes.setAdapter(new CodesAdapter(this));

    }
}