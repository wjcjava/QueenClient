package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

/**
 * Created by john on 2018/5/10.
 *
 * jl
 */

public class LoadingDialog extends Dialog {

    Context context;
    Dialog progressDialog;
    public LoadingDialog(Context context) {
        super(context);
        this.context = context;
    }

    public void loadShow() {

        progressDialog = new Dialog(context,R.style.progress_dialog);
        progressDialog.setContentView(R.layout.dialog);
        progressDialog.setCancelable(true);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText("卖力加载中");
        progressDialog.show();
    }

    public void cancel(){
        progressDialog.dismiss();
    }
}
