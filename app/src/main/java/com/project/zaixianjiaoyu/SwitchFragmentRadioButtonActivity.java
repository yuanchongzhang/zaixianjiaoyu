package com.project.zaixianjiaoyu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.project.zaixianjiaoyu.activity.BaseActivity;
import com.project.zaixianjiaoyu.fragment.HomeFragment;
import com.project.zaixianjiaoyu.fragment.MessageFragment;
import com.project.zaixianjiaoyu.fragment.MineFragment;
import com.project.zaixianjiaoyu.fragment.ShopcartFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2017/10/16.
 */

public class SwitchFragmentRadioButtonActivity extends BaseActivity {


    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbShop)
    RadioButton rbShop;
    @BindView(R.id.rbMessage)
    RadioButton rbMessage;
    @BindView(R.id.rbMine)
    RadioButton rbMine;
    @BindView(R.id.rgTools)
    RadioGroup rgTools;

    private Fragment[] mFragments;

    private int mIndex;

    private static final String TAG = "MainActivity.this";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchfragment);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        initFragment();
    }

    @OnClick({R.id.content, R.id.rbHome, R.id.rbShop, R.id.rbMessage, R.id.rbMine, R.id.rgTools})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.content:
                break;
            case R.id.rbHome:
                setIndexSelected(0);
                break;
            case R.id.rbShop:
                setIndexSelected(1);
                break;
            case R.id.rbMessage:
                setIndexSelected(2);
                break;
            case R.id.rbMine:
                setIndexSelected(3);
                break;
            case R.id.rgTools:
                break;
        }
    }


    private void initFragment() {
        //首页
        HomeFragment homeFragment = new HomeFragment();
        //购物车
        ShopcartFragment shopcartFragment = new ShopcartFragment();

        //消息
        MessageFragment messageFragment = new MessageFragment();
        //个人中心

        MineFragment mineFragment = new MineFragment();

        //添加到数组
        mFragments = new Fragment[]{homeFragment, shopcartFragment, messageFragment, mineFragment};

        //开启事务

        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();

        //添加首页
        ft.add(R.id.content, homeFragment).commit();

        //默认设置为第0个
        setIndexSelected(0);


    }


    private void setIndexSelected(int index) {

        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.content, mFragments[index]).show(mFragments[index]);
        } else {
            ft.show(mFragments[index]);
        }

        ft.commit();
        //再次赋值
        mIndex = index;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    /**
     * 这里用到的了EventBus框架  博客教程:http://blog.csdn.net/lmj623565791/article/details/40920453
     *
     * @param type
     */
    public void onEventMainThread(Integer type) {
        Log.e("---", "EventBus收到int:" + type);
        if (type==0){
            rbHome.performClick();
            setIndexSelected(0);
        }else if (type==1){
            rbShop.performClick();

            setIndexSelected(1);
        }else {
            rbMessage.performClick();
            setIndexSelected(2);
        }



    }
}
