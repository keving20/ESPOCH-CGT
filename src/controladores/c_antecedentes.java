/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import entidades.antecedentes;
import entidades.regla;
import controladores.c_regla;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelos.m_antecedentes;
import recursos.recursoMensajes;
/**
 *
 * @author Jonathan Araujo
 */

@ViewScoped
@ManagedBean
public class c_antecedentes {
    public antecedentes objAntecedente;
    public antecedentes objAntecedenteSel;
    public ArrayList<antecedentes> listaAntecedente;
    
    private void reinit(){
    this.objAntecedente = new antecedentes();
    this.objAntecedenteSel = new antecedentes();
    this.listaAntecedente = new ArrayList<>();
    
    this.cargarAntecedentes();   
    }
    
    public c_antecedentes(){
        this.reinit();
    }

    public antecedentes getObjAntecedente() {
        return objAntecedente;
    }

    public void setObjAntecedente(antecedentes objAntecedente) {
        this.objAntecedente = objAntecedente;
    }

    public antecedentes getObjAntecedenteSel() {
        return objAntecedenteSel;
    }

    public void setObjAntecedenteSel(antecedentes objAntecedenteSel) {
        this.objAntecedenteSel = objAntecedenteSel;
    }

    public ArrayList<antecedentes> getListaAntecedente() {
        return listaAntecedente;
    }

    public void setListaAntecedente(ArrayList<antecedentes> listaAntecedente) {
        this.listaAntecedente = listaAntecedente;
    }
    
    public void cargarAntecedentes(){
        try {
         listaAntecedente = m_antecedentes.obtenerTodosAntecedentes();
         
        } catch (Exception e) {
        } 
    }
}
