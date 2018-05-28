package com.project.zaixianjiaoyu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.activity.ZXingActivity;
import com.project.zaixianjiaoyu.banner.Banner;
import com.project.zaixianjiaoyu.banner.listener.OnBannerListener;
import com.project.zaixianjiaoyu.imageloader.GlideImageLoader;
import com.project.zaixianjiaoyu.paomadeng.OnItemClickListener;
import com.project.zaixianjiaoyu.paomadeng.SimpleMF;
import com.project.zaixianjiaoyu.paomadeng.SimpleMarqueeView;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.ToastUtil;
import com.project.zaixianjiaoyu.zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

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
        marqueeView.setOnItemClickListener(new OnItemClickListener<TextView, String>() {
            @Override
            public void onItemClickListener(TextView mView, String mData, int mPosition) {
                ToastUtil.showCenterToast(getActivity(), mPosition + "");
            }
        });


        return view;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getActivity(), "点击跳转" + position + "", Toast.LENGTH_SHORT).show();
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
