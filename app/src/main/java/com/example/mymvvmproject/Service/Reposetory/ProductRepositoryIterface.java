package com.example.mymvvmproject.Service.Reposetory;

import androidx.lifecycle.MutableLiveData;

import com.example.mymvvmproject.Service.Model.ProductModel;

import java.util.List;

public interface ProductRepositoryIterface {

    public MutableLiveData<List<ProductModel>> getAllProductData();


}
