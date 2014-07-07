package com.charitynews;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.charitynews.news.DisplayNewsActivity;
import com.charitynews.news.NewsItem;
import com.charitynews.news.NewsListAdapter;
import com.charitynews.news.scraper.WordPressScraper;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {



    ArrayList<NewsItem> newsItems = new ArrayList<NewsItem>();

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup the UI
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new NewsListAdapter(this, R.layout.list_item, newsItems));
        listView.setOnItemClickListener(this);
        getNewsItems(WordPressScraper.url);



    }


    private void getNewsItems(String url) {
        JSONObject jo = null;
        JSONArray posts = null;
        try {
            Log.d("json posts", "Trying to get json posts ");
            jo = new WordPressScraper().execute(WordPressScraper.url).get();
            posts = jo.getJSONArray("posts");
            for(int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.getJSONObject(i);
                String title = post.getString("title");
                String author = post.getJSONObject("author").getString("name");
                String content = post.getString("content");
                newsItems.add(new NewsItem(title, content, author, 0));
            }
        }catch(Exception e) {
            Log.d("error", "Error obtaining news items ", e);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        NewsItem selectedItem = newsItems.get(position);
        if (selectedItem != null) {
            String display = selectedItem.getArticleName();
            Toast.makeText(getApplicationContext(), "Opening " + display, Toast.LENGTH_SHORT).show();

            Intent newsDisplayIntent = new Intent(this, DisplayNewsActivity.class);
            newsDisplayIntent.putExtra(DisplayNewsActivity.NEWSITEM_KEY, selectedItem);

            startActivity(newsDisplayIntent);

        }
    }

    public void openTwitter() {
        String url = getResources().getString(R.string.twitter);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}


