/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;

/**
 *
 * @author USER
 */
public class horarios {

    int id_horarios;
    Time hora_entrada;
    Time hora_salida;
    tipo_horario objTipohorario;
    empleado objEmpleado;
    String entrada;
    String salida;
    int tipo_horario;
    public horarios() {
    }

    public horarios(int id_horarios,tipo_horario objTipohorario, empleado objEmpleado, Time hora_entrada, Time hora_salida ) {
        this.id_horarios = id_horarios;
        this.objTipohorario = objTipohorario;
        this.objEmpleado = objEmpleado;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
      
    }

    public int getId_horarios() {
        return id_horarios;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    
    public void setId_horarios(int id_horarios) {
        this.id_horarios = id_horarios;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getTipo_horario() {
        return tipo_horario;
    }

    public void setTipo_horario(int tipo_horario) {
        this.tipo_horario = tipo_horario;
    }

    

    public tipo_horario getObjTipohorario() {
        return objTipohorario;
    }

    public void setObjTipohorario(tipo_horario objTipohorario) {
        this.objTipohorario = objTipohorario;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }
    
    
    
}
