package controladores;

import entidades.anuncios;
import entidades.solicitudes_trab;
import entidades.trabajador;
import entidades.usuario;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelos.m_anuncios;
import modelos.m_solicitudes_trab;

import modelos.m_trabajador;
import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_anuncios {

    public anuncios objAnuncios;
    public anuncios objAnunciosSel;
    public ArrayList<anuncios> listaAnuncios;
    public ArrayList<anuncios> listaAnuncios1;
    private usuario user;
    
    private void reinit() {
        this.user = (usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.objAnuncios = new anuncios();
        this.objAnunciosSel = new anuncios();
        this.listaAnuncios = new ArrayList<>();
        this.listaAnuncios1 = new ArrayList<>();
   
        this.cargarAnuncios();
    }

    public c_anuncios() {
        this.reinit();
    }

    public anuncios getObjAnuncios() {
        return objAnuncios;
    }

    public void setObjAnuncios(anuncios objAnuncios) {
        this.objAnuncios = objAnuncios;
    }

    public anuncios getObjAnunciosSel() {
        return objAnunciosSel;
    }

    public void setObjAnunciosSel(anuncios objAnunciosSel) {
        this.objAnunciosSel = objAnunciosSel;
    }

    public ArrayList<anuncios> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(ArrayList<anuncios> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    public ArrayList<anuncios> getListaAnuncios1() {
        return listaAnuncios1;
    }

    public void setListaAnuncios1(ArrayList<anuncios> listaAnuncios1) {
        this.listaAnuncios1 = listaAnuncios1;
    }   

    public usuario getUser() {
        return user;
    }

    public void setUser(usuario user) {
        this.user = user;
    }
    

    public void cargarAnuncios() {
        try {
            
            int num_empresa = m_anuncios.traerIdEmpresa(user.getId_usuario());
            
            listaAnuncios = m_anuncios.obtenerAnuncios(num_empresa);
        //    listaTrabajador1 = m_trabajador.obtenerTodosTrabajadores();
         

        } catch (Exception e) {
        }
    }

     public void insertarAnuncio() {
        String message;       
        
        try {
            int num_empresa = m_anuncios.traerIdEmpresa(user.getId_usuario());
            boolean resultado = m_anuncios.insertarAnuncio(num_empresa, objAnuncios);
            if (resultado == true) {
                cargarAnuncios();
                message = "¡" + user.getNombre() + user.getApellido() +" SU ANUNCIO HA SIDO REGISTRADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();
            } else {
                 message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡ERROR, NO SE PUDO INGRESAR EL ANUNCIO!";
           
            recursoMensajes.addSuccessMessage(message);
        }
    }
    
   public void eliminarAnuncio() {
        String message;
        try {
            boolean resultado = m_anuncios.eliminarAnuncio(objAnunciosSel.getId_oferta());
            if (resultado == true) {
                cargarAnuncios();
                message = "ANUNCIO ELIMINADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "NO SE HA PODIDO ELIMINAR EL ANUNCIO!";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR AL ELIMINAR DATOS";
            recursoMensajes.addSuccessMessageLogin(message);

        }
    }

    public void modificarAnuncio() {
    
        String message;
        try {
            boolean resultado = m_anuncios.modificarAnuncio(objAnunciosSel);
            if (resultado == true) {
                cargarAnuncios();
                message = "ANUNCIO ACTUALIZADO CON ÉXITO";
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

}