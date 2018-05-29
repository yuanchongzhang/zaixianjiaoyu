package com.project.zaixianjiaoyu.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.R;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Administrator on 2015/12/11.
 */
public class MeFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.img_person)
    ImageView imgPerson;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_qiandao)
    TextView textQiandao;
    @BindView(R.id.text_touxiang)
    TextView textTouxiang;
    @BindView(R.id.text_kaoshi)
    TextView textKaoshi;
    @BindView(R.id.text_goumai)
    TextView textGoumai;
    @BindView(R.id.text_history)
    TextView textHistory;
    @BindView(R.id.text_fankui)
    TextView textFankui;
    @BindView(R.id.text_settings)
    TextView textSettings;
    private static final int REQUEST_IMAGE = 2;
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    protected static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;

    private TextView mResultText;
    private RadioGroup mChoiceMode, mShowCamera;
    private EditText mRequestNum;

    private ArrayList<String> mSelectPath;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.img_person, R.id.text_name, R.id.text_qiandao, R.id.text_touxiang, R.id.text_kaoshi, R.id.text_goumai, R.id.text_history, R.id.text_fankui, R.id.text_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_person:

                break;
            case R.id.text_name:
                break;
            case R.id.text_qiandao:
                Toast.makeText(getActivity(), "签到", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_touxiang:
//                Toast.makeText(getActivity(), "头像设置", Toast.LENGTH_SHORT).show();
                selectImage(REQUEST_IMAGE);
                break;
            case R.id.text_kaoshi:
                Toast.makeText(getActivity(), "考试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_goumai:
                Toast.makeText(getActivity(), "购买课程", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_history:
                Toast.makeText(getActivity(), "历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_fankui:
                Toast.makeText(getActivity(), "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_settings:
                Toast.makeText(getActivity(), "设置", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void selectImage(int result) {
        MultiImageSelector.create(getActivity()).showCamera(true) // 是否显示相机. 默认为显示
//                .count(1) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                .single() // 单选模式
//                .multi() // 多选模式, 默认模式;
//                .origin(ArrayList<String>) // 默认已选择图片. 只有在选择模式为多选时有效
                .start(getActivity(), result);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE){
            if(resultCode == RESULT_OK){
                mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                StringBuilder sb = new StringBuilder();
                for(String p: mSelectPath){
                    sb.append(p);
                    sb.append("\n");
                }
//                mResultText.setText(sb.toString());
                Toast.makeText(getActivity(), sb.toString()+"", Toast.LENGTH_SHORT).show();
                Log.d(sb.toString(),"44444444444444");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
