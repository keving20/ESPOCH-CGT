/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.usuario;
import entidades.tipo_usuario;

import java.util.ArrayList;
import javafx.scene.control.Alert;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelos.m_usuario;
import modelos.m_tipo_usuario;

import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_usuario {

    public usuario objUsuario;
    public usuario objUsuarioSel;
    public tipo_usuario objTipoUsuario;

    public ArrayList<usuario> listaUsuario;
    public ArrayList<tipo_usuario> listaTipoUsuario;

    private void reinit() {
        this.objUsuario = new usuario();
        this.objUsuarioSel = new usuario();
        this.objTipoUsuario = new tipo_usuario();

        objUsuario.setObjTipousuario(objTipoUsuario);
        objUsuarioSel.setObjTipousuario(objTipoUsuario);

        listaTipoUsuario = new ArrayList<>();

        this.cargarUsuario();
    }

    public c_usuario() {
        this.reinit();

    }

    public usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public usuario getObjUsuarioSel() {
        return objUsuarioSel;
    }

    public void setObjUsuarioSel(usuario objUsuarioSel) {
        this.objUsuarioSel = objUsuarioSel;
    }

    public ArrayList<usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public void cargarUsuario() {
        try {
            listaUsuario = m_usuario.obtenerTodosusuario();
            //  listaTipoUsuario = m_tipo_usuario.obtenerTodosTipos();
        } catch (Exception e) {
        }
    }

    public void insertarAdmin() {
        String message;
        objTipoUsuario.setId_tipousuario(1);
        objUsuario.setObjTipousuario(objTipoUsuario);
        try {

            boolean resultado = m_usuario.insertarUsuario(objUsuario);
            if (resultado == true) {
                cargarUsuario();
                message = "¡" + objUsuario.getNombre() + objUsuario.getApellido() + " HA SIDO REGISTRADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();
            } else {
                message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡ERROR, LA CÉDULA YA EXISTE!";

            recursoMensajes.addSuccessMessage(message);
        }
    }

    public void insertarUser() {
        String message;

        try {

            boolean resultado = m_usuario.insertarUsuario(objUsuario);

            if (resultado == true) {

                // trae el último registro de usuario el cual será el id_usuario 
                 int id_usuario = m_usuario.traerUltimoId();
                        
                if (objUsuario.getObjTipousuario().getId_tipousuario() == 2) {
                    //Crear trabajador
                    boolean resultado2 = m_usuario.insertarTrabajador(id_usuario);
                    
                }
                
                 if (objUsuario.getObjTipousuario().getId_tipousuario() == 3) {
                    //Crear empresa
                    boolean resultado2 = m_usuario.insertarEmpresa(id_usuario);
                }

                message = "¡HA SIDO REGISTRADO CON ÉXITO! Por Favor Inicie Sesión";
                recursoMensajes.addSuccessMessage(message);

                // String url;
                //   FacesContext fc = FacesContext.getCurrentInstance();
                //   url = "/BOLSA_EMPLEO/index.xhtml"; //url donde se redirige la pantall
                //   fc.getExternalContext().redirect(url);//redirecciona la página
            } else {
                message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡ERROR, LA CÉDULA YA EXISTE!";

            recursoMensajes.addSuccessMessage(message);
        }
    }

    public void modificarUsuario() {

        String message;
        try {
            boolean resultado = m_usuario.modificarUsuario(objUsuarioSel);
            if (resultado == true) {
                cargarUsuario();
                message = "DATOS ACTUALIZADOS CON ÉXITO";
                System.out.println(message);
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "DATOS NO ACTUALIZADOS";
                recursoMensajes.addSuccessMessageLogin(message);
                System.out.println(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ACTUALIZAR";
            recursoMensajes.addSuccessMessageLogin(message);
            System.out.println(message);
        }
    }

    public void eliminarUsuario() {
        String message;
        try {
            boolean resultado = m_usuario.eliminarUsuario(objUsuarioSel.getId_usuario());
            if (resultado == true) {
                cargarUsuario();
                message = "DATOS ELIMINADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "DATOS NO SE  ELIMINO";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR AL ELIMINAR DATOS";
            recursoMensajes.addSuccessMessageLogin(message);

        }
    }

}
