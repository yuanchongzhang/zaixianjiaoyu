package com.project.zaixianjiaoyu.wxpay;

import android.content.Context;

import com.project.zaixianjiaoyu.weixin.WXPay;


/**
 * Created by Administrator on 2016/7/22.
 */
public class WxPay extends WXPay {
    /**
     * ��ʼ��΢�ŷ���
     *
     * @param context
     */
    public WxPay(Context context) {
        super(context);
    }

    @Override
    protected String appId() {
        return "wxd1f1dd011f72b7ac";
    }

    @Override
    protected String mchId() {
        return "1499158742";
    }

    @Override
    protected String apiKey() {

        return "917fb934b753a85eeaae191d5ff8be21";
    }

    @Override
    protected String notifyUrl() {

//        http://www.biymo.com/payment/wechat/notify.php

        return "http://www.biymo.com/payment/wechat/notify.php";
    }

    @Override
    protected String spbillCreateIp() {
        return "127.0.0.1";
    }
}
