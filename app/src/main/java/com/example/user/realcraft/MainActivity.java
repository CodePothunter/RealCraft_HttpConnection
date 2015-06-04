package com.example.user.realcraft;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by user on 2015/6/4.
 */
public class MainActivity extends Activity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        Log.d("Test","turining");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String
                    url) {
                view.loadUrl(url); // ���ݴ���Ĳ�����ȥ�����µ���ҳ
                return true; // ��ʾ��ǰWebView���Դ��������ҳ�����󣬲��ý���ϵͳ�����
            }
        });
        webView.loadUrl("http://www.baidu.com");
    }
}
