package com.olesiavasileva.testtaskforlynx_media.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Olesia on 04.09.2018.
 */

public class EventModel implements Serializable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("coefficient")
    @Expose
    private String coefficient;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("article")
    @Expose
    private String article;

    public EventModel(String title, String coefficient, String time, String place, String preview,
                      String article) {
        this.title = title;
        this.coefficient = coefficient;
        this.time = time;
        this.place = place;
        this.preview = preview;
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getPreview() {
        return preview;
    }

    public String getArticle() {
        return article;
    }
}
