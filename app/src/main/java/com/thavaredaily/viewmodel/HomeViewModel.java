package com.thavaredaily.viewmodel;

import androidx.databinding.ObservableBoolean;
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

    MutableLiveData<List<SearchItem>> searchItemList = new MutableLiveData<>();
    public ObservableBoolean loading = new ObservableBoolean();

    public LiveData<List<CategoryResponse>> getCategoryResponse() {
        loading.set(true);
        ApiInterface apiInterface = RetrofitClient.getInstance().getApiService();
        Call<List<CategoryResponse>> categoryResponseCall = apiInterface.getCategoryList();
        categoryResponseCall.enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
                if (response.body() != null)
                    categoryResponse.setValue(response.body());
                loading.set(false);
            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
                categoryResponse.setValue(null);
                loading.set(false);
            }
        });
        return categoryResponse;
    }
}
