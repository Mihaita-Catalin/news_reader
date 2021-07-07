package com.mihaitacatalinpavel.newsreader.feature.articlelist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mihaitacatalinpavel.newsreader.databinding.ArticleItemBinding;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.model.ArticleItemViewModel;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.viewholder.ArticleViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private List<ArticleItemViewModel> articleItemViewModelList;

    public ArticleAdapter() {
        this.articleItemViewModelList = new ArrayList<>();
    }

    @NonNull
    @NotNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ArticleItemBinding articleBinder = ArticleItemBinding.inflate(LayoutInflater.
                from(parent.getContext()), parent, false);
        return new ArticleViewHolder(articleBinder);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ArticleViewHolder holder, int position) {
        holder.articleItemBinding.setViewModel(articleItemViewModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleItemViewModelList.size();
    }

    public void setItems(List<ArticleItemViewModel> articles) {
        this.articleItemViewModelList = articles;
        notifyDataSetChanged();
    }
}
