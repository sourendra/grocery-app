package com.thavaredaily.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thavaredaily.data.Item;
import com.thavaredaily.databinding.ItemItemListBinding;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder> {

    Context context;
    List<Item> itemList;
    OnItemCLickListener onItemCLickListener;

    public ItemListAdapter(Context context, List<Item> itemList, OnItemCLickListener onItemCLickListener) {
        this.context = context;
        this.itemList = itemList;
        this.onItemCLickListener = onItemCLickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemItemListBinding itemBinding =
                ItemItemListBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(itemList.get(position));
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemCLickListener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ItemItemListBinding binding;

        public MyViewHolder(ItemItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Item item) {
            binding.tvItemTitle.setText(item.getItemName());
            binding.tvItemSubTitle.setText(item.getItemSubName());
            binding.tvActualPrice.setText(item.getItemActualPrice());
            binding.tvCurrentPrice.setText(item.getItemCurrentPrice());
        }
    }

    public interface OnItemCLickListener {
        void onItemClick(int position);
    }
}
