package com.example.ecommerce.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ecommerce.BaseActivity;
import com.example.ecommerce.Constants;
import com.example.ecommerce.api.FakeApi;
import com.example.ecommerce.api.FakeApiService;
import com.example.ecommerce.databinding.ActivityCategoriesBinding;
import com.example.ecommerce.product.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    private ActivityCategoriesBinding binding;
    private ArrayList<String> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAdapter();
        setCategoryRv();
        setupData();
    }

    private void setupData() {
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Toast.makeText(CategoriesActivity.this, "Success", Toast.LENGTH_SHORT).show();
                List<String> messages = response.body();
                categoriesAdapter.setData(messages);

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                showToast("Failed to load data");

            }
        });
    }
    private void setAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
        categoriesAdapter.setOnItemActionListener(new OnItemActionListener() {

            //TODO: Lambda function.
            @Override
            public void onClick(String categoryName) {
                Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
                intent.putExtra(Constants.KEY_CATEGORY,categoryName);
                startActivity(intent);
            }
        });
    }

    private void setCategoryRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }
}