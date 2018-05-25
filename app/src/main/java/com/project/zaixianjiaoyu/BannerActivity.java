package com.project.zaixianjiaoyu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.project.zaixianjiaoyu.activity.BaseActivity;
import com.project.zaixianjiaoyu.banner.Banner;
import com.project.zaixianjiaoyu.banner.listener.OnBannerListener;
import com.project.zaixianjiaoyu.imageloader.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/20.
 */

public class BannerActivity extends BaseActivity implements OnBannerListener {

    @BindView(R.id.banner)
    Banner banner;
    public  List<String> images = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);

        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
    }


    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(this, "点击了" + position + "个", Toast.LENGTH_SHORT).show();
    }
}
