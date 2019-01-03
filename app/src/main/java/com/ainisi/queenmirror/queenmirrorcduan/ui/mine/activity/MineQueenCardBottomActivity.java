package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MineQueenCardFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MineQueenCardBottomActivity extends BaseActivity implements HttpCallBack {

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;

    @Bind(R.id.or_tab)
    TabLayout otablayout;
    @Bind(R.id.or_mypager)
    NoScrollViewPager omypager;

    private List<String> tablist = new ArrayList<>();
    private List<Fragment> pagerlist = new ArrayList<>();

    String where,changdu;
    String[] text_name,input;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_queen_card_bottom;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title_title.setText("女王特权");
        Intent intent = this.getIntent();
        where = intent.getStringExtra("where");
        changdu = intent.getStringExtra("changdu");
        text_name = new String[Integer.parseInt(changdu)];
        text_name = intent.getStringArrayExtra("text_name");
        input = new String[Integer.parseInt(changdu)];
        input = intent.getStringArrayExtra("input");

        if (tablist.size() == 0) {
            for(int i=0;i<Integer.parseInt(changdu);i++){
                tablist.add(text_name[i]);
            }
        }

        if (pagerlist.size() == 0) {
            for(int i=0;i<Integer.parseInt(changdu);i++){
                pagerlist.add(new MineQueenCardFragment().newInstance(input[i]));
            }
        }

        ViewPager viewPager = new ViewPager(this.getSupportFragmentManager(), pagerlist, tablist);
        omypager.setAdapter(viewPager);
        omypager.setScanScroll(true);

        omypager.setCurrentItem(Integer.parseInt(where));


        for (int i = 0; i < tablist.size(); i++) {
            otablayout.addTab(otablayout.newTab().setText(tablist.get(i)));
        }
        otablayout.setupWithViewPager(omypager);
    }

    @OnClick({R.id.title_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:

                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
