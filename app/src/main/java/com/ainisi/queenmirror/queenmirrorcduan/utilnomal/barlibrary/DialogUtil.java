package com.ainisi.queenmirror.queenmirrorcduan.utilnomal.barlibrary;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

/**
 * Created by john on 2018/6/5.
 */

public class DialogUtil {
    private static DialogUtil dialogUtil;
    private Dialog dialog;
    private TextView message;
    private Button firstBtn;
    private Button secondBtn;
    private onButtnClickListener buttnClickListener;

    public static DialogUtil getDialogInstance(Context context) {
        if (null == dialogUtil) {
            dialogUtil = new DialogUtil(context);
        }
        return dialogUtil;
    }

    private DialogUtil(Context context) {
        initDialog(context);
    }

    public void setMessage(String message) {
        if (null != message && !message.equals("")) {
            this.message.setText(message);
        }

    }

    private void initDialog(Context context) {
        dialog = new Dialog(context);

        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        dialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        window.setWindowAnimations(R.style.dialog);
    }


    public void showDialog() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void dissmissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();

        }
    }

    public void setOnButtnClickListener(onButtnClickListener buttnClickListener) {
        this.buttnClickListener = buttnClickListener;
    }

    public interface onButtnClickListener {
        public void onFirstBtnClick(View v);

        public void onSecondBtnClick(View v);
    }
}
