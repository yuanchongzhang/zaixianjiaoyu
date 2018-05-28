package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

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

        userPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
if (b && !TextUtils.isEmpty(userPhoneNum.getText().toString())){
    imgClearUser.setVisibility(View.VISIBLE);
}else {
    imgClearUser.setVisibility(View.GONE);
}


            }
        });


        userPhoneNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (TextUtils.isEmpty(userPhoneNum.getText().toString())){
                    imgClearUser.setVisibility(View.GONE);
                }else {
                    imgClearUser.setVisibility(View.VISIBLE);
                }

            }
        });


        userPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && !TextUtils.isEmpty(userPassword.getText().toString())){
                    imgClear.setVisibility(View.VISIBLE);
                }else {
                    imgClear.setVisibility(View.GONE);
                }


            }
        });
userPassword.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
if (TextUtils.isEmpty(userPassword.getText().toString())){
    imgClear.setVisibility(View.GONE);
}else {
    imgClear.setVisibility(View.VISIBLE);
}
    }
});

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

                userPhoneNum.setText("");
                break;
            case R.id.user_password:
                break;
            case R.id.img_clear:
//                user_phone_num

                userPassword.setText("");
                break;
            case R.id.btn_login:
                if (TextUtils.isEmpty(userPhoneNum.getText().toString())){
                    ToastUtil.showCenterToast(this,"用户名不能为空");
                }else if (TextUtils.isEmpty(userPassword.getText().toString())){
                    ToastUtil.showCenterToast(this,"密码不能为空");
                }else {
                    ToastUtil.showCenterToast(this,"登录");
                }


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
