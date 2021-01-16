package com.coursera.bicoloreye.petagramfragment.vista.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;
import com.coursera.bicoloreye.petagramfragment.presentador.FavoritosActivityPresenter;
import com.coursera.bicoloreye.petagramfragment.presentador.IFavoritosActivityPresenter;
import com.coursera.bicoloreye.petagramfragment.presentador.IRecyclerViewFragmentPresenter;
import com.coursera.bicoloreye.petagramfragment.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity  implements IFavoritosActivityView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IFavoritosActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miactionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // ((ImageButton) findViewById(R.id.imgBtnFavoritos)).setVisibility(ImageButton.INVISIBLE);

        listaMascotas= (RecyclerView)findViewById(R.id.rvMascotas);
        presenter = new FavoritosActivityPresenter(this,getBaseContext());








        //LinearLayoutManager llm= new LinearLayoutManager(this);
        //llm.setOrientation(RecyclerView.VERTICAL);

        //listaMascotas.setLayoutManager(llm);

        //inicializarListaMascotas();

        //inicializarAdaptador();


    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,this,false);
        adaptador.setEnabledLikes(false);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas= new ArrayList<Mascota>();

        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,10, R.drawable.dog1));

        mascotas.add(new Mascota("Laika","Poodle",2,9, R.drawable.dog3));

        mascotas.add(new Mascota("Martina","Golden",2,8, R.drawable.dog5));

        mascotas.add(new Mascota("Luna","Husky",4,7, R.drawable.dog7));

        mascotas.add(new Mascota("Tren","Doberman",6,6, R.drawable.dog9));

    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm= new LinearLayoutManager(getBaseContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas, boolean single) {
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,this,single);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void setEnabledLikes(MascotaAdaptador adaptador, boolean likes) {
        adaptador.setEnabledLikes(likes);
    }








}