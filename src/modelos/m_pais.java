/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.pais;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_pais {
      //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<pais> llenarPais(ConjuntoResultado rs) throws Exception {
        ArrayList<pais> lst = new ArrayList<>();
        pais objPais = null;
        try {    
            while (rs.next()) {
                objPais = new pais(rs.getString(0),rs.getString(1));
                lst.add(objPais);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<pais> obtenerTodospais() throws Exception {
        ArrayList<pais> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM public.f_select_pais() ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPais(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    } 
}
