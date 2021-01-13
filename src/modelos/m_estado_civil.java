/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.estado_civil;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_estado_civil {
        //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<estado_civil> llenarEstadocivil(ConjuntoResultado rs) throws Exception {
        ArrayList<estado_civil> lst = new ArrayList<>();
        estado_civil objEstadocivil = null;
        try {    
            while (rs.next()) {
                objEstadocivil = new estado_civil(rs.getInt(0),rs.getString(1));
                lst.add(objEstadocivil);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<estado_civil> obtenerTodosestadocivil() throws Exception {
        ArrayList<estado_civil> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_estado_civil()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstadocivil(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
