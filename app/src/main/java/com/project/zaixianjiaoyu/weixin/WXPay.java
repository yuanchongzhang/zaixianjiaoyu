package com.project.zaixianjiaoyu.weixin;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.project.zaixianjiaoyu.weixin.order.AddOrder;
import com.project.zaixianjiaoyu.weixin.order.OpenID;
import com.project.zaixianjiaoyu.weixin.order.Ordering;
import com.project.zaixianjiaoyu.weixin.order.StartOrder;
import com.project.zaixianjiaoyu.weixin.util.MD5;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public abstract class WXPay {

	/**
	 * ����
	 */
	private final Context context;

	/**
	 * IWXAPI
	 */
	public final com.tencent.mm.sdk.openapi.IWXAPI IWXAPI;

	/**
	 * ��ʼ��΢�ŷ���
	 *
	 * @param context
	 */
	public WXPay(Context context) {

		IWXAPI = WXAPIFactory.createWXAPI(this.context = context, appId());

	}

	/**
	 * ��ת��΢��
	 */
	public void openWXApp() {

		IWXAPI.openWXApp();

	}

	/**
	 * ��ά��֧��
	 *
	 * @param url
	 */
	public void pay(String url) {

		new OpenID(appId(), url).execute();

	}

	/**
	 * ֧��
	 *
	 * @param body
	 *            Ʒ���� body �� String(32) Ipad mini 16G ��ɫ ��Ʒ��֧������Ҫ����
	 * @param outTradeNo
	 *            �̻������� out_trade_no �� String(32) 1217752501201407033233368018
	 *            �̻�ϵͳ�ڲ��Ķ�����,32���ַ��ڡ��ɰ�����ĸ, ����˵�����̻�������
	 * @param totalFee
	 *            �ܽ�� total_fee �� Int 888 �����ܽ�ֻ��Ϊ���������֧�����
	 */
	public void pay(String body, String outTradeNo, String totalFee, String attStr) {

		AddOrder addOrder = new AddOrder();

		addOrder.addElement(AddOrder.APPID, appId());

		addOrder.addElement(AddOrder.ATTACH, attStr);

		addOrder.addElement(AddOrder.BODY, body);

//		addOrder.addElement(AddOrder.MCH_ID, mchId());
		addOrder.addElement(AddOrder.MCH_ID, mchId());
		addOrder.addElement(AddOrder.NONCE_STR, genNonceStr());

		addOrder.addElement(AddOrder.NOTIFY_URL, notifyUrl());

		addOrder.addElement(AddOrder.OUT_TRADE_NO, outTradeNo);

		addOrder.addElement(AddOrder.SPBILL_CREATE_IP, spbillCreateIp());

		addOrder.addElement(AddOrder.TOTAL_FEE, totalFee);

		addOrder.addElement(AddOrder.TRADE_TYPE, "APP");

		addOrder.addElement(AddOrder.SIGN, addOrder.genPackageSign(apiKey()));

		addOrder.toString();

		new Ordering(addOrder) {

			@Override
			protected void onPostExecute(java.util.Map<String, String> result) {

				if (result.get("return_code").equals("SUCCESS")) {

					PayReq request = new PayReq();

					request.appId = appId();

					request.partnerId = mchId();

					request.prepayId = result.get("prepay_id");

//					request.packageValue = "prepay_id=" + result.get("prepay_id");
					request.packageValue = "Sign=WXPay";
					request.nonceStr = genNonceStr();

					request.timeStamp = String.valueOf(genTimeStamp());

					StartOrder startOrder = new StartOrder();

					startOrder.addElement(StartOrder.APP_ID, request.appId);

					startOrder.addElement(StartOrder.NONCESTR, request.nonceStr);

					startOrder.addElement(StartOrder.PACKAGE, request.packageValue);

					startOrder.addElement(StartOrder.PARTNER_ID, request.partnerId);

					startOrder.addElement(StartOrder.PREPAY_ID, request.prepayId);

					startOrder.addElement(StartOrder.TIMES_TAMP, request.timeStamp);

					request.sign = startOrder.genAppSign(apiKey());

					IWXAPI.sendReq(request);

				} else {

					Toast.makeText(context, result.get("return_msg"), Toast.LENGTH_SHORT).show();

				}

			}

		}.execute();

	}

	/**
	 * ע��ص�
	 *
	 * @param intent
	 * @param handler
	 */
	public void handleIntent(Intent intent, IWXAPIEventHandler handler){

		IWXAPI.handleIntent(intent, handler);

	}

	/**
	 * ����ַ���
	 *
	 * @return
	 */
	private String genNonceStr() {

		return MD5.getMessageDigest(String.valueOf(new Random().nextInt(10000)).getBytes());

	}

	/**
	 * ʱ���
	 *
	 * @return
	 */
	private long genTimeStamp() {

		return System.currentTimeMillis() / 1000;

	}

	private String toISO(String string){

		try {

			return new String(string.getBytes(), "ISO8859-1");

		} catch (UnsupportedEncodingException e) {

 			return "";

		}

	}

	/**
	 * �����˺�ID appid �� String(32) wx8888888888888888 ΢�ŷ���Ĺ����˺�ID
	 *
	 * @return
	 */
	protected abstract String appId();

	/**
	 * �̻��� mch_id �� String(32) 1900000109 ΢��֧��������̻���
	 *
	 * @return
	 */
	protected abstract String mchId();

	/**
	 * API��Կ�����̻�ƽ̨����
	 *
	 * @return
	 */
	protected abstract String apiKey();

	/**
	 * ֪ͨ��ַ notify_url �� String(256) http://www.baidu.com/ ����΢��֧���첽֪ͨ�ص���ַ
	 *
	 * @return
	 */
	protected abstract String notifyUrl();

	/**
	 * �ն�IP spbill_create_ip �� String(16) 8.8.8.8
	 * APP����ҳ֧���ύ�û���ip��Native֧�������΢��֧��API�Ļ���IP��
	 *
	 * @return
	 */
	protected abstract String spbillCreateIp();

}
