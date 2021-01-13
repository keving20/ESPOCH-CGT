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
public class contrato {
  int id_contrato;
  empresa objEmpresa;
  empleado objEmpleado;
  forma_pago objForma_pago;
  tipo_contrato objTipo_contrato;
  String horario;
  String clausula;
  provincia objProvincia;
  ciudad objCiudad;
  int duracion;
  String fecha_contrato;
          
          

    public contrato() {
    }

    public contrato(int id_contrato, empresa objEmpresa, empleado objEmpleado, forma_pago objForma_pago, tipo_contrato objTipo_contrato, String horario, String clausula, provincia objProvincia, ciudad objCiudad, int duracion, String fecha_contrato) {
        this.id_contrato = id_contrato;
        this.objEmpresa = objEmpresa;
        this.objEmpleado = objEmpleado;
        this.objForma_pago = objForma_pago;
        this.objTipo_contrato = objTipo_contrato;
        this.horario = horario;
        this.clausula = clausula;
        this.objProvincia = objProvincia;
        this.objCiudad = objCiudad;
        this.duracion = duracion;
        this.fecha_contrato = fecha_contrato;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public forma_pago getObjForma_pago() {
        return objForma_pago;
    }

    public void setObjForma_pago(forma_pago objForma_pago) {
        this.objForma_pago = objForma_pago;
    }

    public tipo_contrato getObjTipo_contrato() {
        return objTipo_contrato;
    }

    public void setObjTipo_contrato(tipo_contrato objTipo_contrato) {
        this.objTipo_contrato = objTipo_contrato;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getClausula() {
        return clausula;
    }

    public void setClausula(String clausula) {
        this.clausula = clausula;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

   
  
  
  
}
