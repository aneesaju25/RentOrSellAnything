package com.example.rentorsellanything;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class DisplayAnItemActivity extends AppCompatActivity {

    public void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_displayanitem);

        TextView callUser = findViewById(R.id.tv_call_user);
        callUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0377778888"));
                startActivity(callIntent);
            }
        });

        TextView messageUser = findViewById(R.id.tv_message_user);
        messageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + 1234));
                intent.putExtra("sms_body", "");
                startActivity(intent);
            }
        });

    }
    public void processUserProfileClick(View view)
    {
        Intent intent= new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
}
