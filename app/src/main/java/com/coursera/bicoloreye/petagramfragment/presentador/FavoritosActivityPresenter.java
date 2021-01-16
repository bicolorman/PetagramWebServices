package com.coursera.bicoloreye.petagramfragment.presentador;

import android.content.Context;

import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.db.ConstructorMascotas;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;
import com.coursera.bicoloreye.petagramfragment.vista.activity.IFavoritosActivityView;
import com.coursera.bicoloreye.petagramfragment.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class FavoritosActivityPresenter implements IFavoritosActivityPresenter {

    private IFavoritosActivityView iFavoritosActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FavoritosActivityPresenter(IFavoritosActivityView iFavoritosActivityView, Context context) {
        this.iFavoritosActivityView = iFavoritosActivityView;
        this.context=context;
        obtenerMascotasFavoritasBaseDatatos();
    }




    @Override
    public void obtenerMascotasFavoritasBaseDatatos() {
        constructorMascotas =new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosFavoritos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        MascotaAdaptador mascotaAdaptador;
        iFavoritosActivityView.inicializarAdaptadorRV(mascotaAdaptador= iFavoritosActivityView.crearAdaptador(mascotas,false));
        iFavoritosActivityView.setEnabledLikes(mascotaAdaptador,false);
        iFavoritosActivityView.generarLinearLayoutVertical();
    }

    @Override
    public void obtenerMedios() {

    }
}
