/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jonathan Araujo
 */
public class solicitudes_trab {
    int id_solicitud_t;
    String nombre_oferta;
    String nombre_empresa;   
    String ciudad_empresa;
    BigDecimal remuneracion; 
    String actividades;
    String ubicacion;
    String nombre_trabajador;
    String apellido_trabajador;
    String cedula_trabajador;
    int edad_trabajador;
    String correo1_trabajador; 
    String correo2_trabajador;
    String tel_trabajador;
    String ciudad_trabajador;
    String titulo_trabajador;
    String instruccion_trabajador;

    public solicitudes_trab() {
    }

    public solicitudes_trab(int id_solicitud_t, String nombre_oferta, String nombre_empresa, String ciudad_empresa, BigDecimal remuneracion, String actividades, String ubicacion, String nombre_trabajador, String apellido_trabajador, String cedula_trabajador, int edad_trabajador, String correo1_trabajador, String correo2_trabajador, String tel_trabajador, String ciudad_trabajador, String titulo_trabajador, String instruccion_trabajador) {
        this.id_solicitud_t = id_solicitud_t;
        this.nombre_oferta = nombre_oferta;
        this.nombre_empresa = nombre_empresa;
        this.ciudad_empresa = ciudad_empresa;
        this.remuneracion = remuneracion;
        this.actividades = actividades;
        this.ubicacion = ubicacion;
        this.nombre_trabajador = nombre_trabajador;
        this.apellido_trabajador = apellido_trabajador;
        this.cedula_trabajador = cedula_trabajador;
        this.edad_trabajador = edad_trabajador;
        this.correo1_trabajador = correo1_trabajador;
        this.correo2_trabajador = correo2_trabajador;
        this.tel_trabajador = tel_trabajador;
        this.ciudad_trabajador = ciudad_trabajador;
        this.titulo_trabajador = titulo_trabajador;
        this.instruccion_trabajador = instruccion_trabajador;
    }

    public int getId_solicitud_t() {
        return id_solicitud_t;
    }

    public void setId_solicitud_t(int id_solicitud_t) {
        this.id_solicitud_t = id_solicitud_t;
    }

    public String getNombre_oferta() {
        return nombre_oferta;
    }

    public void setNombre_oferta(String nombre_oferta) {
        this.nombre_oferta = nombre_oferta;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCiudad_empresa() {
        return ciudad_empresa;
    }

    public void setCiudad_empresa(String ciudad_empresa) {
        this.ciudad_empresa = ciudad_empresa;
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

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public String getApellido_trabajador() {
        return apellido_trabajador;
    }

    public void setApellido_trabajador(String apellido_trabajador) {
        this.apellido_trabajador = apellido_trabajador;
    }

    public String getCedula_trabajador() {
        return cedula_trabajador;
    }

    public void setCedula_trabajador(String cedula_trabajador) {
        this.cedula_trabajador = cedula_trabajador;
    }

    public int getEdad_trabajador() {
        return edad_trabajador;
    }

    public void setEdad_trabajador(int edad_trabajador) {
        this.edad_trabajador = edad_trabajador;
    }

    public String getCorreo1_trabajador() {
        return correo1_trabajador;
    }

    public void setCorreo1_trabajador(String correo1_trabajador) {
        this.correo1_trabajador = correo1_trabajador;
    }

    public String getCorreo2_trabajador() {
        return correo2_trabajador;
    }

    public void setCorreo2_trabajador(String correo2_trabajador) {
        this.correo2_trabajador = correo2_trabajador;
    }

    public String getTel_trabajador() {
        return tel_trabajador;
    }

    public void setTel_trabajador(String tel_trabajador) {
        this.tel_trabajador = tel_trabajador;
    }

    public String getCiudad_trabajador() {
        return ciudad_trabajador;
    }

    public void setCiudad_trabajador(String ciudad_trabajador) {
        this.ciudad_trabajador = ciudad_trabajador;
    }

    public String getTitulo_trabajador() {
        return titulo_trabajador;
    }

    public void setTitulo_trabajador(String titulo_trabajador) {
        this.titulo_trabajador = titulo_trabajador;
    }

    public String getInstruccion_trabajador() {
        return instruccion_trabajador;
    }

    public void setInstruccion_trabajador(String instruccion_trabajador) {
        this.instruccion_trabajador = instruccion_trabajador;
    }

  
}
