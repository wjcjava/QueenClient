package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的-设置-隐私
 */
public class ReplaceActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView replacetitle;
    @Bind(R.id.dynamic_selected)
    ImageView dynamic;
    @Bind(R.id.iv_strange)
    ImageView strange;
    @Bind(R.id.tv_me)
    TextView metext;
    @Bind(R.id.tv_her)
    TextView hertext;
    public boolean isClick;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,ReplaceActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_replace;
    }

    @Override
    public void initView() {
        replacetitle.setText("隐私");
    }

    @OnClick({R.id.dynamic_selected
            ,R.id.iv_strange,R.id.title_back
     ,R.id.layout_me,R.id.layout_her
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.dynamic_selected:
                if(isClick){
                    dynamic.setImageResource(R.drawable.icon_install_unselected);
                    isClick=false;
                }else {
                    dynamic.setImageResource(R.drawable.icon_install_selected);
                    isClick=true;
                }
                break;

            case R.id.iv_strange:
                if(isClick){
                    strange.setImageResource(R.drawable.icon_install_unselected);
                    isClick=false;
                }else {
                    strange.setImageResource(R.drawable.icon_install_selected);
                    isClick=true;
                }
                break;
            case R.id.layout_me:
                Intent intent=new Intent(this,MeDynamicActivity.class);
                intent.putExtra("dynamic",metext.getText().toString().trim());
                startActivity(intent);
                break;
            case R.id.layout_her:
                Intent intent1=new Intent(this,HerDynamicActivity.class);
                intent1.putExtra("dynamic",hertext.getText().toString().trim());
                startActivity(intent1);
                break;

        }


    }
}
