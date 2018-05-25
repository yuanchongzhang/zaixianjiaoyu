package com.project.zaixianjiaoyu.activity;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

/**
 * Created by Administrator on 2017/10/13.
 */

public class BaseActivity extends FragmentActivity{


    private ProgressDialog dialog;

    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");
        dialog.show();
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
