package controladores;

import entidades.usuario;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import modelos.m_login;
import modelos.m_usuario;
import org.primefaces.context.RequestContext;
import recursos.recursoMensajes;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

    private usuario objusuimp;
    private m_usuario oMUsuario;
    private usuario objUsuario;
    private String usuario;
    private String clave;
    private boolean logeado = false;

   

    public LoginBean() {
        this.objusuimp = new usuario();
        this.oMUsuario = new m_usuario();
        this.objUsuario = new usuario();
        this.usuario = "";
        this.clave = "";
        this.logeado=false;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    

    public usuario getObjusuimp() {
        return objusuimp;
    }

    public void setObjusuimp(usuario objusuimp) {
        this.objusuimp = objusuimp;
    }

    public m_usuario getoMUsuario() {
        return oMUsuario;
    }

    public void setoMUsuario(m_usuario oMUsuario) {
        this.oMUsuario = oMUsuario;
    }

    public usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

  
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public void login() {
        try {
            String message;
            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage msg = null;
           
            
                    logeado = m_login.loginCorrecto(usuario, clave);
                    if (logeado) {
                        objUsuario = oMUsuario.DatosUsuario(usuario);
                        this.objusuimp = objUsuario;
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", objUsuario);
                        message = "¡ BIENVENIDO " + objUsuario.getNombre() + objUsuario.getApellido()+"!";
                        recursoMensajes.addSuccessMessage(message);
    
                      } else {
                        //logeado = false;
                        message = "¡DATOS INCORRECTOS!";
                        recursoMensajes.addSuccessMessageLogin(message);

                    }
                  
                        if (logeado) {
                redireccionarPaginas(objUsuario.getObjTipousuario().getId_tipousuario());
            } 
            } catch (Exception e) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Contraseña Incorrecta", "");
        }
    }

    private void redireccionarPaginas(Integer Tipo) throws IOException {

        String url;
        FacesContext fc = FacesContext.getCurrentInstance();
        switch (Tipo) {
            case 1:
               
                url = "admin/indexAdmin.xhtml"; //url donde se redirige la pantall
                fc.getExternalContext().redirect(url);//redirecciona la página
                break;
            case 2:
             
                url = "admin/indexUser.xhtml"; //url donde se redirige la pantall
                fc.getExternalContext().redirect(url);//redirecciona la página

                break;
            case 3:
           
                url = "admin/indexEmpresa.xhtml"; //url donde se redirige la pantall
                fc.getExternalContext().redirect(url);//redirecciona la página   

                break;

            default:
                //Redirecciona a ver los datos de la historia clinica
                url = "index.xhtml"; //url donde se redirige la pantall
                fc.getExternalContext().redirect(url);//redirecciona la página   

        }
    }

    public void logout() throws IOException {

        String url;
        FacesContext fc = FacesContext.getCurrentInstance();
        url = "/BOLSA_EMPLEO/index.xhtml"; //url donde se redirige la pantall
        fc.getExternalContext().redirect(url);//redirecciona la página
        this.objUsuario = new usuario();
       this.clave = "";
        this.usuario = "";

       HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(false);
        session.invalidate();
        logeado = false;

    }
    
    
     public void verificarsesion() {
        try {
            usuario us = (usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/BOLSA_EMPLEO/index.xhtml");
            }
        } catch (Exception e) {
        }
    }
    
      //<editor-fold defaultstate="collapsed" desc="Actualizar Usuario">
        public void actualizar(usuario u) {
        this.setObjUsuario(u);

    }

}
