package com.project.zaixianjiaoyu.weixin.order;

import android.os.AsyncTask;
import android.util.Log;


import com.project.zaixianjiaoyu.weixin.util.Util;

import java.net.URLEncoder;

public class OpenID extends AsyncTask<Void, Void, String> {

	public String appid, redirect_uri;

	public OpenID(String appid, String redirect_uri) {
		this.appid = appid;
		this.redirect_uri = redirect_uri;
 	}

	@Override
	protected String doInBackground(Void... arg0) {
//		Util.httpGet("https://open.weixin.qq.com/connect/oauth2/authorize" +
//				"?appid=" + appid +
//				"&redirect_uri=" + redirect_uri +
//				"&response_type=code" +
//				"&scope=snsapi_base" +
//				"#wechat_redirect");
		Log.v("WeiXin", new String(Util.httpGet("https://open.weixin.qq.com/connect/oauth2/authorize" +
				"?appid=" + appid +
				"&redirect_uri=" + URLEncoder.encode(redirect_uri) +
				"&response_type=code" +
				"&scope=snsapi_base" +
				"#wechat_redirect")));
 		return null;
	}
}
