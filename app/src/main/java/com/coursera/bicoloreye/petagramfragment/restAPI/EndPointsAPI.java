package com.coursera.bicoloreye.petagramfragment.restAPI;


import com.coursera.bicoloreye.petagramfragment.restAPI.model.InstagramResponse;
import com.coursera.bicoloreye.petagramfragment.vista.activity.AccountSettingsActivity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPointsAPI {

    @GET(ConstantesRestAPI.URL_GET_INFORMATION_MULTIMEDIA)
    Call<InstagramResponse> getMedia(@Query("fields") String fields, @Query("access_token") String access_token);


}
