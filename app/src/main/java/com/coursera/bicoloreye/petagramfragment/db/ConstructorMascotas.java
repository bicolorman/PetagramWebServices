package com.coursera.bicoloreye.petagramfragment.db;

import android.content.ContentValues;
import android.content.Context;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;
import com.coursera.bicoloreye.petagramfragment.db.*;


import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db= new BaseDatos(context);

        ArrayList<Mascota> mascotas= db.obtenerTodosLasMascotas();
        if(mascotas.size()==0)insertarMascotas(db);
        else return mascotas;
        return db.obtenerTodosLasMascotas();
        /*ArrayList<Contacto> contactos= new ArrayList<Contacto>();

        contactos.add(new Contacto("Oscar Gonzalez","7777771","oscar@gmail.com", R.drawable.candy_icon, 5));
        contactos.add(new Contacto("Adriana Gonzalez","7777772","adriana@gmail.com",R.drawable.forest_mushroom_icon, 3));
        contactos.add(new Contacto("Anamaria Gonzalez","7777773","anamaria@gmail.com",R.drawable.shock_rave_icon, 8));
        contactos.add(new Contacto("Andres Gonzalez","7777774","andres@gmail.com",R.drawable.yammi_banana_icon, 1));


        return contactos;*/
    }

    public ArrayList<Mascota> obtenerDatosFavoritos(){

        BaseDatos db= new BaseDatos(context);
        return db.obtenerMascotasFavoritas();

    }

    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Sasha");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Pastor Aleman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog1);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Dulce");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Bulldog");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog2);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Laika");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Poodle");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog3);
        db.insertarMascota(contentValues);



        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Hassai");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Labrador");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog4);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Martina");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Golden");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog5);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Vianca");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Beagle");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog6);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Luna");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Husky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog7);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Daiki");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Rotweiller");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog8);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Tren");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Doberman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,6);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog9);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES,LIKE);
        db.insertartLikeContacto(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db= new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);
    }
}
