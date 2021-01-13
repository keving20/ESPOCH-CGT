package controladores;

import entidades.solicitudes_empresa;
import entidades.solicitudes_trab;
import entidades.trabajador;
import entidades.usuario;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelos.m_anuncios;
import modelos.m_solicitudes_empresa;
import modelos.m_solicitudes_trab;

import modelos.m_trabajador;
import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_solicitudes_empresa {

    public solicitudes_empresa objSolicitudesEmpresa;
    public solicitudes_empresa objSolicitudesEmpresaSel;
    public ArrayList<solicitudes_empresa> listaSolicitudesEmpresa;
    public ArrayList<solicitudes_empresa> listaSolicitudesEmpresa1;
    private usuario user;
    
    private void reinit() {
        this.user = (usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.objSolicitudesEmpresa = new solicitudes_empresa();
        this.objSolicitudesEmpresaSel = new solicitudes_empresa();
        this.listaSolicitudesEmpresa = new ArrayList<>();
        this.listaSolicitudesEmpresa1 = new ArrayList<>();
   
  

        this.cargarSolicitudesEmpresa();
    }

    public c_solicitudes_empresa() {

        this.reinit();
    }

    public solicitudes_empresa getObjSolicitudesEmpresa() {
        return objSolicitudesEmpresa;
    }

    public void setObjSolicitudesEmpresa(solicitudes_empresa objSolicitudesEmpresa) {
        this.objSolicitudesEmpresa = objSolicitudesEmpresa;
    }

    public solicitudes_empresa getObjSolicitudesEmpresaSel() {
        return objSolicitudesEmpresaSel;
    }

    public void setObjSolicitudesEmpresaSel(solicitudes_empresa objSolicitudesEmpresaSel) {
        this.objSolicitudesEmpresaSel = objSolicitudesEmpresaSel;
    }

    public ArrayList<solicitudes_empresa> getListaSolicitudesEmpresa() {
        return listaSolicitudesEmpresa;
    }

    public void setListaSolicitudesEmpresa(ArrayList<solicitudes_empresa> listaSolicitudesEmpresa) {
        this.listaSolicitudesEmpresa = listaSolicitudesEmpresa;
    }

    public ArrayList<solicitudes_empresa> getListaSolicitudesEmpresa1() {
        return listaSolicitudesEmpresa1;
    }

    public void setListaSolicitudesEmpresa1(ArrayList<solicitudes_empresa> listaSolicitudesEmpresa1) {
        this.listaSolicitudesEmpresa1 = listaSolicitudesEmpresa1;
    }

    
    public usuario getUser() {
        return user;
    }

    public void setUser(usuario user) {
        this.user = user;
    }
    

    public void cargarSolicitudesEmpresa() {
        try {
            
             int num_empresa = m_anuncios.traerIdEmpresa(user.getId_usuario());
             
            listaSolicitudesEmpresa = m_solicitudes_empresa.obtenerSolicitudesEmpresa(num_empresa);
        //    listaTrabajador1 = m_trabajador.obtenerTodosTrabajadores();
         

        } catch (Exception e) {
        }
    }

   public void eliminarSolicitud(int id_solicitud) {
        String message;
        try {
            boolean resultado = m_solicitudes_empresa.eliminarSolicitud(objSolicitudesEmpresaSel.getId_solicitud_t());
            if (resultado == true) {
                cargarSolicitudesEmpresa();
                message = "SOLICITUD ELIMINADA CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "NO SE HA PODIDO ELIMINAR SOLICITUD";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR AL ELIMINAR DATOS";
            recursoMensajes.addSuccessMessageLogin(message);

        }
    }

  

}