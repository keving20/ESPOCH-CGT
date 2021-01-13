/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.sexo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_sexo {
    
    
     public static boolean insertarSexo(sexo objsexo) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.f_insertar_t_ambiente(?,?)";

            lstP.add(new Parametro(1, objsexo.getDescripcion()));
            //////declaro Un resultSet para que me guarde los resultados ejecudatos por el query
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            ////recorre el registro en memoria
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                bandera = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        ///retoramos true si inserta caso contrario devuelve un mensaje de error
        return bandera;
    }

    //////////////////////////////////////////////////////////////
    //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<sexo> llenarSexo(ConjuntoResultado rs) throws Exception {
        ArrayList<sexo> lst = new ArrayList<>();
        sexo sex = null;
        try {    
            while (rs.next()) {
                sex = new sexo(rs.getInt(0),rs.getString(1));
                lst.add(sex);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<sexo> obtenerTodossexo() throws Exception {
        ArrayList<sexo> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_sexo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarSexo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
