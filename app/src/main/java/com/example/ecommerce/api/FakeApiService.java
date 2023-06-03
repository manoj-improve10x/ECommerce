package com.example.ecommerce.api;

import com.example.ecommerce.Constants;
import com.example.ecommerce.cart.Cart;
import com.example.ecommerce.cart.CartProduct;
import com.example.ecommerce.modules.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET(Constants.CATEGORIES_ENDPOINT)
    Call<List<String>> fetchCategories();

    @GET(Constants.PRODUCT_ENDPOINT)
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET(Constants.PRODUCT_ID_ENDPOINT)
    Call<Product> getProduct(@Path("productsId") int productsId);

    @GET(Constants.CART_PRODUCT_ENDPOINT)
    Call<Cart> fetchCartProducts();
}
