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
public class usuario {
    int id_usuario;
    String cedula;
    String clave;
    String nombre;
    String apellido;
    tipo_usuario objTipousuario;

    public usuario() {
    }

    public usuario(int id_usuario, String cedula, String clave, String nombre, String apellido, tipo_usuario objTipousuario) {
        this.id_usuario = id_usuario;
        this.cedula = cedula;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.objTipousuario = objTipousuario;
    }
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public tipo_usuario getObjTipousuario() {
        return objTipousuario;
    }

    public void setObjTipousuario(tipo_usuario objTipousuario) {
        this.objTipousuario = objTipousuario;
    }

    
    
   
    
    
}
