package controladores;

import entidades.solicitudes_trab;
import entidades.trabajador;
import entidades.usuario;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelos.m_solicitudes_trab;

import modelos.m_trabajador;
import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_solicitudes_trab {

    public solicitudes_trab objSolicitudesTrab;
    public solicitudes_trab objSolicitudesTrabSel;
    public ArrayList<solicitudes_trab> listaSolicitudesTrab;
    public ArrayList<solicitudes_trab> listaSolicitudesTrab1;
    private usuario user;
    
    private void reinit() {
        this.user = (usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.objSolicitudesTrab = new solicitudes_trab();
        this.objSolicitudesTrabSel = new solicitudes_trab();
        this.listaSolicitudesTrab = new ArrayList<>();
        this.listaSolicitudesTrab1 = new ArrayList<>();
   
  

        this.cargarSolicitudesTrab();
    }

    public c_solicitudes_trab() {

        this.reinit();
    }

    public solicitudes_trab getObjSolicitudesTrab() {
        return objSolicitudesTrab;
    }

    public void setObjSolicitudesTrab(solicitudes_trab objSolicitudesTrab) {
        this.objSolicitudesTrab = objSolicitudesTrab;
    }

    public solicitudes_trab getObjSolicitudesTrabSel() {
        return objSolicitudesTrabSel;
    }

    public void setObjSolicitudesTrabSel(solicitudes_trab objSolicitudesTrabSel) {
        this.objSolicitudesTrabSel = objSolicitudesTrabSel;
    }

    public ArrayList<solicitudes_trab> getListaSolicitudesTrab() {
        return listaSolicitudesTrab;
    }

    public void setListaSolicitudesTrab(ArrayList<solicitudes_trab> listaSolicitudesTrab) {
        this.listaSolicitudesTrab = listaSolicitudesTrab;
    }

    public ArrayList<solicitudes_trab> getListaSolicitudesTrab1() {
        return listaSolicitudesTrab1;
    }

    public void setListaSolicitudesTrab1(ArrayList<solicitudes_trab> listaSolicitudesTrab1) {
        this.listaSolicitudesTrab1 = listaSolicitudesTrab1;
    }

    public usuario getUser() {
        return user;
    }

    public void setUser(usuario user) {
        this.user = user;
    }
    

    public void cargarSolicitudesTrab() {
        try {
            
            int num_trabajador = m_solicitudes_trab.traerIdTrabajador(user.getId_usuario());
            
            listaSolicitudesTrab = m_solicitudes_trab.obtenerSolicitudesTrab(num_trabajador);
        //    listaTrabajador1 = m_trabajador.obtenerTodosTrabajadores();
         

        } catch (Exception e) {
        }
    }

   public void eliminarSolicitud(int id_solicitud) {
        String message;
        try {
            boolean resultado = m_solicitudes_trab.eliminarSolicitud(objSolicitudesTrabSel.getId_solicitud_t());
            if (resultado == true) {
                cargarSolicitudesTrab();
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