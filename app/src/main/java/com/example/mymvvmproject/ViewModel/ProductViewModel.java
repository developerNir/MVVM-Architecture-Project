package com.example.mymvvmproject.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvmproject.Service.Model.ProductModel;
import com.example.mymvvmproject.Service.Reposetory.ProductRepository;
import java.util.List;

public class ProductViewModel extends ViewModel {



    private final ProductRepository productRepository;


    public ProductViewModel() {
        super();
        productRepository = ProductRepository.getInstance();
    }


    // Repository return LiveData ProductModelList and
    // getProductMutableLiveData receive getAllProductData and
    // return MainActivity Object get this data
    public LiveData<List<ProductModel>> getProductMutableLiveData(){
        Log.d("myLog", "getProductMutableLiveData: ReCreate");
        return productRepository.getAllProductData();

    }



}
