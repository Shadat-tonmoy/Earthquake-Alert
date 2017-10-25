package com.example.android.quakereport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shadat Tonmoy on 10/25/2017.
 */

public class GetEarthQuakeData {
    public GetEarthQuakeData(){

    }
    ArrayList<Earthquake> earthquakes;
    String data = "{\"type\":\"FeatureCollection\",\"metadata\":{\"generated\":1508939065000,\"url\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?starttime=2017-10-24&endtime=2017-10-25&format=geojson&minmag=4.0\",\"title\":\"USGS Earthquakes\",\"status\":200,\"api\":\"1.5.8\",\"count\":8},\"features\":[{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"22km SE of San Mateo del Mar, Mexico\",\"time\":1508887261180,\"updated\":1508888472040,\"tz\":-360,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000awhp\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000awhp&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":326,\"net\":\"us\",\"code\":\"1000awhp\",\"ids\":\",us1000awhp,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":3.31,\"rms\":1.29,\"gap\":166,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 22km SE of San Mateo del Mar, Mexico\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-94.8553,16.0501,27.62]},\"id\":\"us1000awhp\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5,\"place\":\"86km SW of Tres Picos, Mexico\",\"time\":1508861534880,\"updated\":1508897567622,\"tz\":-360,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000awcj\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000awcj&format=geojson\",\"felt\":2,\"cdi\":2.5,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":385,\"net\":\"us\",\"code\":\"1000awcj\",\"ids\":\",us1000awcj,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":2.375,\"rms\":0.79,\"gap\":152,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 5.0 - 86km SW of Tres Picos, Mexico\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-94.0342,15.2536,44.91]},\"id\":\"us1000awcj\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.3,\"place\":\"205km NE of Ndoi Island, Fiji\",\"time\":1508858263610,\"updated\":1508862643040,\"tz\":-720,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000awc4\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000awc4&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":284,\"net\":\"us\",\"code\":\"1000awc4\",\"ids\":\",us1000awc4,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":4.381,\"rms\":0.68,\"gap\":88,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.3 - 205km NE of Ndoi Island, Fiji\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-177.5663,-19.1321,550.66]},\"id\":\"us1000awc4\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"65km S of Hachijo-jima, Japan\",\"time\":1508856101520,\"updated\":1508863262040,\"tz\":540,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000awbu\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000awbu&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":326,\"net\":\"us\",\"code\":\"1000awbu\",\"ids\":\",us1000awbu,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":0.616,\"rms\":0.75,\"gap\":121,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 65km S of Hachijo-jima, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[139.8885,32.5,114.72]},\"id\":\"us1000awbu\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.4,\"place\":\"20km N of Murghob, Tajikistan\",\"time\":1508849649180,\"updated\":1508851699040,\"tz\":300,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000awa7\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000awa7&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":298,\"net\":\"us\",\"code\":\"1000awa7\",\"ids\":\",us1000awa7,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":2.956,\"rms\":0.68,\"gap\":67,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.4 - 20km N of Murghob, Tajikistan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[73.9708,38.3511,137.67]},\"id\":\"us1000awa7\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.7,\"place\":\"141km NNE of Palue, Indonesia\",\"time\":1508842067540,\"updated\":1508895911426,\"tz\":480,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000aw8q\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000aw8q&format=geojson\",\"felt\":10,\"cdi\":2.7,\"mmi\":2.75,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":693,\"net\":\"us\",\"code\":\"1000aw8q\",\"ids\":\",us1000aw8q,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":1.601,\"rms\":1.04,\"gap\":19,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.7 - 141km NNE of Palue, Indonesia\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[123.0401,-7.2364,549.19]},\"id\":\"us1000aw8q\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"8km SSW of Bodrum, Turkey\",\"time\":1508837784190,\"updated\":1508919373147,\"tz\":120,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000aw8c\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000aw8c&format=geojson\",\"felt\":31,\"cdi\":5.1,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":341,\"net\":\"us\",\"code\":\"1000aw8c\",\"ids\":\",us1000aw8c,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,moment-tensor,origin,phase-data,\",\"nst\":null,\"dmin\":0.958,\"rms\":1.5,\"gap\":44,\"magType\":\"mwr\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 8km SSW of Bodrum, Turkey\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[27.3833,36.9672,10]},\"id\":\"us1000aw8c\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.1,\"place\":\"45km S of Tanaga Volcano, Alaska\",\"time\":1508828973570,\"updated\":1508867458048,\"tz\":-600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us1000aw7s\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us1000aw7s&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":3.5,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":400,\"net\":\"us\",\"code\":\"1000aw7s\",\"ids\":\",ak17094161,us1000aw7s,\",\"sources\":\",ak,us,\",\"types\":\",geoserve,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":2.611,\"rms\":1.19,\"gap\":143,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 5.1 - 45km S of Tanaga Volcano, Alaska\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-178.2433,51.482,57.02]},\"id\":\"us1000aw7s\"}],\"bbox\":[-178.2433,-19.1321,10,139.8885,51.482,550.66]}";

    public ArrayList<Earthquake> getEarthquakes()
    {
        return this.earthquakes;
    }
    public void setEarthquakes()
    {
        earthquakes = new ArrayList<Earthquake>();
        try {
            JSONObject root = new JSONObject(data);
            JSONArray featuresArray = root.getJSONArray("features");
            for(int i=0;i<featuresArray.length();i++)
            {
                JSONObject feature = featuresArray.getJSONObject(i);
                JSONObject properties = feature.getJSONObject("properties");
                String magnatude = properties.getString("mag");
                String place = properties.getString("place");
                String time = properties.getString("time");
                Earthquake earthquake = new Earthquake(magnatude,place,time);
                earthquakes.add(earthquake);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
