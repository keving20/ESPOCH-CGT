/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author USER
 */
public class actividad_economica {
    int id_actividad_economica;
    String descripcion;

    public actividad_economica() {
    }

    public actividad_economica(int id_actividad_economica, String descripcion) {
        this.id_actividad_economica = id_actividad_economica;
        this.descripcion = descripcion;
    }

    public int getId_actividad_economica() {
        return id_actividad_economica;
    }

    public void setId_actividad_economica(int id_actividad_economica) {
        this.id_actividad_economica = id_actividad_economica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
