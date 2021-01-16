package com.coursera.bicoloreye.petagramfragment.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.coursera.bicoloreye.petagramfragment.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto ="CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_RAZA+" TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_EDAD+" INTEGER, "+
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" INTEGER"+
                ")";
        String queryCrearTablaLikesContacto="CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA+" INTEGER, "+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+" INTEGER, "+
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA+") "+
                "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTA + "("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"+
                ")";
        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_MASCOTA);
       db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);

    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas= new ArrayList<>(), mascotas5= new ArrayList<>();
        String query= "SELECT * FROM "+ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =     db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota mascotaActual= new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaza(registros.getString(2));
            mascotaActual.setEdad(registros.getInt(3));
            mascotaActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes "+
                    " FROM "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLikes= db.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        Collections.sort(mascotas,Collections.reverseOrder());
        for (int i = 0; i <5 ; i++) {
            mascotas5.add(mascotas.get(i));
        }
        return mascotas5;
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas= new ArrayList<>();
        String query= "SELECT * FROM "+ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =     db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota mascotaActual= new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaza(registros.getString(2));
            mascotaActual.setEdad(registros.getInt(3));
            mascotaActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes "+
                                " FROM "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLikes= db.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null, contentValues);
        db.close();
    }

    public void insertartLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA,null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Mascota mascota){
        int likes=0;

        String query= "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")"+
                " FROM "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                " WHERE "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +"="+mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
            likes=registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
