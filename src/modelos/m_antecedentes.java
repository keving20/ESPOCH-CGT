/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.antecedentes;
import entidades.consulta;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.antecedentes;
import entidades.consulta2;
import entidades.regla;
import entidades.resultados;
import entidades.tipo_usuario;
import entidades.usuario;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Araujo
 */
public class m_antecedentes {

    public static ArrayList<antecedentes> llenarAntecedentes(ConjuntoResultado rs) throws Exception {
        ArrayList<antecedentes> lst = new ArrayList<>();
        antecedentes antecedentes = null;
        try {    
            while (rs.next()) {                              
                    
                antecedentes = new antecedentes(rs.getInt(0),rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getBigDecimal(6));
                        lst.add(antecedentes);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    } 
    
    public static ArrayList<consulta> llenarConsultas(ConjuntoResultado rs) throws Exception {
        ArrayList<consulta> lst = new ArrayList<>();
        consulta consulta = null;
        try {    
            while (rs.next()) {                              
                    
                consulta = new consulta(rs.getString(0),rs.getString(1),rs.getBigDecimal(2));
                        lst.add(consulta);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    } 
    
    
     public static ArrayList<consulta2> llenarConsultas2(ConjuntoResultado rs) throws Exception {
        ArrayList<consulta2> lst = new ArrayList<>();
        consulta2 consulta2 = null;
        try {    
            while (rs.next()) {                              
                    
                consulta2 = new consulta2(rs.getString(0),rs.getString(1));
                        lst.add(consulta2);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    } 
       public static ArrayList<resultados> llenarResultados(ConjuntoResultado rs) throws Exception {
        ArrayList<resultados> lst = new ArrayList<>();
        resultados resultado = null;
        try {    
            while (rs.next()) {                              
                    
                resultado = new resultados(rs.getString(0),rs.getBigDecimal(1),rs.getInt(2),rs.getBigDecimal(3));
                        lst.add(resultado);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    } 
    
     public static ArrayList<antecedentes> obtenerTodosAntecedentes() throws Exception {
        ArrayList<antecedentes> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_antecedentes()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAntecedentes(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     
      public static ArrayList<consulta> obtenerConsultaAntecedentes() throws Exception {
        ArrayList<consulta> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_consulta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarConsultas(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
      
      
      
      public static ArrayList<consulta2> obtenerConsultaAntecedentesRegresion(String regla) throws Exception {
        
        ArrayList<consulta2> lst = new ArrayList<>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_select_regresivo(?)";
           
            lstP.add(new Parametro(1, regla));
             ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarConsultas2(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
      
      public static boolean ingresoTemporal(String ant, BigDecimal valor) throws Exception {
            System.out.println("ESTA ES EL NOMBRE DEL ANTECEDENTE"+ant+"VALOR"+valor);
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.fn_insert_temporal(?,?)";

            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, ant));
            lstP.add(new Parametro(2, valor));

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
      
      
      public static boolean ingresoTemporalFalso(String ant) throws Exception {
          
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.fn_insert_temporal_falso(?)";

            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, ant));
  

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
    
      public static ArrayList<resultados> obtenerResultados() throws Exception {
        ArrayList<resultados> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_resultados()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarResultados(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
      ///
       public static boolean obtenerResultadosRegre() throws Exception {
           boolean respuesta = false;
       
        try {
             ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_resultados_regre()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                respuesta = rs.getBoolean(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return respuesta;
        
   
    }
     
      public static boolean borrarTemporal() throws Exception {
          
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.fn_delete_temporal()";
         
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
