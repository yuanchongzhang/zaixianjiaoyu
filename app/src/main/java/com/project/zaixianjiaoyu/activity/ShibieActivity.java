package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project.zaixianjiaoyu.R;

public class ShibieActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shibie);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShibieActivity.this, IdCardActivity.class);
                startActivity(intent);
                // 调转到活体识别界面
//                Intent faceIntent = new Intent(MainActivity.this, FaceOnlineVerifyActivity.class);
//                startActivity(faceIntent);
            }
        });
    }
}
