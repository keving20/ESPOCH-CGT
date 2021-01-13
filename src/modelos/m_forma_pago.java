/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.forma_pago;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_forma_pago {
       //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<forma_pago> llenarFormapago(ConjuntoResultado rs) throws Exception {
        ArrayList<forma_pago> lst = new ArrayList<>();
        forma_pago objFormapago = null;
        try {    
            while (rs.next()) {
                objFormapago = new forma_pago(rs.getInt(0),rs.getString(1));
                lst.add(objFormapago);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<forma_pago> obtenerTodosformapago() throws Exception {
        ArrayList<forma_pago> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_forma_pago()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarFormapago(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
