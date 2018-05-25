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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/13.
 */

public class TestInterfaceGetActivity extends BaseActivity {


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
//        getData();
    }

    public void getData() {
        MyOkhttp.get("http://www.rongzecf.com/api/index/token")
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
                        token = accessToken.getAccess_token();
                        Toast.makeText(TestInterfaceGetActivity.this, "成功" + accessToken.getStatus(), Toast.LENGTH_SHORT).show();
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
        MyOkhttp.get("http://www.rongzecf.com/api/index/index")
                .tag(this)//
                .params("access_token", accesstoken)

                .execute(new StringCallback(TestInterfaceGetActivity.this) {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d(s.toString(), "4444444444444444444");
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            BannerModel bannerModel = null;
                            if (jsonObject.optString("status").equals("1")) {
                                bannerModel = new BannerModel();
                                JSONArray jsonArray = jsonObject.optJSONArray("banner");
                                List<BannerModel.BannerBean> bannerBeen = new ArrayList<>();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object1 = jsonArray.optJSONObject(i);
                                    BannerModel.BannerBean listContent = new BannerModel.BannerBean();
                                    listContent.setImg(object1.optString("img"));
                                    listContent.setTitle(object1.optString("url"));
                                    listContent.setTitle(object1.optString("title"));
                                    bannerBeen.add(listContent);
                                }
                                JSONArray jsonArray2 = jsonObject.optJSONArray("banner_middle");
                                List<BannerModel.BannerMiddleBean> bannerMiddleBeen = new ArrayList<>();
                                for (int i = 0; i < jsonArray2.length(); i++) {
                                    JSONObject object1 = jsonArray2.optJSONObject(i);
                                    BannerModel.BannerMiddleBean listContent = new BannerModel.BannerMiddleBean();
                                    listContent.setImg(object1.optString("img"));
                                    listContent.setTitle(object1.optString("url"));
                                    listContent.setTitle(object1.optString("title"));
                                    bannerMiddleBeen.add(listContent);

                                }
                                JSONArray jsonArray3 = jsonObject.optJSONArray("borrow_list");
                                List<BannerModel.BorrowListBean> borrowListBeen = new ArrayList<>();
                                for (int i = 0; i < jsonArray3.length(); i++) {
                                    JSONObject object1 = jsonArray3.optJSONObject(i);
                                    BannerModel.BorrowListBean listContent = new BannerModel.BorrowListBean();
                                    listContent.setBorrow_name(object1.optString("borrow_name"));
                                    listContent.setNeed(object1.optString("need"));
                                    listContent.setId(object1.optString("id"));
                                    borrowListBeen.add(listContent);

                                }


                                JSONArray jsonArray4 = jsonObject.optJSONArray("notice");
                                List<BannerModel.NoticeBean> noticeBeen = new ArrayList<>();
                                for (int i = 0; i < jsonArray4.length(); i++) {
                                    JSONObject object1 = jsonArray4.optJSONObject(i);
                                    BannerModel.NoticeBean listContent = new BannerModel.NoticeBean();
                                    listContent.setId(object1.optString("id"));
                                    listContent.setTitle(object1.optString("title"));
                                    listContent.setType_id(object1.optString("type_id"));
                                    noticeBeen.add(listContent);

                                }
                                JSONArray jsonArray5 = jsonObject.optJSONArray("notice");
                                List<BannerModel.FriendListBean> friendListBeen = new ArrayList<>();
                                for (int i = 0; i < jsonArray5.length(); i++) {
                                    JSONObject object1 = jsonArray5.optJSONObject(i);
                                    BannerModel.FriendListBean listContent = new BannerModel.FriendListBean();
                                    listContent.setLink_img(object1.optString("link_img"));

                                    friendListBeen.add(listContent);

                                }

                                testXianshi.setText(bannerBeen.get(0).getImg());
                                testXianshi2.setText(bannerMiddleBeen.get(0).getTitle());
                                testXiansh3.setText(borrowListBeen.get(0).getBorrow_name());
                                testXiansh4.setText(noticeBeen.get(0).getTitle());
                                testXiansh5.setText(friendListBeen.get(0).getLink_img());
                            } else {
                                Toast.makeText(TestInterfaceGetActivity.this, "请求不成功", Toast.LENGTH_SHORT).show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                     /*   Gson gson = new Gson();


                        BannerModel bannerModel = new BannerModel();
                        bannerModel = gson.fromJson(s.toString(), BannerModel.class);


                        Toast.makeText(TestInterfaceGetActivity.this, bannerModel.getNews_id(), Toast.LENGTH_SHORT).show();*/


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
