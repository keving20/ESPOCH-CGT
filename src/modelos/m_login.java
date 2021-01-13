/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.usuario;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public class m_login {
   
       public static boolean registrarUsuario(usuario objusuario) throws Exception {
        boolean respuesta = false;
        try {
            ArrayList<Parametro> lstParamUsusario = new ArrayList<>();
            String sql = "SELECT public.fn_insert_usuario(?,?)";
            lstParamUsusario.add(new Parametro(1, objusuario.getCedula()));
            lstParamUsusario.add(new Parametro(2, objusuario.getClave()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParamUsusario);
            while (rs.next()) {
                if (rs.getBoolean(0)) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    
    public static Boolean existeUsuario(String identificacion) throws Exception {
        Boolean correcto = false;
        try {
            String sql = "SELECT * FROM public.fn_existeUsuario(?) ";
            ArrayList<Parametro> lstParam = new ArrayList<>();           
            lstParam.add(new Parametro(1, identificacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                correcto = rs.getBoolean(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return correcto;
    }

    public static Boolean loginCorrecto(String identificacion, String clave) throws Exception {
        Boolean correcto = false;
        try {
            String sql = "SELECT * FROM public.fn_logincorrecto_usuario(?,?) ";
            ArrayList<Parametro> lstParam = new ArrayList<>();
           
            lstParam.add(new Parametro(1, identificacion));
            lstParam.add(new Parametro(2, clave));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstParam);
            while (rs.next()) {
                correcto = rs.getBoolean(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return correcto;
    }
    
}
