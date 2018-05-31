package com.project.zaixianjiaoyu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.adapter.MyAdapter;
import com.project.zaixianjiaoyu.adapter.Person;
import com.project.zaixianjiaoyu.http.MyOkhttp;
import com.project.zaixianjiaoyu.http.callback.StringNoDialogCallback;
import com.project.zaixianjiaoyu.http.request.BaseRequest;
import com.project.zaixianjiaoyu.layoutmanager.FullyGridLayoutManager;
import com.project.zaixianjiaoyu.model.ShangPin;
import com.project.zaixianjiaoyu.refreshview.XRefreshView;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.view.CustomerFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2015/12/11.
 */
public class MoreFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerViewTestRv;

    XRefreshView xrefreshview;
    private int page = 1;
    private int totalpage = 0;

    List<ShangPin.DataBean> contentBean3 = new ArrayList<>();
    MyAdapter myAdapter;

    private int mLoadCount = 0;


    private boolean isList = true;//false 为grid布局

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fourth, null);

        unbinder = ButterKnife.bind(this, view);
        ImmersionBar.setFitsSystemWindows(getActivity());

        xrefreshview = (XRefreshView) view.findViewById(R.id.xrefreshview);

        xrefreshview.setPullLoadEnable(true);
        xrefreshview.setPinnedTime(1000);
        xrefreshview.setMoveForHorizontal(true);
        //设置刷新完成以后，headerview固定的时间
        xrefreshview.setScrollBackDuration(300);
        xrefreshview.setAutoLoadMore(false);
//        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        xrefreshview.enableReleaseToLoadMore(true);
        xrefreshview.enableRecyclerViewPullUp(true);
        xrefreshview.enablePullUpWhenLoadCompleted(true);
        recyclerViewTestRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapter = new MyAdapter(getActivity(), contentBean3);
        recyclerViewTestRv.setAdapter(myAdapter);
        xrefreshview.setCustomFooterView(new CustomerFooter(getActivity()));
        getShop();

        xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrefreshview.stopRefresh();
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
//                        Toast.makeText(getActivity(), "下拉刷新呢", Toast.LENGTH_SHORT).show();
                       /* mLoadCount++;
                        if (mLoadCount >= 3) {//模拟没有更多数据的情况
                            xrefreshview.setLoadComplete(true);
                        } else {
                            // 刷新完成必须调用此方法停止加载
                            xrefreshview.stopLoadMore(false);

                        }*/
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


                                                }

                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
                                                    xrefreshview.stopLoadMore(false);
                                                    ShangPin fenLeiBean = new ShangPin();
                                                    Gson gson = new Gson();
                                                    fenLeiBean = gson.fromJson(s, ShangPin.class);


                                                    Log.d("3333333333333333", "3333333333333333333333");

                                                    totalpage = fenLeiBean.getPages();

                                                    myAdapter.setData(fenLeiBean.getData());
                                                    WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
                                                    DisplayMetrics dm = new DisplayMetrics();
                                                    wm.getDefaultDisplay().getMetrics(dm);
                                                    int width = dm.widthPixels;         // 屏幕宽度（像素）
                                                    int height = dm.heightPixels;       // 屏幕高度（像素）
//                                                    recyclerViewTestRv.scrollToPosition(contentBean3.size()+2);
// recyclerViewTestRv.smoothScrollToPosition(2);        height

                                                    recyclerViewTestRv.smoothScrollBy(0, 300);
//         smoothScrollToPositionFromTop
//recyclerViewTestRv.notifyAll();
//                                                    myAdapter.notifyDataSetChanged();

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

//                            mRecyclerView.setNoMore(true);
//                            xrefreshview.stopLoadMore(false);
                            xrefreshview.setLoadComplete(true);
                        }
                    }
                }, 1000);
            }


        });
        return view;
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
//                        showLoading();
showLoading();
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");
//                        Log.d(s, "eeeeeeeeeeeeeeeeeeeee");

                        ShangPin fenLeiBean = new ShangPin();
                        Gson gson = new Gson();
                        fenLeiBean = gson.fromJson(s, ShangPin.class);
                        contentBean3 = fenLeiBean.getData();
                        totalpage = fenLeiBean.getPages();
//                        contentBean3.addAll(contentBean3);
                        myAdapter.setData(fenLeiBean.getData());

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        ImmersionBar.with(getActivity())

                .statusBarDarkFont(true, 1f)
                .init();
    }
}
