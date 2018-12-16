package com.beelabs.tbcinfo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.model.dao.ArticleDao;
import com.beelabs.tbcinfo.ui.adapter.ArticleListAdapter;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleActivity extends BaseActivity {
    @BindView(R.id.article_list)
    RecyclerView articleList;

    private ArticleListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        articleList.setLayoutManager(new LinearLayoutManager(this));
        articleList.setHasFixedSize(true);

        adapter = new ArticleListAdapter(ArticleDao.buildArticleList(), ArticleActivity.this);

        articleList.setAdapter(adapter);

    }
}
