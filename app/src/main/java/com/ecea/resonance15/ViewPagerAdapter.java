package com.ecea.resonance15;

/**
 * Created by goku on 25-09-2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecea.resonance15.Models.HomeModel;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = HomeModel.titles.size();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        FrontPageFragment myFragment = new FrontPageFragment();
        Bundle data = new Bundle();
        data.putInt("current_page", position);
        myFragment.setArguments(data);
        return myFragment;
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position + 1);
    }
}