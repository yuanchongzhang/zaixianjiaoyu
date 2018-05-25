package com.project.zaixianjiaoyu.weixin.order;



import com.project.zaixianjiaoyu.weixin.util.MD5;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedList;

public class Order extends LinkedList<NameValuePair> {

	private static final long serialVersionUID = 1L;

	public void addElement(String name, String value) {

		add(new BasicNameValuePair(name, value));

	}

	public String genPackageSign(String apiKey) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size(); i++) {

			sb.append(get(i).getName());

			sb.append('=');

			sb.append(get(i).getValue());

			sb.append('&');

		}

		sb.append("key=").append(apiKey);

		return MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();

	}

	public String genAppSign(String apiKey) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <size(); i++) {

			sb.append(get(i).getName());

			sb.append('=');

			sb.append(get(i).getValue());

			sb.append('&');

		}

		sb.append("key=").append(apiKey);

		return MD5.getMessageDigest(sb.toString().getBytes());

	}

	public String toXml() {

		StringBuilder sb = new StringBuilder();

		sb.append("<xml>");

		for (int i = 0; i < size(); i++) {

			sb.append("<" + get(i).getName() + ">");

			sb.append(get(i).getValue());

			sb.append("</" + get(i).getName() + ">");

		}

		sb.append("</xml>");

		return sb.toString();

	}

}
