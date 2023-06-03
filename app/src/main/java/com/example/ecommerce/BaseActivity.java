package com.example.ecommerce;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerce.api.FakeApi;
import com.example.ecommerce.api.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService fakeApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupApi();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setupApi() {
        FakeApi api = new FakeApi();
        fakeApiService = api.createFakeApiService();
    }
}
