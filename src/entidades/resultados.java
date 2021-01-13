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
public class resultados {
    String resultado;
    int coincidencia;
    BigDecimal valor;
    BigDecimal v_hecho;
    public resultados(){
    }

    public resultados(String resultado,BigDecimal v_hecho, int coincidencia, BigDecimal valor) {
        this.resultado = resultado;
        this.coincidencia = coincidencia;
        this.valor = valor;
        this.v_hecho = v_hecho;
    }

    public String getResultado() {
        return resultado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getV_hecho() {
        return v_hecho;
    }

    public void setV_hecho(BigDecimal v_hecho) {
        this.v_hecho = v_hecho;
    }
    
    

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getCoincidencia() {
        return coincidencia;
    }

    public void setCoincidencia(int coincidencia) {
        this.coincidencia = coincidencia;
    }
    
    
}
