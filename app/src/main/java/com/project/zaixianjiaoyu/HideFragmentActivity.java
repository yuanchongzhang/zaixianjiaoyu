package com.project.zaixianjiaoyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.activity.BaseActivity;
import com.project.zaixianjiaoyu.activity.Loginactivity;
import com.project.zaixianjiaoyu.adapter.MyAdapter;
import com.project.zaixianjiaoyu.fragment.DiSiFragment;
import com.project.zaixianjiaoyu.fragment.HomeFragment;
import com.project.zaixianjiaoyu.fragment.MeFragment;
import com.project.zaixianjiaoyu.fragment.MoreFragment;
import com.project.zaixianjiaoyu.fragment.RightFragment;
import com.project.zaixianjiaoyu.fragment.TouziFragment;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.project.zaixianjiaoyu.util.SharePreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/23.
 */

public class HideFragmentActivity extends BaseActivity {
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_touzi)
    ImageView ivTouzi;
    @BindView(R.id.tv_touzi)
    TextView tvTouzi;
    @BindView(R.id.ll_touzi)
    LinearLayout llTouzi;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.ll_me)
    LinearLayout llMe;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.ll_more)
    LinearLayout llMore;
    @BindView(R.id.iv_fourth)
    ImageView ivFourth;
    @BindView(R.id.tv_fourth)
    TextView tvFourth;
    @BindView(R.id.ll_me_fourth)
    LinearLayout llMeFourth;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private HomeFragment homeFragment;
    private TouziFragment touziFragment;
    private MeFragment meFragment;
    private MoreFragment moreFragment;

    private DiSiFragment moreFragment2;
    private FragmentTransaction ft;

    String token;
//    private RightFragment fg_right_menu;

//    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidefragment);
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);

        setSelect(0);
        /*fManager = getSupportFragmentManager();
        fg_right_menu = (RightFragment) fManager.findFragmentById(R.id.fg_right_menu);*/
        token = (String) SharePreferenceUtil.get(this, "token", "");
        ImmersionBar.with(this)

                .statusBarDarkFont(true, 1f)
                .init();
   /*     drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.END);*/

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {


            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {
                drawerLayout.setClickable(true);
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            /* @Override
            public void onDrawerClosed(View view) {

              *//*  drawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);*//*
            }*/

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        reSetTab();
        hideFragment();
        switch (i) {
            case 0:
                //首页
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.content, homeFragment);
                }
                ivHome.setImageResource(R.drawable.bid01);
                //  tvHome.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(homeFragment);
                break;
            case 1:
                //投资
                if (touziFragment == null) {
                    touziFragment = new TouziFragment();
                    ft.add(R.id.content, touziFragment);
                }
                ivTouzi.setImageResource(R.drawable.bid03);
                //  tvTouzi.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(touziFragment);
                break;
            case 2:
                //资产
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    ft.add(R.id.content, meFragment);
                }
                ivMe.setImageResource(R.drawable.person_selected);
                // tvMe.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(meFragment);
                break;
            case 3:
                //更多
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    ft.add(R.id.content, moreFragment);
                }
                ivMore.setImageResource(R.drawable.bid07);
                //  tvMore.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(moreFragment);
                break;

            case 4:
                //更多
                if (moreFragment2 == null) {
                    moreFragment2 = new DiSiFragment();
                    ft.add(R.id.content, moreFragment2);
                }
//                ivMore.setImageResource(R.drawable.bid07);
                ivFourth.setImageResource(R.drawable.bid05);

                //  tvMore.setTextColor(UIUtils.getColor(R.color.home_back_selected));
                ft.show(moreFragment2);
                break;
        }
        ft.commit();
    }


    private void reSetTab() {
        ivHome.setImageResource(R.drawable.bid02);
        ivTouzi.setImageResource(R.drawable.bid04);
        ivMe.setImageResource(R.drawable.person_unselected);
        ivMore.setImageResource(R.drawable.bid08);
        ivFourth.setImageResource(R.drawable.bid06);
    }


    private void hideFragment() {
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (touziFragment != null) {
            ft.hide(touziFragment);
        }
        if (meFragment != null) {
            ft.hide(meFragment);
        }
        if (moreFragment != null) {
            ft.hide(moreFragment);
        }
        if (moreFragment2 != null) {
            ft.hide(moreFragment2);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//将值传入DemoFragment
//        this.getSupportFragmentManager().findFragmentByTag(MeFragment.class.getSimpleName()).onActivityResult(requestCode, resultCode, data);
//   FragmentManager fragmentManager=getSupportFragmentManager().findFragmentByTag(MeFragment.class.getSimpleName()).onActivityResult(requestCode, resultCode, data);

    }

    @OnClick({R.id.iv_home, R.id.tv_home, R.id.ll_home, R.id.iv_touzi, R.id.tv_touzi, R.id.ll_touzi, R.id.iv_me, R.id.tv_me, R.id.ll_me, R.id.iv_more, R.id.tv_more, R.id.ll_more, R.id.iv_fourth, R.id.tv_fourth, R.id.ll_me_fourth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                setSelect(0);
                break;
            case R.id.tv_home:
                setSelect(0);
                break;
            case R.id.ll_home:
                setSelect(0);
                break;
            case R.id.iv_touzi:


            case R.id.tv_touzi:


            case R.id.ll_touzi:
                token = (String) SharePreferenceUtil.get(this, "token", "");
                if (TextUtils.isEmpty(token)) {
                    startActivity(new Intent(HideFragmentActivity.this, Loginactivity.class));
                } else {
                    setSelect(1);
                }


                break;
            case R.id.iv_me:

            case R.id.tv_me:

            case R.id.ll_me:
                token = (String) SharePreferenceUtil.get(this, "token", "");
                if (TextUtils.isEmpty(token)) {
                    startActivity(new Intent(HideFragmentActivity.this, Loginactivity.class));
                } else {
                    setSelect(2);
                }
                break;
            case R.id.iv_more:

            case R.id.tv_more:

            case R.id.ll_more:

                setSelect(3);
                break;

            case R.id.iv_fourth:


            case R.id.tv_fourth:


            case R.id.ll_me_fourth:

                setSelect(4);


                break;
        }
    }

 /*   public void onEventMainThread(Integer type) {
        Log.e("---", "EventBus收到int:" + type);
        if (type == 0) {
            setSelect(0);
        } else if (type == 1) {
            setSelect(1);
        } else {
            setSelect(2);
        }


    }*/


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
    // 菜单项被选择事件


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
                Toast.makeText(HideFragmentActivity.this, "我的项目", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(HideFragmentActivity.this, "我的任务", Toast.LENGTH_SHORT).show();
                break;
        }
//        return super.onOptionsItemSelected(item);
        return true;
    }

    @OnClick(R.id.drawer_layout)
    public void onViewClicked() {
    }
}
