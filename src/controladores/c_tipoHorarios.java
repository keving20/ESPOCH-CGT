package controladores;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import entidades.asistencia;
import entidades.empleado;
import entidades.horarios;
import entidades.tipo_horario;
import java.sql.Time;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelos.m_empleado;
import modelos.m_horarios;
import modelos.m_tipo_horarios;

import recursos.recursoMensajes;

@ViewScoped
@ManagedBean
public class c_tipoHorarios {

    public tipo_horario objTipoHorarios;
    public tipo_horario objTipoHorariosSel;

    public ArrayList<tipo_horario> listaTipoHorarios;
    public ArrayList<tipo_horario> listaTipoHorarios1;
    public ArrayList<tipo_horario> listaTipoHorariosSel;

    
     private void reinit() {

        this.objTipoHorarios = new tipo_horario();
        this.objTipoHorariosSel = new tipo_horario();
       
               
        listaTipoHorarios = new ArrayList<>();
       
        
        this.cargarTipoHorarios();
    }
      public void cargarTipoHorarios() {

        try {
            listaTipoHorarios = m_tipo_horarios.obtenerTodosTiposHorarios();
            
        } catch (Exception e) {
        }
    } 
      
      public c_tipoHorarios() {
        this.reinit();
    } 

    public tipo_horario getObjTipoHorarios() {
        return objTipoHorarios;
    }

    public void setObjTipoHorarios(tipo_horario objTipoHorarios) {
        this.objTipoHorarios = objTipoHorarios;
    }

    public tipo_horario getObjTipoHorariosSel() {
        return objTipoHorariosSel;
    }

    public void setObjTipoHorariosSel(tipo_horario objTipoHorariosSel) {
        this.objTipoHorariosSel = objTipoHorariosSel;
    }

    public ArrayList<tipo_horario> getListaTipoHorarios() {
        return listaTipoHorarios;
    }

    public void setListaTipoHorarios(ArrayList<tipo_horario> listaTipoHorarios) {
        this.listaTipoHorarios = listaTipoHorarios;
    }

    public ArrayList<tipo_horario> getListaTipoHorarios1() {
        return listaTipoHorarios1;
    }

    public void setListaTipoHorarios1(ArrayList<tipo_horario> listaTipoHorarios1) {
        this.listaTipoHorarios1 = listaTipoHorarios1;
    }

    public ArrayList<tipo_horario> getListaTipoHorariosSel() {
        return listaTipoHorariosSel;
    }

    public void setListaTipoHorariosSel(ArrayList<tipo_horario> listaTipoHorariosSel) {
        this.listaTipoHorariosSel = listaTipoHorariosSel;
    }

   
     
      
}
