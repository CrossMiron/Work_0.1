package com.calculator.miron.work_01.model;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.sql.DBHelper;


public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
    public EditText mTitle, mContent, mCategory, mTag, mDate, mTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle(R.string.create_item_name);
        View view = inflater.inflate(R.layout.dialog_fragment, null);
        view.findViewById(R.id.create_item_button_add).setOnClickListener(this);
        view.findViewById(R.id.create_item_button_cancel).setOnClickListener(this);
        mTitle = (EditText) view.findViewById(R.id.create_item_text_title);
        mContent = (EditText) view.findViewById(R.id.create_item_text_content);
        mCategory = (EditText) view.findViewById(R.id.create_item_text_category);
        mTag = (EditText) view.findViewById(R.id.create_item_text_tag);
        mDate = (EditText) view.findViewById(R.id.create_item_text_date);
        mTime = (EditText) view.findViewById(R.id.create_item_text_time);
        return view;


    }



    @Override
    public void onClick(View view) {
        String title = mTitle.getText().toString();
        String content = mContent.getText().toString();
        String category = mCategory.getText().toString();
        String tag = mTag.getText().toString();
        String date = mDate.getText().toString();
        String time = mTime.getText().toString();

        AddData(title, content, category, tag, date, time);
        mTitle.setText("");
        mContent.setText("");
        mCategory.setText("");
        mTag.setText("");
        mDate.setText("");
        mTime.setText("");

    }

    private void AddData(String title, String content, String category, String tag, String date, String time) {

        boolean insertData = DBHelper.saveTask(title, content, category, tag, date, time);
    }


    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }

}



