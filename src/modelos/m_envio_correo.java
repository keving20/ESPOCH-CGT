/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.envio_correo;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.u_envio_correo;

/**
 *
 * @author USER
 */
public class m_envio_correo {
    
     public static ArrayList<envio_correo> llenarCorreo(ConjuntoResultado rs) throws Exception {
        ArrayList<envio_correo> lst = new ArrayList<>();
        envio_correo correo = null;
        try {
            while (rs.next()) {
                correo = new envio_correo( rs.getString(0));
                lst.add(correo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<envio_correo> obtenerTodosCorreo() throws Exception {
        ArrayList<envio_correo> lst = new ArrayList<>();
        try {
            String sql = "select * from " + u_envio_correo.PROC_ENVIO_CORREO+"()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCorreo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
}
