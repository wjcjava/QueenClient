package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.UserInfoListBean;
import com.bumptech.glide.Glide;
import com.gongwen.marqueen.MarqueeFactory;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者：linxi on 2018/10/30 09:54
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class ComplexViewFight extends MarqueeFactory<LinearLayout, UserInfoListBean.BodyBean.ListBean> {
    private LayoutInflater inflater;
    private Context mContext;

    public ComplexViewFight(Context mContext) {
        super(mContext);
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public LinearLayout generateMarqueeItemView(UserInfoListBean.BodyBean.ListBean data) {
        LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.complex_fight, null);
        CircleImageView fight_img = mView.findViewById(R.id.fight_img);
        TextView fight_tv = mView.findViewById(R.id.fight_tv);
        Glide.with(mContext).load(data.getHeadPic()).into(fight_img);
        fight_tv.setText("拼友″" + data.getCellPhone() + "邀请你来参团");
        return mView;
    }
}