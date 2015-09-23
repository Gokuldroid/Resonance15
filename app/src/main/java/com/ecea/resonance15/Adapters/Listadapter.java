package com.ecea.resonance15.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ecea.resonance15.EventLayout;
import com.ecea.resonance15.R;
import com.ecea.resonance15.Utlis.CustomFontTextView;
import java.util.ArrayList;

/**
 * Created by gokul on 30/07/15.
 */
public class Listadapter extends RecyclerView.Adapter<Listadapter.ViewHolder> {
    ArrayList<String> titles;
    ArrayList<Integer> image;
    ArrayList<String> urls;
    Context context;

    public Listadapter(Context context, ArrayList<String> title,ArrayList<Integer> image,ArrayList<String> urls) {
        this.titles = title;
        this.image=image;
        this.urls=urls;
        this.context = context;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context,EventLayout.class);
                detailIntent.putExtra("title",titles.get(position));
                detailIntent.putExtra("url",urls.get(position));
                detailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detailIntent);
            }
        });
        holder.textView.setText(titles.get(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CustomFontTextView textView;
        LinearLayout linearLayout;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.list_item_image);
            textView = (CustomFontTextView) v.findViewById(R.id.list_item_title);
            linearLayout=(LinearLayout) v.findViewById(R.id.click_item);
        }
    }


}