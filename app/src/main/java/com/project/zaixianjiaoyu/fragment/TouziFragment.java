package com.project.zaixianjiaoyu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.project.zaixianjiaoyu.activity.ShipinActivity;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2015/12/11.
 */
public class TouziFragment extends BaseFragment {

    @BindView(R.id.img_person)
    ImageView imgPerson;
    Unbinder unbinder;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_gognsi)
    TextView textGognsi;
    @BindView(R.id.text_fist)
    TextView textFist;
    @BindView(R.id.text_setconnd)
    TextView textSetconnd;
    @BindView(R.id.recycler_view_test_item_person_name_tv)
    TextView recyclerViewTestItemPersonNameTv;
    @BindView(R.id.text_fisr)
    TextView textFisr;
    @BindView(R.id.text_fourth)
    TextView textFourth;
    @BindView(R.id.layout_first)
    LinearLayout layoutFirst;
    @BindView(R.id.text_fidt)
    TextView textFidt;
    @BindView(R.id.text_fourth3)
    TextView textFourth3;
    @BindView(R.id.text_daoshudier)
    TextView textDaoshudier;
    @BindView(R.id.text_oed)
    TextView textOed;
    @BindView(R.id.layout_34)
    LinearLayout layout34;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_secone, null);

        unbinder = ButterKnife.bind(this, view);

         /* .placeholder(R.color.abc_tab_text_normal)
                .error(R.color.abc_tab_text_normal)*/
        Glide.with(getActivity())
                .load("http://img05.tooopen.com/images/20150820/tooopen_sy_139205349641.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .transform(new GlideCircleTransform(getActivity()))
                .into(imgPerson);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void onResume() {
        super.onResume();
        ImmersionBar.with(getActivity())

                .statusBarDarkFont(true, 1f)
                .init();
    }
    @OnClick({R.id.text_name, R.id.text_gognsi, R.id.text_fist, R.id.text_setconnd, R.id.recycler_view_test_item_person_name_tv, R.id.text_fisr, R.id.text_fourth, R.id.layout_first, R.id.text_fidt, R.id.text_fourth3, R.id.text_daoshudier, R.id.text_oed, R.id.layout_34})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_name:

            case R.id.text_gognsi:

            case R.id.text_fist:

            case R.id.text_setconnd:

            case R.id.recycler_view_test_item_person_name_tv:

            case R.id.text_fisr:

            case R.id.text_fourth:

            case R.id.layout_first:

            case R.id.text_fidt:

            case R.id.text_fourth3:

            case R.id.text_daoshudier:

            case R.id.text_oed:

            case R.id.layout_34:
//                Toast.makeText(getActivity(), "跳转到视频页面", Toast.LENGTH_SHORT).show();
startActivity(new Intent(getActivity(),ShipinActivity.class));

                break;
        }
    }
}
