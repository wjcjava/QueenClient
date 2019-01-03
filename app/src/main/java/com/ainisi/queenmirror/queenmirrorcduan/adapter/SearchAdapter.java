package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * jl
 */

public class SearchAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public SearchAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final String item) {
        helper.setText(R.id.tv_search_list_item,item);

        helper.setOnClickListener(R.id.tv_search_list_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(item.equals("暂无历史搜索数据")){

                }else{
                    SearchActivity.instance.et_search_title.setText(item);
                }
            }
        });
    }
}
