package com.calculator.miron.work_01.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.adapter.FragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolbar();
        initFloatingActionButton();



        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), getResources().
                getStringArray(R.array.titles_tab)));
        mTabLayout.setupWithViewPager(mViewPager);


        mTabLayout.getTabAt(0).setIcon(R.drawable.speaker_tab);
        mTabLayout.getTabAt(1).setIcon(R.drawable.star_tab);
        mTabLayout.getTabAt(2).setIcon(R.drawable.archive_tab);


    }



    private void initFloatingActionButton() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateItem.class));
            }
        });


    }


    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);/// Если убрать эту строку, появится иконка поска...Хммм
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        mToolbar.inflateMenu(R.menu.menu_toolbar);

    }


}
