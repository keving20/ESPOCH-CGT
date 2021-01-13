/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;

import entidades.multas;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Araujo
 */
public class m_multas {
    public static ArrayList<multas> llenarMultas(ConjuntoResultado rs) throws Exception {
        ArrayList<multas> lst = new ArrayList<>();
        multas multas = null;
        try {    
            while (rs.next()) {                              
                
                multas objMultas = new multas();
                objMultas.setId_multas(rs.getInt(0));
                objMultas.setValor(rs.getBigDecimal(1));
                 objMultas.setCant_multas(rs.getInt(2));            
                multas= new multas(rs.getInt(0),rs.getBigDecimal(1),rs.getInt(2));
                        lst.add(multas);

            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }    
    
     public static ArrayList<multas> obtenerTodosMultas() throws Exception {
        ArrayList<multas> lst = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_multas()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarMultas(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     
     public static boolean modificarMultas(multas multas) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_valores_multas(?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, multas.getId_multas()));
            lstP.add(new Parametro(2, multas.getValor()));
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
