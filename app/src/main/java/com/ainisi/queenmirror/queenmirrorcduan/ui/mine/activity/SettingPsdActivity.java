package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.SettingPsdBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * @author linxi
 * @date 2018/10/31 13:46
 * @use 设置密码
 */
public class SettingPsdActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView mTitleTitle;
    @Bind(R.id.setting_psd)
    EditText mSettingPsd;
    @Bind(R.id.setting_psd_two)
    EditText mSettingPsdTwo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting_psd;
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleTitle.setText(R.string.password_setting);
    }

    @OnClick({R.id.title_back, R.id.setting_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.setting_btn:
                String psd = mSettingPsd.getText().toString();
                if (TextUtils.isEmpty(psd)) {
                    T.show(getString(R.string.add_password));
                    return;
                }
                String psdTwo = mSettingPsdTwo.getText().toString();
                if (TextUtils.isEmpty(psdTwo)) {
                    T.show(getString(R.string.add_password_two));
                    return;
                }
                if (!psd.equals(psdTwo)) {
                    T.show(getString(R.string.add_password_no));
                    return;
                }
                UserSetPass();
                break;
            default:
                break;
        }
    }

    private void UserSetPass() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cellPhone", (String) SP.get(SettingPsdActivity.this, SpContent.UserCall, ""));
        params.put("token", (String) SP.get(SettingPsdActivity.this, SpContent.UserToken, ""));
        params.put("userPass", MD5.md5(mSettingPsd.getText().toString() + "MYN888"));
        HttpUtils.doPost(ACTION.USERSETPASS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.USERSETPASS:
                SettingPsdBean bean = GsonUtil.toObj(res, SettingPsdBean.class);
                if (bean.isSuccess()) {
                    T.show(getString(R.string.changepassword_true));
                    SP.put(SettingPsdActivity.this, SpContent.isPassword, true);
                    finish();
                } else {
                    T.show(bean.getMsg());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
