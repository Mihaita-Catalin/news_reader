package com.mihaitacatalinpavel.newsreader.feature.articlelist.viewholder;

import androidx.recyclerview.widget.RecyclerView;

import com.mihaitacatalinpavel.newsreader.databinding.ArticleItemBinding;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    public final ArticleItemBinding articleItemBinding;

    public ArticleViewHolder(ArticleItemBinding articleItemBinding) {
        super(articleItemBinding.getRoot());
        this.articleItemBinding = articleItemBinding;
    }
}
