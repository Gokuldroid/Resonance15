package com.ecea.resonance15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.ecea.resonance15.Utlis.CustomWebViewClient;

public class EventLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle= getIntent().getExtras();

        getSupportActionBar().setTitle(bundle.getString("title"));
        WebView myWebView=(WebView)findViewById(R.id.webview);
        myWebView.loadUrl("file:///android_asset/"+bundle.getString("url"));
        myWebView.setWebViewClient(new CustomWebViewClient(this));
        myWebView.setScrollContainer(false);
    }
}
