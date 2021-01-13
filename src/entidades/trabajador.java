/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jonathan Araujo
 */
public class trabajador {
    int id_trabajador;
    String nombre_usuario;
    String apellido_usuario;   
    String cedula_usuario;
    int edad;
    String ciudad;
    String correo_p;
    String correo_i;
    String telefono;
    String instruccion; 
    String titulo;
    
    public trabajador() {
    }

    public trabajador(int id_trabajador, String nombre_usuario, String apellido_usuario, String cedula_usuario, int edad, String ciudad, String correo_p, String correo_i, String telefono, String instruccion, String titulo) {
        this.id_trabajador = id_trabajador;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.cedula_usuario = cedula_usuario;
        this.edad = edad;
        this.ciudad = ciudad;
        this.correo_p = correo_p;
        this.correo_i = correo_i;
        this.telefono = telefono;
        this.instruccion = instruccion;
        this.titulo = titulo;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(String cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo_p() {
        return correo_p;
    }

    public void setCorreo_p(String correo_p) {
        this.correo_p = correo_p;
    }

    public String getCorreo_i() {
        return correo_i;
    }

    public void setCorreo_i(String correo_i) {
        this.correo_i = correo_i;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

  
    
    
}
