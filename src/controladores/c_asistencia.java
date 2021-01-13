/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.asistencia;
import entidades.empleado;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelos.m_asistencia;
import modelos.m_empleado;

import recursos.recursoMensajes;
/**
 *
 * @author Jonathan Araujo
 */
@ViewScoped
@ManagedBean
public class c_asistencia {

    public asistencia objAsistencia;
    public asistencia objAsistenciaSel;
    public empleado objEmpleado;
    
    public ArrayList<asistencia> listaAsistencia;
     public ArrayList<asistencia> listaAsistencia1;
    public ArrayList<empleado> listaEmpleado;
    String Msj;
    
    
       private void reinit() {

        this.objAsistencia = new asistencia();
        this.objAsistenciaSel = new asistencia();
        this.objEmpleado = new empleado();
              
        objAsistencia.setObjEmpleado(objEmpleado);
        objAsistenciaSel.setObjEmpleado(objEmpleado);
               
        listaAsistencia = new ArrayList<>();
        listaEmpleado = new ArrayList<>();
              
        this.cargarAsistencia();
    }
    public c_asistencia() {
        this.reinit();
    } 
    
    public asistencia getObjAsistencia() {
        return objAsistencia;
    }

    public ArrayList<asistencia> getListaAsistencia1() {
        return listaAsistencia1;
    }

    public void setListaAsistencia1(ArrayList<asistencia> listaAsistencia1) {
        this.listaAsistencia1 = listaAsistencia1;
    }

    public void setObjAsistencia(asistencia objAsistencia) {
        this.objAsistencia = objAsistencia;
    }

    public asistencia getObjAsistenciaSel() {
        return objAsistenciaSel;
    }

    public void setObjAsistenciaSel(asistencia objAsistenciaSel) {
        this.objAsistenciaSel = objAsistenciaSel;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public String getMsj() {
        return Msj;
    }

    public void setMsj(String Msj) {
        this.Msj = Msj;
    }
    

    public ArrayList<asistencia> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(ArrayList<asistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public ArrayList<empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

   

    public void cargarAsistencia() {

        try {
            listaAsistencia = m_asistencia.obtenerTodosasistencia();
            listaEmpleado = m_empleado.obtenerTodosempleado();

        } catch (Exception e) {
        }
    }
    
     public void aprobarSobretiempo(int id) {
          String message;
          
            try {
            boolean resultado = m_asistencia.aprobarSobretiempo(id);
            
            if (resultado == true) {
                cargarAsistencia();
                message = "El Sobretiempo ha sido Aprobado Exitosamente! " ;
                Msj = message;
                recursoMensajes.addSuccessMessage(message);
                
                   this.reinit();
            } else {
                message = "¡Operación no Completada! ";
                recursoMensajes.addErrorMessage(message);
                 Msj = message;
                this.reinit();
            }

        } catch (Exception e) {
            message = "¡ERROR, REGISTRO NO COMPLETADO!";
            recursoMensajes.addErrorMessage(message);
             Msj = message; 
            this.reinit();
        } 
         
    }

    public void insertarAsistencia() {
       
        String message;
        String hora_actual;
        LocalDateTime ahora = LocalDateTime.now();
        hora_actual = ahora.getHour() + ":" + ahora.getMinute() + ":" + ahora.getSecond(); //Aquí calculamos la hora Actual
        
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
       
        objAsistencia.setEntrada(currentTimestamp);
       
        try {
            boolean resultado = m_asistencia.insertarAsistencia(objAsistencia);
            
            if (resultado == true) {
                cargarAsistencia();
                message = " " +objAsistencia.getObjEmpleado().getCedula()+" HA SIDO REGISTRADO CON ÉXITO a las: " + hora_actual;
                Msj = message;
                recursoMensajes.addSuccessMessage(message);
                
                   this.reinit();
            } else {
                message = "¡REGISTRO NO COMPLETADO! ";
                recursoMensajes.addErrorMessage(message);
                 Msj = message;
                this.reinit();
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            recursoMensajes.addErrorMessage(message);
             Msj = message; 
            this.reinit();
        }

    }
    
  
}
