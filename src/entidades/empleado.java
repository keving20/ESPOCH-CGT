/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author USER
 */
public class empleado {
    int id_empleado;
    String nombres;
    String apellidos;
    String direccion;
    String telefono;
    estado_civil objEstado_civil;
    String experiencia;
    String universidad;
    rol Objrol;
    String cedula;
    Date fecha_inicio;
    BigDecimal sueldo;
    provincia objProvincia;
    ciudad objCiudad;
    sexo objSexo;
    departamento objDepartamento;
    String cod_empresa;
    Boolean acum_13;
    Boolean acum_14;

    public empleado() {
    }

    public empleado(int id_empleado, String nombres, String apellidos, String direccion, String telefono, estado_civil objEstado_civil, String experiencia, String universidad, rol Objrol, String cedula, Date fecha_inicio, BigDecimal sueldo, provincia objProvincia, ciudad objCiudad, sexo objSexo, departamento objDepartamento, String cod_empresa, Boolean acum_13, Boolean acum_14) {
        this.id_empleado = id_empleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.objEstado_civil = objEstado_civil;
        this.experiencia = experiencia;
        this.universidad = universidad;
        this.Objrol = Objrol;
        this.cedula = cedula;
        this.fecha_inicio = fecha_inicio;
        this.sueldo = sueldo;
        this.objProvincia = objProvincia;
        this.objCiudad = objCiudad;
        this.objSexo = objSexo;
        this.objDepartamento = objDepartamento;
        this.cod_empresa = cod_empresa;
        this.acum_13 = acum_13;
        this.acum_14 = acum_14;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Boolean getAcum_13() {
        return acum_13;
    }

    public void setAcum_13(Boolean acum_13) {
        this.acum_13 = acum_13;
    }

    public Boolean getAcum_14() {
        return acum_14;
    }

    public void setAcum_14(Boolean acum_14) {
        this.acum_14 = acum_14;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public estado_civil getObjEstado_civil() {
        return objEstado_civil;
    }

    public void setObjEstado_civil(estado_civil objEstado_civil) {
        this.objEstado_civil = objEstado_civil;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public rol getObjrol() {
        return Objrol;
    }

    public void setObjrol(rol Objrol) {
        this.Objrol = Objrol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public provincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(provincia objProvincia) {
        this.objProvincia = objProvincia;
    }

    public ciudad getObjCiudad() {
        return objCiudad;
    }

    public void setObjCiudad(ciudad objCiudad) {
        this.objCiudad = objCiudad;
    }

    public sexo getObjSexo() {
        return objSexo;
    }

    public void setObjSexo(sexo objSexo) {
        this.objSexo = objSexo;
    }

    public departamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }



    }

   