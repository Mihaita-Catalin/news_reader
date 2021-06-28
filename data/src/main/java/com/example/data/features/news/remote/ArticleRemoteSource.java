package com.example.data.features.news.remote;

import com.example.data.features.news.model.Article;
import com.example.data.features.news.remote.mapper.ArticleDtoToArticleMapper;
import com.example.data.remote.ArticleApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class ArticleRemoteSource {

    private static final String API_KEY = "9ecf468e228f401ab4d1139427957693";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final ArticleApi newsApi;

    public ArticleRemoteSource(ArticleApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io())
                .map(new ArticleDtoToArticleMapper());
    }
}
