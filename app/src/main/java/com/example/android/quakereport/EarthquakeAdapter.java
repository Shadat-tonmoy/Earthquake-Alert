package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shadat Tonmoy on 10/25/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private View row;
    private TextView magnitudeView,locationView,dateView;
    private ArrayList<Earthquake> earthquakes;


    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull ArrayList<Earthquake> earthquakes) {
        super(context, resource, textViewResourceId, earthquakes);
        this.earthquakes = earthquakes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = convertView;
        if(row==null)
        {
            row = inflater.inflate(R.layout.single_row,parent,false);
        }

        magnitudeView = (TextView) row.findViewById(R.id.magnitude);
        locationView = (TextView) row.findViewById(R.id.location);
        dateView = (TextView) row.findViewById(R.id.date);

        Earthquake earthquake = getItem(position);
        String magnitude = earthquake.getMagnitude();
        String location = earthquake.getLocation();
        String date = earthquake.getDate();

        double mag = Double.parseDouble(magnitude);
        if(mag>=0.0 && mag<=4.0)
            magnitudeView.setBackgroundResource(R.drawable.round_green);
        else if(mag>4 && mag<=5.0)
            magnitudeView.setBackgroundResource(R.drawable.round_yellow);
        else magnitudeView.setBackgroundResource(R.drawable.round_red);

        Log.e("From adapter : ","mag:"+magnitude+" location : "+location+"\n");

        magnitudeView.setText(magnitude);
        locationView.setText(location);
        dateView.setText(date);

        return row;
    }

    @Nullable
    @Override
    public Earthquake getItem(int position) {
        return earthquakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getCount() {
        return earthquakes.size();
    }

    public void setEarthquakes(ArrayList<Earthquake> earthquakes) {
        Log.e("MESS","Settting earthquakes");
        this.earthquakes = earthquakes;
        notifyDataSetChanged();
    }
}
