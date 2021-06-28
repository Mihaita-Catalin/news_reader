package com.mihaitacatalinpavel.newsreader.feature.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mihaitacatalinpavel.newsreader.feature.articlelist.adapter.ArticleAdapter;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles) {
        ArticleAdapter articleAdapter = (ArticleAdapter) recyclerView.getAdapter();

        if (articleAdapter == null) {
            articleAdapter = new ArticleAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(articleAdapter);
        }

        articleAdapter.setItems(articles);
    }
}
