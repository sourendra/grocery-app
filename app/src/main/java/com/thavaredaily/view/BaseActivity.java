package com.thavaredaily.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.thavaredaily.R;

public class BaseActivity extends AppCompatActivity {


    protected void replaceFragment(Fragment fragment, int container) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }

    protected void addFragment(Fragment fragment, int container) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment);
//        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }
}
