package com.example.data;

import androidx.annotation.NonNull;

import com.example.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface ArticleRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Flowable<List<Article>> getArticleList();
}
