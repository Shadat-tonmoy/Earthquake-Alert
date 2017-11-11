package com.example.android.quakereport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RecentEarthquake extends Fragment implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    private ListView earthquakeListView;
    ArrayList<Earthquake> earthquakes;
    EarthquakeAdapter adapter;
    private View view,emptyView,noInternetConnectionView;
    private TextView debugView;
    private ProgressBar progressBar;
    private TextView retryButton;



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
        emptyView = view.findViewById(R.id.nothing_found_msg);
        noInternetConnectionView = view.findViewById(R.id.no_internet_msg);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        retryButton = (TextView) view.findViewById(R.id.retryButton);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        earthquakes = new ArrayList<Earthquake>();
        earthquakeListView = (ListView) view.findViewById(R.id.list);
        adapter = new EarthquakeAdapter(getActivity().getApplicationContext(),R.layout.single_row,R.id.magnitude,earthquakes);
        earthquakeListView.setAdapter(adapter);
        emptyView.setVisibility(View.GONE);
        noInternetConnectionView.setVisibility(View.GONE);
        //debugView = (TextView) view.findViewById(R.id.debug);
        getData();
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }



    @Override
    public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
        Log.e("MSH","RUN");

        return new EarthquakeLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        progressBar.setVisibility(View.GONE);
        noInternetConnectionView.setVisibility(View.GONE);
        Log.e("Loading is finished","Yes Man!!!");
        for(int i=0;i<data.size();i++)
        {
            Earthquake earthquake = data.get(i);
            String result = "new Quake : "+earthquake.getMagnitude()+" "+earthquake.getLocation()+" "+earthquake.getDate();
            Log.e("Result : ",result);
        }
        adapter.setEarthquakes((ArrayList<Earthquake>) data);
        earthquakeListView.setEmptyView(emptyView);
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        earthquakes = new ArrayList<Earthquake>();

    }

    public void getData()
    {
        progressBar.setVisibility(View.VISIBLE);
        noInternetConnectionView.setVisibility(View.GONE);
        ConnectivityManager manager = (ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isConnected())
        {
            getActivity().getSupportLoaderManager().initLoader(1,null,this).forceLoad();
        }
        else
        {
            progressBar.setVisibility(View.GONE);
            earthquakeListView.setEmptyView(noInternetConnectionView);
        }
    }
}
