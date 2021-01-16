package com.coursera.bicoloreye.petagramfragment.restAPI.deserializador;

import com.coursera.bicoloreye.petagramfragment.pojo.InstagramPost;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramProfile;
import com.coursera.bicoloreye.petagramfragment.restAPI.JsonKeys;

import com.coursera.bicoloreye.petagramfragment.restAPI.model.InstagramResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class InstagramPostDeserializador implements JsonDeserializer<InstagramResponse> {
    @Override
    public InstagramResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson= new Gson();
        InstagramResponse instagramResponse= gson.fromJson(json,InstagramResponse.class);
        InstagramProfile instagramProfile=new InstagramProfile();
        JsonObject instagramPostResponseDataObject_BD = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_BD);
        System.out.println("instagramPostResponseDataObject_BD:"+instagramPostResponseDataObject_BD.toString());

        instagramProfile.setProfile_picture_url(instagramPostResponseDataObject_BD.get(JsonKeys.PROFILE_PICTURE_URL).getAsString());
        instagramProfile.setUsername(instagramPostResponseDataObject_BD.get(JsonKeys.PROFILE_USERNAME).getAsString());

        JsonObject instagramPostResponseDataObject_MEDIA = instagramPostResponseDataObject_BD.get(JsonKeys.MEDIA_RESPONSE_MEDIA).getAsJsonObject();
        System.out.println("instagramPostResponseDataObject_MEDIA:"+instagramPostResponseDataObject_MEDIA.toString());

        JsonArray instagramResponseData= instagramPostResponseDataObject_MEDIA.get(JsonKeys.MEDIA_RESPONSE_ARRAY).getAsJsonArray();
        System.out.println("instagramResponseData:"+instagramResponseData.toString());

        instagramResponse.setInstagramProfile(instagramProfile);
        instagramResponse.setInstagramPosts(deserilizarIPostDeJson(instagramResponseData));
        return instagramResponse;
    }
    
    private ArrayList<InstagramPost> deserilizarIPostDeJson(JsonArray instagramPostResponseData){
        ArrayList<InstagramPost> instagramPosts = new ArrayList<>();
        if (instagramPostResponseData!=null)
        System.out.println("Deserializador lleno:"+instagramPostResponseData.size());
        else System.out.println("Deserializador vacio"+instagramPosts.size());
        for (int i = 0; i < instagramPostResponseData.size(); i++) {
            JsonObject instagramPostResponseDataObject = instagramPostResponseData.get(i).getAsJsonObject();
            String id=instagramPostResponseDataObject.get(JsonKeys.ID).getAsString();
            String caption=instagramPostResponseDataObject.get(JsonKeys.CAPTION).getAsString();
            String urlFoto=instagramPostResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            int likes=instagramPostResponseDataObject.get(JsonKeys.MEDIA_LIKES).getAsInt();

            InstagramPost current= new InstagramPost();
            current.setId(id);
            current.setCaption(caption);
            current.setMedia_url(urlFoto);
            current.setLike_count(likes);

            instagramPosts.add(current);


        }

        return instagramPosts;
    }
}
