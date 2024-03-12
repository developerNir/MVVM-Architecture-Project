package com.example.mymvvmproject.Service.Network;

import com.example.mymvvmproject.Service.Model.MainDataModel;



import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("products")
    Call<MainDataModel> getAllProductData();


}
