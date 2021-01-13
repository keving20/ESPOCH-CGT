/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.regla;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelos.m_reglas;
import recursos.recursoMensajes;

/**
 *
 * @author Jonathan Araujo
 */

@ViewScoped
@ManagedBean
public class c_regla {

    public regla objRegla;
    public regla objReglaSel;

    public ArrayList<regla> listaRegla;
    public ArrayList<regla> listaRegla1;
    public ArrayList<regla> ListaReglaSel;

    private void reinit() {

        this.objRegla = new regla();
        this.objReglaSel = new regla();

        listaRegla = new ArrayList<>();

        this.cargarReglas();
    }

    public void cargarReglas() {

        try {
            listaRegla = m_reglas.obtenerTodosReglas();

        } catch (Exception e) {
        }

    }

    public c_regla() {
        this.reinit();
    }

    public regla getObjRegla() {
        return objRegla;
    }

    public void setObjRegla(regla objRegla) {
        this.objRegla = objRegla;
    }

    public regla getObjReglaSel() {
        return objReglaSel;
    }

    public void setObjReglaSel(regla objReglaSel) {
        this.objReglaSel = objReglaSel;
    }

    public ArrayList<regla> getListaRegla() {
        return listaRegla;
    }

    public void setListaRegla(ArrayList<regla> listaRegla) {
        this.listaRegla = listaRegla;
    }

    public ArrayList<regla> getListaRegla1() {
        return listaRegla1;
    }

    public void setListaRegla1(ArrayList<regla> listaRegla1) {
        this.listaRegla1 = listaRegla1;
    }

    public ArrayList<regla> getListaReglaSel() {
        return ListaReglaSel;
    }

    public void setListaReglaSel(ArrayList<regla> ListaReglaSel) {
        this.ListaReglaSel = ListaReglaSel;
    }

    public void ingresarRegla(int id) {
        String message; 
        try {

            boolean resultado = m_reglas.NuevaRegla(objRegla,id);
            if (resultado == true) {
                cargarReglas();
                message = "¡Se ha Ingresado correctamente " ;
                recursoMensajes.addSuccessMessage(message);
             
            } else {
                message = "¡Registro no Completado!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            recursoMensajes.addSuccessMessage(message);
        }
    }
    
     public void ingresarAnt(int iduser, int idregla, String antecedente, BigDecimal valor) {
        
         
        String message; 
        try {

            boolean resultado = m_reglas.NuevoAnt(iduser,idregla,antecedente,valor);
            if (resultado == true) {
                cargarReglas();
                message = "¡Se ha Ingresado correctamente " ;
                recursoMensajes.addSuccessMessage(message);
             
            } else {
                message = "¡Registro no Completado!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            recursoMensajes.addSuccessMessage(message);
        }
    }
    
     public void modificarRegla() {
          String message; 
        try {
            boolean resultado = m_reglas.modificarRegla(objReglaSel);
            if (resultado == true) {
                cargarReglas();
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
     
      public void eliminarRegla() {
          String message; 
        try {
            boolean resultado = m_reglas.eliminarRegla(objReglaSel);
            if (resultado == true) {
                cargarReglas();
                message = "DATOS ELIMINADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);

            } else {
                message = "DATOS NO ELIMININADOS";
                recursoMensajes.addSuccessMessage(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ELIMINAR";
            recursoMensajes.addSuccessMessage(message);
        }

    }
       public void eliminarAnt(int id) {
          String message; 
        try {
            boolean resultado = m_reglas.eliminarAnt(id);
            if (resultado == true) {
                cargarReglas();
                message = "DATOS ELIMINADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);

            } else {
                message = "DATOS NO ELIMININADOS";
                recursoMensajes.addSuccessMessage(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ELIMINAR";
            recursoMensajes.addSuccessMessage(message);
        }

    }
       
         public void modificarAnt(int id, String descripcion, BigDecimal valor) {
          String message; 
        try {
            boolean resultado = m_reglas.modificarAnt(id,descripcion,valor);
            if (resultado == true) {
                cargarReglas();
                message = "DATOS MODIFICADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);

            } else {
                message = "DATOS NO MODIFICADOS";
                recursoMensajes.addSuccessMessage(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS MODIFICAR";
            recursoMensajes.addSuccessMessage(message);
        }

    }
      
}
