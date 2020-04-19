package com.thavaredaily.viewmodel;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thavaredaily.api.ApiInterface;
import com.thavaredaily.api.RetrofitClient;
import com.thavaredaily.data.CategoryResponse;
import com.thavaredaily.data.ItemsForCategoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemViewModel extends ViewModel {
    private static final String TAG = "ItemViewModel";
    private MutableLiveData<ItemsForCategoryResponse> itemsForCategoryResponse = new MutableLiveData<>();
    public ObservableBoolean loading = new ObservableBoolean();

    public LiveData<ItemsForCategoryResponse> getItemsForCategory(String category) {
        loading.set(true);
        ApiInterface apiInterface = RetrofitClient.getInstance().getApiService();
        Call<ItemsForCategoryResponse> categoryResponseCall = apiInterface.getItemListForCategory(category);
        categoryResponseCall.enqueue(new Callback<ItemsForCategoryResponse>() {
            @Override
            public void onResponse(Call<ItemsForCategoryResponse> call, Response<ItemsForCategoryResponse> response) {
                if (response.body() != null)
                    itemsForCategoryResponse.setValue(response.body());
                loading.set(false);
            }

            @Override
            public void onFailure(Call<ItemsForCategoryResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                itemsForCategoryResponse.setValue(null);
                loading.set(false);
            }
        });
        return itemsForCategoryResponse;
    }

    /*public void setLoading(boolean loading) {
        this.loading.setValue(loading);
    }

    public boolean isLoading() {
        if (loading == null || loading.getValue() == null) {
            loading = new MutableLiveData<>();
            loading.setValue(false);
            return loading.getValue();
        } else
            return loading.getValue();
    }*/
}
