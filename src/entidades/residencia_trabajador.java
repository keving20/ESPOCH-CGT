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
public class residencia_trabajador {
    int id_residencia;
    String codigo;
    String descripcion;

    public residencia_trabajador() {
    }

    public residencia_trabajador(int id_residencia, String codigo, String descripcion) {
        this.id_residencia = id_residencia;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_residencia() {
        return id_residencia;
    }

    public void setId_residencia(int id_residencia) {
        this.id_residencia = id_residencia;
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
