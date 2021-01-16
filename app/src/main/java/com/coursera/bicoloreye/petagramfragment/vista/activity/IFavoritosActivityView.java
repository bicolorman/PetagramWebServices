package com.coursera.bicoloreye.petagramfragment.vista.activity;


import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;

import java.util.ArrayList;

public interface IFavoritosActivityView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas, boolean single);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
    public void setEnabledLikes(MascotaAdaptador adaptador,boolean likes);
}
