package com.thavaredaily.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.thavaredaily.BR;
import com.thavaredaily.R;
import com.thavaredaily.data.CategoryResponse;
import com.thavaredaily.databinding.ItemCategoriesBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    Context context;
    List<CategoryResponse> itemList;
    OnItemClickListener onItemClickListener;

    public CategoriesAdapter(Context context, List<CategoryResponse> itemList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
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
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemClickListener.onItemClick(itemList.get(position));
        });
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

        public void bind(CategoryResponse category) {
//            binding.setVariable(com.thavaredaily.BR.obj, obj);
            binding.tvCategoryName.setText(category.getName());
            Glide.with(context).load(category.getImageLink()).placeholder(CommonUtils.getCircularProgressDrawable(context))
                    .error(context.getResources().getDrawable(R.drawable.ic_groceries_default)).into(binding.civCategoryPic);
            binding.executePendingBindings();
        }
    }

    public interface OnItemClickListener{
        void onItemClick(CategoryResponse categoryResponse);
    }
}
