package com.example.data.features.news.remote.mapper;

import com.example.data.features.news.local.ArticleEntity;
import com.example.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToArticle implements Function<List<ArticleEntity>, List<Article>> {

    @Override
    public List<Article> apply(List<ArticleEntity> articleEntities) {
        List<Article> articles = new ArrayList<>();

        for (ArticleEntity entity : articleEntities) {
            Article article = new Article(
                    entity.imageUrl != null ? entity.imageUrl : "",
                    entity.title != null ? entity.title : "",
                    entity.content != null ? entity.content : ""
            );
            articles.add(article);
        }
        return articles;
    }
}
