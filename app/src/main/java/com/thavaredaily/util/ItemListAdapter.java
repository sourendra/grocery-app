package com.thavaredaily.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thavaredaily.R;
import com.thavaredaily.data.ValueItem;
import com.thavaredaily.databinding.ItemItemListBinding;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder> {

    Context context;
    List<ValueItem> itemList;
    OnItemCLickListener onItemCLickListener;

    public ItemListAdapter(Context context, List<ValueItem> itemList, OnItemCLickListener onItemCLickListener) {
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

        @SuppressLint("StringFormatMatches")
        public void bind(ValueItem item) {
            binding.tvItemTitle.setText(item.getName());
//            binding.tvItemSubTitle.setText(item.getItemSubName());
//            binding.tvActualPrice.setText(context.getResources().getString(R.string.rs, item.getActualPrice()));
//            binding.tvCurrentPrice.setText(context.getResources().getString(R.string.rs, item.getDiscountPrice()));
            Glide.with(context).load(item.getImageLink()).placeholder(CommonUtils.getCircularProgressDrawable(context))
                    .error(context.getResources().getDrawable(R.drawable.ic_groceries_default)).into(binding.ivItem);
        }
    }

    public interface OnItemCLickListener {
        void onItemClick(int position);
    }
}
