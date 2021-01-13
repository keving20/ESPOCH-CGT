/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.aplica_convenio_doble_imposicion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_aplica_convenio_doble_imposicion {
        //////////////////////////////////////////////////////////////
    //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<aplica_convenio_doble_imposicion> llenarAplicaconveniodobleimposicion(ConjuntoResultado rs) throws Exception {
        ArrayList<aplica_convenio_doble_imposicion> lst = new ArrayList<>();
        aplica_convenio_doble_imposicion aplicaconvenio = null;
        try {    
            while (rs.next()) {
                aplicaconvenio = new aplica_convenio_doble_imposicion(rs.getInt(0),rs.getString(1),rs.getString(2));
                lst.add(aplicaconvenio);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<aplica_convenio_doble_imposicion> obtenerTodosAplicaconveniodobleimposicion() throws Exception {
        ArrayList<aplica_convenio_doble_imposicion> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_t_ambiente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAplicaconveniodobleimposicion(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
