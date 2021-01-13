/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.departamento;
import entidades.empleado;
import entidades.empresa;
import entidades.estado_aprobacion;
import entidades.rol;
import entidades.rol_de_pagos;
import entidades.usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static modelos.m_empleado.llenarEmpleado;

/**
 *
 * @author USER
 */
public class m_rol_de_pagos {

    public static boolean insertarRoldepagos(rol_de_pagos objrolpagos) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT * from f_insert_rol_de_pagos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            lstP.add(new Parametro(1, objrolpagos.getFecha_rol_pago()));
            lstP.add(new Parametro(2, objrolpagos.getDias_trabajados()));
            lstP.add(new Parametro(3, objrolpagos.getHoras_extras()));
            lstP.add(new Parametro(4, objrolpagos.getComisiones()));
            lstP.add(new Parametro(5, objrolpagos.getTotal_ingresos()));
            lstP.add(new Parametro(6, objrolpagos.getAporte_personal()));
            lstP.add(new Parametro(7, objrolpagos.getMultas()));
            lstP.add(new Parametro(8, objrolpagos.getAnticipo_sueldos()));
            lstP.add(new Parametro(9, objrolpagos.getComisariato()));
            lstP.add(new Parametro(10, objrolpagos.getTotal_deducciones()));
            lstP.add(new Parametro(11, objrolpagos.getFonde_reserva()));
            lstP.add(new Parametro(12, objrolpagos.getLiquido_a_recibir()));
            lstP.add(new Parametro(13, objrolpagos.getObjEmpresa().getId_empresa()));
            lstP.add(new Parametro(14, objrolpagos.getObjEmpleado().getId_empleado()));
            lstP.add(new Parametro(15, objrolpagos.getBonificaciones()));
            lstP.add(new Parametro(16, objrolpagos.getIngresosnograbados()));
            lstP.add(new Parametro(17, objrolpagos.getAlimentacion()));
            lstP.add(new Parametro(18, objrolpagos.getOtros()));
            lstP.add(new Parametro(19, objrolpagos.getHorassuplementarias()));
            lstP.add(new Parametro(20, objrolpagos.getHorasnocturnas()));
            lstP.add(new Parametro(21, objrolpagos.getDecimo_tercer()));
            lstP.add(new Parametro(22, objrolpagos.getDecimo_cuarto()));
            lstP.add(new Parametro(23, objrolpagos.getAtrasos()));
            lstP.add(new Parametro(24, objrolpagos.getUniformes()));
            lstP.add(new Parametro(25, objrolpagos.getCanthorasextra()));
            lstP.add(new Parametro(26, objrolpagos.getCanthorassuplementarias()));
            lstP.add(new Parametro(27, objrolpagos.getCanthorasnocturas()));
            lstP.add(new Parametro(28, objrolpagos.getObjEncargado().getCedula()));
            lstP.add(new Parametro(29, objrolpagos.getCheque()));
            lstP.add(new Parametro(30, objrolpagos.getHoras_trabajadas()));
            lstP.add(new Parametro(31, objrolpagos.getVacaciones()));
            lstP.add(new Parametro(32, objrolpagos.getPrestamo_iess()));

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
    public static boolean modificarRoldepagos(rol_de_pagos objrolpagos) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select f_update_rol_de_pagos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, objrolpagos.getId_rol_pagos()));
            lstP.add(new Parametro(2, objrolpagos.getFecha_rol_pago()));
            lstP.add(new Parametro(3, objrolpagos.getDias_trabajados()));
            lstP.add(new Parametro(4, objrolpagos.getCanthorasextra()));
            lstP.add(new Parametro(5, objrolpagos.getHoras_extras()));
            lstP.add(new Parametro(6, objrolpagos.getCanthorasnocturas()));
            lstP.add(new Parametro(7, objrolpagos.getHorasnocturnas()));
            lstP.add(new Parametro(8, objrolpagos.getCanthorassuplementarias()));
            lstP.add(new Parametro(9, objrolpagos.getHorassuplementarias()));
            lstP.add(new Parametro(10, objrolpagos.getDecimo_tercer()));
            lstP.add(new Parametro(11, objrolpagos.getDecimo_cuarto()));
            lstP.add(new Parametro(12, objrolpagos.getComisiones()));
            lstP.add(new Parametro(13, objrolpagos.getIngresosnograbados()));
            lstP.add(new Parametro(14, objrolpagos.getOtros()));
            lstP.add(new Parametro(15, objrolpagos.getBonificaciones()));
            lstP.add(new Parametro(16, objrolpagos.getTotal_ingresos()));
            lstP.add(new Parametro(17, objrolpagos.getAporte_personal()));
            lstP.add(new Parametro(18, objrolpagos.getMultas()));
            lstP.add(new Parametro(19, objrolpagos.getAnticipo_sueldos()));
            lstP.add(new Parametro(20, objrolpagos.getUniformes()));
            lstP.add(new Parametro(21, objrolpagos.getAtrasos()));
            lstP.add(new Parametro(22, objrolpagos.getComisariato()));
            lstP.add(new Parametro(23, objrolpagos.getAlimentacion()));
            lstP.add(new Parametro(24, objrolpagos.getTotal_deducciones()));
            lstP.add(new Parametro(25, objrolpagos.getFonde_reserva()));
            lstP.add(new Parametro(26, objrolpagos.getLiquido_a_recibir()));
            lstP.add(new Parametro(27, objrolpagos.getCheque()));
             lstP.add(new Parametro(28, objrolpagos.getHoras_trabajadas()));
              lstP.add(new Parametro(29, objrolpagos.getVacaciones()));
               lstP.add(new Parametro(30, objrolpagos.getPrestamo_iess()));
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
    public static boolean AprobarRoldepagos(rol_de_pagos objrolpagos) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select f_aprobar_rol_de_pagos(?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, objrolpagos.getId_rol_pagos()));
            lstP.add(new Parametro(2, objrolpagos.getObjEstado().getId_estado_aprobacion()));
            
       
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
    public static boolean eliminarRoldepagos(rol_de_pagos objrolpagos) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select f_delete_rol_de_pagos(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, objrolpagos.getId_rol_pagos()));

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

    //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<rol_de_pagos> llenarRoldepagos(ConjuntoResultado rs) throws Exception {
        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        rol_de_pagos objRolpagos = null;
        try {
            while (rs.next()) {
                empresa objEmpresa = new empresa();
                //  objEmpresa.setId_empresa(rs.getInt(13));
                objEmpresa.setApellido_usuario(rs.getString(13));

                empleado objEmpleado = new empleado();
                //objEmpleado.setId_empleado(rs.getInt(14));
                objEmpleado.setId_empleado(rs.getInt(14));
                objEmpleado.setNombres(rs.getString(15));
                objEmpleado.setApellidos(rs.getString(16));
                objEmpleado.setCedula(rs.getString(17));
                objEmpleado.setFecha_inicio(rs.getDate(18));
                objEmpleado.setSueldo(rs.getBigDecimal(19));

                departamento objDepartamento = new departamento();
                objDepartamento.setDescripcion(rs.getString(20));

                rol objRol = new rol();
                objRol.setNombre_rol(rs.getString(21));

                usuario objEcargado = new usuario();
                objEcargado.setNombre(rs.getString(35));
                objEcargado.setApellido(rs.getString(36));

                estado_aprobacion objEstado = new estado_aprobacion();
                objEstado.setId_estado_aprobacion(rs.getInt(41));
                objEstado.setNombre_estado(rs.getString(42));

                objRolpagos = new rol_de_pagos(rs.getInt(0), rs.getString(1), rs.getInt(2),
                        rs.getBigDecimal(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getBigDecimal(6),
                        rs.getBigDecimal(7), rs.getBigDecimal(8), rs.getBigDecimal(9), rs.getBigDecimal(10),
                        rs.getBigDecimal(11), rs.getBigDecimal(12), objEmpresa, objEmpleado, objDepartamento, objRol, rs.getBigDecimal(22),
                        rs.getBigDecimal(23), rs.getBigDecimal(24), rs.getBigDecimal(25), rs.getBigDecimal(26),
                        rs.getBigDecimal(27), rs.getBigDecimal(28), rs.getBigDecimal(29), rs.getBigDecimal(30), rs.getBigDecimal(31),
                        rs.getInt(32), rs.getInt(33), rs.getInt(34), objEcargado, rs.getString(37), rs.getInt(38), rs.getBigDecimal(39), rs.getBigDecimal(40),
                        objEstado);
                lst.add(objRolpagos);

            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    ///////seleccionar todas las dependencias
    public static ArrayList<rol_de_pagos> obtenerTodosroldepagos() throws Exception {

        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_rol_de_pagos_v2()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRoldepagos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<rol_de_pagos> obtenerAuxiliarroldepagos() throws Exception {

        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_rol_de_pagos_a()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRoldepagos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<rol_de_pagos> obtenerContabilidadroldepagos() throws Exception {

        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_rol_de_pagos_c()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRoldepagos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<rol_de_pagos> obtenerSistemasroldepagos() throws Exception {

        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_rol_de_pagos_s()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRoldepagos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    

    public static ArrayList<rol_de_pagos> obtenerAlgunosroldepagosNuevo(String fechain, Integer depart) throws Exception {

        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        ArrayList<Parametro> lstP;
        lstP = new ArrayList<>();
        try {

            String sql = "select * from public.f_select_rol_de_pagos_fecha_nuevo(?,?)";
            lstP.add(new Parametro(1, fechain));
            lstP.add(new Parametro(2, depart));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarRoldepagos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        System.err.println(lst);
        return lst;
    }

    public static ArrayList<rol_de_pagos> obtenerAlgunosroldepagos(String fechain) throws Exception {

        ArrayList<rol_de_pagos> lst = new ArrayList<>();
        ArrayList<Parametro> lstP;
        lstP = new ArrayList<>();
        try {

            String sql = "select * from public.f_select_rol_de_pagos_fecha(?)";
            lstP.add(new Parametro(1, fechain));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarRoldepagos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        System.err.println(lst);
        return lst;
    }

    ///////eliminar
    public static boolean eliminarRoldepagos(int idRol) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_rol_de_pagos(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idRol));
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

    public static rol_de_pagos buscarDatos(String codigo, Integer mes, Integer anio) throws Exception {
        rol_de_pagos objrol = new rol_de_pagos();
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_empleado_cedula(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            objrol = llenarRoldepagos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objrol;
    }

    public static Integer buscarTotalDias(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalDias = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_dias_trabajados(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalDias = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalDias;
    }

    public static Integer buscarTotalNocturnas(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalNocturnas = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_horas_nocturnas(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalNocturnas = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalNocturnas;
    }

    public static Integer buscarTotalSuplementarias(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalSuplementarias = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_horas_suplementaria(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalSuplementarias = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalSuplementarias;
    }

    public static Integer buscarTotalHoras(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalSuplementarias = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_horas_trabajadas(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalSuplementarias = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalSuplementarias;
    }

    public static Integer buscarTotalFinSemana(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalFinSemana = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_horas_fin_semana(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalFinSemana = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalFinSemana;
    }

    public static Integer buscarTotalFeriados(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalFeriados = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_horas_feriados(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalFeriados = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalFeriados;
    }

    public static Integer buscarHorasTrabajadas(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalHoras = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_horas_trabajadas(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalHoras = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalHoras;
    }

    public static Integer buscarTotalAtrasos(String codigo, Integer mes, Integer anio) throws Exception {
        Integer totalAtrasos = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_asistencia_total_atrasos(?,?,?)";
            lstP.add(new Parametro(1, codigo));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, anio));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                totalAtrasos = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return totalAtrasos;
    }

    public static String buscarValorAtrasos(Integer cant) throws Exception {
        String valAtrasos = "0";
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_valor_atrasos(?)";
            lstP.add(new Parametro(1, cant));

            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                valAtrasos = rs.getString(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return valAtrasos;
    }

    public static Boolean buscarTiempoTrabajo(String cedula, String fecha) throws Exception {
        boolean respuesta = false;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_tiempo_trabajo(?,?)";
            lstP.add(new Parametro(1, cedula));
            lstP.add(new Parametro(2, fecha));
            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                respuesta = rs.getBoolean(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return respuesta;
    }

    public static Boolean buscar_acumula13(String cedula) throws Exception {
        boolean respuesta = false;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_acumula_13(?)";
            lstP.add(new Parametro(1, cedula));

            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                respuesta = rs.getBoolean(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return respuesta;
    }

    public static Boolean buscar_acumula14(String cedula) throws Exception {
        boolean respuesta = false;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_acumula_14(?)";
            lstP.add(new Parametro(1, cedula));

            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                respuesta = rs.getBoolean(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return respuesta;
    }
}
