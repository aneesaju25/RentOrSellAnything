package com.example.rentorsellanything;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayAnItemActivity extends AppCompatActivity {

    public void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_displayanitem);

    }
    public void processWishlistClick(View view)
    {
        Intent intent= new Intent(this, MyActivity.class);
        startActivity(intent);
    }
}
