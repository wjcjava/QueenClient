package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PositionListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

//我的位置
public class MinePositionActivity extends BaseNewActivity implements AdapterView.OnItemClickListener {
    @Bind(R.id.title_title)
    TextView postitle;
    @Bind(R.id.title_right)
    TextView postitleright;
    @Bind(R.id.lv_mine_position)
    ListView listView;
    private List<String> list = new ArrayList<String>();
    private PositionListAdapter adapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_position;
    }


    @Override
    protected void initView() {
        super.initView();
        postitle.setText(R.string.myposition);
        postitle.setTextSize(16);
        postitleright.setText(R.string.administration);
        postitleright.setTextSize(14);
        postitle.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
        initListener();
    }

    public void initListener() {
        listView.setOnItemClickListener(this);
    }
    @Override
    protected void initData() {
        super.initData();
        list.add("111 号码一");
        list.add("222 号码二");
        adapter = new PositionListAdapter(this, list);
        listView.setAdapter(adapter);

    }
    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        saveCurrentPosition(position);
        adapter.notifyDataSetChanged();
    }

    private void saveCurrentPosition(int position){
        SharedPreferences preferences = getSharedPreferences("user" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("CurrentPosition" , position + "");
        editor.commit();
    }


}
