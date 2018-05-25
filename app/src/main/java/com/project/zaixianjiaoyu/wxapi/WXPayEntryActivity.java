package com.project.zaixianjiaoyu.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, "wxd1f1dd011f72b7ac");
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if (resp.errCode==0){
                Toast.makeText(this, "微信支付成功", Toast.LENGTH_SHORT).show();
                finish();
            }else if (resp.errCode==-2){
                Toast.makeText(this, "微信支付取消", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(this, "微信支付失败", Toast.LENGTH_SHORT).show();
                finish();
            }

           /* if (resp.errCode == 0) {
//                ToastUtils.showToast(this,"成功");
                LovelyToast.makeText(WXPayEntryActivity.this, "微信支付成功", 0, LovelyToast
                        .SUCCESS, LovelyToast.SCALE);
                Intent intent2 = new Intent();
                intent2.putExtra("ids", "2");
                Bundle bundle = new Bundle();
                bundle.putInt(OrderAllActivity.POSITION_KEY, 1);
//                intent2.putExtra("ordersn", ordersn);
                intent2.setClass(WXPayEntryActivity.this, OrderAllActivity.class).putExtras(bundle);
                startActivity(intent2);

                finish();
                // // TODO: 2017/5/15 跳转成功界面
            } else if (resp.errCode == -2) {
                LovelyToast.makeText(WXPayEntryActivity.this, "微信支付取消", 0, LovelyToast
                        .SUCCESS, LovelyToast.SCALE);
                Bundle bundle = new Bundle();
                bundle.putInt(OrderAllActivity.POSITION_KEY, 0);
                startActivity(new Intent(WXPayEntryActivity.this, OrderAllActivity.class).putExtras(bundle));

                finish();

            }

            else {
                LovelyToast.makeText(WXPayEntryActivity.this, "微信支付失败", 0, LovelyToast
                        .SUCCESS, LovelyToast.SCALE);
                // // TODO: 2017/5/15  跳转失败界面
                Bundle bundle = new Bundle();
                bundle.putInt(OrderAllActivity.POSITION_KEY, 0);
                startActivity(new Intent(WXPayEntryActivity.this, OrderAllActivity.class).putExtras(bundle));

                finish();
            }
            finish();*/
        }
    }
}