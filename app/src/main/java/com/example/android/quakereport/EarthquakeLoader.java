package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shadat Tonmoy on 11/1/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private TextView debugView;

    String urlToParse = "https://earthquake.usgs.gov/fdsnws/event/1/query?starttime=2017-10-25&endtime=2017-10-26&format=geojson&minmag=4.5";
    private List<Earthquake> earthquakes;

    public EarthquakeLoader(Context context) {
        super(context);
        this.debugView = debugView;

    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.e("loaging in background","of course yes");

        earthquakes = new ArrayList<Earthquake>();
        InputStream inputStream;
        String response = null;
        String res = "";
        try {

            URL url = new URL(urlToParse);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(1500);
            connection.connect();
            int status = connection.getResponseCode();
//            debugView.setText("Status"+status);
            if(status==200)
            {
                inputStream = connection.getInputStream();
                response = readFromInputStream(inputStream);

                JSONObject root = new JSONObject(response);
                JSONArray featuresArray = root.getJSONArray("features");
                for(int i=0;i<featuresArray.length();i++)
                {
                    JSONObject feature = featuresArray.getJSONObject(i);
                    JSONObject properties = feature.getJSONObject("properties");
                    double mag = properties.getDouble("mag");
                    String place = properties.getString("place");
                    long time = properties.getLong("time");
                    res+="Mag : "+mag+" Place : "+place+" time : "+time+"\n";
                    Earthquake earthquake = new Earthquake(String.valueOf(mag),place,String.valueOf(time));
                    earthquakes.add(earthquake);
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("will return",res);
        return earthquakes;
    }

    public String readFromInputStream(InputStream inputStream)
    {
        String response = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line!=null)
            {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
