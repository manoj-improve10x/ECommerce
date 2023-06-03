package com.example.ecommerce.cart;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cart {

    private Integer id;
    private Integer userId;
    private String data;
    @SerializedName("products")
    private ArrayList<CartProduct> cartProduct;

    public ArrayList<CartProduct> getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(ArrayList<CartProduct> cartProduct) {
        this.cartProduct = cartProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
