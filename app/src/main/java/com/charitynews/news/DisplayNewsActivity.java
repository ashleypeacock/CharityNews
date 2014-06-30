package com.charitynews.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.charitynews.R;

/**
 * Displays news information once the user has clicked it.
 */
public class DisplayNewsActivity extends Activity {

    private NewsItem newsItem = null;

    public static final String NEWSITEM_KEY = "com.charitynews.newsitem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        newsItem = (NewsItem)i.getSerializableExtra(NEWSITEM_KEY);
        setContentView(R.layout.news_display);

        TextView newsContent = (TextView) findViewById(R.id.newsdisplaycontent);
        newsContent.setText(newsItem.getArticleContent());

        TextView articleName = (TextView) findViewById(R.id.newsdisplayarticlename);
        articleName.setText(newsItem.getArticleName());
    }

}
