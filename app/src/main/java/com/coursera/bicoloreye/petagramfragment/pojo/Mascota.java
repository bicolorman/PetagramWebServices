package com.coursera.bicoloreye.petagramfragment.pojo;

public class Mascota implements Comparable<Mascota>{
    private String nombre;
    private String raza;
    private int edad;
    private int likes;
    private int foto;
    private int id;

    public Mascota(String nombre, String raza, int edad, int likes, int foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.likes = likes;
        this.foto = foto;
    }

    public Mascota() {
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int setLike(){
        this.likes++;
        return likes;
    }



    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", foto=" + foto +
                '}';
    }

    @Override
    public int compareTo(Mascota mascota) {
        if(this.getLikes()<mascota.getLikes())return -1;
        else if(this.getLikes()>mascota.getLikes())return 1;
        else return 0;

    }
}
