package com.example.safeplast.Room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
public class Plasticos implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nombre;

    private String descripcion;

    private String usuario;

    private String origen;

    private String ubicacion;

    private String categoria;

    private int fotografia;

    public Plasticos(int id, String nombre, String descripcion, String usuario, String origen, String ubicacion, String categoria, int fotografia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.origen = origen;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.fotografia = fotografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getFotografia() {
        return fotografia;
    }

    public void setFotografia(int fotografia) {
        this.fotografia = fotografia;
    }
}
