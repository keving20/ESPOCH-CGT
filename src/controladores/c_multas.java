/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author Jonathan Araujo
 */
import entidades.horarios;
import entidades.multas;
import recursos.recursoMensajes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelos.m_multas;

@ViewScoped
@ManagedBean
public class c_multas {

    public multas objMultas;
    public multas objMultasSel;

    public ArrayList<multas> listaMultas;
    public ArrayList<multas> listaMultas1;
    public ArrayList<multas> listaMultasSel;

    private void reinit() {

        this.objMultas = new multas();
        this.objMultasSel = new multas();

        listaMultas = new ArrayList<>();

        this.cargarMultas();

    }

    public void cargarMultas() {

        try {
            listaMultas = m_multas.obtenerTodosMultas();

        } catch (Exception e) {
        }
    }

    public c_multas() {
        this.reinit();
    } 

    public multas getObjMultas() {
        return objMultas;
    }

    public void setObjMultas(multas objMultas) {
        this.objMultas = objMultas;
    }

    public multas getObjMultasSel() {
        return objMultasSel;
    }

    public void setObjMultasSel(multas objMultasSel) {
        this.objMultasSel = objMultasSel;
    }

    public ArrayList<multas> getListaMultas() {
        return listaMultas;
    }

    public void setListaMultas(ArrayList<multas> listaMultas) {
        this.listaMultas = listaMultas;
    }

    public ArrayList<multas> getListaMultas1() {
        return listaMultas1;
    }

    public void setListaMultas1(ArrayList<multas> listaMultas1) {
        this.listaMultas1 = listaMultas1;
    }

    public ArrayList<multas> getListaMultasSel() {
        return listaMultasSel;
    }

    public void setListaMultasSel(ArrayList<multas> listaMultasSel) {
        this.listaMultasSel = listaMultasSel;
    }
    
     public void modificarMultas() throws ParseException {
        String message;
        
        try {
            boolean resultado = m_multas.modificarMultas(objMultasSel);
            if (resultado == true) {
                cargarMultas();
                message = "DATOS ACTUALIZADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);

            } else {
                message = "DATOS NO ACTUALIZADOS";
                recursoMensajes.addSuccessMessage(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ACTUALIZAR";
            recursoMensajes.addSuccessMessage(message);
        }
    }
    
    
}
