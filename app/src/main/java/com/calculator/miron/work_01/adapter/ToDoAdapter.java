package com.calculator.miron.work_01.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.calculator.miron.work_01.R;

/**
 * Created by Miron on 13.10.16.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;


        public ViewHolder(View itemView) {

            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.cv_tv_title);

        }
    }
}