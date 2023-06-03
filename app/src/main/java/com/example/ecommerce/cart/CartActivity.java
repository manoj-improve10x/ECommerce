package com.example.ecommerce.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ecommerce.BaseActivity;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityCartBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseActivity {

    private ActivityCartBinding binding;
    private ArrayList<CartProduct> cartArrayList = new ArrayList<>();
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupData();
        setupAdapter();
        setupCartRv();
    }

    private void setupAdapter() {
        adapter = new CartAdapter();
        adapter.setData(cartArrayList);
    }

    private void setupCartRv() {
        binding.cartRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRv.setAdapter(adapter);
    }
    private void setupData() {
        Call<Cart> call = fakeApiService.fetchCartProducts();
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if (response.isSuccessful()) {
                    Cart cart = response.body();
                    adapter.setData(cart.getCartProduct());
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });
    }
}