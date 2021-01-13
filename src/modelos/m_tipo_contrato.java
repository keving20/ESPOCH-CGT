/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.tipo_contrato;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_tipo_contrato {
    
    
    //////////////////////////////////////////////////////////////
    //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<tipo_contrato> llenarTipocontrato(ConjuntoResultado rs) throws Exception {
        ArrayList<tipo_contrato> lst = new ArrayList<>();
        tipo_contrato tipocontrato = null;
        try {    
            while (rs.next()) {
                tipocontrato = new tipo_contrato(rs.getInt(0),rs.getString(1));
                lst.add(tipocontrato);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<tipo_contrato> obtenerTodostipocontrato() throws Exception {
        ArrayList<tipo_contrato> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_tipo_contrato()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTipocontrato(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
