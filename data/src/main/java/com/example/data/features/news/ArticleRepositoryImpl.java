package com.example.data.features.news;

import com.example.data.ArticleRepository;
import com.example.data.features.news.local.ArticleEntity;
import com.example.data.features.news.local.NewsLocalStore;
import com.example.data.features.news.model.Article;
import com.example.data.features.news.remote.ArticleRemoteSource;

import java.util.List;

import io.reactivex.Completable;
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
    public Flowable<List<ArticleEntity>> getArticleList() {
        return localStore.getArticleList()
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Completable saveArticleItem(ArticleEntity article) {
        return localStore.saveItem(article)
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Completable deleteItem(int itemId) {
        return localStore.deleteArticleItem(itemId)
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Single<ArticleEntity> getArticleItem(int itemId) {
        return localStore.getArticleItem(itemId)
                .subscribeOn(Schedulers.io());
    }
}
