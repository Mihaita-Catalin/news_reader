package com.mihaitacatalinpavel.newsreader.feature.articlelist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mihaitacatalinpavel.newsreader.R;
import com.mihaitacatalinpavel.newsreader.feature.articlelist.fragment.ArticleListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ArticleListFragment.newInstance())
                    .commitNow();
        }

    }
}