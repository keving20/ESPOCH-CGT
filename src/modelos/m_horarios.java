/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.asistencia;
import entidades.empleado;
import entidades.horarios;
import entidades.tipo_horario;
import java.sql.SQLException;
import java.util.ArrayList;
import static modelos.m_asistencia.llenarAsistencia;

/**
 *
 * @author Jonathan Araujo
 */



public class m_horarios {
public static ArrayList<horarios> llenarHorarios(ConjuntoResultado rs) throws Exception {
        ArrayList<horarios> lst = new ArrayList<>();
        horarios horarios = null;
        try {    
            while (rs.next()) {                              
                empleado objempleado = new empleado();
                objempleado.setCedula(rs.getString(2));
                objempleado.setNombres(rs.getString(3));
                objempleado.setApellidos(rs.getString(4));
                
                tipo_horario objTipoHorario = new tipo_horario();
                objTipoHorario.setDescripcion(rs.getString(1));
                
                               
                horarios = new horarios(rs.getInt(0),objTipoHorario,objempleado,rs.getTime(5),rs.getTime(6));
                        lst.add(horarios);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }    
    
     public static ArrayList<horarios> obtenerTodosHorarios() throws Exception {
        ArrayList<horarios> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_horarios()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarHorarios(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     
      ///////insertar
    public static boolean NuevoHorario(horarios objHorarios) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_insert_horario(?,?,?,?)";
            
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, objHorarios.getTipo_horario()));
             lstP.add(new Parametro(2, objHorarios.getObjEmpleado().getCedula()));
              lstP.add(new Parametro(3, objHorarios.getHora_entrada()));
               lstP.add(new Parametro(4, objHorarios.getHora_salida()));
            //////declaro Un resultSet para que me guarde los resultados ejecudatos por el query
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            ////recorre el registro en memoria
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                bandera = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        ///retoramos true si inserta caso contrario devuelve un mensaje de error
        return bandera;
    }
    
    ///////eliminar
    public static boolean eliminarHorario(int idHorario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_horario(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idHorario));
            //////declaro Un resultSet para que me guarde los resultados ejecudatos por el query
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            ////recorre el registro en memoria
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                bandera = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        ///retoramos true si inserta caso contrario devuelve un mensaje de error
        return bandera;
    }
    
      ///////update
    public static boolean modificarHorario(horarios horarios) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_horario(?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, horarios.getId_horarios()));
            lstP.add(new Parametro(2, horarios.getTipo_horario()));
           lstP.add(new Parametro(3, horarios.getHora_entrada()));
            lstP.add(new Parametro(4, horarios.getHora_salida()));
            //////declaro Un resultSet para que me guarde los resultados ejecudatos por el query
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            ////recorre el registro en memoria
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                bandera = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        ///retoramos true si inserta caso contrario devuelve un mensaje de error
        return bandera;
    }
}
