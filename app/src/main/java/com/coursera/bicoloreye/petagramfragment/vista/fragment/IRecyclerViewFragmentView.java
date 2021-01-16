package com.coursera.bicoloreye.petagramfragment.vista.fragment;


import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas, boolean single);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
    public void setEnabledLikes(MascotaAdaptador adaptador,boolean likes);
}
