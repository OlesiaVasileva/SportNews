package com.olesiavasileva.testtaskforlynx_media.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Olesia on 04.09.2018.
 */

public class Article implements Serializable {
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("text")
    @Expose
    private String text;

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }
}
