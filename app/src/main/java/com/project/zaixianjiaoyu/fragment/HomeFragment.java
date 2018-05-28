package com.project.zaixianjiaoyu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.activity.HomeDetailActivity;
import com.project.zaixianjiaoyu.activity.WebViewActivity;
import com.project.zaixianjiaoyu.activity.ZXingActivity;
import com.project.zaixianjiaoyu.adapter.Person;
import com.project.zaixianjiaoyu.adapter.SimpleAdapter;
import com.project.zaixianjiaoyu.banner.Banner;
import com.project.zaixianjiaoyu.banner.listener.OnBannerListener;
import com.project.zaixianjiaoyu.imageloader.GlideImageLoader;
import com.project.zaixianjiaoyu.paomadeng.OnItemClickListener;
import com.project.zaixianjiaoyu.paomadeng.SimpleMF;
import com.project.zaixianjiaoyu.paomadeng.SimpleMarqueeView;
import com.project.zaixianjiaoyu.refreshview.XRefreshView;
import com.project.zaixianjiaoyu.refreshview.XRefreshViewFooter;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.ToastUtil;
import com.project.zaixianjiaoyu.zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.just.library.FileUpLoadChooserImpl.REQUEST_CODE;


public class HomeFragment extends Fragment implements OnBannerListener {
    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;

    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.img_zxing)
    ImageView imgZxing;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.lyaout_search)
    LinearLayout lyaoutSearch;
    @BindView(R.id.layout_searchweb)
    LinearLayout layoutSearchweb;

    public HomeFragment() {

    }

    public List<String> images = new ArrayList<>();
    List<String> datas = new ArrayList<>();
    XRefreshView xRefreshView;

    RecyclerView recyclerView;

    SimpleAdapter adapter;
    List<Person> personList = new ArrayList<Person>();
    LinearLayoutManager layoutManager;
    private boolean isBottom = false;
    private int mLoadCount = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImmersionBar.with(getActivity())

                .statusBarDarkFont(true, 1f)
                .init();
        unbinder = ButterKnife.bind(this, view);
        xRefreshView= (XRefreshView) view.findViewById(R.id.xrefreshview);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_test_rv);
        recyclerView.setHasFixedSize(true);
        xRefreshView.setPullLoadEnable(true);
        adapter = new SimpleAdapter(personList, getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        // 静默加载模式不能设置footerview
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
        datas.add("德国vs巴西");
        datas.add("10分钟一期");
        datas.add("奖池近50亿");
        datas.add("奖池近52亿");
        datas.add("掘金vs猛龙");
        SimpleMarqueeView<String> marqueeView = (SimpleMarqueeView) view.findViewById(R.id.simpleMarqueeView);
        SimpleMF<String> marqueeFactory = new SimpleMF(getActivity());
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();
        marqueeView.setOnItemClickListener(new OnItemClickListener<TextView, String>() {
            @Override
            public void onItemClickListener(TextView mView, String mData, int mPosition) {
//                ToastUtil.showCenterToast(getActivity(), mPosition + "");
//                startActivity(new Intent(getActivity(),HomeDetailActivity.class));
startActivity(new Intent(getActivity(),WebViewActivity.class));

            }
        });

        adapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));
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
                        if(xRefreshView.hasLoadCompleted()){
                        }
                        for (int i = 0; i < 6; i++) {
                            adapter.insert(new Person("More ", "21"),
                                    adapter.getAdapterItemCount());

                        }
                        mLoadCount++;
                        if (mLoadCount >= 3) {
                            xRefreshView.setLoadComplete(true);
                        } else {
                            // 刷新完成必须调用此方法停止加载
                            xRefreshView.stopLoadMore(false);
                        }
                    }
                }, 1000);
            }


        });

        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(getActivity(), position+"", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),HomeDetailActivity.class));
            }
        });

        return view;


    }

    private boolean isLeft = true;
    private int getType() {
        isLeft = !isLeft;
        return isLeft ? 0 : 1;
    }
    private void initData() {
        for (int i = 0; i < 15; i++) {
            Person person = new Person("2018年5月下半月培训计划" + i, "" + i);
            personList.add(person);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void OnBannerClick(int position) {
     startActivity(new Intent(getActivity(), WebViewActivity.class));
    }

    @OnClick({R.id.img_zxing, R.id.edit_search, R.id.img_search, R.id.lyaout_search, R.id.layout_searchweb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_zxing:
//               startActivity(new Intent(getActivity(),ZXingActivity.class));
               Intent intent = new Intent(getActivity(), ZXingActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.edit_search:
                break;
            case R.id.img_search:
                break;
            case R.id.lyaout_search:
                break;
            case R.id.layout_searchweb:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
