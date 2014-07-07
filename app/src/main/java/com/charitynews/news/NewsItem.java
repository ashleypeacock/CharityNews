package com.charitynews.news;

import java.io.Serializable;

/**
 * Represents an individual news item.
 */
public class NewsItem implements Serializable {
    private String articleName;
    private String articleContent;
    private String authorName;
    private int id;
    private boolean isLongActicle = false;
    // this is for the display when the user clicks on it.
    private int articleTrimEnd = 100;

    public NewsItem(String articleName, String articleContent, String authorName, int id) {
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.authorName = authorName;
        this.id = id;
        if(articleContent.length() >= articleTrimEnd) {
            isLongActicle = true;
        }
    }

    /**
     * Gets the trimmed down article to display in the description before opening it.
     * @return article trimmed.
     */
    public String getTrimmedArticle() {
        if(articleContent != null && articleContent.length() > articleTrimEnd) {
            return articleContent.substring(0, articleTrimEnd);
        }
        return articleContent;
    }

    public boolean isLongArticle() {
        return isLongActicle;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
