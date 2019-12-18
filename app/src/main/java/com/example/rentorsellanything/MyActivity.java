package com.example.rentorsellanything;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_myactivities);

        TextView myPosts = findViewById(R.id.tvShowMyPosts);
        final GridView view = findViewById(R.id.gridviewMyPosts);
        TextView myWishlist = findViewById(R.id.tvShowMyWishlist);
        final GridView view1 = findViewById(R.id.gridviewMyWishlist);

        myPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.GONE);
                view.setVisibility(View.VISIBLE);
            }
        });

        view.setAdapter(new ImageAdapter(this));


        myWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.GONE);
                view1.setVisibility(View.VISIBLE);
            }
        });

        view1.setAdapter(new ImageAdapter(this));
    }
    public void processHomeBtnClick(View view)
    {
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
