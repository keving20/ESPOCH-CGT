/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jonathan Araujo
 */
public class antecedentes {
    int id_antecedente;
    String descripcion;
    int id_regla;
    String hipotesis;
    int id_usuario;
    String cedula;
    BigDecimal valor;
    
    public antecedentes(){
    }

    public antecedentes(int id_antecedente, String descripcion, int id_regla, String hipotesis, int id_usuario, String cedula, BigDecimal valor) {
        this.id_antecedente = id_antecedente;
        this.descripcion = descripcion;
        this.id_regla = id_regla;
        this.hipotesis = hipotesis;
        this.id_usuario = id_usuario;
        this.cedula = cedula;
        this.valor = valor;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_regla() {
        return id_regla;
    }

    public void setId_regla(int id_regla) {
        this.id_regla = id_regla;
    }

    public String getHipotesis() {
        return hipotesis;
    }

    public void setHipotesis(String hipotesis) {
        this.hipotesis = hipotesis;
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

   
    
    
}
