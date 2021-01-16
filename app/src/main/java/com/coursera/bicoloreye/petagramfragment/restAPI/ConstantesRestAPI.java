package com.coursera.bicoloreye.petagramfragment.restAPI;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class ConstantesRestAPI  {

        public static final String VERSION= "/v9.0";
        public static final String ACCESS_TOKEN="&access_token=EAAFi1LZAbBZBoBAJEW9WFbGQGUf4ThuMdy7TAIEYLejlLwf0rV5DP0HoKc0zbZAJ7zBnVHCHhtZC2GET9AUzJNevcBIzCDtU6cHZAogdwGvEfMZBS1OkZCORPdshECdiJAWAUEo2Mg6tdZBOyGzYQcrymsWNSaxfGPEvwyPBLVP8DfQhPP1Q4VgO";
        public static final String ACCESS_TOKENF="EAAFi1LZAbBZBoBAJEW9WFbGQGUf4ThuMdy7TAIEYLejlLwf0rV5DP0HoKc0zbZAJ7zBnVHCHhtZC2GET9AUzJNevcBIzCDtU6cHZAogdwGvEfMZBS1OkZCORPdshECdiJAWAUEo2Mg6tdZBOyGzYQcrymsWNSaxfGPEvwyPBLVP8DfQhPP1Q4VgO";
        public static final String FIELDS_NODEUSER="?fields=id,username";
        public static final String KEY_NODEUSER="/me";
        public static final String FIELDS_MULTIMEDIAUSER1="business_discovery.username(";
        public static final String FIELDS_MULTIMEDIAUSER2="){username,profile_picture_url,followers_count,media_count,media{comments_count,like_count,media_url,caption,id}}";
        public static final String FIELDS_MULTIMEDIAUSER="?fields=business_discovery.username({usernameInstagram}){username,profile_picture_url,followers_count,media_count,media{comments_count,like_count,media_url,caption,id}}";
        public static final String KEY_MULTIMEDIAUSER="/17841444705301308";
        public static final String KEY_NODEMULTIMEDIA="/";
        public static final String URL_GET_INFORMATION_USER=KEY_NODEUSER+FIELDS_NODEUSER+ACCESS_TOKEN;
        public static final String URL_GET_INFORMATION_MULTIMEDIAUSER=VERSION+KEY_MULTIMEDIAUSER+FIELDS_MULTIMEDIAUSER+ACCESS_TOKEN;
        public static final String URL_GET_INFORMATION_MULTIMEDIA=VERSION+KEY_MULTIMEDIAUSER;
        //business_discovery.username(instagram){username,profile_picture_url,followers_count,media_count,media{comments_count,like_count,media_url,caption,id}}

        public static final String ROOT_URL="https://graph.facebook.com";
        //https://graph.facebook.com/v9.0/17841444705301308?fields=business_discovery.username(instagram){username,profile_picture_url,followers_count,media_count,media{comments_count,like_count}}&access_token=EAAFi1LZAbBZBoBAJEW9WFbGQGUf4ThuMdy7TAIEYLejlLwf0rV5DP0HoKc0zbZAJ7zBnVHCHhtZC2GET9AUzJNevcBIzCDtU6cHZAogdwGvEfMZBS1OkZCORPdshECdiJAWAUEo2Mg6tdZBOyGzYQcrymsWNSaxfGPEvwyPBLVP8DfQhPP1Q4VgO




}

