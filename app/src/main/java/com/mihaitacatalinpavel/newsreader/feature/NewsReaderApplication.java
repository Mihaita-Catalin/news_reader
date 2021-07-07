package com.mihaitacatalinpavel.newsreader.feature;

import android.app.Application;

import com.example.data.di.RepoModule;

public class NewsReaderApplication extends Application {

    private static RepoModule repoModule;

    public static RepoModule getRepoProvider() {
        return repoModule;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        repoModule = new RepoModule(this);
    }
}
