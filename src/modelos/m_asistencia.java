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
import entidades.estado_aprobacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Locale;
import recursos.recursoMensajes;

/**
 *
 * @author Jonathan Araujo
 */
public class m_asistencia {

   public static boolean insertarAsistencia(asistencia objAsistencia) throws Exception {
        boolean bandera = false;
        
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
            
            String sql = "SELECT * from public.f_control_asistencia_final(?,?)";         
            lstP.add(new Parametro(1, objAsistencia.getObjEmpleado().getCedula()));
            lstP.add(new Parametro(2, objAsistencia.getEntrada()));

//////declaro Un resultSet para que me guarde los resultados ejecudatos por el query
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
           
            ////recorre el registro en memoria                          
            while (rs.next()) {                      
                if (rs.getString(0).equals("true")) {                 
                    bandera = true;   }                          
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        ///retoramos true si inserta caso contrario devuelve un mensaje de error
        
        return bandera;
    }
   
   
   public static boolean aprobarSobretiempo(int id) throws Exception {
        boolean bandera = false;
        
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
            
            String sql = "SELECT * from public.f_aprobar_sobretiempo(?)";         
            lstP.add(new Parametro(1, id));
            

//////declaro Un resultSet para que me guarde los resultados ejecudatos por el query
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
           
            ////recorre el registro en memoria                          
            while (rs.next()) {                      
                if (rs.getString(0).equals("true")) {                 
                    bandera = true;   }                          
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        ///retoramos true si inserta caso contrario devuelve un mensaje de error
        
        return bandera;
    }
    
     //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<asistencia> llenarAsistencia(ConjuntoResultado rs) throws Exception {
        ArrayList<asistencia> lst = new ArrayList<>();
        asistencia asistencia = null;
        try {    
            while (rs.next()) {                              
                empleado objempleado = new empleado();
                objempleado.setCedula(rs.getString(1));
                objempleado.setNombres(rs.getString(2));
                objempleado.setApellidos(rs.getString(3));
                
                estado_aprobacion objEstado = new estado_aprobacion();
                objEstado.setId_estado_aprobacion(rs.getInt(11));
                objEstado.setNombre_estado(rs.getString(12));
                               
                asistencia = new asistencia(rs.getInt(0),objempleado,rs.getTimeStamp(4),rs.getTimeStamp(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),objEstado, rs.getInt(13),rs.getInt(14));
                        lst.add(asistencia);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    
       ///////seleccionar todas las dependencias
    public static ArrayList<asistencia> obtenerTodosasistencia() throws Exception {
        ArrayList<asistencia> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_asistencia_new()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAsistencia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
