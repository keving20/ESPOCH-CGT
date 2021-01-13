/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.estado_aprobacion;
import entidades.sexo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Araujo
 */
public class m_estado_aprobacion {
     public static ArrayList<estado_aprobacion> llenarEstado(ConjuntoResultado rs) throws Exception {
        ArrayList<estado_aprobacion> lst = new ArrayList<>();
        estado_aprobacion estado = null;
        try {    
            while (rs.next()) {
                estado = new estado_aprobacion(rs.getInt(0),rs.getString(1));
                lst.add(estado);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<estado_aprobacion> obtenerTodosEstados() throws Exception {
        ArrayList<estado_aprobacion> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_estado_aprobacion()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstado(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
