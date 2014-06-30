package com.charitynews.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.charitynews.R;

import java.util.ArrayList;

public class NewsListAdapter extends ArrayAdapter<NewsItem> {


    ArrayList<NewsItem> newsItems;

    public NewsListAdapter(Context context, int textViewResourceId, ArrayList<NewsItem> objects) {
        super(context,  textViewResourceId, objects);
        this.newsItems = objects;
    }

    /**
     * getView is finding the view for each individual item at a position.
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

        NewsItem i = newsItems.get(position);

        if (i != null) {

            TextView tt = (TextView) v.findViewById(R.id.articlename);
            TextView mtd = (TextView) v.findViewById(R.id.authorarticle);
            TextView bt = (TextView) v.findViewById(R.id.articlecontent);

            if (tt != null) {
                tt.setText("Article name: " + i.getArticleName());
            }

            if (mtd != null) {
                mtd.setText("Author" + i.getAuthorName());
            }
            if (bt != null) {
                bt.setText("Details: " + i.getArticleContent());
            }
        }

        return v;

    }

}
