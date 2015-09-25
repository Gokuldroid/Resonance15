package com.ecea.resonance15;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.pushbots.push.Pushbots;

public class Resonance_Home extends AppCompatActivity {

    GridView homeGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resonance__home);

        Pushbots.sharedInstance().init(this);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Resonance'15");*/
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);

        /*homeGrid=(GridView)findViewById(R.id.title_grid);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int size = dm.widthPixels / 2;
        homeGrid.setAdapter(new GridAdapter(getApplicationContext(), HomeModel.titles, HomeModel.image, size));
        homeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent i = new Intent(Resonance_Home.this, ListActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent(Resonance_Home.this, Workshop_ListActivity.class);
                        startActivity(i1);
                    break;
                    case 2:
                        Intent i2 = new Intent(Resonance_Home.this, SocialHub.class);
                        startActivity(i2);
                        break;

                }
            }
        });
    }*/
    }
}