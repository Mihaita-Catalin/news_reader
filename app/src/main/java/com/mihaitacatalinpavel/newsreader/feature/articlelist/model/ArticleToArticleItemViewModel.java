package com.mihaitacatalinpavel.newsreader.feature.articlelist.model;

import com.example.data.features.news.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToArticleItemViewModel implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(@NotNull List<Article> articles) {
        List<ArticleItemViewModel> articlesItems = new ArrayList<>();

        for (Article a : articles) {
            ArticleItemViewModel article = new ArticleItemViewModel();
            article.articleImage = a.imageUrl;
            article.articleTitle.set(a.articleTitle);
            article.articleContent.set(a.articleContent);
            articlesItems.add(article);
        }

        return articlesItems;
    }
}
