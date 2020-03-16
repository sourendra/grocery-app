package com.thavaredaily;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.thavaredaily.view.BaseFragment;
import com.thavaredaily.view.HomeActivity;
import com.thavaredaily.view.fragments.CartFragment;
import com.thavaredaily.view.fragments.FavouriteFragment;
import com.thavaredaily.view.fragments.HomeFragment;
import com.thavaredaily.view.fragments.NotificationFragment;
import com.thavaredaily.view.fragments.ProfileFragment;
import com.thavaredaily.view.user.LoginFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragment fragment = LoginFragment.newInstance("", "");
        addFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
//        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }

    @Override
    public void navigateToFragment(Fragment fragment) {
        replaceFragment(fragment);
    }

    @Override
    public void navigateToHome() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
    }
}
