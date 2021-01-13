/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.math.BigDecimal;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
@ManagedBean(name = "oferta")
@ApplicationScoped
/**
 *
 * @author Jonathan Araujo
 */
public class ofertas {
    int id_oferta;
    String nombre_oferta;
    BigDecimal remuneracion;   
    String actividades;
    String ubicacion;
    String empresa;
    String tel_empresa;
    String correo_empresa;
    String ubic_empresa;
    
    public ofertas() {
    }

    public ofertas(int id_oferta, String nombre_oferta, BigDecimal remuneracion, String actividades, String ubicacion, String empresa, String tel_empresa, String correo_empresa, String ubic_empresa) {
        this.id_oferta = id_oferta;
        this.nombre_oferta = nombre_oferta;
        this.remuneracion = remuneracion;
        this.actividades = actividades;
        this.ubicacion = ubicacion;
        this.empresa = empresa;
        this.tel_empresa = tel_empresa;
        this.correo_empresa = correo_empresa;
        this.ubic_empresa = ubic_empresa;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    public String getNombre_oferta() {
        return nombre_oferta;
    }

    public void setNombre_oferta(String nombre_oferta) {
        this.nombre_oferta = nombre_oferta;
    }

    public BigDecimal getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(BigDecimal remuneracion) {
        this.remuneracion = remuneracion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTel_empresa() {
        return tel_empresa;
    }

    public void setTel_empresa(String tel_empresa) {
        this.tel_empresa = tel_empresa;
    }

    public String getCorreo_empresa() {
        return correo_empresa;
    }

    public void setCorreo_empresa(String correo_empresa) {
        this.correo_empresa = correo_empresa;
    }

    public String getUbic_empresa() {
        return ubic_empresa;
    }

    public void setUbic_empresa(String ubic_empresa) {
        this.ubic_empresa = ubic_empresa;
    }
    
    
}
