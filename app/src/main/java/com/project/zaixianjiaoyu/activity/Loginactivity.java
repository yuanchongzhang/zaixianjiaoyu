package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.project.zaixianjiaoyu.Constant;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.http.MyOkhttp;
import com.project.zaixianjiaoyu.http.callback.StringNoDialogCallback;
import com.project.zaixianjiaoyu.http.request.BaseRequest;
import com.project.zaixianjiaoyu.model.AccessToken;
import com.project.zaixianjiaoyu.model.LoginModel;
import com.project.zaixianjiaoyu.model.TestBean;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.SharePreferenceUtil;
import com.project.zaixianjiaoyu.util.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import okhttp3.Call;
import okhttp3.Response;

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
    ImageView textForget;
    @BindView(R.id.linearlayout_forget)
    LinearLayout linearlayoutForget;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        tvTitle.setText("登录");
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 1f)
                .init();

        userPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && !TextUtils.isEmpty(userPhoneNum.getText().toString())) {
                    imgClearUser.setVisibility(View.VISIBLE);
                } else {
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

                if (TextUtils.isEmpty(userPhoneNum.getText().toString())) {
                    imgClearUser.setVisibility(View.GONE);
                } else {
                    imgClearUser.setVisibility(View.VISIBLE);
                }

            }
        });


        userPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && !TextUtils.isEmpty(userPassword.getText().toString())) {
                    imgClear.setVisibility(View.VISIBLE);
                } else {
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
                if (TextUtils.isEmpty(userPassword.getText().toString())) {
                    imgClear.setVisibility(View.GONE);
                } else {
                    imgClear.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @OnClick({R.id.img_back, R.id.rl_back, R.id.tv_title, R.id.rl_top_layout, R.id.user_phone_num, R.id.img_clear_user, R.id.user_password, R.id.img_clear, R.id.btn_login, R.id.text_forget, R.id.linearlayout_forget})
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
                if (TextUtils.isEmpty(userPhoneNum.getText().toString())) {
                    ToastUtil.showCenterToast(this, "用户名不能为空");
                } else if (TextUtils.isEmpty(userPassword.getText().toString())) {
                    ToastUtil.showCenterToast(this, "密码不能为空");
                } else {
                  /*  ToastUtil.showCenterToast(this, "登录");
                    SharePreferenceUtil.put(Loginactivity.this, "token", "2345");
                    finish();*/
//                    http://221.208.29.24/webapi//api/login/Getlogin?cSys_UserID=wuxijuan&&cPassword=
//                    String string = "http://221.208.29.24/webapi//api/login/Getlogin?cSys_UserID=wuxijuan&&cPassword=";
                    String const_url = Constant.MODEL_URL + "/api/login/Getlogin?";

//                    wuxijuan  123456
                    MyOkhttp.get(const_url)
                            .tag(this)
                            .params("cSys_UserID", userPhoneNum.getText().toString())
                            .params("cPassword", userPassword.getText().toString())
                            .execute(new StringNoDialogCallback() {

                                @Override
                                public void onBefore(BaseRequest request) {
                                    super.onBefore(request);

                                    showLoading();
                                }

                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
                                    Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
                                    LoginModel loginModel = new LoginModel();
                                    Gson gson = new Gson();
                                    loginModel = gson.fromJson(s, LoginModel.class);

                                    if (loginModel.isLoginResult() == true) {
                                        SharePreferenceUtil.put(Loginactivity.this, "token", loginModel.getToken());
                                        ToastUtil.showCenterToast(Loginactivity.this, "登录成功");
                                        finish();
                                    } else {
                                        ToastUtil.showCenterToast(Loginactivity.this, loginModel.getErrorMessage());
                                    }


                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    dismissLoading();
                                }

                                @Override
                                public void onAfter(String s, Exception e) {
                                    super.onAfter(s, e);
                                    dismissLoading();
                                }
                            });


                }


                break;
            case R.id.text_forget:
                startActivity(new Intent(Loginactivity.this, ForgetActivity.class));

                break;
            case R.id.linearlayout_forget:
                startActivity(new Intent(Loginactivity.this, ForgetActivity.class));
                break;
        }
    }


}
