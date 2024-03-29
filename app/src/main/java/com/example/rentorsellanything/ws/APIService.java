package com.example.rentorsellanything.ws;

import com.example.rentorsellanything.pojo.LoginRequest;
import com.example.rentorsellanything.pojo.LoginResponse;
import com.example.rentorsellanything.pojo.RegisterRequest;
import com.example.rentorsellanything.pojo.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("register")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

}
