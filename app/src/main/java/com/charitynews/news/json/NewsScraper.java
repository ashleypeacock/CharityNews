package com.charitynews.news.json;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Obtains news from a JSON object.
 */
public class NewsScraper extends AsyncTask<String, String, JSONObject>{

    public static String url = "http://autism-simulator.com/?json=get_recent_posts";

    @Override
    protected JSONObject doInBackground(String... url) {
        JSONObject jo = null;
        try {
            jo = getJSON(url[0]);
        } catch(Exception e) {

        }
        return jo;
    }

    public String getUrl() {
        return url;
    }

    public JSONObject getJSON(String url) {
        JSONObject jsonObject = null;
        try {
            DefaultHttpClient defaultClient = new DefaultHttpClient();

            // Setup the get request
            HttpGet httpGetRequest = new HttpGet(url);
            HttpResponse httpResponse = defaultClient.execute(httpGetRequest);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            StringBuilder json = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                json.append(line);
            }

            jsonObject = new JSONObject(json.toString());
           // Log.d("JSON", jsonObject.toString());

        }catch(Exception e) {
            Log.d("json", "Error occured", e);
            return null;
        }
        return jsonObject;
    }


}
