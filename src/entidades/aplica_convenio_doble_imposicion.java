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
public class aplica_convenio_doble_imposicion {
    int id_aplica_convenio;
    String codigo;
    String descripcion;

    public aplica_convenio_doble_imposicion() {
    }

    public aplica_convenio_doble_imposicion(int id_aplica_convenio, String codigo, String descripcion) {
        this.id_aplica_convenio = id_aplica_convenio;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_aplica_convenio() {
        return id_aplica_convenio;
    }

    public void setId_aplica_convenio(int id_aplica_convenio) {
        this.id_aplica_convenio = id_aplica_convenio;
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
