package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.http.MyOkhttp;
import com.project.zaixianjiaoyu.http.callback.StringCallback;
import com.project.zaixianjiaoyu.http.callback.StringNoDialogCallback;
import com.project.zaixianjiaoyu.http.request.BaseRequest;
import com.project.zaixianjiaoyu.model.AccessToken;
import com.project.zaixianjiaoyu.model.BannerModel;
import com.project.zaixianjiaoyu.util.MD5Utils;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/13.
 */

public class TestInterfacePostActivity extends BaseActivity {
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.test_xianshi)
    TextView testXianshi;
    @BindView(R.id.test_xianshi2)
    TextView testXianshi2;
    @BindView(R.id.test_xiansh3)
    TextView testXiansh3;
    @BindView(R.id.test_xiansh4)
    TextView testXiansh4;
    @BindView(R.id.test_xiansh5)
    TextView testXiansh5;
    private String md5str;
    private String str;
    String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testinterface);
        ButterKnife.bind(this);
        str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        md5str = MD5Utils.encode("index/index" + "20160001" + str + "24SD%F4}S5").toUpperCase();
    }

    public void getData() {
        MyOkhttp.post("http://www.rongzecf.com/api/index/token")
                .tag(this)
                .params("client_id", "20160001")
                .params("grant_type", "index/index")
                .params("source_from", "1")
                .params("add_time", str)
                .params("sign_info", md5str)
                .execute(new StringNoDialogCallback() {

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);


                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
                        AccessToken accessToken = new AccessToken();
                        Gson gson = new Gson();
                        accessToken = gson.fromJson(s, AccessToken.class);
//                        token = accessToken.getAccess_token();
//                        Toast.makeText(TestInterfacePostActivity.this, "成功" + accessToken.getStatus(), Toast.LENGTH_SHORT).show();
                        getZhaiqistData(token);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);

                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);

                    }
                });

    }

    public void getZhaiqistData(String accesstoken) {
        MyOkhttp.post("http://www.rongzecf.com/api/index/index")
                .tag(this)//
                .params("access_token", accesstoken)

                .execute(new StringCallback(TestInterfacePostActivity.this) {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d(s.toString(), "4444444444444444444");
                        Gson gson = new Gson();


                        BannerModel bannerModel = new BannerModel();
                        bannerModel = gson.fromJson(s.toString(), BannerModel.class);
                        testXianshi.setText(bannerModel.getBanner().get(0).getTitle());
                        testXianshi2.setText(bannerModel.getBanner_middle().get(0).getTitle());
                        testXiansh3.setText(bannerModel.getBorrow_list().get(0).getBorrow_duration());
                        testXiansh4.setText(bannerModel.getNotice().get(0).getTitle());
                        testXiansh5.setText(bannerModel.getStatus());
                        Toast.makeText(TestInterfacePostActivity.this, bannerModel.getNews_id(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
//        MyOkHttp.getInstance().cancelTag(this);
//        MyOkhttp.getInstance().cancelTag(this);
    }


    @OnClick({R.id.btn_test, R.id.test_xianshi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_test:
                getData();
                break;
            case R.id.test_xianshi:
                break;
        }
    }
}
