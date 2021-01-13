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
public class enfermedad_catastrofica {
    int id_enfermedad;
    String codigo;
    String descripcion;

    public enfermedad_catastrofica() {
    }

    public enfermedad_catastrofica(int id_enfermedad, String codigo, String descripcion) {
        this.id_enfermedad = id_enfermedad;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_enfermedad() {
        return id_enfermedad;
    }

    public void setId_enfermedad(int id_enfermedad) {
        this.id_enfermedad = id_enfermedad;
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
