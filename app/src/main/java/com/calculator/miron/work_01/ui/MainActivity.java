package com.calculator.miron.work_01.ui;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.adapter.FragmentPagerAdapter;
import com.calculator.miron.work_01.adapter.ToDoAdapter;
import com.calculator.miron.work_01.model.MyDialogFragment;
import com.calculator.miron.work_01.model.TabListing;
import com.calculator.miron.work_01.model.ToDoItem;
import com.calculator.miron.work_01.sql.DBHelper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ViewPager mViewPager;
    public TabLayout mTabLayout;
    public NavigationView mNavigationView;
    public MyDialogFragment mMyDialogFragment;
    public ToDoAdapter mAdapter;
    public ArrayList<ToDoItem> mTodoItemsList;
    public RecyclerView mRecyclerView;
    public Toolbar mToolbar;
    private DBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initFloatingActionButton();


        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), getResources().
                getStringArray(R.array.titles_tab)));
        mTabLayout.setupWithViewPager(mViewPager);

        // TODO: 09.11.16 Need to fix it. Method invocation 'setIcon' may produce 'java.lang.NullPointerException'
        mTabLayout.getTabAt(0).setIcon(R.drawable.tab_speaker);
        mTabLayout.getTabAt(1).setIcon(R.drawable.tab_star);
        mTabLayout.getTabAt(2).setIcon(R.drawable.tab_archive);
        mTabLayout.getTabAt(3).setIcon(R.drawable.tab_settings);
        mTabLayout.getTabAt(4).setIcon(R.drawable.tab_info);


        mDbHelper = DBHelper.getsInstance(this);
        mTodoItemsList = mDbHelper.createToDoItemList();
        mAdapter = new ToDoAdapter(mTodoItemsList);

        //show dialog for add new task
        mMyDialogFragment = MyDialogFragment.newInstance(new MyDialogFragment.CallbacksAdapter() {
            @Override
            public void onAddTask(ToDoItem toDoItem) {
                if (toDoItem == null) return;
                //save data to DB
                new UpdateDataTask().execute(toDoItem);
            }
        });

        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mNavigationView.setNavigationItemSelectedListener(this);


        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);

    }


    private void initFloatingActionButton() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyDialogFragment.show(getSupportFragmentManager(), "mMyDialogFragment");

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.button_menu_refresh) {
            refreshList();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_reminders:
                mViewPager.setCurrentItem(TabListing.TAB_REMINDER);
                break;
            case R.id.menu_item_favorites:
                mViewPager.setCurrentItem(TabListing.TAB_FAVORITE);
                break;
            case R.id.menu_item_archive:
                mViewPager.setCurrentItem(TabListing.TAB_ARCHIVE);
                break;
            case R.id.menu_item_settings:
                mViewPager.setCurrentItem(TabListing.TAB_SERRINGS);
                break;
            case R.id.menu_item_info:
                mViewPager.setCurrentItem(TabListing.TAB_INFO);
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);


        return true;
    }

    /**
     * Method for refresh tasks list
     * TODO: needs to move it to Tab fragment, because activity_main.xml doesn`t contain RecyclerView
     */
    private void refreshList() {
        if (mAdapter != null && mTodoItemsList != null) {
            Log.d("tag-debug", "MainActivity.refreshList(): ");
            mRecyclerView = (RecyclerView) findViewById(R.id.mRecycler);
            if (mRecyclerView != null) {
                mRecyclerView.setAdapter(mAdapter);
            }

            mTodoItemsList.clear();
            //get data from DB for populate tasks list
            mTodoItemsList.addAll(mDbHelper.createToDoItemList());
            //refresh the tasks list on the screen
            mAdapter.notifyDataSetChanged();
            //scroll to last position
            //mRecyclerView.scrollToPosition(mTodoItemsList.size() - 1);
        }
    }

    /**
     * Async Task for update database and refresh list
     * TODO: need to move it to Tab fragment
     */
    private class UpdateDataTask extends AsyncTask<ToDoItem, Void, Boolean> {
        @Override
        protected Boolean doInBackground(ToDoItem... params) {
            ToDoItem toDoItem = params[0];
            boolean isSuccess = mDbHelper.saveTask(toDoItem);
            return isSuccess;
        }

        @Override
        protected void onPostExecute(Boolean isSuccess) {
            //if DB update was success
            if (isSuccess) {
                refreshList();
            }
        }
    }

}
