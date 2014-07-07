package com.charitynews.news;

import android.content.Context;
import android.text.Html;
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

            TextView articleName = (TextView) v.findViewById(R.id.articlename);
            TextView articleAuthor = (TextView) v.findViewById(R.id.authorarticle);
            TextView articleContent = (TextView) v.findViewById(R.id.articlecontent);

            if (articleName != null) {
                articleName.setText("Article name: " + i.getArticleName());
            }

            if (articleAuthor != null) {
                articleAuthor.setText("Author: " + i.getAuthorName());
            }
            if (articleContent != null) {
                articleContent.setText("Details: " + Html.fromHtml(i.getTrimmedArticle()));
            }
        }

        return v;

    }

}
