package com.example.user.realcraft;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by user on 2015/6/4.
 */
public class MainActivity extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        textView = (TextView) findViewById(R.id.textView);
        String response = HttpUtil.HttpClientGET("http://112.74.98.74/request/download");
        textView.setText(response);
    }
}
