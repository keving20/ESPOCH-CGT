/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.ofertas;
import entidades.tipo_usuario;
import entidades.usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_ofertas {
    
    
    
     public static ArrayList<ofertas> llenarOfertas(ConjuntoResultado rs) throws Exception {
        ArrayList<ofertas> lst = new ArrayList<>();
        ofertas objofertas = null;
        try {    
            while (rs.next()) {
               
                
                objofertas = new ofertas(rs.getInt(0),rs.getString(1),rs.getBigDecimal(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                lst.add(objofertas);
            } //rs.getBigDecimal(24)
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
     
     
     
      
      
       ///////seleccionar todas las dependencias
    public static ArrayList<ofertas> obtenerTodosOfertas() throws Exception {
        ArrayList<ofertas> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_ofertas()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarOfertas(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
         ///////modificar
    public static boolean modificarUsuario(usuario objUsuario ) throws Exception {
       
        
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_usuario(?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
           
            lstP.add(new Parametro(1, objUsuario.getId_usuario()));
            lstP.add(new Parametro(2, objUsuario.getCedula()));
            lstP.add(new Parametro(3, objUsuario.getClave()));
            lstP.add(new Parametro(4, objUsuario.getNombre()));
            lstP.add(new Parametro(5, objUsuario.getApellido()));
            
           
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
    public static boolean eliminarUsuario(int idUsuario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_usuario(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idUsuario));
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
