package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.adapter.MyAdapter;
import com.project.zaixianjiaoyu.http.MyOkhttp;
import com.project.zaixianjiaoyu.http.callback.StringNoDialogCallback;
import com.project.zaixianjiaoyu.http.request.BaseRequest;
import com.project.zaixianjiaoyu.model.Gengxin;
import com.project.zaixianjiaoyu.model.ShangPin;
import com.project.zaixianjiaoyu.util.UpdateManager;
import com.project.zaixianjiaoyu.xrecycleview.ProgressStyle;
import com.project.zaixianjiaoyu.xrecycleview.XRecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/23.
 */

public class HotActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_hot);

        UpdateManager manager = new UpdateManager(HotActivity.this,
                "https://udrmb-file.b0.upaiyun.com/apk/udrmb_1.0.0.apk");
        manager.showDownloadDialog();


//                https://udrmb-file.b0.upaiyun.com/apk/udrmb_1.0.0.apk
              /*  MyOkhttp.post("https://udrmb-file.b0.upaiyun.com/apk/udrmb_1.0.0.apk")
                        .tag(this)


                        .execute(new StringNoDialogCallback() {

                            @Override
                            public void onBefore(BaseRequest request) {
                                super.onBefore(request);


                            }

                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Gengxin gengxin = new Gengxin();

                                Gson gson = new Gson();
                                gengxin = gson.fromJson(s, Gengxin.class);
                                UpdateManager manager = new UpdateManager(HotActivity.this,
                                        gengxin.getWapurl());
                                manager.showDownloadDialog();
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
        }, 1000);*/


    }
}
