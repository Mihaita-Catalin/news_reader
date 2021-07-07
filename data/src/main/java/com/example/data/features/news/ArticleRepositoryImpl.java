package com.example.data.features.news;

import com.example.data.ArticleRepository;
import com.example.data.features.news.local.NewsLocalStore;
import com.example.data.features.news.model.Article;
import com.example.data.features.news.remote.ArticleRemoteSource;
import com.example.data.features.news.remote.mapper.ArticleEntityToArticle;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class ArticleRepositoryImpl implements ArticleRepository {

    private final ArticleRemoteSource remoteSource;
    private final NewsLocalStore localStore;

    public ArticleRepositoryImpl(ArticleRemoteSource remoteSource, NewsLocalStore localStore) {
        this.remoteSource = remoteSource;
        this.localStore = localStore;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles();
    }

    @androidx.annotation.NonNull
    @Override
    public Flowable<List<Article>> getArticleList() {
        return localStore.getArticleList()
                .map(new ArticleEntityToArticle())
                .subscribeOn(Schedulers.io());
    }
}
