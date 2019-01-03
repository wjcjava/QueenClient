package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundByCpgronpActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.RefundReasonActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RefundReasonAdapter  extends BaseQuickAdapter<String,BaseViewHolder> {

    String where;
    public RefundReasonAdapter(int layoutResId, @Nullable List<String> data,String where) {
        super(layoutResId, data);
        this.where = where;
    }

    @Override
    protected void convert(BaseViewHolder helper, final String item) {

        helper.setText(R.id.tv_arefund_reason,item.toString());

        CheckBox check_refundreason_check = helper.getView(R.id.check_refundreason_check);
        check_refundreason_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    RefundReasonActivity.instance.finish();
                    if(where.equals("1")){
                        ConfirmRefundActivity.instance.tv_arefund_select.setText(item);
                    }else{
                        ConfirmRefundByCpgronpActivity.instance.tv_arefund_select.setText(item);
                    }
                }
            }
        });
    }
}
