/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.empresa;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_empresa {

    public static boolean insertarEmpresa(empresa objempresa) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "select * from public.f_insert_empresa(?,?,?,?,?,?,?,?,?,?)";

           
            lstP.add(new Parametro(1, objempresa.getCorreo()));
            lstP.add(new Parametro(2, objempresa.getTelefono()));
           
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
    public static ArrayList<empresa> llenarEmpresa(ConjuntoResultado rs) throws Exception {
        ArrayList<empresa> lst = new ArrayList<>();
        empresa empresa = null;
        try {
            while (rs.next()) {

                empresa = new empresa(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8));
                lst.add(empresa);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<empresa> obtenerTodosempresa() throws Exception {
        ArrayList<empresa> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_empresa()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEmpresa(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
      ///////seleccionar una dependencia
    public static ArrayList<empresa> obtenerDependenciaEmpresa(int id_usuario) throws Exception {
        ArrayList<empresa> lst = new ArrayList<>();
         ArrayList<Parametro> lstP = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_dependencia_empresa(?)";
              lstP.add(new Parametro(1, id_usuario));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEmpresa(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    ///////modificar
    public static boolean modificarEmpresa(empresa objEmpresa) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_empresa(?,?,?,?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, objEmpresa.getId_empresa()));
            lstP.add(new Parametro(2, objEmpresa.getNombre_empresa()));
            lstP.add(new Parametro(3, objEmpresa.getNombre_usuario()));
            lstP.add(new Parametro(4, objEmpresa.getApellido_usuario()));
            lstP.add(new Parametro(5, objEmpresa.getCiudad()));      
            lstP.add(new Parametro(6, objEmpresa.getUbicacion()));
            lstP.add(new Parametro(7, objEmpresa.getTelefono()));
            lstP.add(new Parametro(8, objEmpresa.getCorreo()));

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

    ///////eliminar
    public static boolean eliminarEmpresa(int idEmpresa) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_empresa(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idEmpresa));
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

}
