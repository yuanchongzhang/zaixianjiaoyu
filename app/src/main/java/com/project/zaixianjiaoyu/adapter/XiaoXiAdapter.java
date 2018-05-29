package com.project.zaixianjiaoyu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.zaixianjiaoyu.R;
import com.project.zaixianjiaoyu.model.ShangPin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 */
public class XiaoXiAdapter extends RecyclerView.Adapter<XiaoXiAdapter.ViewHolder> {

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int pos);
    }

    public List<String> datas = null;
    private ItemClickCallBack clickCallBack;

    private Context context;

    public XiaoXiAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_index, viewGroup, false);
    /*    */

        return new ViewHolder(view);
    }

    public void setData(List<String> list) {
        List<String> list2 = new ArrayList<>();
        datas.addAll(list);

        notifyDataSetChanged();
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.text_zhi.setText(datas.get(position));

  /*      viewHolder.text_new.setText("¥" + datas.get(position).getItemendprice());
        Glide.with(context).load(datas.get(position).getItempic()).error(R.mipmap.zhanwei).placeholder(R.mipmap.zhanwei).into(viewHolder.img_tupian);
        viewHolder.text_old.setText("¥" + datas.get(position).getItemprice());
        viewHolder.text_right.setText("¥" + datas.get(position).getRate());
        viewHolder.text_xiaoliang.setText("销量" + datas.get(position).getItemsale());
        viewHolder.text_quan.setText("领券减" + datas.get(position).getCouponmoney() + "元");*/

        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(viewHolder.itemView, position); // 2
                }
            });
        }

        viewHolder.text_zhi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clickCallBack != null) {
                            clickCallBack.onItemClick(position);
                        }
                    }
                }
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text_zhi;

        public TextView text_new;
        public ImageView img_tupian;
        public TextView text_old;

        public TextView text_right;
        public TextView text_xiaoliang;
        public TextView text_quan;


        public ViewHolder(View view) {
            super(view);
            text_zhi = (TextView) view.findViewById(R.id.text_zhi);
            text_new = (TextView) view.findViewById(R.id.text_new);
            img_tupian = (ImageView) view.findViewById(R.id.img_tupian);
            text_old = (TextView) view.findViewById(R.id.text_old);
            text_xiaoliang = (TextView) view.findViewById(R.id.text_xiaoliang);
            text_quan = (TextView) view.findViewById(R.id.text_quan);

            text_right = (TextView) view.findViewById(R.id.text_right);
        }
    }



}





















