package com.thavaredaily.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thavaredaily.R;
import com.thavaredaily.data.Item;
import com.thavaredaily.databinding.FragmentItemListBinding;
import com.thavaredaily.util.ItemListAdapter;
import com.thavaredaily.viewmodel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemListFragment extends Fragment implements ItemListAdapter.OnItemCLickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int categoryId;
    private String mParam2;

    FragmentItemListBinding binding;

    ItemViewModel itemViewModel;

    List<Item> itemList = new ArrayList<>();

    public ItemListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemListFragment newInstance(int param1, String param2) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryId = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        itemViewModel = new ViewModelProvider(getActivity()).get(ItemViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_item_list, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_list, container, false);
        binding.setViewModel(itemViewModel);
        getItemList();
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void getItemList() {
        itemViewModel.getItemsForCategory(String.valueOf(categoryId)).observe(this, itemsForCategoryResponse -> {
            if (itemsForCategoryResponse != null) {
                ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), itemsForCategoryResponse.getValue(), this::onItemClick);
                binding.rvItemList.setAdapter(itemListAdapter);
            }
        });
    }

    @Override
    public void onItemClick(int position) {

    }
}
