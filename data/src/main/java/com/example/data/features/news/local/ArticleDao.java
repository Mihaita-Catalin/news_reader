package com.example.data.features.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM articles")
    Flowable<List<ArticleEntity>> queryArticles();

    @Query("SELECT * FROM articles where id= :id")
    Single<ArticleEntity> queryArticleItem(int id);

    @Query("DELETE FROM articles where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM articles")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);

    @Query("UPDATE articles SET imageUrl = :imageUrl, title = :title," +
            " content =:content where id=:id")
    Completable updateProfile(String imageUrl, String title, String content, int id);
}
