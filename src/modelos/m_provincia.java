/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.provincia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_provincia {
       //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<provincia> llenarProvincia(ConjuntoResultado rs) throws Exception {
        ArrayList<provincia> lst = new ArrayList<>();
        provincia objProvincia = null;
        try {    
            while (rs.next()) {
                objProvincia = new provincia(rs.getInt(0),rs.getString(1));
                lst.add(objProvincia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<provincia> obtenerTodosprovincia() throws Exception {
        ArrayList<provincia> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_provincia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProvincia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
