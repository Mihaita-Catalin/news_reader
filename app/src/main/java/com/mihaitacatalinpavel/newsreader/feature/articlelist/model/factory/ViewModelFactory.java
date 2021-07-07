package com.mihaitacatalinpavel.newsreader.feature.articlelist.model.factory;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.data.ArticleRepository;
import com.mihaitacatalinpavel.newsreader.feature.NewsReaderApplication;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.model.ArticleViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
            ArticleRepository repo = NewsReaderApplication.getRepoProvider().provideNewsRepository();
            return (T) new ArticleViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
