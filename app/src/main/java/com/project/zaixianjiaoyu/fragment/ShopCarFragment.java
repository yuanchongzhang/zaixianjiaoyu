package com.project.zaixianjiaoyu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.zaixianjiaoyu.R;


public class ShopCarFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.from(getActivity()).inflate(R.layout.fragment_shopcar, null);
        return view;

//        return inflater.inflate(R.layout.fragment_shopcar, container, false);
    }


}
