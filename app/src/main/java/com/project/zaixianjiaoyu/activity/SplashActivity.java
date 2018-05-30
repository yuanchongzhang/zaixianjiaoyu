package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.project.zaixianjiaoyu.BuildConfig;
import com.project.zaixianjiaoyu.HideFragmentActivity;
import com.project.zaixianjiaoyu.MainActivity;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.util.SharePreferenceUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by Administrator on 2016/11/15.
 */
public class SplashActivity extends BaseActivity {
//    a82483efc4a7a62caa74230a7aecd619
//175507BFADAD16EF28FED47D0C5EEE64  A82483EFC4A7A62CAA74230A7AECD619
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


        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, PackageManager.GET_SIGNATURES);
            String signValidString = getSignValidString(packageInfo.signatures[0].toByteArray());
            Log.e("获取应用签名", BuildConfig.APPLICATION_ID + "__" + signValidString);
        } catch (Exception e) {
            Log.e("获取应用签名", "异常__" + e);
        }



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

    private String getSignValidString( byte[] paramArrayOfByte) throws NoSuchAlgorithmException
    {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramArrayOfByte);
        return toHexString(localMessageDigest.digest());
    }
    public String toHexString(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfByte.length);
        for (int i = 0; ; i++) {
            if (i >= paramArrayOfByte.length) {
                return localStringBuilder.toString();
            }
            String str = Integer.toString(0xFF & paramArrayOfByte[i], 16);
            if (str.length() == 1) {
                str = "0" + str;
            }
            localStringBuilder.append(str);
        }
    }
}
