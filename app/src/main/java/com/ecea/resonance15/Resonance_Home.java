package com.ecea.resonance15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.GridView;

import com.ecea.resonance15.Adapters.GridAdapter;
import com.ecea.resonance15.Models.HomeModel;

public class Resonance_Home extends AppCompatActivity {

    GridView homeGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resonance__home);
        homeGrid=(GridView)findViewById(R.id.title_grid);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int size = dm.widthPixels / 2;
        homeGrid.setAdapter(new GridAdapter(getApplicationContext(), HomeModel.titles, HomeModel.image, size));
    }
}
