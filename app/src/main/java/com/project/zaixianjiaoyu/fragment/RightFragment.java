package com.project.zaixianjiaoyu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.util.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Jay on 2015/10/9 0009.
 */
public class RightFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_right, container, false);
/*
        unbinder = ButterKnife.bind(this, view);

        Glide.with(getActivity())
                .load("http://img05.tooopen.com/images/20150820/tooopen_sy_139205349641.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .transform(new GlideCircleTransform(getActivity()))
                .into(imgHead);*/

        return view;
    }







}
