package com.example.myltalearning.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myltalearning.Fragments.ForumFragment;
import com.example.myltalearning.Fragments.HomeFragment;
import com.example.myltalearning.Fragments.ProfileFragment;
import com.example.myltalearning.Fragments.SubscribeFragment;
import com.example.myltalearning.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.dash_tabLayout);
        tabLayout.addOnTabSelectedListener(this);
        loadFragment(HomeFragment.newInstance());
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbars = findViewById(R.id.toolbar);
        setSupportActionBar(toolbars);
    }

    private void loadFragment(Fragment activeFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, activeFragment).commit();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Fragment fragment = null;
        switch (tab.getPosition()) {
            case 0:
                fragment = HomeFragment.newInstance();
                getSupportActionBar().setTitle("Home");
                break;
            case 1:
                fragment = SubscribeFragment.newInstance();
                getSupportActionBar().setTitle("Subscribe");
                break;
            case 2:
                fragment = ForumFragment.newInstance();
                getSupportActionBar().setTitle("Forum");
                break;
            case 3:
                fragment = ProfileFragment.newInstance();
                getSupportActionBar().setTitle("Profile");
                break;

        }
        loadFragment(fragment);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
