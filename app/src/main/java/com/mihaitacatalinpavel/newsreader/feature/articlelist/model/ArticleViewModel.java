package com.mihaitacatalinpavel.newsreader.feature.articlelist.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.data.ArticleRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ArticleViewModel extends AndroidViewModel implements LifecycleObserver {

    @NonNull
    public final ObservableList<ArticleItemViewModel> articles;
    private final ArticleRepository repo;
    private Disposable disposable;

    public ArticleViewModel(Application application, ArticleRepository repo) {
        super(application);
        this.repo = repo;
        this.articles = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        repo.getNewsArticles()
                .map(new ArticleToArticleItemViewModel())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onArticlesReceived,
                        this::onError
                );
    }

    private void onArticlesReceived(List<ArticleItemViewModel> articles) {
        this.articles.clear();
        this.articles.addAll(articles);
    }

    private void onError(Throwable throwable) {
        Log.e("ArticleViewModel", "onError", throwable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchToDoList() {
        if (articles.isEmpty()) {
            disposable = repo.getArticleList()
                    .map(new ArticleToArticleItemViewModel())
                    .subscribe(
                            this::onArticlesReceived,
                            this::onError
                    );
        }
    }
}