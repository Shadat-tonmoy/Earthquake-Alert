package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shadat Tonmoy on 10/25/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private View row;
    private TextView magnitudeView,locationView,dateView;


    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Earthquake> objects) {
        super(context, resource, textViewResourceId, objects);
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

        magnitudeView.setText(magnitude);
        locationView.setText(location);
        dateView.setText(date);

        return row;
    }
}
