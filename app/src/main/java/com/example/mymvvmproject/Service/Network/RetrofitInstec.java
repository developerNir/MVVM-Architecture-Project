package com.example.mymvvmproject.Service.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstec {


    public static String BASE_URL = "https://dummyjson.com/";

    public static Retrofit retrofit;

    public static Retrofit getRetrofitInstence(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



}
