package com.project.zaixianjiaoyu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2015/12/11.
 */
public class MeFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.img_person)
    ImageView imgPerson;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_qiandao)
    TextView textQiandao;
    @BindView(R.id.text_touxiang)
    TextView textTouxiang;
    @BindView(R.id.text_kaoshi)
    TextView textKaoshi;
    @BindView(R.id.text_goumai)
    TextView textGoumai;
    @BindView(R.id.text_history)
    TextView textHistory;
    @BindView(R.id.text_fankui)
    TextView textFankui;
    @BindView(R.id.text_settings)
    TextView textSettings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.img_person, R.id.text_name, R.id.text_qiandao, R.id.text_touxiang, R.id.text_kaoshi, R.id.text_goumai, R.id.text_history, R.id.text_fankui, R.id.text_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_person:


                break;
            case R.id.text_name:
                break;
            case R.id.text_qiandao:
                Toast.makeText(getActivity(), "签到", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_touxiang:
                Toast.makeText(getActivity(), "头像设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_kaoshi:
                Toast.makeText(getActivity(), "考试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_goumai:
                Toast.makeText(getActivity(), "购买课程", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_history:
                Toast.makeText(getActivity(), "历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_fankui:
                Toast.makeText(getActivity(), "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_settings:
                Toast.makeText(getActivity(), "设置", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
