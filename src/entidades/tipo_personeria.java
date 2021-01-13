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
public class tipo_personeria {
    int id_tipo_personeria;
    String descripcion;

    public tipo_personeria() {
    }

    public tipo_personeria(int id_tipo_personeria, String descripcion) {
        this.id_tipo_personeria = id_tipo_personeria;
        this.descripcion = descripcion;
    }

    public int getId_tipo_personeria() {
        return id_tipo_personeria;
    }

    public void setId_tipo_personeria(int id_tipo_personeria) {
        this.id_tipo_personeria = id_tipo_personeria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
