/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author USER
 */
public class certificado_laboral {
    int id_certificado;
    Date fecha;
    empleado objEmpleado;
    empresa objEmpresa;

    public certificado_laboral() {
    }

    public certificado_laboral(int id_certificado, Date fecha, empleado objEmpleado, empresa objEmpresa) {
        this.id_certificado = id_certificado;
        this.fecha = fecha;
        this.objEmpleado = objEmpleado;
        this.objEmpresa = objEmpresa;
    }

    public int getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(int id_certificado) {
        this.id_certificado = id_certificado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }
    
    
}
