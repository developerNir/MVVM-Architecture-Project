package com.example.mymvvmproject.View.Ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mymvvmproject.R;
import com.example.mymvvmproject.Service.Model.ProductModel;
import com.example.mymvvmproject.View.Adapter.BlogListAdapter;
import com.example.mymvvmproject.ViewModel.ProductViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    private ProductViewModel productViewModel;
    private BlogListAdapter blogListAdapter;


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("myLog", "onDestroy: Activity ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myLog", "onRestart: Activity ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myLog", "onStop: Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myLog", "onResume: Activity");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("myLog", "onCreate: Activity");

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager linearLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        productViewModel = new ViewModelProvider(MainActivity.this).get(ProductViewModel.class);

        productViewModel.getProductMutableLiveData().observe(this, new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productModels) {


                blogListAdapter = new BlogListAdapter(MainActivity.this, productModels);

                Log.d("myLog", "onChanged: "+productModels.size());
                recyclerView.setAdapter(blogListAdapter);



            }
        });










    }
}