package com.example.ecommerce.productDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ecommerce.BaseActivity;
import com.example.ecommerce.Constants;
import com.example.ecommerce.R;
import com.example.ecommerce.api.FakeApi;
import com.example.ecommerce.api.FakeApiService;
import com.example.ecommerce.cart.CartActivity;
import com.example.ecommerce.databinding.ActivityProductDetailsBinding;
import com.example.ecommerce.modules.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {

    private ActivityProductDetailsBinding binding;
    private int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("ProductDetails");
        if(getIntent().hasExtra(Constants.KEY_PRODUCT)){
            productId = getIntent().getIntExtra(Constants.KEY_PRODUCT,productId);
        }
        getData();
    }

    private void getData() {
        Call<Product> call = fakeApiService.getProduct(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                binding.setProduct(product);
                binding.ratingBar2.setRating(product.rating.getRate());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });

    }
}