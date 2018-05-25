package com.project.zaixianjiaoyu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.banner.Banner;
import com.project.zaixianjiaoyu.banner.listener.OnBannerListener;
import com.project.zaixianjiaoyu.imageloader.GlideImageLoader;
import com.project.zaixianjiaoyu.paomadeng.SimpleMF;
import com.project.zaixianjiaoyu.paomadeng.SimpleMarqueeView;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends Fragment implements OnBannerListener {


    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;

    public HomeFragment() {

    }
    public List<String> images = new ArrayList<>();
    List<String> datas = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImmersionBar.with(getActivity())

                .statusBarDarkFont(true, 1f)
                .init();
        unbinder = ButterKnife.bind(this, view);

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



        return view;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getActivity(), "点击跳转"+position+"", Toast.LENGTH_SHORT).show();
    }
}
