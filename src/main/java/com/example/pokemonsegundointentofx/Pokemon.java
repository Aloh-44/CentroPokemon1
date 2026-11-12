package com.example.pokemonsegundointentofx;

public class Pokemon {
    private String nombre;
    private int nivel;
    private String tipo;

    public Pokemon(String nombre, int nivel, String tipo){
        setNombre(nombre);
        setNivel(nivel);
        this.tipo = tipo;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();

    }
    public int getNivel(){
        return nivel;
    }

    public void setNivel(int nivel){
        if(nivel < 1 || nivel > 100){
            throw new IllegalArgumentException("El nivel debe estar entre 1 y 100.");
        }
        this.nivel = nivel;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public double getCostoCuracion(){
        double base = 5000;
        if ("Fuego".equalsIgnoreCase(tipo)){
            base = 7000;
        }
        return base + (nivel * 500);
    }
}
