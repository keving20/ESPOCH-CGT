/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.tipo_usuario;
import entidades.usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_usuario {
    
    
    
    
    //<editor-fold defaultstate="collapsed" desc="AUTENTICAR USUARIO">
    public  boolean LoginUsuario(String usuario, String contrasena) throws Exception {
        ArrayList<usuario> lst = new ArrayList<>();

        int cont = 0;
        boolean valor = false;
        String sql = "select * from public.f_autenticacion_usuario('" + usuario + "','" + contrasena + "')";
        ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    cont = cont + 1;
                }
            } catch (Exception e) {
                lst.clear();
                throw e;
            }
        }

        if (cont >= 1) {

            valor = true;
        }

        return valor;
    }

    //</editor-fold>
    
 
    //<editor-fold defaultstate="collapsed" desc="BUSCAR USUARIO">
   public usuario DatosUsuario(String cedula) throws Exception {
        usuario obj;
        try {
            ArrayList<Parametro> lstU = new ArrayList<>();
            String sql = "select * from public.f_buscar_usuario(?)";
            lstU.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstU);
            obj = new usuario();
            obj = llenarUsuario(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return obj;
    }

    //</editor-fold>
   
   
     public static ArrayList<usuario> llenarUsuario(ConjuntoResultado rs) throws Exception {
        ArrayList<usuario> lst = new ArrayList<>();
        usuario objusuario = null;
        try {    
            while (rs.next()) {
                tipo_usuario objTipousuario=new tipo_usuario();
                objTipousuario.setId_tipousuario( rs.getInt(5));
                objTipousuario.setDescripcion_tusuario(rs.getString(6));
                
                objusuario = new usuario(rs.getInt(0),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),objTipousuario);
                lst.add(objusuario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
     
     
     
      public static boolean insertarUsuario(usuario objUsuario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.fn_insert_usuario(?,?,?,?,?)";

            lstP.add(new Parametro(1, objUsuario.getCedula()));
            lstP.add(new Parametro(2, objUsuario.getClave()));
            lstP.add(new Parametro(3, objUsuario.getNombre()));
            lstP.add(new Parametro(4, objUsuario.getApellido()));
            lstP.add(new Parametro(5, objUsuario.getObjTipousuario().getId_tipousuario()));
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
      //
         public static boolean insertarTrabajador(int id_usuario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.fn_insert_trabajador(?)";

            lstP.add(new Parametro(1, id_usuario));

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
         
           //
         public static boolean insertarEmpresa(int id_usuario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.fn_insert_empresa(?)";

            lstP.add(new Parametro(1, id_usuario));

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
      
      
       ///////seleccionar todas las dependencias
    public static ArrayList<usuario> obtenerTodosusuario() throws Exception {
        ArrayList<usuario> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_usuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUsuario(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
         ///////modificar
    public static boolean modificarUsuario(usuario objUsuario ) throws Exception {
       
        
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_usuario(?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
           
            lstP.add(new Parametro(1, objUsuario.getId_usuario()));
            lstP.add(new Parametro(2, objUsuario.getCedula()));
            lstP.add(new Parametro(3, objUsuario.getClave()));
            lstP.add(new Parametro(4, objUsuario.getNombre()));
            lstP.add(new Parametro(5, objUsuario.getApellido()));
            
           
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
    public static Integer traerUltimoId() throws Exception {
        Integer id_trabajador = 0;

        try {
            String sql = "select * from public.f_select_ultimo_usuario()";
           
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);

            while (rs.next()) {
                id_trabajador = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return id_trabajador;
    }
    
      ///////eliminar
    public static boolean eliminarUsuario(int idUsuario) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_usuario(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idUsuario));
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
