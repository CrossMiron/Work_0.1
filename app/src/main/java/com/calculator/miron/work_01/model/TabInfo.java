package com.calculator.miron.work_01.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calculator.miron.work_01.R;

/**
 * Created by Miron on 22.09.16.
 */

public class TabInfo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_info, container, false);
        return view;
    }
}
