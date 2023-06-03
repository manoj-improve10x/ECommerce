package com.example.ecommerce.product;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.databinding.ProductItemBinding;
import com.example.ecommerce.modules.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private List<Product> products;
    private ItemActionListener itemActionListener;

    void setData(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
    void setOnItemActionListener(ItemActionListener itemActionListener){
        this.itemActionListener = itemActionListener;
    }


    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        ProductsViewHolder productsViewHolder = new ProductsViewHolder(binding);
        return productsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Product product = products.get(position);
       holder.binding.setProduct(product);
       holder.binding.ratingBar.setRating(product.rating.getRate());
       holder.binding.getRoot().setOnClickListener(v -> {
           itemActionListener.onClicked(products.get(position).getId());
       });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
