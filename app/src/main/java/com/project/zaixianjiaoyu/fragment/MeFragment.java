package com.project.zaixianjiaoyu.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.AuthTask;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.zaixianjiaoyu.BuildConfig;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.activity.AliWxPayActivity;
import com.project.zaixianjiaoyu.activity.FeedBackActivity;
import com.project.zaixianjiaoyu.activity.HistoryActivity;
import com.project.zaixianjiaoyu.activity.ShibieActivity;
import com.project.zaixianjiaoyu.alipay.AuthResult;
import com.project.zaixianjiaoyu.alipay.OrderInfoUtil2_0;
import com.project.zaixianjiaoyu.alipay.PayResult;
import com.project.zaixianjiaoyu.util.GlideCircleTransform;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Administrator on 2015/12/11.
 */
public class MeFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.img_person)
    ImageView imgPerson;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_qiandao)
    TextView textQiandao;
    @BindView(R.id.text_touxiang)
    TextView textTouxiang;
    @BindView(R.id.text_kaoshi)
    TextView textKaoshi;
    @BindView(R.id.text_goumai)
    TextView textGoumai;
    @BindView(R.id.text_history)
    TextView textHistory;
    @BindView(R.id.text_fankui)
    TextView textFankui;
    @BindView(R.id.text_settings)
    TextView textSettings;
    private static final int REQUEST_IMAGE = 2;
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    protected static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;

    private TextView mResultText;
    private RadioGroup mChoiceMode, mShowCamera;
    private EditText mRequestNum;

    private ArrayList<String> mSelectPath;

    public static final String APPID = "2018010801686332";
