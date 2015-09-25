package com.ecea.resonance15.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecea.resonance15.R;
import com.ecea.resonance15.SocialHub;
import com.ecea.resonance15.Utlis.CustomFontTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by goku on 24-06-2015.
 */
public class FacebookViewAdapter extends RecyclerView.Adapter<FacebookViewAdapter.ViewHolder> {
    ArrayList<SocialHub.Posts> dataSet;
    Context context;

    Typeface typeface;

    public FacebookViewAdapter(Context context,ArrayList<SocialHub.Posts> dataSet)
    {
        this.dataSet=dataSet;
        this.context=context;
        typeface=Typeface.createFromAsset(context.getAssets(),"fonts/Gregular.otf");
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textView.setText(Html.fromHtml(dataSet.get(position).title));
        holder.textView.setTypeface(typeface);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webview =new Intent(Intent.ACTION_VIEW,Uri.parse(dataSet.get(position).link));
                webview.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(webview);
            }
        });
        Picasso.with(context).load(dataSet.get(position).imageurl).resize(150, 150).centerCrop().into(holder.imageView);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_layout_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout;
        public ViewHolder(View v)
        {
            super(v);
            imageView=(ImageView)v.findViewById(R.id.article_image);
            textView=(TextView)v.findViewById(R.id.title_text);
            relativeLayout=(RelativeLayout)v.findViewById(R.id.feed_item);
        }
    }


}

