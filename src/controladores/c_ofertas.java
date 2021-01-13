package controladores;

import entidades.empresa;
import entidades.ofertas;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelos.m_empresa;
import modelos.m_ofertas;
import modelos.m_trabajador;
import modelos.m_usuario;
import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_ofertas {

    public ofertas objOfertas;
    public ofertas objOfertasSel;
    public ArrayList<ofertas> listaOfertas;
    public ArrayList<ofertas> listaOfertas1;

    private void reinit() {
        this.objOfertas = new ofertas();
        this.objOfertasSel = new ofertas();
        this.listaOfertas = new ArrayList<>();
        this.listaOfertas1 = new ArrayList<>();

        this.cargarOfertas();
    }

    public c_ofertas() {

        this.reinit();
    }

    public ofertas getObjOfertas() {
        return objOfertas;
    }

    public void setObjOfertas(ofertas objOfertas) {
        this.objOfertas = objOfertas;
    }

    public ofertas getObjOfertasSel() {
        return objOfertasSel;
    }

    public void setObjOfertasSel(ofertas objOfertasSel) {
        this.objOfertasSel = objOfertasSel;
    }

    public ArrayList<ofertas> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(ArrayList<ofertas> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }

    public ArrayList<ofertas> getListaOfertas1() {
        return listaOfertas1;
    }

    public void setListaOfertas1(ArrayList<ofertas> listaOfertas1) {
        this.listaOfertas1 = listaOfertas1;
    }

    public void cargarOfertas() {
        try {

            listaOfertas = m_ofertas.obtenerTodosOfertas();
            //listaEmpresa1 = m_empresa.obtenerTodosempresa();

        } catch (Exception e) {
        }
    }

    public void postularOferta(int usuario, int id_oferta) {
        String message;

        try {

            int num_trabajador = m_trabajador.traerIdTrabajador(usuario); //Envia el Usuario y trae el id de trabajador
            boolean existente = m_trabajador.existeSolicitud(num_trabajador, id_oferta);
            if (existente == true) {
                message = "ERROR! UD YA HA POSTULADO ANTERIORMENTE A ESTA OFERTA";
                recursoMensajes.addSuccessMessage(message);
            } else {
                if (m_trabajador.ingresarSolicitud(num_trabajador, id_oferta)) {
                    message = "UD HA POSTULADO EXITOSAMENTE A ESTE EMPLEO! Espere a que: " + objOfertasSel.getEmpresa() + " lo contacte!";
                    recursoMensajes.addSuccessMessage(message);
                }
                else{
                message = "Error! No se guardó";
                    recursoMensajes.addErrorMessage(message);
                }
            }

            //if (resultado == true) {
            //    cargarUsuario();
            //  message = "¡" + objUsuario.getNombre()+objUsuario.getApellido()+ " HA SIDO REGISTRADO CON ÉXITO!";
            //  recursoMensajes.addSuccessMessage(message);
            //   this.reinit();
            // } else {
            //     message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            //     recursoMensajes.addSuccessMessage(message);
            // }
        } catch (Exception e) {
            message = "¡ERROR, NO ES POSIBLE POSTULAR!";

            recursoMensajes.addErrorMessage(message);
        }
    }

}
