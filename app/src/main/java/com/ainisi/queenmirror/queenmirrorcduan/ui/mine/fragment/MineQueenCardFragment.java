package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;
import com.google.zxing.WriterException;

import butterknife.Bind;

/**
 * Created by john on 2018/8/14.
 * jl
 */

public class MineQueenCardFragment  extends BaseFragment implements HttpCallBack {
    String state;
    @Bind(R.id.web_mine_queen_card)
    WebView web_mine_queen_card;

    public MineQueenCardFragment newInstance(String flag) {
        Bundle bundle = new Bundle();
        bundle.putString("state", flag);
        MineQueenCardFragment testFm = new MineQueenCardFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.mine_queen_card_fragment;
    }


    @Override
    protected void initView() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            state = bundle.getString("state");
        }

        new WebService(getActivity(), Html.fromHtml(state).toString(), web_mine_queen_card);

        //硬件加速
        web_mine_queen_card.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void doFitsrData() {

    }

    @Override
    public void initPresenter() {

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
