package com.example.data.features.news.remote.model;

public class ArticleDto {

    public final SourceDto source;
    public final String urlToImage;
    public final String url;
    public final String content;
    public final String title;

    public ArticleDto(SourceDto source, String urlToImage, String url, String content, String title) {
        this.source = source;
        this.urlToImage = urlToImage;
        this.url = url;
        this.content = content;
        this.title = title;
    }
}
