package com.calculator.miron.work_01.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.adapter.ViewPagerAdapter;
import com.calculator.miron.work_01.model.TabFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolbar();


        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);


        mTabLayout.getTabAt(0).setIcon(R.drawable.speaker_tab);
        mTabLayout.getTabAt(0).setText(R.string.menu_item_reminders);
        mTabLayout.getTabAt(1).setIcon(R.drawable.star_tab);
        mTabLayout.getTabAt(1).setText(R.string.menu_item_favorites);
        mTabLayout.getTabAt(2).setIcon(R.drawable.archive_tab);
        mTabLayout.getTabAt(2).setText(R.string.menu_item_archive);


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


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment(), "");
        adapter.addFragment(new TabFragment(), "");
        adapter.addFragment(new TabFragment(), "");
        viewPager.setAdapter(adapter);


    }


}
