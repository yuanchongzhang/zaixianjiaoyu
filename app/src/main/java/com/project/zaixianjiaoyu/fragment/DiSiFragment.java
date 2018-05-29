package com.project.zaixianjiaoyu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.activity.HomeDetailActivity;
import com.project.zaixianjiaoyu.adapter.Person;
import com.project.zaixianjiaoyu.adapter.SimpleAdapter;
import com.project.zaixianjiaoyu.adapter.XiaoXiAdapter;
import com.project.zaixianjiaoyu.refreshview.XRefreshView;
import com.project.zaixianjiaoyu.refreshview.XRefreshViewFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2015/12/11.
 */
public class DiSiFragment extends Fragment {

    Unbinder unbinder;
    XRefreshView xRefreshView;

    RecyclerView recyclerView;
    List<Person> personList = new ArrayList<Person>();
    XiaoXiAdapter xiaoXiAdapter;
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;
    List<String> datas=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fourth2, null);

        unbinder = ButterKnife.bind(this, view);
        xRefreshView = (XRefreshView) view.findViewById(R.id.xrefreshview);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_test_rv);
        recyclerView.setHasFixedSize(true);
        xRefreshView.setPullLoadEnable(true);
        for (int i = 0; i < 10; i++) {
            datas.add("消息" + i);
        }

        xiaoXiAdapter =new XiaoXiAdapter(getActivity(), datas);

//        adapter = new SimpleAdapter(personList, getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        // 静默加载模式不能设置footerview
        recyclerView.setAdapter(xiaoXiAdapter);
        recyclerView.setLayoutManager(layoutManager);

//        adapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));
        xRefreshView.setPinnedTime(1000);
        xRefreshView.setMoveForHorizontal(true);
        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xRefreshView.stopRefresh();
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

        xiaoXiAdapter.setOnItemClickListener(new XiaoXiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position+"", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            Person person = new Person("2018年5月下半月培训计划" + i, "" + i);
            personList.add(person);
        }
    }
}
