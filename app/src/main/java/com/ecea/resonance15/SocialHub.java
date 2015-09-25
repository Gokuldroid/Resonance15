package com.ecea.resonance15;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.ecea.resonance15.Adapters.FacebookViewAdapter;
import com.ecea.resonance15.Utlis.GoHttpHelper;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SocialHub extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    LinearLayout progress;

    public static final String TAG_TITLE = "data";
    public static final String TAG_DATA = "message";
    public static final String TAG_PICTURE = "picture";
    public static final String TAG_LINK = "link";
    ArrayList<Posts> postsArrayList=new ArrayList<Posts>();
    JSONArray title = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_hub);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Social Hub");

        progress=(LinearLayout)findViewById(R.id.progress_bar);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);

        URL url = null;
        try {
            url = new URL("https://graph.facebook.com/1483873845223143/feed?limit=50&access_token=1461028827545098%7CgcE94zv2JbjGF5F1zu-imcVl_Cc");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        final Request request = new Request.Builder()
                .url(url)
                .build();

        final GoHttpHelper helper=new GoHttpHelper() {
            @Override
            public void Response(boolean result, String response) {
                if(result)
                {

                    postsArrayList.clear();
                    try{

                        JSONObject jsonObj = new JSONObject(response);

                        title = jsonObj.getJSONArray(TAG_TITLE);

                        for (int i = 0; i < title.length(); i++) {
                            JSONObject c = title.getJSONObject(i);

                            Posts post=new Posts();
                            post.title = c.getString(TAG_DATA);
                            post.imageurl=c.getString(TAG_PICTURE);
                            post.link=c.getString(TAG_LINK);
                            postsArrayList.add(post);
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    if (mSwipeRefreshLayout.isRefreshing())
                        mSwipeRefreshLayout.setRefreshing(false);
                    recyclerView.setAdapter(new FacebookViewAdapter(SocialHub.this,postsArrayList));
                    progress.setVisibility(View.INVISIBLE);

                }
            }
        };

        helper.execute(request);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                helper.execute(request);
            }
        });

    }
    public class Posts{
       public String title;
       public String imageurl;
       public String link;
    }
}
