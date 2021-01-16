package com.coursera.bicoloreye.petagramfragment.pojo;

import android.content.Context;
import android.content.SharedPreferences;

public class InstagramPost {
    private String id;
    private String media_url;
    private int like_count;
    private String caption;

    public InstagramPost() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
