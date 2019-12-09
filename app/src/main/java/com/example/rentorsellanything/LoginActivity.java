package com.example.rentorsellanything;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //single line comment
    /* multi line comment
    multi line comment */
    public void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_login);
    }
    public void processSignupLinkClick(View view)
    {
        Intent intent= new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
    public void processSigninLinkClick(View view)
    {
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
