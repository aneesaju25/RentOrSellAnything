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

import com.example.rentorsellanything.pojo.RegisterRequest;
import com.example.rentorsellanything.pojo.RegisterResponse;
import com.example.rentorsellanything.ws.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_registration);


        @NonNull
        final EditText etusername = findViewById(R.id.etregister_username);
        final EditText etpassword = findViewById(R.id.etregister_password);
        final EditText etEmail = findViewById(R.id.etregister_email);
        final EditText etMobile = findViewById(R.id.etregister_mobileNumber);
        final EditText etAddress = findViewById(R.id.etregister_address);

        Button btn = findViewById(R.id.activity_reg_btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();
                String email = etEmail.getText().toString();
                String mobile = etMobile.getText().toString();
                String address = etAddress.getText().toString();

                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setUsername(username);
                registerRequest.setPassword(password);
                registerRequest.setEmail(email);
                registerRequest.setMobile(mobile);
                registerRequest.setAddress(address);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://backtowork.icfoss.qleapbs.com/rentsell/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RegisterResponse> call = service.register(registerRequest);
                call.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                        if (response.body() != null && response.body().getStatus()) {
                            Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<RegisterResponse> call, Throwable t) {

                        Log.e("RegisterActivity", t.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "API Call Failure"+t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void processSigninLinkClick(View view)
    {
        Intent intent= new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
