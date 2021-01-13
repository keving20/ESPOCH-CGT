/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.condicion_trabajador_respecto_discapacidades;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_condicion_trabajador_respecto_discapadidad {
    
     //////////////////////////////////////////////////////////////
    //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<condicion_trabajador_respecto_discapacidades> llenarCondiciontrabajador(ConjuntoResultado rs) throws Exception {
        ArrayList<condicion_trabajador_respecto_discapacidades> lst = new ArrayList<>();
        condicion_trabajador_respecto_discapacidades condicion = null;
        try {    
            while (rs.next()) {
                condicion = new condicion_trabajador_respecto_discapacidades(rs.getInt(0),rs.getString(1),rs.getString(2));
                lst.add(condicion);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<condicion_trabajador_respecto_discapacidades> obtenerTodoscondiciontrabajador() throws Exception {
        ArrayList<condicion_trabajador_respecto_discapacidades> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_t_ambiente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCondiciontrabajador(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
    
}
