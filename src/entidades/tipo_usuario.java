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
public class tipo_usuario {
    int id_tipousuario;
    String descripcion_tusuario;

    public tipo_usuario() {
    }

    public tipo_usuario(int id_tipousuario, String descripcion_tusuario) {
        this.id_tipousuario = id_tipousuario;
        this.descripcion_tusuario = descripcion_tusuario;
    }

    public int getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public String getDescripcion_tusuario() {
        return descripcion_tusuario;
    }

    public void setDescripcion_tusuario(String descripcion_tusuario) {
        this.descripcion_tusuario = descripcion_tusuario;
    }
    
    
    
    
}
