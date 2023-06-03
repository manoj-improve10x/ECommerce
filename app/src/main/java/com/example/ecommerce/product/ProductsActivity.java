package com.example.ecommerce.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecommerce.BaseActivity;
import com.example.ecommerce.Constants;
import com.example.ecommerce.api.FakeApi;
import com.example.ecommerce.api.FakeApiService;
import com.example.ecommerce.databinding.ActivityProductsBinding;
import com.example.ecommerce.modules.Product;
import com.example.ecommerce.productDetails.ProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private ActivityProductsBinding binding;
    private ProductsAdapter productsAdapter;
    private ArrayList<Product> products = new ArrayList<>();
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra(Constants.KEY_CATEGORY)) {
            category = getIntent().getStringExtra(Constants.KEY_CATEGORY);
        }
        setAdapter();
        productsRv();
        setUpData();
    }

    private  void setAdapter(){
        productsAdapter = new ProductsAdapter();
        productsAdapter.setData(products);
        productsAdapter.setOnItemActionListener(new ItemActionListener() {
            @Override
            public void onClicked(int productId) {
                Intent intent = new Intent(getApplicationContext() , ProductDetailsActivity.class);
                intent.putExtra(Constants.KEY_PRODUCT, productId);
                startActivity(intent);

            }
        });
    }

    private void productsRv() {
        binding.productsRv.setAdapter(productsAdapter);
        binding.productsRv.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void setUpData() {
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products1 = response.body();
                productsAdapter.setData(products1);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }
}