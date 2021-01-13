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
public class tipo_contrato {
    int tipo_contrato;
    String descripcion;

    public tipo_contrato() {
    }

    public tipo_contrato(int tipo_contrato, String descripcion) {
        this.tipo_contrato = tipo_contrato;
        this.descripcion = descripcion;
    }

    public int getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(int tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
