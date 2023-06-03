package com.example.ecommerce;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.ecommerce.api.FakeApi;
import com.example.ecommerce.api.FakeApiService;
import com.example.ecommerce.cart.Cart;
import com.example.ecommerce.cart.CartProduct;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategoryProducts() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApiService();
        Call<List<String>> call = fakeApiService.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }
    @Test
    public void getCartProduct() throws IOException {
        FakeApiService service = new FakeApi().createFakeApiService();
        Call<Cart> call = service.fetchCartProducts();
        Cart categories = call.execute().body();
        assertNotNull(categories);
        System.out.println(new Gson().toJson(categories));
    }
}