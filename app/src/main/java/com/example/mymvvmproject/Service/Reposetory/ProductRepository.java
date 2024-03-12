package com.example.mymvvmproject.Service.Reposetory;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mymvvmproject.Service.Model.MainDataModel;
import com.example.mymvvmproject.Service.Model.ProductModel;
import com.example.mymvvmproject.Service.Network.ApiService;
import com.example.mymvvmproject.Service.Network.RetrofitInstec;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository implements ProductRepositoryIterface{


    private static ProductRepository productRepository;
    private MainDataModel mainDataModel;
    private List<ProductModel> productModelList;
    private MutableLiveData mLiveData;


    public static ProductRepository getInstance(){
        if (productRepository == null){
            productRepository = new ProductRepository();
        }
        return productRepository;
    }


    @Override
    public MutableLiveData<List<ProductModel>> getAllProductData(){

        if (mLiveData== null){

            mLiveData = new MutableLiveData<>();

        }


        // Api Call -----------------------------------------
        ApiService apiService = RetrofitInstec.getRetrofitInstence().create(ApiService.class);
        // call with main Model and Api service Method ------
        Call<MainDataModel> call = apiService.getAllProductData();

        call.enqueue(new Callback<MainDataModel>() {
            @Override
            public void onResponse(Call<MainDataModel> call, Response<MainDataModel> response) {
                Log.d("myLog", "onResponse: Api call"+response.body());
                if (response.isSuccessful()){
                    // response get MainDataModel into --------
                    mainDataModel = response.body();
                    // Product model into MainModel GetProducts method --------
                    productModelList = mainDataModel.getProducts();
                    // mLiveData into Product Model
                    mLiveData.postValue(productModelList);
                }


            }

            @Override
            public void onFailure(Call<MainDataModel> call, Throwable t) {
                Log.d("myLog", "onFailure: "+t.getMessage());

            }
        });


        return mLiveData;


    }



}
