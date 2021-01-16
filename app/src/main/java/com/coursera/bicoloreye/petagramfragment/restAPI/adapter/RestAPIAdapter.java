package com.coursera.bicoloreye.petagramfragment.restAPI.adapter;

import com.coursera.bicoloreye.petagramfragment.restAPI.ConstantesRestAPI;
import com.coursera.bicoloreye.petagramfragment.restAPI.EndPointsAPI;
import com.coursera.bicoloreye.petagramfragment.restAPI.deserializador.InstagramPostDeserializador;
import com.coursera.bicoloreye.petagramfragment.restAPI.model.InstagramResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIAdapter {

    public EndPointsAPI establecerConexionRestAPIInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPointsAPI.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(InstagramResponse.class,new InstagramPostDeserializador());
        return gsonBuilder.create();
    }
}
