package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Loginactivity extends BaseActivity {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_top_layout)
    RelativeLayout rlTopLayout;
    @BindView(R.id.user_phone_num)
    EditText userPhoneNum;
    @BindView(R.id.img_clear_user)
    ImageView imgClearUser;
    @BindView(R.id.user_password)
    EditText userPassword;
    @BindView(R.id.img_clear)
    ImageView imgClear;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.text_forget)
    TextView textForget;
    @BindView(R.id.linearlayout_forget)
    LinearLayout linearlayoutForget;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ImmersionBar.with(this)

                .statusBarDarkFont(true, 1f)
                .init();
    }

    @OnClick({R.id.img_back, R.id.rl_back, R.id.tv_title, R.id.rl_top_layout, R.id.user_phone_num, R.id.img_clear_user, R.id.user_password, R.id.img_clear, R.id.btn_login,R.id.text_forget, R.id.linearlayout_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_title:
                break;
            case R.id.rl_top_layout:
                break;
            case R.id.user_phone_num:
                break;
            case R.id.img_clear_user:
                break;
            case R.id.user_password:
                break;
            case R.id.img_clear:
                break;
            case R.id.btn_login:
                break;
            case R.id.text_forget:
                startActivity(new Intent(Loginactivity.this,ForgetActivity.class));

                break;
            case R.id.linearlayout_forget:
                startActivity(new Intent(Loginactivity.this,ForgetActivity.class));
                break;
        }
    }


}
