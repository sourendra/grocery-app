package com.thavaredaily.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.thavaredaily.R;
import com.thavaredaily.databinding.ActivityHomeBinding;
import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        /*AHBottomNavigationItem itemCoins = new AHBottomNavigationItem(R.string.coins, R.drawable.ic_coins, R.color.colorAccent);
        AHBottomNavigationItem itemFavourites = new AHBottomNavigationItem(R.string.favourites, R.drawable.ic_favourite, R.color.colorAccent);
        AHBottomNavigationItem itemCart = new AHBottomNavigationItem(R.string.cart, R.drawable.ic_cart, R.color.colorAccent);
        AHBottomNavigationItem itemNotification = new AHBottomNavigationItem(R.string.notification, R.drawable.ic_notification, R.color.colorAccent);
        AHBottomNavigationItem itemMore = new AHBottomNavigationItem(R.string.more, R.drawable.ic_more, R.color.colorAccent);

        binding.bottomNavigation.addItem(itemCoins);
        binding.bottomNavigation.addItem(itemFavourites);
        binding.bottomNavigation.addItem(itemCart);
        binding.bottomNavigation.addItem(itemNotification);
        binding.bottomNavigation.addItem(itemMore);

        binding.bottomNavigation.setDefaultBackgroundColor(Color.WHITE);

        binding.bottomNavigation.setAccentColor(R.color.colorAccent);
        binding.bottomNavigation.setInactiveColor(R.color.colorBlack);

        binding.bottomNavigation.setForceTint(true);

        binding.bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

        binding.bottomNavigation.setColored(true);

        binding.bottomNavigation.setCurrentItem(0);

        binding.bottomNavigation.setNotificationBackgroundColor(getResources().getColor(R.color.colorPrimary));

        binding.bottomNavigation.setNotification("3", 3);*/
//        binding.bnbDefault.addOnSelectedListener((oldPosition, newPosition) -> {
//
//        });
//        BottomItem item1 = new BottomItem();
//        item1.setText("Coins");
//        item1.setIconResID(R.drawable.ic_coins);
//        item1.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item1.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
//        binding.bnbDefault.addItem(item1);
//
//        BottomItem item2 = new BottomItem();
//        item2.setText("Favourites");
//        item2.setIconResID(R.drawable.ic_favourite);
//        item2.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item2.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
//        binding.bnbDefault.addItem(item2);
//
//        BottomItem item3 = new BottomItem();
//        item3.setText("Cart");
//        item3.setIconResID(R.drawable.ic_cart);
//        item3.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item3.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
//        binding.bnbDefault.addItem(item3);
//
//        BottomItem item4 = new BottomItem();
//        item4.setText("Notification");
//        item4.setIconResID(R.drawable.ic_notification);
//        item4.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item4.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
//        binding.bnbDefault.addItem(item4);
//
//        BottomItem item5 = new BottomItem();
//        item5.setText("More");
//        item5.setIconResID(R.drawable.ic_more);
//        item5.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item5.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
//        binding.bnbDefault.addItem(item5);
//
//        binding.bnbDefault.setSelectedPosition(0);
//        binding.bnbDefault.initialize();
////        binding.bnbDefault.setBadgeNumber(0, 2);
//        binding.bnbDefault.setBadgeNumber(3, 5);
        addBadgeAt(1, 3);
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
