package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.util.Regular;
import com.project.zaixianjiaoyu.util.TimeCount;
import com.project.zaixianjiaoyu.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetActivity extends BaseActivity {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_top_layout)
    RelativeLayout rlTopLayout;
    @BindView(R.id.edit_userphone)
    EditText editUserphone;
    @BindView(R.id.img_clearphone)
    ImageView imgClearphone;
    @BindView(R.id.btn_send_mes)
    Button btnSendMes;
    @BindView(R.id.edit_sms)
    EditText editSms;
    @BindView(R.id.imgclearsms)
    ImageView imgclearsms;
    @BindView(R.id.btn_next)
    Button btnNext;
    private TimeCount timeCount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);
        timeCount = new TimeCount(60000, 100, btnSendMes);
    editUserphone.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (TextUtils.isEmpty(editUserphone.getText().toString())){
                imgClearphone.setVisibility(View.GONE);
            }else {
                imgClearphone.setVisibility(View.VISIBLE);
            }

        }
    });


        editUserphone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b&& !TextUtils.isEmpty(editUserphone.getText().toString())){
                    imgClearphone.setVisibility(View.VISIBLE);
                }else {
                    imgClearphone.setVisibility(View.GONE);
                }

            }
        });


        editSms.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b&& !TextUtils.isEmpty(editSms.getText().toString())){
                    imgclearsms.setVisibility(View.VISIBLE);
                }else {
                    imgclearsms.setVisibility(View.GONE);
                }

            }
        });

        editSms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (TextUtils.isEmpty(editSms.getText().toString())){
                    imgclearsms.setVisibility(View.GONE);
                }else {
                    imgclearsms.setVisibility(View.VISIBLE);
                }

            }
        });


    }


    @OnClick({R.id.img_back, R.id.rl_back, R.id.tv_title, R.id.rl_top_layout, R.id.edit_userphone, R.id.img_clearphone, R.id.btn_send_mes, R.id.edit_sms, R.id.imgclearsms, R.id.btn_next})
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
            case R.id.edit_userphone:
                break;
            case R.id.img_clearphone:
                editUserphone.setText("");
                break;
            case R.id.btn_send_mes:
                if (TextUtils.isEmpty(editUserphone.getText().toString())){
                    ToastUtil.showCenterToast(this,"手机号不能为空");
                } else if (!Regular.isMobileNO(editUserphone.getText().toString())) {
                    ToastUtil.showCenterToast(this, "请输入正确的手机号码");
                }else {
timeCount.start();
                }

                break;
            case R.id.edit_sms:

                break;
            case R.id.imgclearsms:
                editSms.setText("");
                break;
            case R.id.btn_next:
                if (TextUtils.isEmpty(editUserphone.getText().toString())){
                    ToastUtil.showCenterToast(this,"手机号不能为空");
                }else if (TextUtils.isEmpty(editSms.getText().toString())){
                    ToastUtil.showCenterToast(this,"验证码不能为空");
                }else {
                    ToastUtil.showCenterToast(this,"重置密码");
                }

                break;
        }
    }
}
