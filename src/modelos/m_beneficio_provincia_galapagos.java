/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.beneficio_provincia_galapagos;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
public class m_beneficio_provincia_galapagos {
      //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<beneficio_provincia_galapagos> llenarBeneficioprovinciagalapagos(ConjuntoResultado rs) throws Exception {
        ArrayList<beneficio_provincia_galapagos> lst = new ArrayList<>();
        beneficio_provincia_galapagos beneficio = null;
        try {    
            while (rs.next()) {
                beneficio = new beneficio_provincia_galapagos(rs.getInt(0),rs.getString(1),rs.getString(2));
                lst.add(beneficio);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<beneficio_provincia_galapagos> obtenerTodosbeneficiogalapagos() throws Exception {
        ArrayList<beneficio_provincia_galapagos> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_t_ambiente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarBeneficioprovinciagalapagos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
