package com.project.zaixianjiaoyu.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_top_layout)
    RelativeLayout rlTopLayout;
    @BindView(R.id.text_tousu)
    TextView textTousu;
    @BindView(R.id.text_jianyi)
    TextView textJianyi;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        tvTitle.setText("意见反馈");
        ImmersionBar.with(this)

                .statusBarDarkFont(true, 1f)
                .init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.img_back, R.id.rl_back, R.id.tv_title, R.id.rl_top_layout, R.id.text_tousu, R.id.text_jianyi, R.id.btn_login})
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
            case R.id.text_tousu:

                textTousu.setTextColor(Color.WHITE);
                textTousu.setBackground(getResources().getDrawable(R.drawable.shape_feedback1));
                textJianyi.setTextColor(Color.parseColor("#20A8FF"));
                textJianyi.setBackground(getResources().getDrawable(R.drawable.shape_feedback2));
                break;
            case R.id.text_jianyi:
                textJianyi.setTextColor(Color.WHITE);
                textJianyi.setBackground(getResources().getDrawable(R.drawable.shape_feedback1));
                textTousu.setTextColor(Color.parseColor("#20A8FF"));
                textTousu.setBackground(getResources().getDrawable(R.drawable.shape_feedback2));


                break;
            case R.id.btn_login:
                finish();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                // 隐藏软键盘
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                break;
        }
    }
}
