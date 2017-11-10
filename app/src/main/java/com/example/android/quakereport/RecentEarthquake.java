package com.example.android.quakereport;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RecentEarthquake extends Fragment implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    private ListView earthquakeListView;
    ArrayList<Earthquake> earthquakes;
    EarthquakeAdapter adapter;
    private View view;



    public RecentEarthquake() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recent_earthquake, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        earthquakes = new ArrayList<Earthquake>();
        earthquakeListView = (ListView) view.findViewById(R.id.list);
        adapter = new EarthquakeAdapter(getActivity().getApplicationContext(),R.layout.single_row,R.id.magnitude,earthquakes);
        earthquakeListView.setAdapter(adapter);

        String urlToParse = "https://earthquake.usgs.gov/fdsnws/event/1/query?starttime=2017-10-25&endtime=2017-10-26&format=geojson&minmag=4.5";
        URL url = null;
        try {
            url = new URL(urlToParse);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        getActivity().getSupportLoaderManager().initLoader(1,null,this).forceLoad();
    }



    @Override
    public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
        Log.e("MSH","RUN");

        return new EarthquakeLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        Log.e("Loading is finished","Yes Man!!!");
        for(int i=0;i<data.size();i++)
        {
            Earthquake earthquake = data.get(i);
            String result = "new Quake : "+earthquake.getMagnitude()+" "+earthquake.getLocation()+" "+earthquake.getDate();
            Log.e("Result : ",result);
        }
        adapter.setEarthquakes((ArrayList<Earthquake>) data);


    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        earthquakes = new ArrayList<Earthquake>();

    }
}
