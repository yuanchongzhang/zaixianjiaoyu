package com.project.zaixianjiaoyu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.zaixianjiaoyu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2015/12/11.
 */
public class DiSiFragment extends Fragment {

    @BindView(R.id.btn_shouye)
    Button btnShouye;
    @BindView(R.id.btn_second)
    Button btnSecond;
    @BindView(R.id.btn_third)
    Button btnThird;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fourth2, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_shouye, R.id.btn_second, R.id.btn_third})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_shouye:
                EventBus.getDefault().post(0);

                break;
            case R.id.btn_second:
                EventBus.getDefault().post(1);
                break;
            case R.id.btn_third:
                EventBus.getDefault().post(2);
                break;
        }
    }
}
