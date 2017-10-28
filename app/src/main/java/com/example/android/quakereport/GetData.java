package com.example.android.quakereport;

import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by Shadat Tonmoy on 10/28/2017.
 */

public class GetData extends AsyncTask<URL,Integer,Long> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Long doInBackground(URL... urls) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
    }
}

