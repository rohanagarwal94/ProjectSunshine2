package com.example.rohanpc.projectsunshine1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailactivityFragment extends Fragment {


    private static final String forecast_hashtag=" #SunshineApp";
    private String mForecaster;

    public DetailactivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent i=getActivity().getIntent();
        View v= inflater.inflate(R.layout.fragment_detailactivity, container, false);
        if(i!=null&& i.hasExtra(Intent.EXTRA_TEXT))
        {
            mForecaster=i.getStringExtra(Intent.EXTRA_TEXT);
            TextView textview=(TextView)v.findViewById(R.id.textview2);
            textview.setText(mForecaster);

        }

        return v;
    }

    private Intent createShareForecastIntent()
    {
        Intent shareintent=new Intent(Intent.ACTION_SEND);
        shareintent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_TEXT,mForecaster+forecast_hashtag);
        return shareintent;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detailfragment,menu);

        MenuItem menuitem=menu.findItem(R.id.action_share);

        ShareActionProvider shareactionprovider =(ShareActionProvider) MenuItemCompat.getActionProvider(menuitem);
        if(shareactionprovider!=null)
        {
            shareactionprovider.setShareIntent(createShareForecastIntent());
        }

    }
}
