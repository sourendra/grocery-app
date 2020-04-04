package com.thavaredaily.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thavaredaily.R;
import com.thavaredaily.databinding.FragmentHomeBinding;
import com.thavaredaily.listeners.OnFragmentInteractionListener;
import com.thavaredaily.util.CategoriesAdapter;
import com.thavaredaily.util.ImageSliderViewPager;
import com.thavaredaily.util.TopOffersAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    FragmentHomeBinding binding;

    List<String> categoryList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        ImageSliderViewPager sliderViewPager = new ImageSliderViewPager(getContext(), new int[5]);
        binding.vpOffers.setAdapter(sliderViewPager);
        binding.dots.attachViewPager(binding.vpOffers);
        setupTopOffers();
        setupCategories();
        return binding.getRoot();
    }

    private void setupTopOffers(){
        TopOffersAdapter adapter = new TopOffersAdapter(getContext());
        binding.rvOffers.setAdapter(adapter);
    }

    private void setupCategories(){
        if (categoryList != null && categoryList.size() == 0) {
            categoryList.add("Fruits & Vegetables");
            categoryList.add("Beverages");
            categoryList.add("Branded Food");
            categoryList.add("Dairy, Bakery & Eggs");
            categoryList.add("Foodgrain, Oil & Masala");
            categoryList.add("Frozen Veg");
            categoryList.add("Home care & Fashion");
        }
        CategoriesAdapter adapter = new CategoriesAdapter(getContext(), categoryList);
        binding.rvCategories.setAdapter(adapter);
//        binding.rvCategories.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
