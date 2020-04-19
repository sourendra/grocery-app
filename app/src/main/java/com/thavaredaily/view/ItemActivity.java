package com.thavaredaily.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.thavaredaily.R;
import com.thavaredaily.data.CategoryResponse;
import com.thavaredaily.databinding.ActivityItemBinding;
import com.thavaredaily.view.fragments.ItemListFragment;

public class ItemActivity extends BaseActivity {

    ActivityItemBinding binding;
    Integer categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            categoryId = bundle.getInt("categoryId");
//        setContentView(R.layout.activity_item);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        addFragment(ItemListFragment.newInstance(categoryId, ""), binding.container.getId());
    }
}
