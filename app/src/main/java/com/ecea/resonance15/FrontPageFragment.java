package com.ecea.resonance15;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecea.resonance15.Models.HomeModel;
import com.ecea.resonance15.Utlis.CustomFontTextView;

/**
 * Created by goku on 25-09-2015.
 */
public class FrontPageFragment extends Fragment {

    int mCurrentPage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        mCurrentPage = data.getInt("current_page", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.front_fragment_layout, container,false);
        ImageView image = (ImageView) v.findViewById(R.id.bg_image_view);
        TextView textView=(TextView) v.findViewById(R.id.title_text_view);
        image.setImageResource(HomeModel.image.get(mCurrentPage));
        textView.setText(HomeModel.titles.get(mCurrentPage));
        textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/Gmedium.otf"));
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mCurrentPage) {
                    case 0:
                        Intent i = new Intent(getActivity(), ListActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent(getActivity(), Workshop_ListActivity.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(getActivity(), SocialHub.class);
                        startActivity(i2);
                        break;

                }
            }
        });
        return v;
    }
}