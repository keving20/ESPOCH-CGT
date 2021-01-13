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
public class beneficio_provincia_galapagos {
    int id_beneficio_galapagos;
    String codigo;
    String descripcion;

    public beneficio_provincia_galapagos() {
    }

    public beneficio_provincia_galapagos(int id_beneficio_galapagos, String codigo, String descripcion) {
        this.id_beneficio_galapagos = id_beneficio_galapagos;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_beneficio_galapagos() {
        return id_beneficio_galapagos;
    }

    public void setId_beneficio_galapagos(int id_beneficio_galapagos) {
        this.id_beneficio_galapagos = id_beneficio_galapagos;
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
