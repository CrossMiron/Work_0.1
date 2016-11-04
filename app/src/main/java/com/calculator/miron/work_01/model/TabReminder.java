package com.calculator.miron.work_01.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.adapter.ToDoAdapter;
import com.calculator.miron.work_01.sql.DBHelper;

import java.util.ArrayList;

/**
 * Created by Miron on 28.09.16.
 */

public class TabReminder extends Fragment {

     ToDoAdapter mAdapter;
     ArrayList<ToDoItem> mTodoItemsList;
     RecyclerView mRecyclerView;


    public static TabReminder newInstance() {

        Bundle args = new Bundle();

        TabReminder fragment = new TabReminder();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_reminder, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecycler);
        mTodoItemsList = DBHelper.createToDoItemList();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ToDoAdapter (mTodoItemsList);
        mRecyclerView.setAdapter(mAdapter);
        return view;



    }




}


