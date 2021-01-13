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
public class multas {
    int id_multas;
    BigDecimal valor;
    int cant_multas;
    public multas() {
    }

    public multas(int id_multas, BigDecimal valor, int cant_multas) {
        this.id_multas = id_multas;
        this.valor = valor;
        this.cant_multas = cant_multas;
    }

    public int getId_multas() {
        return id_multas;
    }

    public void setId_multas(int id_multas) {
        this.id_multas = id_multas;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getCant_multas() {
        return cant_multas;
    }

    public void setCant_multas(int cant_multas) {
        this.cant_multas = cant_multas;
    }
     
    
}
