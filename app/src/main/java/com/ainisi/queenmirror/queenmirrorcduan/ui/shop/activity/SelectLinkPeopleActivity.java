package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *选择联系人
 */
public class SelectLinkPeopleActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.et_select_link_name)
    EditText et_select_link_name;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.title_right)
    TextView title_right;
    @Bind(R.id.et_select_link_phone)
    EditText et_select_link_phone;
    @Bind(R.id.rg_select_link_sex)
    RadioGroup rg_select_link_sex;

    String sex = "女士";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_link_people;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("添加联系人");
        title_right.setVisibility(View.VISIBLE);
        title_right.setText("保存");


        // 方法一监听事件,通过获取点击的id来实例化并获取选中状态的RadioButton控件
        rg_select_link_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                int id = group.getCheckedRadioButtonId();
                // 通过id实例化选中的这个RadioButton
                RadioButton choise = (RadioButton) findViewById(id);
                // 获取这个RadioButton的text内容
                String output = choise.getText().toString();
                sex = output;
            }
        });
    }

    @OnClick({R.id.title_back,R.id.title_right})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.title_right:
                //保存
                if(et_select_link_name.getText().toString().equals("")||et_select_link_phone.getText().toString().equals("")){
                    T.show("请完善相关信息");
                }else{
                    SP.put(this, SpContent.Lickname,et_select_link_name.getText().toString());
                    SP.put(this, SpContent.LickPhone,et_select_link_phone.getText().toString());
                    SP.put(this, SpContent.LickSex,sex);
                    finish();
                }
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
