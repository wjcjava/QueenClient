package com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.MessagePicturesLayout;
import com.borjabravo.readmoretextview.ReadMoreTextView;

import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 个人中心动态
 */
public class DynamicListAdapter extends RecyclerView.Adapter<DynamicListAdapter.ViewHolder> {

    private Context mContext;
    private MessagePicturesLayout.Callback mCallback;
    private List<Uri> pictureList1 = Arrays.asList(
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664940_9893.jpg"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664940_3308.jpg"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664927_3920.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664926_8360.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664926_6184.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664925_8382.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664925_2087.jpg"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664777_5730.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483664741_1378.jpg"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671689_9534.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671689_2126.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671703_7890.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201707/27/1501118577_9169.jpg") // 超出屏幕宽度大尺寸图测试
    );
    private List<Uri> pictureList2 = Arrays.asList(
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671690_1970.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671690_6902.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671702_6499.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/06/1483671702_2352.jpg")
    );
    private List<Uri> pictureList3 = Arrays.asList(
            Uri.parse("http://img.my.csdn.net/uploads/201701/17/1484647817_3557.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/17/1484647818_9583.jpg"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/17/1484647817_7305.png")
    );
    private List<Uri> pictureList4 = Arrays.asList(
            Uri.parse("http://img.my.csdn.net/uploads/201701/17/1484647278_8869.png"),
            Uri.parse("http://img.my.csdn.net/uploads/201701/17/1484647702_1117.jpg")
    );

    public DynamicListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public DynamicListAdapter setPictureClickCallback(MessagePicturesLayout.Callback callback) {
        mCallback = callback;
        return this;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_info, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        if (position == 0) {
//            holder.mRecommendItemLvName.setTextColor(ContextCompat.getColor(mContext, R.color.color_EC77AB));
//        } else {
//            holder.mRecommendItemLvName.setTextColor(ContextCompat.getColor(mContext, R.color.grey_color1));
//        }
        SpannableStringBuilder style = new SpannableStringBuilder();
        style.append("#我是隔壁的小王#");
        style.append("也是美美哒，刚昨晚美甲也是美美哒，刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒,也是美美哒,刚昨晚美甲也是美美哒，刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒刚昨晚美甲也是美美哒,刚昨晚美甲也是美美哒");
        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(mContext, "触发点击事件!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        style.setSpan(clickableSpan, 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.color_33B0E4));
        style.setSpan(foregroundColorSpan, 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //配置给TextView
        holder.mRecommendItemLvContent.setText(style);
        holder.mRecommendItemLvContent.setMovementMethod(LinkMovementMethod.getInstance());
        switch (position) {
            case 0:
                holder.mRecommendItemLvPictures.set(pictureList1, pictureList1);
                break;
            case 1:
                holder.mRecommendItemLvPictures.set(pictureList2, pictureList2);
                break;
            case 2:
                holder.mRecommendItemLvPictures.set(pictureList3, pictureList3);
                break;
            case 3:
                holder.mRecommendItemLvPictures.set(pictureList4, pictureList4);
                break;
            default:
                holder.mRecommendItemLvPictures.set(pictureList1, pictureList1);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mRecommendItemLvImg;
        private TextView mRecommendItemLvName;
        private TextView mRecommendItemLvGz;
        private ReadMoreTextView mRecommendItemLvContent;
        private MessagePicturesLayout mRecommendItemLvPictures;

        public ViewHolder(View itemView) {
            super(itemView);
            mRecommendItemLvImg = itemView.findViewById(R.id.recommend_item_lv_img);
//            mRecommendItemLvName = itemView.findViewById(R.id.recommend_item_lv_name);
            mRecommendItemLvGz = itemView.findViewById(R.id.recommend_item_lv_gz);
            mRecommendItemLvContent = itemView.findViewById(R.id.recommend_item_lv_content);
            mRecommendItemLvPictures = itemView.findViewById(R.id.recommend_item_lv_pictures);
            mRecommendItemLvPictures.setCallback(mCallback);
        }
    }
}
