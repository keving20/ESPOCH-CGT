/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import entidades.empresa;
import entidades.usuario;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelos.m_empresa;

import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_empresa {

    public empresa objEmpresa;
    public empresa objEmpresaSel;
    public ArrayList<empresa> listaEmpresa;
    public ArrayList<empresa> listaEmpresa1;
    private usuario user;
    
    private void reinit() {
        this.user = (usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.objEmpresa = new empresa();
        this.objEmpresaSel = new empresa();
        this.listaEmpresa = new ArrayList<>();
        this.listaEmpresa1 = new ArrayList<>();
   
  

        this.cargarEmpresa();
    }

    public c_empresa() {

        this.reinit();
    }

    public empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public empresa getObjEmpresaSel() {
        return objEmpresaSel;
    }

    public void setObjEmpresaSel(empresa objEmpresaSel) {
        this.objEmpresaSel = objEmpresaSel;
    }

    public ArrayList<empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(ArrayList<empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public ArrayList<empresa> getListaEmpresa1() {
        return listaEmpresa1;
    }

    public void setListaEmpresa1(ArrayList<empresa> listaEmpresa1) {
        this.listaEmpresa1 = listaEmpresa1;
    }

    public usuario getUser() {
        return user;
    }

    public void setUser(usuario user) {
        this.user = user;
    }
    

    public void cargarEmpresa() {
        try {

           // listaEmpresa = m_empresa.obtenerTodosempresa();
            listaEmpresa1 = m_empresa.obtenerDependenciaEmpresa(user.getId_usuario());
         

        } catch (Exception e) {
        }
    }

    public void insertarEmpresa() {
        String message;
        try {

            boolean resultado = m_empresa.insertarEmpresa(objEmpresa);
            if (resultado == true) {
                cargarEmpresa();
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

    public void modificarEmpresa() {
        String message;
        try {
            boolean resultado = m_empresa.modificarEmpresa(objEmpresaSel);
            if (resultado == true) {
                cargarEmpresa();
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

    public void eliminarEmpresa() {
        String message;
        try {
            boolean resultado = m_empresa.eliminarEmpresa(objEmpresaSel.getId_empresa());
            if (resultado == true) {
                cargarEmpresa();
                message = "EMPRESA ELIMINADA CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "EMPRESA NO SE  ELIMINO";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR AL ELIMINAR EMPRESA";
            recursoMensajes.addSuccessMessageLogin(message);

        }
    }

}
