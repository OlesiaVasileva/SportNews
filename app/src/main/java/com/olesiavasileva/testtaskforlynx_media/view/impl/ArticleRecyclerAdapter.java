package com.olesiavasileva.testtaskforlynx_media.view.impl;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olesiavasileva.testtaskforlynx_media.R;
import com.olesiavasileva.testtaskforlynx_media.model.entity.ArticleModel;


/**
 * Created by Olesia on 05.09.2018.
 */

public class ArticleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    private ArticleModel articleModel;

    public static final String TAG = "MyLogs";

    void setArticle(ArticleModel article) {
        articleModel = article;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_header, parent, false);
                return new HeaderHolder(view);
            }
            case TYPE_ITEM: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
                return new ArticleHolder(view);
            }
            case TYPE_FOOTER: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_footer, parent, false);
                return new PredictionHolder(view);
            }

        }
        throw new IllegalArgumentException("Invalid viewType " + viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case TYPE_HEADER:
                HeaderHolder headerHolder = (HeaderHolder) holder;
                headerHolder.team1.setText(articleModel.getTeam1().toUpperCase());
                headerHolder.team2.setText(articleModel.getTeam2().toUpperCase());
                headerHolder.time.setText(articleModel.getTime());
                headerHolder.tournament.setText(articleModel.getTournament());
                headerHolder.place.setText(articleModel.getPlace());
                break;

            case TYPE_ITEM:
                ArticleHolder articleHolder = (ArticleHolder) holder;
                articleHolder.header.setText(articleModel.getArticle().get(position - 1).getHeader());
                articleHolder.text.setText(articleModel.getArticle().get(position - 1).getText());
                break;
            case TYPE_FOOTER:
                PredictionHolder predictionHolder = (PredictionHolder) holder;
                predictionHolder.prediction.setText(articleModel.getPrediction());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        // условие для определения айтем какого типа выводить в конкретной позиции
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        if (articleModel == null) {
            return 0;
        }
        int result = 2 + articleModel.getArticle().size();
        Log.d(TAG, "itemCount: " + result);
        return result;
    }

    public static class HeaderHolder extends RecyclerView.ViewHolder {

        TextView team1;
        TextView team2;
        TextView time;
        TextView tournament;
        TextView place;

        public HeaderHolder(View v) {
            super(v);

            team1 = v.findViewById(R.id.article_team1);
            team2 = v.findViewById(R.id.article_team2);
            time = v.findViewById(R.id.article_time);
            tournament = v.findViewById(R.id.article_tournament);
            place = v.findViewById(R.id.article_place);
        }
    }

    public static class ArticleHolder extends RecyclerView.ViewHolder {

        TextView header;
        TextView text;

        public ArticleHolder(View v) {
            super(v);

            header = v.findViewById(R.id.article_header);
            text = v.findViewById(R.id.article_text);
        }
    }

    public static class PredictionHolder extends RecyclerView.ViewHolder {

        TextView prediction;

        public PredictionHolder(View v) {
            super(v);

            prediction = v.findViewById(R.id.article_prediction);
        }
    }
}
