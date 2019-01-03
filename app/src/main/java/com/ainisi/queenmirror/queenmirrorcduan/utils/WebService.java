package com.ainisi.queenmirror.queenmirrorcduan.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebService {
    Context context;
    String introud;
    WebView webView;

    public WebService(Context context, String introud,WebView webView)  {
        super();
        this.context = context;
        this.introud = introud;
        this.webView = webView;
        Webser();
    }

    @SuppressLint("ResourceAsColor")
    public void Webser(){
        if(introud!=null){
            webView.setScrollContainer(false);
            webView.setScrollbarFadingEnabled(false);
            webView.setVerticalScrollBarEnabled(false); //垂直不显示
            webView.setBackgroundColor(0); // 设置背景色
            webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
            WebSettings settings = webView.getSettings();
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setBuiltInZoomControls(false); // 设置显示缩放按钮
            settings.setSupportZoom(false); // 支持缩放
            StringBuffer str = new StringBuffer();

            str.append(introud)
                    .append("<style>\n" +
                            " \n" +
                            "img{\n" +
                            " width:100%;\n" +
                            " height:auto;\n" +
                            "}\n" +
                            " \n" +
                            "</style>");
            webView.loadDataWithBaseURL("", str.toString(), "text/html","UTF-8", "about:blank");
        }else{
            //WebView加载web资源
            webView.loadUrl("");
        }
    }
}