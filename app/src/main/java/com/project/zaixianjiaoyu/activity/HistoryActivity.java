package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.adapter.HistoryAdapter;
import com.project.zaixianjiaoyu.refreshview.XRefreshView;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_top_layout)
    RelativeLayout rlTopLayout;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerViewTestRv;
    @BindView(R.id.xrefreshview)
    XRefreshView xrefreshview;
    HistoryAdapter xiaoXiAdapter;
    LinearLayoutManager layoutManager;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    private int mLoadCount = 0;
    List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        recyclerViewTestRv.setHasFixedSize(true);
        ImmersionBar.with(this)

                .statusBarDarkFont(true, 1f)
                .init();
        xrefreshview.setPullLoadEnable(true);
        for (int i = 0; i < 10; i++) {
            datas.add("消息" + i);
        }
        tvTitle.setText("收藏历史");

        xiaoXiAdapter = new HistoryAdapter(this, datas);

//        adapter = new SimpleAdapter(personList, getActivity());
        layoutManager = new LinearLayoutManager(this);
        recyclerViewTestRv.setLayoutManager(layoutManager);
        recyclerViewTestRv.setNestedScrollingEnabled(false);
        // 静默加载模式不能设置footerview
        recyclerViewTestRv.setAdapter(xiaoXiAdapter);
        recyclerViewTestRv.setLayoutManager(layoutManager);

//        adapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));
        xrefreshview.setPinnedTime(1000);
        xrefreshview.setMoveForHorizontal(true);
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

                    }
                }, 1000);
            }


        });

        xiaoXiAdapter.setOnItemClickListener(new HistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(HistoryActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick({R.id.img_back, R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_back:
                finish();
                break;
        }
    }
}
