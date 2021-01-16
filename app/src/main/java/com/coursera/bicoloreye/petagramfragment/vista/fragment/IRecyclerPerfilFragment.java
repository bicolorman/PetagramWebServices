package com.coursera.bicoloreye.petagramfragment.vista.fragment;


import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.adapter.PostInstagramAdapter;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramPost;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramProfile;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerPerfilFragment {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();
    public PostInstagramAdapter crearAdaptador(ArrayList<InstagramPost> posts);
    public void setProfile(InstagramProfile instagramProfile);
    public void inicializarAdaptadorRV(PostInstagramAdapter adaptador);
    public void setEnabledLikes(PostInstagramAdapter adaptador,boolean likes);

}
