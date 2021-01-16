package com.coursera.bicoloreye.petagramfragment.restAPI.model;


import com.coursera.bicoloreye.petagramfragment.pojo.InstagramPost;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramProfile;

import java.util.ArrayList;

public class InstagramResponse {

    private ArrayList<InstagramPost> instagramPosts ;

    public InstagramProfile getInstagramProfile() {
        return instagramProfile;
    }

    public void setInstagramProfile(InstagramProfile instagramProfile) {
        this.instagramProfile = instagramProfile;
    }

    private InstagramProfile instagramProfile;

    public ArrayList<InstagramPost> getInstagramPosts() {
        return instagramPosts;
    }

    public void setInstagramPosts(ArrayList<InstagramPost> instagramPosts) {
        this.instagramPosts = instagramPosts;
    }
}
