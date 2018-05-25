package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;

public class Loginactivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImmersionBar.with(this)

                .statusBarDarkFont(true, 1f)
                .init();
    }
}
