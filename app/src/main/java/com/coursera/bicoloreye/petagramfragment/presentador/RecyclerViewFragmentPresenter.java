package com.coursera.bicoloreye.petagramfragment.presentador;

import android.content.Context;

import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.db.ConstructorMascotas;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;
import com.coursera.bicoloreye.petagramfragment.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerMascotaBaseDatatos();
    }


    @Override
    public void obtenerMascotaBaseDatatos() {
            constructorMascotas =new ConstructorMascotas(context);
            mascotas = constructorMascotas.obtenerDatos();
            mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        MascotaAdaptador mascotaAdaptador;
        iRecyclerViewFragmentView.inicializarAdaptadorRV(mascotaAdaptador=iRecyclerViewFragmentView.crearAdaptador(mascotas,false));
        iRecyclerViewFragmentView.setEnabledLikes(mascotaAdaptador,true);
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }


}
