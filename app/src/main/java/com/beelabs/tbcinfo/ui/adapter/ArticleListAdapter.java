package com.beelabs.tbcinfo.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.model.db.ArticleModel;
import com.beelabs.tbcinfo.ui.activity.ArticleActivity;

import java.util.List;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {
    private List<ArticleModel> list;
    private BaseActivity activity;

    public ArticleListAdapter(List<ArticleModel> list, ArticleActivity activity) {
        this.list = list;
        this.activity = activity;

    }

    @Override
    public ArticleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(activity).inflate(R.layout.row_article, parent, false);

        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ArticleListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
