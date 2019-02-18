package com.example.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ViewNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

        WebView w = (WebView)findViewById(R.id.webView);
        String url = getIntent().getStringExtra("url");
        String source = getIntent().getStringExtra("source");
        w.loadUrl(url);
        setTitle(source);
    }
}
