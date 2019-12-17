package com.example.rentorsellanything;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rentorsellanything.pojo.LoginRequest;
import com.example.rentorsellanything.pojo.LoginResponse;
import com.example.rentorsellanything.pojo.RegisterRequest;
import com.example.rentorsellanything.pojo.RegisterResponse;
import com.example.rentorsellanything.ws.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_login);

        @NonNull
        final EditText etusername = findViewById(R.id.etlogin_username);
        @NonNull
        final EditText etpassword = findViewById(R.id.etlogin_password);

        Button signin = findViewById(R.id.activity_login_btn_signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setUsername(username);
                loginRequest.setPassword(password);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://backtowork.icfoss.qleapbs.com/rentsell/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<LoginResponse> call = service.login(loginRequest);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if (response.body() != null && response.body().getStatus()) {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResponse> call, Throwable t) {

                        Log.e("LoginActivity", t.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "API Call Failure"+t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void processSignupLinkClick(View view)
    {
        Intent intent= new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
