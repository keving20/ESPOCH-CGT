
package controladores;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import entidades.asistencia;
import entidades.empleado;
import entidades.horarios;
import entidades.tipo_horario;
import java.sql.Time;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelos.m_empleado;
import modelos.m_horarios;

import recursos.recursoMensajes;

@ViewScoped
@ManagedBean
public class c_horarios {
       public horarios objHorarios;
       public horarios objHorariosSel;
       public empleado objEmpleado;
       public tipo_horario objTipo_horario;
       
       public ArrayList<horarios> listaHorarios;
       public ArrayList<horarios> listaHorarios1;
       public ArrayList<horarios> listaHorariosSel;
       public ArrayList<empleado> listaEmpleado;
       public ArrayList<tipo_horario> listaTipo_horario;
  
        private void reinit() {

        this.objHorarios = new horarios();
        this.objHorariosSel = new horarios();
        this.objEmpleado = new empleado();
        this.objTipo_horario = new tipo_horario();
        
        objHorarios.setObjEmpleado(objEmpleado);
        objHorariosSel.setObjEmpleado(objEmpleado);
               
        listaHorarios = new ArrayList<>();
        listaEmpleado = new ArrayList<>();
        listaTipo_horario = new ArrayList<>();
        
        this.cargarHorarios();
    }
       
      public void cargarHorarios() {

        try {
            listaHorarios = m_horarios.obtenerTodosHorarios();
            listaEmpleado = m_empleado.obtenerTodosempleado();

        } catch (Exception e) {
        }
    } 
      public c_horarios() {
        this.reinit();
    } 

    public horarios getObjHorarios() {
        return objHorarios;
    }

    public void setObjHorarios(horarios objHorarios) {
        this.objHorarios = objHorarios;
    }

    public ArrayList<horarios> getListaHorarios1() {
        return listaHorarios1;
    }

    public void setListaHorarios1(ArrayList<horarios> listaHorarios1) {
        this.listaHorarios1 = listaHorarios1;
    }

    public horarios getObjHorariosSel() {
        return objHorariosSel;
    }

    public void setObjHorariosSel(horarios objHorariosSel) {
        this.objHorariosSel = objHorariosSel;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public tipo_horario getObjTipo_horario() {
        return objTipo_horario;
    }

    public void setObjTipo_horario(tipo_horario objTipo_horario) {
        this.objTipo_horario = objTipo_horario;
    }

    public ArrayList<horarios> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(ArrayList<horarios> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    public ArrayList<horarios> getListaHorariosSel() {
        return listaHorariosSel;
    }

    public void setListaHorariosSel(ArrayList<horarios> listaHorariosSel) {
        this.listaHorariosSel = listaHorariosSel;
    }

    public ArrayList<empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public ArrayList<tipo_horario> getListaTipo_horario() {
        return listaTipo_horario;
    }

    public void setListaTipo_horario(ArrayList<tipo_horario> listaTipo_horario) {
        this.listaTipo_horario = listaTipo_horario;
    }
       
      public void insertarHorario() throws ParseException {
        String message;
        
         
         DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
         String Entrada = getObjHorarios().getEntrada();
         String Salida = getObjHorarios().getSalida();
         Time timeEntrada = new Time(formatter.parse(Entrada).getTime());
         Time timeSalida = new Time(formatter.parse(Salida).getTime());
         
         objHorarios.setHora_entrada(timeEntrada);
         objHorarios.setHora_salida(timeSalida);
         
        System.out.println(getObjHorarios().getTipo_horario()); 
        System.out.println(getObjHorarios().getObjEmpleado().getCedula());
        System.out.println(getObjHorarios().getHora_entrada());
        System.out.println(getObjHorarios().getHora_salida());
        
        try {

            boolean resultado = m_horarios.NuevoHorario(objHorarios);
            if (resultado == true) {
                cargarHorarios();
                message = "¡EL HORARIO PARA: " + objHorarios.getObjEmpleado().getCedula()+ " HA SIDO REGISTRADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
             
            } else {
                message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            recursoMensajes.addSuccessMessage(message);
        }
    }
      
      public void eliminarHorario() {
        String message;
        try {
            boolean resultado = m_horarios.eliminarHorario(objHorariosSel.getId_horarios());
            if (resultado == true) {
                cargarHorarios();
                message = "HORARIO ELIMINADO CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                //cargarColor();

            } else {
                message = "HORARIO NO ELIMINADO";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR AL ELIMINAR HORARIO";
            recursoMensajes.addSuccessMessageLogin(message);
           
        }
    }
      
       public void modificarHorario() throws ParseException {
        String message;
        
       // System.out.println(getObjHorariosSel().getEntrada());
      //  System.out.println(getObjHorariosSel().getSalida());
        
         DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
         String Entrada = getObjHorariosSel().getEntrada();
         String Salida = getObjHorariosSel().getSalida();
         Time timeEntrada = new Time(formatter.parse(Entrada).getTime());
         Time timeSalida = new Time(formatter.parse(Salida).getTime());
        
           objHorariosSel.setHora_entrada(timeEntrada);
         objHorariosSel.setHora_salida(timeSalida);
         
         
          System.out.println(getObjHorariosSel().getId_horarios());
          System.out.println(getObjHorariosSel().getTipo_horario()); 
        System.out.println(getObjHorariosSel().getHora_entrada());
        System.out.println(getObjHorariosSel().getHora_salida());
        
        try {
            boolean resultado = m_horarios.modificarHorario(objHorariosSel);
            if (resultado == true) {
                cargarHorarios();
                message = "DATOS ACTUALIZADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);

            } else {
                message = "DATOS NO ACTUALIZADOS";
                recursoMensajes.addSuccessMessage(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ACTUALIZAR";
            recursoMensajes.addSuccessMessage(message);
        }
    }
}
