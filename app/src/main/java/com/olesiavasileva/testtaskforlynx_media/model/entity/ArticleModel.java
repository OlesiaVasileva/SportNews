package com.olesiavasileva.testtaskforlynx_media.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Olesia on 04.09.2018.
 */

public class ArticleModel implements Serializable {
    @SerializedName("team1")
    @Expose
    private String team1;
    @SerializedName("team2")
    @Expose
    private String team2;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("tournament")
    @Expose
    private String tournament;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("article")
    @Expose
    private List<Article> article;
    @SerializedName("prediction")
    @Expose
    private String prediction;

    public ArticleModel(String team1, String team2, String time, String tournament,
                        String place, List<Article> article, String prediction) {
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        this.tournament = tournament;
        this.place = place;
        this.article = article;
        this.prediction = prediction;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTime() {
        return time;
    }

    public String getTournament() {
        return tournament;
    }

    public String getPlace() {
        return place;
    }

    public List<Article> getArticle() {
        return article;
    }

    public String getPrediction() {
        return prediction;
    }
}
