package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

public class HomeFragmentOne{

//    public class MainActivity extends AppCompatActivity implements JsBridge {

//        private static final String TAG = "MainActivity";
//        private WebView webView;
//        private TextView textView;
//        ProgressBar progressBar;
//
//        Handler mhandler;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            initwidget(savedInstanceState);
//            Log.i(TAG, "onCreate");
//
//        }
//
//        private void initwidget(Bundle savedInstanceState) {
//            webView = findViewById(R.id.webview);
//            textView = findViewById(R.id.tv_result);
//            progressBar=findViewById(R.id.progressbar);
//            mhandler = new Handler();
////        webView.getSettings().setJavaScriptEnabled(true);
////        webView.addJavascriptInterface(new JSInterface(this), "ainisiLauncher");
////        webView.loadUrl("file:///android_asset/index.html");
////        webView.loadUrl("http://192.168.101.30:8020/HelloHBuilder/index.html?");
//            initWebView("http://192.168.101.30:8020/HelloHBuilder/index.html");
//        }
//
//
//        @Override
//        public void setTextViewValue(final String value) {
//            mhandler.post(new Runnable() {
//                @Override
//                public void run() {
////                textView.setText(value);
//                    if ("save".equals(value)){
////                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
////                    startActivity(intent);
//                        saveImage(webView);
//                    }
//                }
//            });
//        }
//
//
//        /**
//         * 淇濆瓨鍥剧墖
//         *
//         * @param view
//         */
//        public void saveImage(View view) {
//            Picture picture = webView.capturePicture();
//            Bitmap b = Bitmap.createBitmap(
//                    picture.getWidth(), picture.getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas c = new Canvas(b);
//            picture.draw(c);
//            File file = new File("/queenmirror/" + "vipPage.jpg");
//            if(file.exists()){
//                file.delete();
//            }
//            FileOutputStream fos = null;
//            try {
//                fos = new FileOutputStream(file.getAbsoluteFile());
//                if (fos != null) {
//                    b.compress(Bitmap.CompressFormat.JPEG, 90, fos);
//                    fos.close();
//                    Toast.makeText(getApplicationContext(), "淇濆瓨鎴愬姛", Toast.LENGTH_SHORT).show();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                Toast.makeText(getApplicationContext(), "淇濆瓨澶辫触", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//
//        private void initWebView(String proposalUrl) {
//            webView.loadUrl(proposalUrl);
//            webView.addJavascriptInterface(new JSInterface(this), "ainisiLauncher");//娣诲姞js鐩戝惉 杩欐牱html灏辫兘璋冪敤瀹㈡埛绔?        webView.setWebChromeClient(webChromeClient);
//            webView.setWebViewClient(webViewClient);
//
//            WebSettings webSettings = webView.getSettings();
//            webSettings.setJavaScriptEnabled(true);//鍏佽浣跨敤js
//            /**
//             * LOAD_CACHE_ONLY: 涓嶄娇鐢ㄧ綉缁滐紝鍙鍙栨湰鍦扮紦瀛樻暟鎹?         * LOAD_DEFAULT: 锛堥粯璁わ級鏍规嵁cache-control鍐冲畾鏄惁浠庣綉缁滀笂鍙栨暟鎹€?         * LOAD_NO_CACHE: 涓嶄娇鐢ㄧ紦瀛橈紝鍙粠缃戠粶鑾峰彇鏁版嵁.
//             * LOAD_CACHE_ELSE_NETWORK锛屽彧瑕佹湰鍦版湁锛屾棤璁烘槸鍚﹁繃鏈燂紝鎴栬€卬o-cache锛岄兘浣跨敤缂撳瓨涓殑鏁版嵁銆?         */
//            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//涓嶄娇鐢ㄧ紦瀛橈紝鍙粠缃戠粶鑾峰彇鏁版嵁.
//
//            //鏀寔灞忓箷缂╂斁
//            webSettings.setSupportZoom(true);
//            webSettings.setBuiltInZoomControls(true);
//
//            //涓嶆樉绀簑ebview缂╂斁鎸夐挳
////        webSettings.setDisplayZoomControls(false);
//        }
//
//        //WebChromeClient涓昏杈呭姪WebView澶勭悊Javascript鐨勫璇濇銆佺綉绔欏浘鏍囥€佺綉绔檛itle銆佸姞杞借繘搴︾瓑
//        private WebChromeClient webChromeClient = new WebChromeClient() {
//            //涓嶆敮鎸乯s鐨刟lert寮圭獥锛岄渶瑕佽嚜宸辩洃鍚劧鍚庨€氳繃dialog寮圭獥
//            @Override
//            public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
//                AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
//                localBuilder.setMessage(message).setPositiveButton("纭畾", null);
//                localBuilder.setCancelable(false);
//                localBuilder.create().show();
//
//                //娉ㄦ剰:
//                //蹇呴』瑕佽繖涓€鍙ヤ唬鐮?result.confirm()琛ㄧず:
//                //澶勭悊缁撴灉涓虹‘瀹氱姸鎬佸悓鏃跺敜閱扺ebCore绾跨▼
//                //鍚﹀垯涓嶈兘缁х画鐐瑰嚮鎸夐挳
//                result.confirm();
//                return true;
//            }
//
//            //鑾峰彇缃戦〉鏍囬
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//                Log.i(TAG, "缃戦〉鏍囬:" + title);
//            }
//
//            //鍔犺浇杩涘害鍥炶皟
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                progressBar.setProgress(newProgress);
//            }
//        };
//
//        //WebViewClient涓昏甯姪WebView澶勭悊鍚勭閫氱煡銆佽姹備簨浠?    private WebViewClient webViewClient = new WebViewClient() {
//        @Override
//        public void onPageFinished(WebView view, String url) {//椤甸潰鍔犺浇瀹屾垚
//            progressBar.setVisibility(View.GONE);
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {//椤甸潰寮€濮嬪姞杞?            progressBar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            Log.i(TAG, "鎷︽埅url:" + url);
//            if (url.equals("http://www.google.com/")) {
//                Toast.makeText(MainActivity.this, "鍥藉唴涓嶈兘璁块棶google,鎷︽埅璇rl", Toast.LENGTH_LONG).show();
//                return true;//琛ㄧず鎴戝凡缁忓鐞嗚繃浜?            }
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//
//        };
//    }

}
