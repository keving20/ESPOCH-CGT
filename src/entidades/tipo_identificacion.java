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
public class tipo_identificacion {
    int id_identificacion;
    String codigo;
    String descripcion;

    public tipo_identificacion() {
    }

    public tipo_identificacion(int id_identificacion, String codigo, String descripcion) {
        this.id_identificacion = id_identificacion;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_identificacion() {
        return id_identificacion;
    }

    public void setId_identificacion(int id_identificacion) {
        this.id_identificacion = id_identificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
