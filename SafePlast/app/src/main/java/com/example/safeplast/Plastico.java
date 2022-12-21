package com.example.safeplast;

import com.example.safeplast.Room.PlasticoDao;
import com.example.safeplast.Room.Plasticos;
import com.example.safeplast.Room.PlasticoDataBase;

import java.util.ArrayList;
import java.util.List;

public class Plastico {
    private String nombre;
    private int cantidad;
    private String color;

    private static PlasticoDataBase plasticoDataBase;
    private static PlasticoDao plasticoDao;
    public static ArrayList<Plasticos> listadetodosPlasticos;
    public static ArrayList <Plastico> consumo;

    Plastico(String n, int cant, String c){
        this.nombre = n;
        this.cantidad=cant;
        this.color = c;
    }

    //Accesores
    public String getNombre(){
        return nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public String getColor() {
        return color;
    }

    public static void generarConsumPlasticoBeta(){
        consumo = new ArrayList<Plastico>();
        /*int countPet=0,countHdpe=0,countPvc=0,countLdpe=0,countPp=0,countPs=0,countOtros=0;
        listadetodosPlasticos = new ArrayList<Plasticos>();
        listadetodosPlasticos.addAll(plasticoDao.getAllPlasticos());
        for (Plasticos p: listadetodosPlasticos){
            String categoria = p.getCategoria();
            if(categoria.equalsIgnoreCase("PET"))
                countPet++;
            if(categoria.equalsIgnoreCase("HDPE"))
                countHdpe++;
            if(categoria.equalsIgnoreCase("PVC"))
                countPvc++;
            if(categoria.equalsIgnoreCase("LDPE"))
                countLdpe++;
            if(categoria.equalsIgnoreCase("PP"))
                countPp++;
            if(categoria.equalsIgnoreCase("PS"))
                countPs++;
            if(categoria.equalsIgnoreCase("Otros"))
                countOtros++;

        }*/
        consumo.add(new Plastico("PET", 8,"#2ba9ca"));
        consumo.add(new Plastico("HDPE", 8,"#23afa0"));
        consumo.add(new Plastico("PVC", 12,"#9ee0a9"));
        consumo.add(new Plastico("LDPE", 8,"#e5e5bb"));
        consumo.add(new Plastico("PP", 10,"#0c412e"));
        consumo.add(new Plastico("PS", 8,"#377057"));
        consumo.add(new Plastico("O", 8,"#749576"));

    }
}
