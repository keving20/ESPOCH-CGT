/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jonathan Araujo
 */
public class estado_aprobacion {
     int id_estado_aprobacion;
    String nombre_estado;
    
    public estado_aprobacion() {
    }

    public estado_aprobacion(int id_estado_aprobacion, String nombre_estado) {
        this.id_estado_aprobacion = id_estado_aprobacion;
        this.nombre_estado = nombre_estado;
    }

    public int getId_estado_aprobacion() {
        return id_estado_aprobacion;
    }

    public void setId_estado_aprobacion(int id_estado_aprobacion) {
        this.id_estado_aprobacion = id_estado_aprobacion;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
    
    
}
