package com.example.data.features.news.model;

import androidx.annotation.NonNull;

public class Article {

    @NonNull
    public final String imageUrl;

    @NonNull
    public final String articleTitle;

    @NonNull
    public final String articleContent;

    public Article(@NonNull String imageUrl, @NonNull String articleTitle, @NonNull String articleContent) {
        this.imageUrl = imageUrl;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
    }
}
