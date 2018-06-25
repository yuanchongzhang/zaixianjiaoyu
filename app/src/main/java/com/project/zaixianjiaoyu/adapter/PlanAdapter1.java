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
import com.project.zaixianjiaoyu.model.PlanBean;
import com.project.zaixianjiaoyu.model.ShangPin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 */
public class PlanAdapter1 extends RecyclerView.Adapter<PlanAdapter1.ViewHolder> {

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int pos);
    }

    public List<PlanBean.DataBean> datas = null;
    private ItemClickCallBack clickCallBack;

    private Context context;

    public PlanAdapter1(Context context, List<PlanBean.DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_plan, viewGroup, false);
        /*    */

        return new ViewHolder(view);
    }

    public void setData(List<PlanBean.DataBean> list) {
        List<PlanBean.DataBean> list2 = new ArrayList<>();
        datas.addAll(list);

        notifyDataSetChanged();
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
//        viewHolder.text_daoshudier.setText(datas.get(position).getData().get(position).getCTrainPlanName());
        viewHolder.text_daoshudier.setText(datas.get(position).getCTrainPlanName());


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
        public TextView text_daoshudier;



        public ViewHolder(View view) {
            super(view);
            text_daoshudier = (TextView) view.findViewById(R.id.text_daoshudier);

        }
    }


}





















