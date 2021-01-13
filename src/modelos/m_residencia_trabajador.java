/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.residencia_trabajador;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_residencia_trabajador {
    
       //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<residencia_trabajador> llenarResidencia(ConjuntoResultado rs) throws Exception {
        ArrayList<residencia_trabajador> lst = new ArrayList<>();
        residencia_trabajador objResidencia = null;
        try {    
            while (rs.next()) {
                objResidencia = new residencia_trabajador(rs.getInt(0),rs.getString(1),rs.getString(2));
                lst.add(objResidencia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<residencia_trabajador> obtenerTodosresidencia() throws Exception {
        ArrayList<residencia_trabajador> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_t_ambiente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarResidencia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    } 
    
    
}
