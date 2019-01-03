package com.ainisi.queenmirror.queenmirrorcduan.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;

/**
 * 启动画面
 */
public class SplashActivity extends AppCompatActivity {

    private final static int SEND_SMS_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                String[] mPermissionList = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(SplashActivity.this, mPermissionList, SEND_SMS_REQUEST_CODE);
            } else {
                handler.sendEmptyMessageDelayed(1, 1000 * 2);
            }
        } else {
            handler.sendEmptyMessageDelayed(1, 1000 * 2);
        }

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (SP.get(SplashActivity.this, SpContent.IsFirst, "0").equals("0")) {
                        startActivity(new Intent(SplashActivity.this, GuidePageActivity.class));
                        SplashActivity.this.finish();
                    } else {
                        SP.put(SplashActivity.this, SpContent.Current, "0");
                        Intent intent = new Intent(SplashActivity.this, HomePageActivity.class);
                        startActivity(intent);
                        SplashActivity.this.finish();
                    }
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        doNext(requestCode, grantResults);
    }

    private void doNext(int requestCode, int[] grantResults) {
        if (requestCode == SEND_SMS_REQUEST_CODE) {
            if (grantResults.length == 0) {
                Toast.makeText(this, "您未允许使用定位信息！", Toast.LENGTH_SHORT).show();
            } else {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted准许
                    handler.sendEmptyMessageDelayed(1, 1000 * 2);
                } else {
                    // Permission Denied拒绝
                    Toast.makeText(this, "您APP内部部分功能不能够使用哦！", Toast.LENGTH_SHORT).show();

                    handler.sendEmptyMessageDelayed(1, 1000 * 2);
                }
            }
        }
    }

}
