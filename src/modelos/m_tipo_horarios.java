/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.empleado;
import entidades.horarios;
import entidades.tipo_horario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Araujo
 */
public class m_tipo_horarios {
    public static ArrayList<tipo_horario> llenarTipoHorarios(ConjuntoResultado rs) throws Exception {
        ArrayList<tipo_horario> lst = new ArrayList<>();
        tipo_horario tipo_horarios = null;
        try {    
            while (rs.next()) {      
               
                tipo_horarios = new tipo_horario(rs.getInt(0),rs.getString(1));
                        lst.add(tipo_horarios);
            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }    
    
     public static ArrayList<tipo_horario> obtenerTodosTiposHorarios() throws Exception {
        ArrayList<tipo_horario> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_tipo_horario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTipoHorarios(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     
      
    
}
