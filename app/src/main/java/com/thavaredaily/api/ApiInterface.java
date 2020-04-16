package com.thavaredaily.api;

import com.thavaredaily.data.CategoryResponse;
import com.thavaredaily.data.ItemsForCategoryResponse;
import com.thavaredaily.data.SearchItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("item/category")
    Call<List<CategoryResponse>> getCategoryList();

    @GET("item/byCategory/{categoryId}")
    Call<ItemsForCategoryResponse> getItemListForCategory(@Path("categoryId") String categoryId);

    @GET("item/search/{typedKey}")
    Call<List<SearchItem>> getSearchItemList(@Path("typedKey") String typedKey);
}
