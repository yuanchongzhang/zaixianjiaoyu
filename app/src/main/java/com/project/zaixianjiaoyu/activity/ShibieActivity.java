package com.project.zaixianjiaoyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.project.zaixianjiaoyu.BaseApplication;
import com.project.zaixianjiaoyu.Config;
import com.project.zaixianjiaoyu.R;

public class ShibieActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shibie);

        // 根据需求添加活体动作
        BaseApplication.livenessList.clear();
        BaseApplication.livenessList.add(LivenessTypeEnum.Eye);
        BaseApplication.livenessList.add(LivenessTypeEnum.Mouth);
        BaseApplication.livenessList.add(LivenessTypeEnum.HeadUp);
        BaseApplication.livenessList.add(LivenessTypeEnum.HeadDown);
        BaseApplication.livenessList.add(LivenessTypeEnum.HeadLeft);
        BaseApplication.livenessList.add(LivenessTypeEnum.HeadRight);
        BaseApplication.livenessList.add(LivenessTypeEnum.HeadLeftOrRight);

        initLib();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     Intent intent = new Intent(ShibieActivity.this, IdCardActivity.class);
                startActivity(intent);*/
                setFaceConfig();
                Intent faceIntent = new Intent(ShibieActivity.this, FaceLivenessExpActivity.class);
        /*faceIntent.putExtra("username", username);
        faceIntent.putExtra("idnumber", idnumber);*/
                startActivity(faceIntent);
                // 调转到活体识别界面
//                Intent faceIntent = new Intent(MainActivity.this, FaceOnlineVerifyActivity.class);
//                startActivity(faceIntent);
            }
        });
    }

    private void setFaceConfig() {
        FaceConfig config = FaceSDKManager.getInstance().getFaceConfig();
        // SDK初始化已经设置完默认参数（推荐参数），您也根据实际需求进行数值调整
        config.setLivenessTypeList(BaseApplication.livenessList);
        config.setLivenessRandom(BaseApplication.isLivenessRandom);
        config.setBlurnessValue(FaceEnvironment.VALUE_BLURNESS);
        config.setBrightnessValue(FaceEnvironment.VALUE_BRIGHTNESS);
        config.setCropFaceValue(FaceEnvironment.VALUE_CROP_FACE_SIZE);
        config.setHeadPitchValue(FaceEnvironment.VALUE_HEAD_PITCH);
        config.setHeadRollValue(FaceEnvironment.VALUE_HEAD_ROLL);
        config.setHeadYawValue(FaceEnvironment.VALUE_HEAD_YAW);
        config.setMinFaceSize(FaceEnvironment.VALUE_MIN_FACE_SIZE);
        config.setNotFaceValue(FaceEnvironment.VALUE_NOT_FACE_THRESHOLD);
        config.setOcclusionValue(FaceEnvironment.VALUE_OCCLUSION);
        config.setCheckFaceQuality(true);
        config.setLivenessRandomCount(2);
        config.setFaceDecodeNumberOfThreads(2);

        FaceSDKManager.getInstance().setFaceConfig(config);
    }

    /**
     * 初始化SDK
     */
    private void initLib() {
        // 为了android和ios 区分授权，appId=appname_face_android ,其中appname为申请sdk时的应用名
        // 应用上下文
        // 申请License取得的APPID
        // assets目录下License文件名
        FaceSDKManager.getInstance().initialize(this, Config.licenseID, Config.licenseFileName);
//        setFaceConfig();
    }

}
