package com.coursera.bicoloreye.petagramfragment.pojo;

public class InstagramProfile {

    String username;
    String profile_picture_url;

public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_picture_url() {
        return profile_picture_url;
    }

    public void setProfile_picture_url(String profile_picture_url) {
        this.profile_picture_url = profile_picture_url;
    }

    @Override
    public String toString() {
        return "InstagramProfile{" +
                ", username='" + username + '\'' +
                ", profile_picture_url='" + profile_picture_url + '\'' +
                '}';
    }
}
