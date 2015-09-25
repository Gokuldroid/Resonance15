package com.ecea.resonance15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.ecea.resonance15.Adapters.Listadapter;
import com.ecea.resonance15.Models.HomeModel;
import com.ecea.resonance15.Utlis.CustomWebViewClient;

public class Workshop_ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Voice controlled Robots");
        WebView myWebView=(WebView)findViewById(R.id.webview);
        myWebView.loadUrl("file:///android_asset/voice_control.html");
        myWebView.setWebViewClient(new CustomWebViewClient(this));
        myWebView.setScrollContainer(false);
    }
}
