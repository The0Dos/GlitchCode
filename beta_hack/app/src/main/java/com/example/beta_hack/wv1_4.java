package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class wv1_4 extends AppCompatActivity {
    private WebView webView;
    private URLs url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wv14);
        webView = findViewById(R.id.webView);
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        webView.loadUrl(URLs.Robot);
    }
}