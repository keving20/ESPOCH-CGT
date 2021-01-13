/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.tipo_usuario;
import entidades.usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_tipo_usuario {
    
   
   
     public static ArrayList<tipo_usuario> llenarTipoUsuario(ConjuntoResultado rs) throws Exception {
        ArrayList<tipo_usuario> lst = new ArrayList<>();
        tipo_usuario objusuario = null;
        try {    
            while (rs.next()) {
                objusuario = new tipo_usuario(rs.getInt(0),rs.getString(1));
                lst.add(objusuario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
          
      
       ///////seleccionar todas las dependencias
    public static ArrayList<tipo_usuario> obtenerTodosTipos() throws Exception {
        ArrayList<tipo_usuario> lst = new ArrayList<>();
        try {
            String sql = "f_select_tipousuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTipoUsuario(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     
}
