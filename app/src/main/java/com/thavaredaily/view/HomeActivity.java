package com.thavaredaily.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.thavaredaily.R;
import com.thavaredaily.databinding.ActivityHomeBinding;
import com.thavaredaily.listeners.OnFragmentInteractionListener;
import com.thavaredaily.util.HomePagerAdapter;
import com.thavaredaily.view.fragments.CartFragment;
import com.thavaredaily.view.fragments.FavouriteFragment;
import com.thavaredaily.view.fragments.HomeFragment;
import com.thavaredaily.view.fragments.NotificationFragment;
import com.thavaredaily.view.fragments.ProfileFragment;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    ActivityHomeBinding binding;

    HomeFragment homeFragment;
    FavouriteFragment favouriteFragment;
    CartFragment cartFragment;
    NotificationFragment notificationFragment;
    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initFragments();
        addBadgeAt(1, 3);
    }

    private void initFragments(){
        homeFragment = HomeFragment.newInstance("", "");
        favouriteFragment = FavouriteFragment.newInstance("", "");
        cartFragment = CartFragment.newInstance("", "");
        notificationFragment = NotificationFragment.newInstance("", "");
        profileFragment = ProfileFragment.newInstance("", "");
        HomePagerAdapter pagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFrag(homeFragment, homeFragment.getClass().getSimpleName());
        pagerAdapter.addFrag(favouriteFragment, favouriteFragment.getClass().getSimpleName());
        pagerAdapter.addFrag(cartFragment, cartFragment.getClass().getSimpleName());
        pagerAdapter.addFrag(notificationFragment, notificationFragment.getClass().getSimpleName());
        pagerAdapter.addFrag(profileFragment, profileFragment.getClass().getSimpleName());
        binding.viewPager.setPagingEnabled(false);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.bottomNavigation.setupWithViewPager(binding.viewPager);
    }

    private Badge addBadgeAt(int position, int number) {
        // add badge
        return new QBadgeView(HomeActivity.this)
                .setBadgeNumber(number)
                .setGravityOffset(12, 2, true)
                .bindTarget(binding.bottomNavigation.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState)
                            Toast.makeText(HomeActivity.this, R.string.tips_badge_removed, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
