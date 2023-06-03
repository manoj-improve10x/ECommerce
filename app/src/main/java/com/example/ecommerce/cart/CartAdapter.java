package com.example.ecommerce.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.databinding.CartItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<CartProduct> cartArraylist;

    public void setData(ArrayList<CartProduct> cartArraylist) {
        this.cartArraylist = cartArraylist;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        CartViewHolder cartViewHolder = new CartViewHolder(binding);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProduct cartProduct = cartArraylist.get(position);
        holder.binding.setCartProduct(cartProduct);
    }

    @Override
    public int getItemCount() {
        return cartArraylist.size();
    }
}
