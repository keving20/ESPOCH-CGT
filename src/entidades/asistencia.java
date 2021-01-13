/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Jonathan Araujo
 */
public class asistencia {

    int id_asistencia;
    empleado objEmpleado;
    Timestamp entrada;
    Timestamp salida;
    int tipo_asistencia;
    String atrasos;
    String atrasos2;
    String sobretiempo;
    String descripcion;
    estado_aprobacion objEstado;
    int sobretiempo_min;
    int sobretiempo_hour;

    public asistencia() {
    }

    public asistencia(int id_asistencia, empleado objEmpleado, Timestamp entrada, Timestamp salida, int tipo_asistencia, String atrasos, String atrasos2, String sobretiempo, String descripcion, estado_aprobacion objEstado, int sobretiempo_min, int sobretiempo_hour) {
        this.id_asistencia = id_asistencia;
        this.objEmpleado = objEmpleado;
        this.entrada = entrada;
        this.salida = salida;
        this.tipo_asistencia = tipo_asistencia;
        this.atrasos = atrasos;
        this.atrasos2 = atrasos2;
        this.sobretiempo = sobretiempo;
        this.descripcion = descripcion;
        this.objEstado = objEstado;
        this.sobretiempo_min = sobretiempo_min;
        this.sobretiempo_hour = sobretiempo_hour;
    }

    public int getSobretiempo_min() {
        return sobretiempo_min;
    }

    public void setSobretiempo_min(int sobretiempo_min) {
        this.sobretiempo_min = sobretiempo_min;
    }

    public int getSobretiempo_hour() {
        return sobretiempo_hour;
    }

    public void setSobretiempo_hour(int sobretiempo_hour) {
        this.sobretiempo_hour = sobretiempo_hour;
    }

       
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAtrasos2() {
        return atrasos2;
    }

    public void setAtrasos2(String atrasos2) {
        this.atrasos2 = atrasos2;
    }

    public String getSobretiempo() {
        return sobretiempo;
    }

    public void setSobretiempo(String sobretiempo) {
        this.sobretiempo = sobretiempo;
    }

    public estado_aprobacion getObjEstado() {
        return objEstado;
    }

    public void setObjEstado(estado_aprobacion objEstado) {
        this.objEstado = objEstado;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getSalida() {
        return salida;
    }

    public void setSalida(Timestamp salida) {
        this.salida = salida;
    }

    public int getTipo_asistencia() {
        return tipo_asistencia;
    }

    public void setTipo_asistencia(int tipo_asistencia) {
        this.tipo_asistencia = tipo_asistencia;
    }

    public String getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(String atrasos) {
        this.atrasos = atrasos;
    }

}