//    public static final String APPID = "2018010801706528";

    public static final String RSA_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDklPqDHUU0efceV10d6FTlPa7OuBBdN6GD9MAYoNSfD6f3lb2rdLL7FTM6zR+99fMtGJ2CbhuhQqDxHyVEdTBcI4s+wFGwELnsQSf/pjlgKr1BtF2f5utbELpBnZ1Q+AgYR3OpMye08aDA9qjANKWFaOu79lBEnonHZMFmxgQV1Kekvp2HhakkhwHX+g5nqwHaR/P4a9xrxa6Xw/iES3kFBH2cxqo7O5zt9d4ZXHHMkfhDE/DFk954o+CnmaGQaXVoFkuWtAAJ+o//ncwQ+gmOoXHPd4ojB6Oy23xT7ffjUhWAibuIdnWY9sG0xllo2lEqBIflLU/bzl8of1u5ywMfAgMBAAECggEAGXRFmUgvJrLWQ/iyk9wFaCnAR6DToa3KPKmKorN2OehCah2wq2EpdTBdLhUdjcfPtpvhHl8okIKc7XzsZ30tT3Vd0jUUY6jZK2fuDlfyV7UqsiBltKLAXrm0JA5rMFMOg7WhOZxKtamanyJYlF7Id9zBM4MwWRPWf+/GYa13Uv7PZzL8iE9xbllTqw8rKMViCsZztDx2FcckZIt8ZQD989l5Du6+3U5M35lWPMQ41wRBcrnms+kql4oBoGusUA0EjwDkGlikB+STwTPCDjtSUyl9QmILGT0V0zytOLSQING2jxaRdMivX0KOWihMuTF6qHQxgJ0a/q1PGpgeHsSCEQKBgQD8mBIvSbh0YuMntE8rmtYAxz39PUcxewCmq3g/jQp4iHO5B+0dkrZMfDqgqx8H5wTig4BbrZTH3SoU/KLppC/1kPcV0XvWBnHO3lI3VwLO4SWDQkZzVT0FhktHqWiBVaJOl8TXdVyQkPSoEKg3h5+1OZGJL/IP8A8Sf6xYqQKrpQKBgQDnqgUwCZsxm07kcFGju1gY/fmHyjiUsU4uK0zh2Yd5r96t+heTHGDBrg7xKs29IO9bhPLf4wh4uypWffKxnk32ryb1ZMx2C17QOKyiDnSmI9gaMXOvfSzwhrJJGm2UrBHgju37vW960RQS4Y06l7K4xpsyLJ2xTQsTalem/VPIcwKBgQDll5AH3XlEiNGyOCkyGEXmZTOKKBW6+vOnivn8wcU/s7+D8plrJPyAXvanLYNCGpENFrwoGInAdN2YP94QgkV5bq+37DYkXq05fEi8tmD+DBWdzjLdCCA0ElIArBIqZNznlPm9YZambKuEy8cq2iKnhdEsIiFirS/1/4h2+gBMZQKBgCPzFF8B/p1SFooIjAK2fdNTBjf2P5WDdjhf68xYb1eI3StuVd40Vyd3FUaDd+3TgJFZLj9kAdqKYOWPIexCPqL7RzZpb/kZhpsVUGTNjXiCs3RNHECtUh35KQ2DFmIt2ZBZXcDlArmyXEUZz0q6Y7ecylSc69OpuwBGTlfRlADVAoGBAKM3d+iZ3464t1cGuVUc5nB5ISKr6+UtOkEXHNurFpCDMQQHafyCCkptSqz/BSBb4w/vbthKOf22R5aikBFBsLGQVPHN+YgCnYZmOUZc19FyvaqOAcOlCUKeKbu6fZFagAcR+avSYHMS3DtesWa8Qbp2gT/hyNhAUk7lqhVJqpRF";
    private static final int SDK_PAY_FLAG = 1;

    private static final int SDK_AUTH_FLAG = 2;
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    Log.d(msg.obj.toString(), "444444444444");

                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(getActivity(), "支付成功", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(getActivity(), "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(getActivity(),
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(getActivity(),
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me, null);

        unbinder = ButterKnife.bind(this, view);
        Glide.with(getActivity())
                .load("http://img05.tooopen.com/images/20150820/tooopen_sy_139205349641.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .transform(new GlideCircleTransform(getActivity()))
                .into(imgPerson);




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.img_person, R.id.text_name, R.id.text_qiandao, R.id.text_touxiang, R.id.text_kaoshi, R.id.text_goumai, R.id.text_history, R.id.text_fankui, R.id.text_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_person:

                break;
            case R.id.text_name:
                break;
            case R.id.text_qiandao:
                Toast.makeText(getActivity(), "签到", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_touxiang:
//                Toast.makeText(getActivity(), "头像设置", Toast.LENGTH_SHORT).show();
                selectImage(REQUEST_IMAGE);
                break;
            case R.id.text_kaoshi:
                Toast.makeText(getActivity(), "考试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_goumai:
//                Toast.makeText(getActivity(), "购买课程", Toast.LENGTH_SHORT).show();
                /**
                 * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
                 * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
                 * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
                 *
                 * orderInfo的获取必须来自服务端；
                 */

                String name = "名堂";
//                String body = "20120212" + "," + "0" + "," + 2 + "," + BaseApplication.basePreferences.readUid();
                String body = "20120212" + "," + "0.01" + "," + 2;

//                String body = "0";
                boolean rsa2 = true;
                Map<String, String> authInfoMap = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2, body, "201223443", "0.01", name);
//                Map<String, String> authInfoMap = OrderInfoUtil2_0.buildOrderParam(authInfoMap);
                String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);


//                String sign = OrderInfoUtil2_0.getSign(authInfoMap, RSA_PRIVATE, rsa2);

                String sign = null;
                try {
                    sign = OrderInfoUtil2_0.getSign(authInfoMap, RSA_PRIVATE, rsa2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                final String authInfo = info + "&" + sign;
                Log.i("123456789", authInfo);
                Runnable authRunable = new Runnable() {
                    @Override
                    public void run() {
                        // 构造PayTask对象
                        AuthTask authTask = new AuthTask(getActivity());

                        // 调用支付接口,获取支付结果
                        Map<String, String> result = authTask.authV2(authInfo, true);
                        Log.d(result.toString() + "", "333333333333333");
                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;

                        Log.d(msg.what + "", "333333333333333");

                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                // 必须异步调用
                Thread authThread = new Thread(authRunable);
                authThread.start();


                break;
            case R.id.text_history:
//                Toast.makeText(getActivity(), "历史", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(getActivity(),HistoryActivity.class));

                break;
            case R.id.text_fankui:

              startActivity(new Intent(getActivity(),FeedBackActivity.class));

                break;
            case R.id.text_settings:
//                Toast.makeText(getActivity(), "设置", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(getActivity(),ShibieActivity.class));

                break;
        }
    }

    private void selectImage(int result) {
        MultiImageSelector.create(getActivity()).showCamera(true) // 是否显示相机. 默认为显示
//                .count(1) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                .single() // 单选模式
//                .multi() // 多选模式, 默认模式;
//                .origin(ArrayList<String>) // 默认已选择图片. 只有在选择模式为多选时有效
                .start(getActivity(), result);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE){
            if(resultCode == RESULT_OK){
                mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                StringBuilder sb = new StringBuilder();
                for(String p: mSelectPath){
                    sb.append(p);
                    sb.append("\n");
                }
//                mResultText.setText(sb.toString());
                Toast.makeText(getActivity(), sb.toString()+"", Toast.LENGTH_SHORT).show();
                Log.d(sb.toString(),"44444444444444");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
