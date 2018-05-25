package com.project.zaixianjiaoyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.zaixianjiaoyu.activity.AliWxPayActivity;
import com.project.zaixianjiaoyu.activity.HotActivity;
import com.project.zaixianjiaoyu.activity.ListActivity;
import com.project.zaixianjiaoyu.activity.SharePreferenceActivity;
import com.project.zaixianjiaoyu.activity.SplashActivity;
import com.project.zaixianjiaoyu.activity.TablayoutActivity;
import com.project.zaixianjiaoyu.activity.TestInterfaceGetActivity;
import com.project.zaixianjiaoyu.activity.TestInterfacePostActivity;
import com.project.zaixianjiaoyu.paomadeng.OnItemClickListener;
import com.project.zaixianjiaoyu.paomadeng.SimpleMF;
import com.project.zaixianjiaoyu.paomadeng.SimpleMarqueeView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/13.
 */

public class MainActivity extends Activity {
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.btnm)
    Button btnm;
    @BindView(R.id.btn_banner)
    Button btnBanner;
    @BindView(R.id.btn_fragment)
    Button btnFragment;
    @BindView(R.id.btn_switchfragment)
    Button btn_switchfragment;
    @BindView(R.id.btn_sharepreference)
    Button btn_sharepreference;
    @BindView(R.id.btn_welcome)
    Button btn_welcome;
    @BindView(R.id.btn_dimens)
    Button btn_dimens;

    //隐藏fragment
    @BindView(R.id.btn_hidefragment)
    Button btn_hidefragment;
    @BindView(R.id.btn_x5)
    Button btn_x5;
    @BindView(R.id.btn_jump)
    Button btn_jump;

    @BindView(R.id.btn_toast)
    Button btn_toast;

    @BindView(R.id.btn_hotgengxin)
    Button btn_hotgengxin;
    @BindView(R.id.btn_jumptablayout)
    Button btn_jumptablayout;

    @BindView(R.id.btn_pay)
    Button btn_pay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SimpleMarqueeView<String> marqueeView = (SimpleMarqueeView) findViewById(R.id.simpleMarqueeView);
        final SimpleMF<String> marqueeFactory = new SimpleMF(this);
        final List<String> datas = Arrays.asList("张掖彩民回乡祭祖 收获3D游戏奖金9.36万元", "开心购福彩天天赢黄金弃领金条继续抽奖", "盱眙彩民好运气 连续两次收获中福在线大奖", "辽宁福彩快乐12玩法3000万元大派奖", "酒泉老彩民再度命中“连环夺宝”25万头奖");
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();
        marqueeView.setOnItemClickListener(new OnItemClickListener<TextView, String>() {
            @Override
            public void onItemClickListener(TextView mView, String mData, int mPosition) {
           /*     Intent intent = new Intent(getActivity(), WebViewActivity.class);
                if (mPosition == 0) {
                    intent.putExtra("url", "http://www.zhcw.com/xinwen/caizhongxinwen-3D/16611694.shtml");

                }else if (mPosition==1){
                    intent.putExtra("url", "http://www.zhcw.com/xinwen/caizhongxinwen-qt/16612840.shtml");
                }else if (mPosition==2){
                    intent.putExtra("url", "http://www.zhcw.com/xinwen/caizhongxinwen-qt/16611683.shtml");
                }else if (mPosition==3){
                    intent.putExtra("url", "http://www.zhcw.com/xinwen/caizhongxinwen-qt/16602225.shtml");
                }else {
                    intent.putExtra("url", "http://www.zhcw.com/xinwen/caizhongxinwen-qt/16593917.shtml");
                }

                startActivity(intent);
*/
                Toast.makeText(MainActivity.this, mPosition + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @OnClick({R.id.btn_test, R.id.btnm, R.id.btn_banner, R.id.btn_fragment, R.id.btn_switchfragment, R.id.btn_sharepreference, R.id.btn_welcome, R.id.btn_dimens, R.id.btn_hidefragment, R.id.btn_x5, R.id.btn_jump, R.id.btn_toast, R.id.btn_hotgengxin, R.id.btn_jumptablayout,R.id.btn_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_test:
                startActivity(new Intent(MainActivity.this, TestInterfaceGetActivity.class));
                break;
            case R.id.btnm:
                startActivity(new Intent(MainActivity.this, TestInterfacePostActivity.class));
                break;
            case R.id.btn_banner:
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
                break;
            case R.id.btn_fragment:
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
                break;
            case R.id.btn_switchfragment:
                startActivity(new Intent(MainActivity.this, SwitchFragmentRadioButtonActivity.class));
                break;
            case R.id.btn_sharepreference:
                startActivity(new Intent(MainActivity.this, SharePreferenceActivity.class));
                break;
            case R.id.btn_welcome:
                startActivity(new Intent(MainActivity.this, SplashActivity.class));
                break;
            case R.id.btn_dimens:
                startActivity(new Intent(MainActivity.this, DimensActivity.class));
                break;
            case R.id.btn_hidefragment:
                //hide  fragment
                startActivity(new Intent(MainActivity.this, HideFragmentActivity.class));
                break;

            case R.id.btn_x5:

                break;

            case R.id.btn_jump:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;

            case R.id.btn_toast:
                Toast.makeText(this, "\"finish\"", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_hotgengxin:
//                Toast.makeText(this, "\"finish\"", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, HotActivity.class));
                break;

            case R.id.btn_jumptablayout:
                startActivity(new Intent(MainActivity.this, TablayoutActivity.class));
                break;
            case R.id.btn_pay:
                startActivity(new Intent(MainActivity.this,AliWxPayActivity.class));
                break;

        }
    }
}
