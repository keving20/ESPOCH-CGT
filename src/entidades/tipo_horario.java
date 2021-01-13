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
public class tipo_horario {
    int id_tipo_horario;
    String descripcion;

    public tipo_horario() {
    }

    public tipo_horario(int id_tipo_horario, String descripcion) {
        this.id_tipo_horario = id_tipo_horario;
        this.descripcion = descripcion;
    }

    public int getId_tipo_horario() {
        return id_tipo_horario;
    }

    public void setId_tipo_horario(int id_tipo_horario) {
        this.id_tipo_horario = id_tipo_horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
