package com.example.ecommerce.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.databinding.CategoriesItemBinding;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {

    CategoriesItemBinding binding;

    public CategoriesViewHolder(CategoriesItemBinding categoriesItemBinding) {
        super(categoriesItemBinding.getRoot());
        binding = categoriesItemBinding;
    }
}
