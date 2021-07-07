package com.mihaitacatalinpavel.newsreader.feature.articlelist.model;

import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    public final ObservableField<String> articleTitle;
    public final ObservableField<String> articleContent;
    public String articleImage;

    public ArticleItemViewModel() {
        articleTitle = new ObservableField<>();
        articleContent = new ObservableField<>();
    }
}
