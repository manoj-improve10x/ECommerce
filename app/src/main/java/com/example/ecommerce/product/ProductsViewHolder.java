package com.example.ecommerce.product;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.databinding.ProductItemBinding;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

   ProductItemBinding binding;

   public ProductsViewHolder(ProductItemBinding productItemBinding) {
      super(productItemBinding.getRoot());
      binding = productItemBinding;
   }
}
