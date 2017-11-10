/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {


    private TextView debugView;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        //debugView = (TextView) findViewById(R.id.debugView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);




        //new GetData().execute(url);
    }


    /*private class GetData extends AsyncTask<URL,Void,String>{
        String response = "";
        InputStream inputStream = null;
        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];

            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                int statusCode = urlConnection.getResponseCode();
                if(statusCode==200)
                {
                    inputStream = urlConnection.getInputStream();
                    response = readFromInputStream(inputStream);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            String res= "";
            super.onPostExecute(s);
            try {
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

            } catch (JSONException e) {
                e.printStackTrace();
            }
            EarthquakeAdapter adapter = new EarthquakeAdapter(getApplicationContext(),R.layout.single_row,R.id.magnitude,earthquakes);
            earthquakeListView.setAdapter(adapter);
        }

        private String readFromInputStream(InputStream inputStream)
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
    }*/


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RecentEarthquake(), "Recent Earthquakes");
        adapter.addFragment(new PastEarthquake(), "Past Earthquakes");
        //adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
