package com.project.zaixianjiaoyu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.zaixianjiaoyu.R;


public class ShopcartFragment2 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_shop_cat, null);

        return view;
//        return inflater.inflate(R.layout.fragment_shop_cat, container, false);
    }


}
