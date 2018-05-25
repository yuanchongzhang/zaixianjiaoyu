package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.project.zaixianjiaoyu.HideFragmentActivity;
import com.project.zaixianjiaoyu.MainActivity;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.util.SharePreferenceUtil;


/**
 * Created by Administrator on 2016/11/15.
 */
public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* // 判断是否是第一次开启应用
        boolean isFirstOpen = SharedPreferencesUtil.getBoolean(this, SharedPreferencesUtil.FIRST_OPEN, true);
        // 如果是第一次启动，则先进入功能引导页
        if (isFirstOpen) {
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }
*/
        // 如果不是第一次启动app，则正常显示启动屏
        setContentView(R.layout.activity_welcome);
        // ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                boolean isFirstOpen = SharePreferenceUtil.getBoolean(SplashActivity.this, SharePreferenceUtil.FIRST_OPEN, true);
                // 如果是第一次启动，则先进入功能引导页
                if (isFirstOpen) {
//                    Intent intent = new Intent(SplashActivity.this, WelcomeGuideActivity.class);
                    Intent intent = new Intent(SplashActivity.this, HideFragmentActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                } else {
//                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    Intent intent = new Intent(SplashActivity.this, HideFragmentActivity.class);
                    finish();
                }
            }
        }, 3000);

    }

}
