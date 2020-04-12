package com.thavaredaily;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.thavaredaily.view.BaseActivity;
import com.thavaredaily.view.BaseFragment;
import com.thavaredaily.view.HomeActivity;
import com.thavaredaily.view.fragments.CartFragment;
import com.thavaredaily.view.fragments.FavouriteFragment;
import com.thavaredaily.view.fragments.HomeFragment;
import com.thavaredaily.view.fragments.NotificationFragment;
import com.thavaredaily.view.fragments.ProfileFragment;
import com.thavaredaily.view.user.LoginFragment;

public class MainActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragment fragment = LoginFragment.newInstance("", "");
        addFragment(fragment, R.id.container);
    }

    @Override
    public void navigateToFragment(Fragment fragment) {
        replaceFragment(fragment, R.id.container);
    }

    @Override
    public void navigateToHome() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
    }
}
