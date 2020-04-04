package com.thavaredaily.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thavaredaily.BR;
import com.thavaredaily.databinding.ItemCategoriesBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    Context context;
    List<String> itemList;

    public CategoriesAdapter(Context context, List<String> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemCategoriesBinding itemBinding =
                ItemCategoriesBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemCategoriesBinding binding;

        public MyViewHolder(ItemCategoriesBinding categoriesBinding) {
            super(categoriesBinding.getRoot());
            this.binding = categoriesBinding;
        }

        public void bind(String category) {
//            binding.setVariable(com.thavaredaily.BR.obj, obj);
            binding.tvCategoryName.setText(category);
            binding.executePendingBindings();
        }
    }
}
