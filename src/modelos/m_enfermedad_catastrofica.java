/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.enfermedad_catastrofica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_enfermedad_catastrofica {
    
    
     //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<enfermedad_catastrofica> llenarEnfermedadcatastrofica(ConjuntoResultado rs) throws Exception {
        ArrayList<enfermedad_catastrofica> lst = new ArrayList<>();
        enfermedad_catastrofica objEnfermedad = null;
        try {    
            while (rs.next()) {
                objEnfermedad = new enfermedad_catastrofica(rs.getInt(0),rs.getString(1),rs.getString(2));
                lst.add(objEnfermedad);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<enfermedad_catastrofica> obtenerTodosenfermedadcatastrofica() throws Exception {
        ArrayList<enfermedad_catastrofica> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_t_ambiente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEnfermedadcatastrofica(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }   
    
}
