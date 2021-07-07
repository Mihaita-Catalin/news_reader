package com.mihaitacatalinpavel.newsreader.feature.articlelist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mihaitacatalinpavel.newsreader.databinding.ArticleListFragmentBinding;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.model.ArticleViewModel;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.model.factory.ViewModelFactory;

public class ArticleListFragment extends Fragment {

    private ArticleViewModel mViewModel;

    public static ArticleListFragment newInstance() {
        return new ArticleListFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity()
                .getApplication())).get(ArticleViewModel.class);
        getLifecycle().addObserver(mViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArticleListFragmentBinding binding = ArticleListFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}