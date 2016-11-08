package com.calculator.miron.work_01.model;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.sql.DBHelper;


public class MyDialogFragment extends DialogFragment {


    public EditText mTitle, mContent, mCategory, mTag, mDate, mTime;
    private View view;



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        view = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment, null);
        mTitle = (EditText) view.findViewById(R.id.create_item_text_title);
        mContent = (EditText) view.findViewById(R.id.create_item_text_content);
        mCategory = (EditText) view.findViewById(R.id.create_item_text_category);
        mTag = (EditText) view.findViewById(R.id.create_item_text_tag);
        mDate = (EditText) view.findViewById(R.id.create_item_text_date);
        mTime = (EditText) view.findViewById(R.id.create_item_text_time);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.create_item_name);
        builder.setView(view);


        builder.setPositiveButton(R.string.create_item_button_add, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
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
        })
                .setNegativeButton(R.string.create_item_button_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });




        return builder.create();




    }
    private void AddData(String title, String content, String category, String tag, String date, String time) {

        boolean insertData = DBHelper.saveTask(title, content, category, tag, date, time);
    }




}



