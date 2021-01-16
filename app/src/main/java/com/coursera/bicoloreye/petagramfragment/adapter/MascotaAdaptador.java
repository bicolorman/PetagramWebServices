package com.coursera.bicoloreye.petagramfragment.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.db.ConstructorMascotas;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;
    private boolean enabledLikes;
    private boolean enabledNames;
    private boolean single;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity, boolean single){
        this.mascotas=mascotas;
        this.activity=activity;
        this.enabledNames=true;
        this.single=single;
    }



    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate( (!single)?R.layout.cardview_mascota:R.layout.cardview_mascota_single,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=mascotas.get(position);
        Log.i("Mascota->"+position,mascota.toString());

        Log.i("mascotaViewHolder->",mascotaViewHolder.toString());
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        if(enabledNames)
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvlikes.setText(""+mascota.getLikes());

        if(enabledLikes)
        mascotaViewHolder.btnLikeMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Diste Like a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
                //mascotaViewHolder.tvlikes.setText(mascota.setLike()+"");
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvlikes.setText(constructorMascotas.obtenerLikesMascota(mascota)+"");
            }
        });


    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public void setEnableName(boolean name){ this.enabledNames=name; }

    public boolean isEnabledName() {
        return enabledNames;
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public boolean isEnabledLikes() {
        return enabledLikes;
    }

    public void setEnabledLikes(boolean enabledLikes) {
        this.enabledLikes = enabledLikes;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFotoMascota,imgLikeMascota;
        private ImageButton btnLikeMascota;
        private TextView tvNombreMascota,tvlikes;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoMascota=(ImageView)itemView.findViewById(R.id.imgFotoMascota);
            imgLikeMascota=(ImageView)itemView.findViewById(R.id.imgLikeMascota);
            tvNombreMascota=(TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvlikes=(TextView) itemView.findViewById(R.id.tvlikes);
            btnLikeMascota= (ImageButton)itemView.findViewById(R.id.btnLikeMascota);
        }
    }
}
