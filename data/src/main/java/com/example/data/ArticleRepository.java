package com.example.data;

import androidx.annotation.NonNull;

import com.example.data.features.news.local.ArticleEntity;
import com.example.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface ArticleRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Flowable<List<ArticleEntity>> getArticleList();

    @NonNull
    Completable saveArticleItem(ArticleEntity article);

    @NonNull
    Completable deleteItem(int itemId);

    @NonNull
    Single<ArticleEntity> getArticleItem(int itemId);
}
