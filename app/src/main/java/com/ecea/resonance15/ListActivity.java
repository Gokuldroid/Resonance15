package com.ecea.resonance15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ecea.resonance15.Adapters.Listadapter;
import com.ecea.resonance15.Models.HomeModel;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Events");
        RecyclerView list=(RecyclerView) findViewById(R.id.list_view);
        list.setItemAnimator(new FadeInAnimator());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new Listadapter(this,HomeModel.eventtitles,HomeModel.eventimages,HomeModel.eventurl));
    }
}
