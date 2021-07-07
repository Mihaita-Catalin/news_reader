package com.example.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.data.ArticleRepository;
import com.example.data.features.news.ArticleRepositoryImpl;
import com.example.data.features.news.local.NewsLocalStore;
import com.example.data.features.news.remote.ArticleRemoteSource;
import com.example.data.remote.HttpClientFactory;
import com.example.data.store.local.ArticlesDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {

    @NonNull
    public final Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;
    private volatile ArticlesDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public ArticleRepository provideNewsRepository() {
        return new ArticleRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private ArticleRemoteSource provideNewsRemoteSource() {
        return new ArticleRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsLocalStore provideLocalDataStore() {
        ArticlesDatabase database = getInstance();
        return new NewsLocalStore(database.articleDao());
    }

    ArticlesDatabase getInstance() {
        if (database == null) {
            synchronized (ArticlesDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            ArticlesDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
