package com.example.rentorsellanything;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        EditText etName = findViewById(R.id.etregister_name);
        EditText etEmail = findViewById(R.id.etregister_email);
        EditText etMobile = findViewById(R.id.etregister_mobileNumber);
        EditText etAddress = findViewById(R.id.etregister_address);

        Button btn = findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setuName(username);
                registerRequest.setuPassword(password);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.40.35/rentsell/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);

                Call<RegisterResponse> registerResponse = service.register(registerRequest);
                registerResponse.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {

                    }
                });

                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    public void processSigninLinkClick(View view)
    {
        Intent intent= new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void processSignupBtnClick(View view)
    {
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
