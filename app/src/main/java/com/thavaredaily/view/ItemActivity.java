package com.thavaredaily.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.thavaredaily.R;
import com.thavaredaily.databinding.ActivityItemBinding;
import com.thavaredaily.view.fragments.ItemListFragment;

public class ItemActivity extends BaseActivity {

    ActivityItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_item);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        addFragment(new ItemListFragment(), binding.container.getId());
    }
}
