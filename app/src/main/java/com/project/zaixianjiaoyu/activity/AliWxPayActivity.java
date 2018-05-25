package com.project.zaixianjiaoyu.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.AuthTask;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.alipay.AuthResult;
import com.project.zaixianjiaoyu.alipay.OrderInfoUtil2_0;
import com.project.zaixianjiaoyu.alipay.PayResult;
import com.project.zaixianjiaoyu.wxpay.WxPay;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/24.
 */

public class AliWxPayActivity extends BaseActivity {


    @BindView(R.id.btn_alipay)
    Button btnAlipay;
    @BindView(R.id.btn_wx)
    Button btnWx;

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
                        Toast.makeText(AliWxPayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(AliWxPayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(AliWxPayActivity.this,
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(AliWxPayActivity.this,
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
    private IWXAPI api;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipay);
        ButterKnife.bind(this);
        final IWXAPI msgApi = WXAPIFactory.createWXAPI(AliWxPayActivity.this, null);
// 将该app注册到微信
        msgApi.registerApp("wxd1f1dd011f72b7ac");

        Random rand = new Random();
        final int i = rand.nextInt(100);
        api = WXAPIFactory.createWXAPI(AliWxPayActivity.this, "wxd1f1dd011f72b7ac");
    }

    @OnClick({R.id.btn_alipay, R.id.btn_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_alipay:

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
                        AuthTask authTask = new AuthTask(AliWxPayActivity.this);

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
            case R.id.btn_wx:
                Toast.makeText(this, "跳转到新浪", Toast.LENGTH_SHORT).show();
                Random rand = new Random();
                final int i = rand.nextInt(100);
//                WxPay wxPay = new WxPay(LoginActivity.this);
//
//                wxPay.pay("名堂", i + "", "1", "1");
                WxPay wxPay = new WxPay(AliWxPayActivity.this);
//                        startActivity(new Intent(ConfirmOrderActivity.this, OrderAllActivity.class));
//                    Log.e("---------", "privilege" + privilegePrice + "wallet" + walletPrice + "truePrice" + String.valueOf(Float.parseFloat(truePrice) * 100).replace(".0", ""));
//                    wxPay.pay(title, orderNum, "1", "1,"+BaseApplication.BasePreferences.readUserId()+","+privilegePrice+","+walletPrice+","+orderId+","+orderNo+","+ordertotalAmount);
                String a = "102.3";
                try {
                    double money = Double.parseDouble(a) * 100;
                    wxPay.pay("清君堂", i + "", subZeroAndDot(String.valueOf(money)), "3");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(AliWxPayActivity.this, "数据加载失败", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return
     */
    private String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
