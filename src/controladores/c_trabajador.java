package controladores;


import entidades.trabajador;
import entidades.usuario;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelos.m_trabajador;

import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_trabajador {

    public trabajador objTrabajador;
    public trabajador objTrabajadorSel;
    public ArrayList<trabajador> listaTrabajador;
    public ArrayList<trabajador> listaTrabajador1;
    private usuario user;
    
    private void reinit() {
         this.user = (usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
      
        this.objTrabajador = new trabajador();
        this.objTrabajadorSel = new trabajador();
        this.listaTrabajador = new ArrayList<>();
        this.listaTrabajador1 = new ArrayList<>();
   
  

        this.cargarTrabajador();
    }

    public c_trabajador() {

        this.reinit();
    }

    public trabajador getObjTrabajador() {
        return objTrabajador;
    }

    public void setObjTrabajador(trabajador objTrabajador) {
        this.objTrabajador = objTrabajador;
    }

    public trabajador getObjTrabajadorSel() {
        return objTrabajadorSel;
    }

    public void setObjTrabajadorSel(trabajador objTrabajadorSel) {
        this.objTrabajadorSel = objTrabajadorSel;
    }

    public ArrayList<trabajador> getListaTrabajador() {
        return listaTrabajador;
    }

    public void setListaTrabajador(ArrayList<trabajador> listaTrabajador) {
        this.listaTrabajador = listaTrabajador;
    }

    public ArrayList<trabajador> getListaTrabajador1() {
        return listaTrabajador1;
    }

    public void setListaTrabajador1(ArrayList<trabajador> listaTrabajador1) {
        this.listaTrabajador1 = listaTrabajador1;
    }

    public usuario getUser() {
        return user;
    }

    public void setUser(usuario user) {
        this.user = user;
    }

    

    public void cargarTrabajador() {
        try {
                       
            //listaTrabajador = m_trabajador.obtenerTodosTrabajadores();
            listaTrabajador1 = m_trabajador.obtenerDependenciaTrabajador(user.getId_usuario());
         

        } catch (Exception e) {
        }
    }

    public void insertarTrabajador() {
        String message;
        try {
                boolean resultado=true;
            //boolean resultado = m_empresa.insertarEmpresa(objEmpresa);
            if (resultado == true) {
                cargarTrabajador();
                message = " HA SIDO REGISTRADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();
            } else {
                message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            recursoMensajes.addSuccessMessage(message);
        }
    }

   
 public void modificarTrabajador() {
        String message;
        try {
            boolean resultado = m_trabajador.modificarTrabajador(objTrabajadorSel);
            if (resultado == true) {
                cargarTrabajador();
                message = "DATOS ACTUALIZADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "DATOS NO ACTUALIZADOS";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ACTUALIZAR";
            recursoMensajes.addSuccessMessageLogin(message);
        }
    }
  

}