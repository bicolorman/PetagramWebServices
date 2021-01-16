package com.coursera.bicoloreye.petagramfragment.vista.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.adapter.PostInstagramAdapter;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramPost;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramProfile;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;
import com.coursera.bicoloreye.petagramfragment.presentador.IRecyclerPerfilFragmentPresenter;
import com.coursera.bicoloreye.petagramfragment.presentador.RecyclerPerfilFragmentPresenter;
import com.google.android.material.textview.MaterialTextView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class PerfilFragment extends Fragment  implements IRecyclerPerfilFragment{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaPosts;
    private CircularImageView profile;
    private MaterialTextView username;
    private IRecyclerPerfilFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaPosts= (RecyclerView)v.findViewById(R.id.rvPosts);
        profile=(CircularImageView) v.findViewById(R.id.ciProfile);
        username=(MaterialTextView) v.findViewById(R.id.tvUsername);
        presenter = new RecyclerPerfilFragmentPresenter(this,getContext());

        return v;

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,getActivity(),true);
        adaptador.setEnabledLikes(false);
        adaptador.setEnableName(false);
        listaPosts.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas= new ArrayList<Mascota>();

        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,10, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,2, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,8, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,4, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,9, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,3, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,14, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,1, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,6, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,7, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,5, R.drawable.dog_profile_64));
        mascotas.add(new Mascota("Sasha","Pastor Aleman",4,4, R.drawable.dog_profile_64));

    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaPosts.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        listaPosts.setLayoutManager(gridLayoutManager);
    }


    @Override
    public PostInstagramAdapter crearAdaptador(ArrayList<InstagramPost> posts) {
        PostInstagramAdapter adaptador= new PostInstagramAdapter(posts,getActivity());
        return adaptador;
    }

    @Override
    public void setProfile(InstagramProfile instagramProfile) {
        Picasso.get().load(instagramProfile.getProfile_picture_url()).placeholder(R.drawable.instagrampost).into(profile);
        username.setText(instagramProfile.getUsername());
    }

    @Override
    public void inicializarAdaptadorRV(PostInstagramAdapter adaptador) {
        listaPosts.setAdapter(adaptador);
    }

    @Override
    public void setEnabledLikes(PostInstagramAdapter adaptador, boolean likes) {

    }
}