package com.project.zaixianjiaoyu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.statusbar.ImmersionBar;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.webkit.WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE;

/**
 * Created by Administrator on 2017/10/23.
 */

public class WebViewActivity extends BaseActivity {


    @BindView(R.id.v4_webview)
    WebView v4Webview;
    WebChromeClient chromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView webView, int i) {
            Log.e("进度", i + "");
            if (i == 100) {
                dismissLoading();
            } else {
                showLoading();
            }
        }
    };
    private final String ACTION_NAME = "发送广播";
    String url;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_top_layout)
    RelativeLayout rlTopLayout;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ACTION_NAME)) {


                finish();
            }
        }

    };

    public void registerBoradcastReceiver() {
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction(ACTION_NAME);
        //注册广播
        registerReceiver(mBroadcastReceiver, myIntentFilter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 1f)
                .init();
        initWebView();
        registerBoradcastReceiver();
//        url = getIntent().getStringExtra("url");
//        Log.d("myurl", url);
//        Toast.makeText(this, "aaaa", Toast.LENGTH_SHORT).show();
        tvTitle.setText("网页");
        v4Webview.loadUrl("https://www.baidu.com/?tn=57095150_6_oem_dg");

    }

    public void initWebView() {
        v4Webview.clearCache(true);

//        v4Webview.setWebChromeClient(chromeClient);
        v4Webview.setWebChromeClient(chromeClient);
        v4Webview.getSettings().setUseWideViewPort(true);

        v4Webview.getSettings().setLoadWithOverviewMode(true);
        v4Webview.getSettings().setSavePassword(true);
        v4Webview.getSettings().setSaveFormData(true);
        v4Webview.getSettings().setJavaScriptEnabled(true);

        // enable navigator.geolocation
        v4Webview.getSettings().setGeolocationEnabled(true);
        v4Webview.getSettings().setGeolocationDatabasePath(
                "/data/data/org.itri.html5webview/databases/");

        v4Webview.requestFocus();
        v4Webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // v4_webview.setScrollBarStyle(0);
        String ua = v4Webview.getSettings().getUserAgentString();
        v4Webview.getSettings().setUserAgentString(
                ua + "; " + "mingtang_android");
        v4Webview.addJavascriptInterface(new JsInterfaces(this),
                "AndroidWebView");
        v4Webview.getSettings().setBuiltInZoomControls(true);
        v4Webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        v4Webview.getSettings().setDomStorageEnabled(true);

        v4Webview.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            v4Webview.getSettings().setMixedContentMode(
                    MIXED_CONTENT_COMPATIBILITY_MODE);
        }
        v4Webview.getSettings().setAllowFileAccess(true);
        v4Webview.getSettings().setAppCacheEnabled(true);
        v4Webview.getSettings().setJavaScriptEnabled(true);
//        v4Webview.getSettings().setAppCachePath(appCachePath);
        v4Webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        v4Webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//		v4_webview.getSettings().setSupportZoom(true);
        v4Webview.getSettings().setDefaultTextEncodingName("utf-8");
        v4Webview.getSettings().setDisplayZoomControls(false);
        v4Webview.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent ev) {

                ((android.webkit.WebView) v).requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });
        v4Webview.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
                Log.d("newurl", url);

                return true;
            }

            @Override
            public void onReceivedSslError(WebView arg0, SslErrorHandler arg1,
                                           SslError arg2) {
                // TODO Auto-generated method stub
//				super.onReceivedSslError(arg0, arg1, arg2);
                arg1.proceed();

            }

        });
    }

    @OnClick({R.id.img_back, R.id.rl_back, R.id.tv_title, R.id.rl_top_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_back:
                break;
            case R.id.tv_title:
                break;
            case R.id.rl_top_layout:
                break;
        }
    }


    public class JsInterfaces {
        private Context mContext;


        public JsInterfaces(Context mContext) {
            super();
            this.mContext = mContext;

        }

        @JavascriptInterface
        public void jumpFuliDetail(String url) {
//            finish();  结束当前页面
            Log.d("4444444444", url);


            Toast.makeText(WebViewActivity.this, "跳转到福利", Toast.LENGTH_SHORT).show();

        }

        @JavascriptInterface
        public void jumptoweb(String url) {
//            finish();  结束当前页面
//            Toast.makeText(HongBaoWebActivity.this, "1234", Toast.LENGTH_SHORT).show();
            Log.d(url, "3333333333333333333");
            Intent intent = new Intent(WebViewActivity.this, WebViewActivity.class);

            intent.putExtra("url", url);
            startActivity(intent);
//
//
//    HongBaoWebActivity.this.finish();
        }

        @JavascriptInterface
        public void finishacticity() {
//            finish();  结束当前页面
//            Toast.makeText(HongBaoWebActivity.this, "1234", Toast.LENGTH_SHORT).show();
//            HongBaoWebActivity.this.finish();
        }

        @JavascriptInterface
        public void finishActivity() {
//            finish();  结束当前页面
//            Toast.makeText(ShopDetailActivity.this, "1234", Toast.LENGTH_SHORT).show();
            WebViewActivity.this.finish();
        }

        //同款
        @JavascriptInterface
        public void jumpToShopDetail(String sameurl) {
//            finish();跳转商品详情
//            Toast.makeText(HongBaoWebActivity.this, ";跳转商品详情", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(WebViewActivity.this, WebViewActivity.class);
//            intent.putExtra("url", sameurl);
            intent.putExtra("url", sameurl);
            startActivity(intent);
            Log.d(sameurl, "44444444444444444");
//            HongBaoWebActivity.this.finish();

        }


    }


}
