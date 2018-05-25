package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.adapter.MyAdapter;
import com.project.zaixianjiaoyu.fragment.HomeFragment;
import com.project.zaixianjiaoyu.fragment.MeFragment;
import com.project.zaixianjiaoyu.fragment.MoreFragment;
import com.project.zaixianjiaoyu.fragment.TouziFragment;
import com.project.zaixianjiaoyu.http.MyOkhttp;
import com.project.zaixianjiaoyu.http.callback.StringNoDialogCallback;
import com.project.zaixianjiaoyu.http.request.BaseRequest;
import com.project.zaixianjiaoyu.model.ShangPin;
import com.project.zaixianjiaoyu.xrecycleview.ProgressStyle;
import com.project.zaixianjiaoyu.xrecycleview.XRecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/23.
 */

public class ListActivity extends BaseActivity {

    private XRecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private int page = 1;
    List<ShangPin.DataBean> contentBean3 = new ArrayList<>();
    int totalpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_list);

        mRecyclerView = (XRecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(ListActivity.this, 2);
        mRecyclerView.setLayoutManager(layoutManager);


        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mRecyclerView.loadMoreComplete();
        mAdapter = new MyAdapter(ListActivity.this, contentBean3);
        getShop();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListActivity.this, position + "", Toast.LENGTH_SHORT).show();


            }
        });


        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //refresh data here

                page = 1;
                MyOkhttp.post("http://www.biymo.com/app/index.php?")
                        .tag(this)
                        .params("i", "3")
                        .params("c", "entry")
                        .params("rate", "30")
                        .params("do", "newcatpost")
                        .params("m", "tiger_newhu")
                        .params("type", "0")
                        .params("page", page)

                        .execute(new StringNoDialogCallback() {
                            @Override
                            public void onBefore(BaseRequest request) {
                                super.onBefore(request);
                                showLoading();

                            }

                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
//                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
                                contentBean3.clear();
                                ShangPin fenLeiBean = new ShangPin();
                                Gson gson = new Gson();
                                fenLeiBean = gson.fromJson(s, ShangPin.class);
//                                contentBean3 = fenLeiBean.getData();
                                totalpage = fenLeiBean.getPages();
//                                contentBean3.addAll(fenLeiBean.getData());
                                mAdapter.setData(fenLeiBean.getData());
//                                mAdapter.notifyDataSetChanged();

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
                                mRecyclerView.refreshComplete();
                            }
                        });

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {


                        if (page < totalpage) {
                            new Handler().postDelayed(new Runnable() {
                                public void run() {

                                    page++;
                                    MyOkhttp.post("http://www.biymo.com/app/index.php?")
                                            .tag(this)
                                            .params("i", "3")
                                            .params("c", "entry")
                                            .params("rate", "30")
                                            .params("do", "newcatpost")
                                            .params("m", "tiger_newhu")
                                            .params("type", "0")
                                            .params("page", page)

                                            .execute(new StringNoDialogCallback() {
                                                @Override
                                                public void onBefore(BaseRequest request) {
                                                    super.onBefore(request);
//                                                    showLoading();

                                                }

                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Log.d(s, "eeeeeeeeeeeeeeeeeeeee");

                                                    ShangPin fenLeiBean = new ShangPin();
                                                    Gson gson = new Gson();
                                                    fenLeiBean = gson.fromJson(s, ShangPin.class);


                                                    Log.d("3333333333333333", "3333333333333333333333");


                                                    totalpage = fenLeiBean.getPages();
//                                                    contentBean3.addAll(contentBean3);

                                                    List<ShangPin.DataBean> contengbean4 = new ArrayList<>();

                                                    mAdapter.setData(fenLeiBean.getData());


                                                    mAdapter.notifyDataSetChanged();
                                                    mRecyclerView.loadMoreComplete();
                                                }

                                                @Override
                                                public void onError(Call call, Response response, Exception e) {
                                                    super.onError(call, response, e);
//                                                    dismissLoading();
                                                }

                                                @Override
                                                public void onAfter(String s, Exception e) {
                                                    super.onAfter(s, e);
//                                                    dismissLoading();
                                                }
                                            });

                                    page++;

                                }
                            }, 1000);
                        } else {

                            mRecyclerView.setNoMore(true);
                        }
//                        times ++;
                    }
                }, 1000);
            }
        });
    }

    public void getShop() {
        //商品
//http://www.50210.com.cn/app/index.php?i=3&c=entry&rate=30&do=Newcatpost&m=tiger_newhu
        page = 1;
        MyOkhttp.post("http://www.biymo.com/app/index.php?")
                .tag(this)
                .params("i", "3")
                .params("c", "entry")
                .params("rate", "30")
                .params("do", "newcatpost")
                .params("m", "tiger_newhu")
                .params("type", "0")
                .params("page", page)

                .execute(new StringNoDialogCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        showLoading();

                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
//                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");

                        ShangPin fenLeiBean = new ShangPin();
                        Gson gson = new Gson();
                        fenLeiBean = gson.fromJson(s, ShangPin.class);
//                        contentBean3 = fenLeiBean.getData();
                        totalpage = fenLeiBean.getPages();
//                        contentBean3.addAll(fenLeiBean.getData());
                        mAdapter.setData(fenLeiBean.getData());
//                        mAdapter.notifyDataSetChanged();

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

}
