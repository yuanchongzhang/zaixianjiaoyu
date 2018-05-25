package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.util.SharePreferenceUtil;

/**
 * Created by Administrator on 2017/10/16.
 */

public class SharePreferenceActivity extends BaseActivity {
    TextView text_hello1, text_hello2, text_hello3, text_hello4, text_hello5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreference);
        text_hello1 = (TextView) findViewById(R.id.text_hello1);
        text_hello1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePreferenceUtil.put(SharePreferenceActivity.this, "test", "显示测试用例");
           /*     if (SharePreferenceUtil.contains(MainActivity.this, "test")) {
                    AppToastMgr.shortToast(MainActivity.this, SharePreferenceUtil.get(MainActivity.this, "test", "") + "");
                }*/
            }
        });

        text_hello2 = (TextView) findViewById(R.id.text_hello2);
        text_hello2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    SharePreferenceUtil.put(MainActivity.this, "test", "显示测试用例");
                if (SharePreferenceUtil.contains(MainActivity.this, "test")) {
                    AppToastMgr.shortToast(MainActivity.this, SharePreferenceUtil.get(MainActivity.this, "test", "") + "");
                }*/
                String string = (String) SharePreferenceUtil.get(SharePreferenceActivity.this, "test", "");
                text_hello2.setText(string);
            }
        });

        text_hello3 = (TextView) findViewById(R.id.text_hello3);
        text_hello3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePreferenceUtil.put(SharePreferenceActivity.this, "test1", "显示测试用例2");
             /*   if (SharePreferenceUtil.contains(MainActivity.this, "test")) {
                    AppToastMgr.shortToast(MainActivity.this, SharePreferenceUtil.get(MainActivity.this, "test", "") + "");
                }*/
            }
        });
        text_hello4 = (TextView) findViewById(R.id.text_hello4);
        text_hello4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    SharePreferenceUtil.put(MainActivity.this, "test", "显示测试用例");
                if (SharePreferenceUtil.contains(MainActivity.this, "test")) {
                    AppToastMgr.shortToast(MainActivity.this, SharePreferenceUtil.get(MainActivity.this, "test", "") + "");
                }*/
                String string = (String) SharePreferenceUtil.get(SharePreferenceActivity.this, "test1", "");
                text_hello4.setText(string);
            }
        });
        text_hello5 = (TextView) findViewById(R.id.text_hello5);
        text_hello5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   SharePreferenceUtil.put(MainActivity.this, "test", "显示测试用例");
                if (SharePreferenceUtil.contains(MainActivity.this, "test")) {
                    AppToastMgr.shortToast(MainActivity.this, SharePreferenceUtil.get(MainActivity.this, "test", "") + "");
                }*/
                SharePreferenceUtil.clear(SharePreferenceActivity.this);
                String string1 = (String) SharePreferenceUtil.get(SharePreferenceActivity.this, "test", "");
                text_hello2.setText(string1);
                String string2 = (String) SharePreferenceUtil.get(SharePreferenceActivity.this, "test1", "");
                text_hello4.setText(string2);
//                finish();
//                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }
        });
    }

}
