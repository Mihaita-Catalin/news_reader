package com.example.data.features.news.local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class NewsLocalStore {

    private ArticleDao dao;

    public NewsLocalStore(ArticleDao dao) {
        this.dao = dao;
    }

    public Flowable<List<ArticleEntity>> getArticleList() {
        return dao.queryArticles();
    }

    public Single<ArticleEntity> getArticleItem(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteArticleItem(int id) {
        return dao.deleteArticleItem(id);
    }

    public Completable saveItem(ArticleEntity article) {
        if (article.id == null) {
            return dao.insertArticle(article);
        } else {
            return dao.updateProfile(article.imageUrl, article.title, article.content, article.id);
        }
    }
}
