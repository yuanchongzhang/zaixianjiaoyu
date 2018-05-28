package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeDetailActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_top_layout)
    RelativeLayout rlTopLayout;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.text_content)
    TextView textContent;
    @BindView(R.id.btn_collect)
    Button btnCollect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homedetail);
        ButterKnife.bind(this);
        tvTitle.setText("新闻详情");

        ImmersionBar.with(this)
                .statusBarDarkFont(true, 1f)
                .init();
    }

    @OnClick({R.id.img_back, R.id.rl_back, R.id.tv_title, R.id.rl_top_layout, R.id.text_title, R.id.text_time, R.id.text_content,R.id.btn_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_back:
                break;
            case R.id.tv_title:
                break;
            case R.id.rl_top_layout:
                break;
            case R.id.text_title:
                break;
            case R.id.text_time:
                break;
            case R.id.text_content:
                break;
            case R.id.btn_collect:
                ToastUtil.showCenterToast(this,"收藏成功");
                break;
        }
    }

}
