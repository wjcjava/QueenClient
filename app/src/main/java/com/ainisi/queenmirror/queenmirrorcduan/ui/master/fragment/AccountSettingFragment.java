package com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment;


import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.utils.LinesEditView;

import butterknife.Bind;

/**
 * 账户设置
 */
public class AccountSettingFragment extends BaseFragment {

    @Bind(R.id.multiline_edit_text)
    LinesEditView multilineEditText;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_account_setting;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doFitsrData() {

    }

}
