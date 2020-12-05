package com.strathmore.my_droid_cafe_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inflate the toolbar

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //create an instance of the tab layout and add the tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_3));

        //set tab to fill entire layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //use the pager adapter to connect content with the view and manage screens

        //create an instance of the view pager
        final ViewPager viewPager = findViewById(R.id.view_pager);

        //create instance of pager adapter
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //set page adapter to view pager using set adapter method
        viewPager.setAdapter(pagerAdapter);

        //handling clicks
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setSupportActionBar(Toolbar toolbar) {
    }
}