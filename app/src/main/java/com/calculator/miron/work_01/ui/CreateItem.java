package com.calculator.miron.work_01.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.sql.DBHelper;

public class CreateItem extends AppCompatActivity implements View.OnClickListener {

    Button button_add_item;
    EditText edit_text_title, edit_text_content, edit_text_category;
    EditText edit_text_tag, edit_text_date, edit_text_time;


    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_item);

        button_add_item = (Button) findViewById(R.id.create_item_button_add);
        button_add_item.setOnClickListener(this);


        edit_text_title = (EditText) findViewById(R.id.create_item_text_title);
        edit_text_content = (EditText) findViewById(R.id.create_item_text_content);
        edit_text_category = (EditText) findViewById(R.id.create_item_text_category);
        edit_text_tag = (EditText) findViewById(R.id.create_item_text_tag);
        edit_text_date = (EditText) findViewById(R.id.create_item_text_date);
        edit_text_time = (EditText) findViewById(R.id.create_item_text_time);


        dbHelper = new DBHelper(this);


    }

    @Override
    public void onClick(View view) {


    }


}
