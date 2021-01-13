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
import entidades.trabajador;
import entidades.usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_trabajador {

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
    public static ArrayList<trabajador> llenarTrabajador(ConjuntoResultado rs) throws Exception {
        ArrayList<trabajador> lst = new ArrayList<>();
        trabajador trabajador = null;
        try {
            while (rs.next()) {

                trabajador = new trabajador(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                lst.add(trabajador);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

   public static boolean ingresarSolicitud(int id_trabajador, int id_oferta) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.fn_insert_solicitud(?,?)";

            lstP.add(new Parametro(1, id_trabajador));
            lstP.add(new Parametro(2, id_oferta));
  
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

    //////traer id del trabajador
    public static Integer traerIdTrabajador(int usuario) throws Exception {
        Integer id_trabajador = 0;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_trabajador_id(?)";
            lstP.add(new Parametro(1, usuario));

            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                id_trabajador = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return id_trabajador;
    }

    public static boolean existeSolicitud(int id_trabajador, int id_oferta) throws Exception {
        boolean resultado = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_existe_solicitud(?,?)";
            lstP.add(new Parametro(1, id_trabajador));
             lstP.add(new Parametro(2, id_oferta));

            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                resultado = rs.getBoolean(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return resultado;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<trabajador> obtenerTodosTrabajador() throws Exception {
        ArrayList<trabajador> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_trabajador()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTrabajador(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
///////seleccionar trabajador por id
    public static ArrayList<trabajador> obtenerDependenciaTrabajador(int id_usuario) throws Exception {
        ArrayList<trabajador> lst = new ArrayList<>();
        ArrayList<Parametro> lstP = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_dependencia_trabajador(?)";
            lstP.add(new Parametro(1, id_usuario));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarTrabajador(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    ///////modificar
      ///////modificar
    public static boolean modificarTrabajador(trabajador objTrabajador) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_trabajador(?,?,?,?,?,?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, objTrabajador.getId_trabajador()));
            lstP.add(new Parametro(2, objTrabajador.getNombre_usuario()));
            lstP.add(new Parametro(3, objTrabajador.getApellido_usuario()));
            lstP.add(new Parametro(4, objTrabajador.getEdad()));
            lstP.add(new Parametro(5, objTrabajador.getCiudad()));      
            lstP.add(new Parametro(6, objTrabajador.getInstruccion()));
            lstP.add(new Parametro(7, objTrabajador.getTitulo()));
            lstP.add(new Parametro(8, objTrabajador.getTelefono()));
            lstP.add(new Parametro(9, objTrabajador.getCorreo_p()));
            lstP.add(new Parametro(10, objTrabajador.getCorreo_i()));


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
