package com.coursera.bicoloreye.petagramfragment.vista.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;
import com.coursera.bicoloreye.petagramfragment.presentador.IRecyclerViewFragmentPresenter;
import com.coursera.bicoloreye.petagramfragment.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaMascotas= (RecyclerView)v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;



       /*
        if(listaMascotas!=null) {

            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(RecyclerView.VERTICAL);

            listaMascotas.setLayoutManager(llm);

            inicializarListaMascotas();

            inicializarAdaptador();
        }
        return v;*/
    }

    public void inicializarAdaptador(boolean single){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,getActivity(),single);
        adaptador.setEnabledLikes(true);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas= new ArrayList<Mascota>();

        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,0, R.drawable.dog1));
        mascotas.add(new Mascota("Dulce","Bulldog",3,0, R.drawable.dog2));
        mascotas.add(new Mascota("Laika","Poodle",2,0, R.drawable.dog3));
        mascotas.add(new Mascota("Hassai","Labrador",1,0, R.drawable.dog4));
        mascotas.add(new Mascota("Martina","Golden",2,0, R.drawable.dog5));
        mascotas.add(new Mascota("Vianca","Beagle",3,0, R.drawable.dog6));
        mascotas.add(new Mascota("Luna","Husky",4,0, R.drawable.dog7));
        mascotas.add(new Mascota("Daiki","Rotweiller",5,0, R.drawable.dog8));
        mascotas.add(new Mascota("Tren","Doberman",6,0, R.drawable.dog9));

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas, boolean single) {
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,getActivity(),single);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void setEnabledLikes(MascotaAdaptador adaptador,boolean likes) {
        adaptador.setEnabledLikes(likes);
    }


}
