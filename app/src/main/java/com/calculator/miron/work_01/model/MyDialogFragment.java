package com.calculator.miron.work_01.model;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;

import com.calculator.miron.work_01.R;


public class MyDialogFragment extends DialogFragment {

    public static final String BUNDLE_KEY_CALLBACKS = "key.callbacks";

    public EditText mTitle, mContent, mCategory, mTag, mDate, mTime;
    private CallbacksAdapter mCallbacks;

    public static MyDialogFragment newInstance(CallbacksAdapter callbacks) {

        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_KEY_CALLBACKS, callbacks);
        MyDialogFragment fragment = new MyDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mCallbacks = args.getParcelable(BUNDLE_KEY_CALLBACKS);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment, null);
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

                ToDoItem toDoItem = new ToDoItem(title, content, category, tag, date, time);

                mTitle.setText("");
                mContent.setText("");
                mCategory.setText("");
                mTag.setText("");
                mDate.setText("");
                mTime.setText("");

                if (mCallbacks != null) {
                    mCallbacks.onAddTask(toDoItem);
                }

            }
        })
                .setNegativeButton(R.string.create_item_button_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });


        return builder.create();


    }

    public static class CallbacksAdapter implements Parcelable {
        public static final Parcelable.Creator<CallbacksAdapter> CREATOR = new Parcelable.Creator<CallbacksAdapter>() {

            public CallbacksAdapter createFromParcel(Parcel in) {
                return new CallbacksAdapter(in);
            }

            @Override
            public CallbacksAdapter[] newArray(int size) {
                return new CallbacksAdapter[size];
            }
        };


        public CallbacksAdapter() {
        }

        CallbacksAdapter(Parcel in) {
        }

        /**
         * Save task
         *
         * @param toDoItem ToDoItem
         */
        public void onAddTask(ToDoItem toDoItem) {
            //realize it in the activity class
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }

}



