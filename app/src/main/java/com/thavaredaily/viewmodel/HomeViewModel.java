package com.thavaredaily.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thavaredaily.api.ApiInterface;
import com.thavaredaily.api.RetrofitClient;
import com.thavaredaily.data.CategoryResponse;
import com.thavaredaily.data.ItemsForCategoryResponse;
import com.thavaredaily.data.SearchItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    MutableLiveData<List<CategoryResponse>> categoryResponse = new MutableLiveData<>();
    MutableLiveData<ItemsForCategoryResponse> itemsForCategoryResponse = new MutableLiveData<>();
    MutableLiveData<List<SearchItem>> searchItemList = new MutableLiveData<>();

    public LiveData<List<CategoryResponse>> getCategoryResponse(){
        ApiInterface apiInterface = RetrofitClient.getInstance().getApiService();
        Call<List<CategoryResponse>> categoryResponseCall = apiInterface.getCategoryList();
        categoryResponseCall.enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {

            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {

            }
        });
        return categoryResponse;
    }
}
