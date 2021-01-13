/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.tipos_sistema_salario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_tipo_sistema_salario {
    
    
     public static boolean insertarTiposistemasalario(tipos_sistema_salario objtipossalario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.f_insertar_t_ambiente(?,?)";

            lstP.add(new Parametro(1, objtipossalario.getCodigo()));
            lstP.add(new Parametro(2, objtipossalario.getDescripcion()));
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
    public static ArrayList<tipos_sistema_salario> llenarTiposistemasalario(ConjuntoResultado rs) throws Exception {
        ArrayList<tipos_sistema_salario> lst = new ArrayList<>();
        tipos_sistema_salario objtiposistemasalario = null;
        try {    
            while (rs.next()) {
                objtiposistemasalario = new tipos_sistema_salario(rs.getInt(0),rs.getInt(1),rs.getString(2));
                lst.add(objtiposistemasalario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<tipos_sistema_salario> obtenerTodostiposistemasalario() throws Exception {
        ArrayList<tipos_sistema_salario> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_t_ambiente()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTiposistemasalario(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
