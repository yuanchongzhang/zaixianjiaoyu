package com.project.zaixianjiaoyu.paomadeng;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/10.
 */

public class SimpleMF <E extends CharSequence> extends MarqueeFactory<TextView, E> {

    public SimpleMF(Context mContext) {
        super(mContext);
    }

    @Override
    public TextView generateMarqueeItemView(E data) {
        TextView mView = new TextView(mContext);
        mView.setText(data);
        return mView;
    }
}
