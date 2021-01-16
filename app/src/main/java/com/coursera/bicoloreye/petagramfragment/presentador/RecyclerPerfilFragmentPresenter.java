package com.coursera.bicoloreye.petagramfragment.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.coursera.bicoloreye.petagramfragment.pojo.InstagramPost;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramProfile;
import com.coursera.bicoloreye.petagramfragment.restAPI.ConstantesRestAPI;
import com.coursera.bicoloreye.petagramfragment.restAPI.EndPointsAPI;
import com.coursera.bicoloreye.petagramfragment.restAPI.adapter.RestAPIAdapter;
import com.coursera.bicoloreye.petagramfragment.restAPI.model.InstagramResponse;
import com.coursera.bicoloreye.petagramfragment.vista.fragment.IRecyclerPerfilFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerPerfilFragmentPresenter implements IRecyclerPerfilFragmentPresenter {

    private IRecyclerPerfilFragment iRecyclerPerfilFragment;
    private Context context;
    //private ConstructorContactos constructorContactos;
    private ArrayList<InstagramPost> posts;
    private InstagramProfile instagramProfile;

    public RecyclerPerfilFragmentPresenter(IRecyclerPerfilFragment iRecyclerPerfilFragment, Context context) {
        this.iRecyclerPerfilFragment=iRecyclerPerfilFragment;
        this.context=context;
        //obtenerContactoBaseDatatos();
        obtenerMedios();
    }

    @Override
    public void obtenerMedios() {
        RestAPIAdapter restAPIAdapter= new RestAPIAdapter();
        if(restAPIAdapter==null) System.out.println("restAPIAdapter en nulo");
        Gson gsonMediaRecent = restAPIAdapter.construyeGsonDeserializadorMediaRecent();
        if(gsonMediaRecent==null) System.out.println("gsonMediaRecent en nulo");
        EndPointsAPI endPointsAPI= restAPIAdapter.establecerConexionRestAPIInstagram(gsonMediaRecent);
        if(endPointsAPI==null) System.out.println("endPointsAPI en nulo");

        String fields= ConstantesRestAPI.FIELDS_MULTIMEDIAUSER1+getCuenta()+ConstantesRestAPI.FIELDS_MULTIMEDIAUSER2;
        String access_token=ConstantesRestAPI.ACCESS_TOKENF;
        Call<InstagramResponse> contactoResponseCall= endPointsAPI.getMedia(fields,access_token);
        contactoResponseCall.enqueue(new Callback<InstagramResponse>() {
            @Override
            public void onResponse(Call<InstagramResponse> call, Response<InstagramResponse> response) {
                InstagramResponse instagramResponse=response.body();
                if(instagramResponse==null)
                    System.out.println("Viene nulo");
                else {
                    posts = instagramResponse.getInstagramPosts();
                    instagramProfile = instagramResponse.getInstagramProfile();
                    mostrarContactosRV();
                }
            }

            @Override
            public void onFailure(Call<InstagramResponse> call, Throwable t) {
                Toast.makeText(context,"Algo Paso intenta de nuevo", Toast.LENGTH_LONG);
                Log.e("FALLO LA CONEXION",t.toString());
            }
        });



    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerPerfilFragment.inicializarAdaptadorRV(iRecyclerPerfilFragment.crearAdaptador(posts));

        iRecyclerPerfilFragment.generarGridLayout();
        iRecyclerPerfilFragment.setProfile(instagramProfile);
    }

    @Override
    public void mostrarPerfil() {

    }


    public String getCuenta(){

        SharedPreferences sharedPreferences = context.getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        return sharedPreferences.getString("cuenta","petagram_4ndr01d");


    }
}
