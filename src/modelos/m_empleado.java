/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.ciudad;
import entidades.departamento;
import entidades.empleado;
import entidades.estado_civil;
import entidades.provincia;
import entidades.rol;
import entidades.sexo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_empleado {

    public static boolean insertarEmpleado(empleado objempleado) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT * from public.f_insert_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            java.sql.Date fechainicio = new java.sql.Date(objempleado.getFecha_inicio().getTime());

            lstP.add(new Parametro(1, objempleado.getNombres()));
            lstP.add(new Parametro(2, objempleado.getApellidos()));
            lstP.add(new Parametro(3, objempleado.getDireccion()));
            lstP.add(new Parametro(4, objempleado.getTelefono()));
            lstP.add(new Parametro(5, objempleado.getObjEstado_civil().getId_estadocivil()));
            lstP.add(new Parametro(6, objempleado.getExperiencia()));
            lstP.add(new Parametro(7, objempleado.getUniversidad()));
            lstP.add(new Parametro(8, objempleado.getObjrol().getId_rol()));
            lstP.add(new Parametro(9, objempleado.getCedula()));
            lstP.add(new Parametro(10, fechainicio));
            lstP.add(new Parametro(11, objempleado.getSueldo()));
            lstP.add(new Parametro(12, objempleado.getObjProvincia().getId_provincia()));
            lstP.add(new Parametro(13, objempleado.getObjCiudad().getId_ciudad()));
            lstP.add(new Parametro(14, objempleado.getObjSexo().getId_sexo()));
            lstP.add(new Parametro(15, objempleado.getObjDepartamento().getId_departamento()));
            lstP.add(new Parametro(16, objempleado.getCod_empresa()));
            lstP.add(new Parametro(17, objempleado.getAcum_13()));
            lstP.add(new Parametro(18, objempleado.getAcum_14()));
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

    ///////modificar
    public static boolean modificarEmpleado(empleado objempleado) throws Exception {

        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            java.sql.Date fechainicio = new java.sql.Date(objempleado.getFecha_inicio().getTime());

            lstP.add(new Parametro(1, objempleado.getId_empleado()));
            lstP.add(new Parametro(2, objempleado.getNombres()));
            lstP.add(new Parametro(3, objempleado.getApellidos()));
            lstP.add(new Parametro(4, objempleado.getDireccion()));
            lstP.add(new Parametro(5, objempleado.getTelefono()));
            lstP.add(new Parametro(6, objempleado.getObjEstado_civil().getId_estadocivil()));
            lstP.add(new Parametro(7, objempleado.getExperiencia()));
            lstP.add(new Parametro(8, objempleado.getUniversidad()));
            lstP.add(new Parametro(9, objempleado.getObjrol().getId_rol()));
            lstP.add(new Parametro(10, objempleado.getCedula()));
            lstP.add(new Parametro(11, fechainicio));
            lstP.add(new Parametro(12, objempleado.getSueldo()));
            lstP.add(new Parametro(13, objempleado.getObjProvincia().getId_provincia()));
            lstP.add(new Parametro(14, objempleado.getObjCiudad().getId_ciudad()));
            lstP.add(new Parametro(15, objempleado.getObjSexo().getId_sexo()));
            lstP.add(new Parametro(16, objempleado.getObjDepartamento().getId_departamento()));
            lstP.add(new Parametro(17, objempleado.getCod_empresa()));
            lstP.add(new Parametro(18, objempleado.getAcum_13()));
            lstP.add(new Parametro(19, objempleado.getAcum_14()));
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
    public static ArrayList<empleado> llenarEmpleado(ConjuntoResultado rs) throws Exception {
        ArrayList<empleado> lst = new ArrayList<>();
        empleado empleado = null;
        try {
            while (rs.next()) {

                estado_civil objEstadocivil = new estado_civil();
                objEstadocivil.setEstado(rs.getString(5));

                rol objRol = new rol();
                objRol.setNombre_rol(rs.getString(8));

                provincia objProvincia = new provincia();
                objProvincia.setDescripcion(rs.getString(12));

                ciudad objCiudad = new ciudad();
                objCiudad.setDescripcion(rs.getString(13));

                sexo objSexo = new sexo();
                objSexo.setDescripcion(rs.getString(14));

                departamento objDepartamento = new departamento();
                objDepartamento.setDescripcion(rs.getString(15));

                empleado = new empleado(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), objEstadocivil, rs.getString(6), rs.getString(7), objRol, rs.getString(9), rs.getDate(10), rs.getBigDecimal(11), objProvincia, objCiudad, objSexo, objDepartamento, rs.getString(16), rs.getBoolean(17), rs.getBoolean(18));
                lst.add(empleado);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<empleado> obtenerTodosempleado() throws Exception {
        ArrayList<empleado> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_empleado()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEmpleado(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    ///////eliminar
    public static boolean eliminarEmpleado(int idEmpleado) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_empleado(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idEmpleado));
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

    //seleccionar un empleado
    public static empleado buscarEmpleado(String codigo) throws Exception {
        empleado objempleado = new empleado();
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_empleado_cedula(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            objempleado = llenarEmpleado(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objempleado;
    }

}
