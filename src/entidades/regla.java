/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jonathan Araujo
 */

import java.math.BigDecimal;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "ruleService")
@ApplicationScoped

public class regla {
    int id_reglas;
    String hipotesis;
    usuario objUsuario;
    BigDecimal valor;
    
    
    public regla() {
    }

    public regla(int id_reglas, String hipotesis, BigDecimal valor, usuario objUsuario) {
        this.id_reglas = id_reglas;
        this.hipotesis = hipotesis;
        this.objUsuario = objUsuario;
        this.valor = valor;
    }

    public int getId_reglas() {
        return id_reglas;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setId_reglas(int id_reglas) {
        this.id_reglas = id_reglas;
    }

    public String getHipotesis() {
        return hipotesis;
    }

    public void setHipotesis(String hipotesis) {
        this.hipotesis = hipotesis;
    }

    public usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
    
    
}
