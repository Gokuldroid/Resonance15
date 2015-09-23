package com.ecea.resonance15.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.ecea.resonance15.R;
import com.ecea.resonance15.Utlis.CustomFontTextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by goku on 18-06-2015.
 */
public class GridAdapter extends BaseAdapter {
    private Context context;
    ArrayList<String> titles=new ArrayList<String>();
    ArrayList<Integer> image=new ArrayList<Integer>();
    int size;

    public GridAdapter(Context context, ArrayList<String> titles, ArrayList<Integer> image,int size) {
    this.context=context;
        this.titles=titles;
        this.image=image;
        this.size=size;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder;

        if(convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.home_gridview_item,null);
            viewHolder=new ViewHolder();
            viewHolder.textView=(CustomFontTextView)convertView.findViewById(R.id.titleItem);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.titleImage);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText(titles.get(position));
        viewHolder.imageView.setImageResource(image.get(position));
        convertView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, size));
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        CustomFontTextView textView;
    }
}
