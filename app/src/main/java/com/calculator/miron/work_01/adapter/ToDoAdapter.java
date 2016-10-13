package com.calculator.miron.work_01.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.model.ToDoItem;

import java.util.ArrayList;

/**
 * Created by Miron on 13.10.16.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private ArrayList<ToDoItem> mTodoItemsList;

    public ToDoAdapter(ArrayList<ToDoItem> todoItemsList) {
        mTodoItemsList = todoItemsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ToDoItem item = mTodoItemsList.get(position);
        holder.mTitle.setText(item.getTitle());
        holder.mContent.setText(item.getContent());
        holder.mCategory.setText(item.getCategory());
        holder.mTag.setText(item.getTag());
        holder.mDate.setText(item.getDate());
        holder.mTime.setText(item.getTime());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mContent;
        public TextView mCategory;
        public TextView mTag;
        public TextView mDate;
        public TextView mTime;


        public ViewHolder(View itemView) {

            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.cv_tv_title);
            mContent = (TextView) itemView.findViewById(R.id.cv_tv_content);
            mCategory = (TextView) itemView.findViewById(R.id.cv_tv_category);
            mTag = (TextView) itemView.findViewById(R.id.cv_tv_tag);
            mDate = (TextView) itemView.findViewById(R.id.cv_tv_date);
            mTime = (TextView) itemView.findViewById(R.id.cv_tv_time);

        }
    }
}