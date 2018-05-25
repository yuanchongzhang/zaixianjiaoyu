package com.project.zaixianjiaoyu.weixin.order;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;


import com.project.zaixianjiaoyu.weixin.util.Util;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Ordering extends AsyncTask<Void, Void, Map<String, String>> {

	private AddOrder order;

	public Ordering(AddOrder order) {

		this.order = order;

	}

	@Override
	protected Map<String, String> doInBackground(Void... arg0) {

//		Log.v("WeiXin", " AddOrder = " + order.toXml());

		return decodeXml(new String(Util.httpPost(String.format("https://api.mch.weixin.qq.com/pay/unifiedorder"), toXml(order.toXml()))));

	}

	public Map<String, String> decodeXml(String content) {

//		Log.v("WeiXin", " content = " + content);

		try {

			Map<String, String> xml = new HashMap<String, String>();

			XmlPullParser parser = Xml.newPullParser();

			parser.setInput(new StringReader(content));

			int event = parser.getEventType();

			while (event != XmlPullParser.END_DOCUMENT) {

				String nodeName = parser.getName();

				switch (event) {

				case XmlPullParser.START_DOCUMENT:

					break;

				case XmlPullParser.START_TAG:

					if ("xml".equals(nodeName) == false) {

						xml.put(nodeName, parser.nextText());

					}

					break;

				case XmlPullParser.END_TAG:

					break;

				}

				event = parser.next();

			}

			return xml;

		} catch (Exception e) {

			Log.e("orion", e.toString());

		}

		return null;

	}

	private String toXml(String xml){

		try {

			return new String(xml.getBytes(), "ISO8859-1");

		} catch (UnsupportedEncodingException e) {

 			return "";

		}

	}

}
