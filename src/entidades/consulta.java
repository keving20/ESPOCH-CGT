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
public class consulta {
    String antecedente;
    String antecedentesel;
    BigDecimal valor;
    
    public consulta(){}

    public consulta(String antecedente, String antecedentesel, BigDecimal valor) {
        this.antecedente = antecedente;
        this.antecedentesel = antecedentesel;
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getAntecedentesel() {
        return antecedentesel;
    }

    public void setAntecedentesel(String antecedentesel) {
        this.antecedentesel = antecedentesel;
    }
    
    
}
