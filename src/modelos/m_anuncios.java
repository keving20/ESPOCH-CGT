package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.anuncios;
import entidades.empresa;
import entidades.solicitudes_trab;
import entidades.trabajador;
import entidades.usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class m_anuncios{

    //////////////////////////////////////////////////////////////
  
    //////traer id del trabajador
    public static Integer traerIdEmpresa(int usuario) throws Exception {
        Integer id_empresa = 0;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from public.f_select_empresa_por_id(?)";
            lstP.add(new Parametro(1, usuario));

            //System.out.println(codigo+mes+anio);
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                id_empresa = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return id_empresa;
    }

 ///////seleccionar las solicitudes de un trabjador por un id
    public static ArrayList<anuncios> obtenerAnuncios(int id_usuario) throws Exception {
        ArrayList<anuncios> lst = new ArrayList<>();
        ArrayList<Parametro> lstP = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_ofertas_empresa(?)";
            lstP.add(new Parametro(1, id_usuario));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarAnuncios(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
      //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<anuncios> llenarAnuncios(ConjuntoResultado rs) throws Exception {
        ArrayList<anuncios> lst = new ArrayList<>();
        anuncios objAnuncios = null;
        try {
            while (rs.next()) {

                objAnuncios = new anuncios(rs.getInt(0), rs.getString(1), rs.getBigDecimal(2), rs.getString(3), rs.getString(4),rs.getString(5),  rs.getString(6), rs.getString(7), rs.getString(8));
                lst.add(objAnuncios);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

 
      public static boolean insertarAnuncio(int id_empresa,anuncios objAnuncio) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            String sql = "SELECT public.f_insert_oferta(?,?,?,?,?)";

            lstP.add(new Parametro(1, id_empresa));
            lstP.add(new Parametro(2, objAnuncio.getNombre_oferta()));
            lstP.add(new Parametro(3, objAnuncio.getRemuneracion()));
            lstP.add(new Parametro(4, objAnuncio.getActividades()));
            lstP.add(new Parametro(5, objAnuncio.getUbicacion()));
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
    public static boolean eliminarAnuncio(int idAnuncio) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_oferta(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idAnuncio));
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
    public static boolean modificarAnuncio(anuncios objAnuncio) throws Exception {
            
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();

            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_update_oferta(?,?,?,?,?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
           
            lstP.add(new Parametro(1, objAnuncio.getId_oferta()));
            lstP.add(new Parametro(2, objAnuncio.getNombre_oferta()));
            lstP.add(new Parametro(3, objAnuncio.getRemuneracion()));
            lstP.add(new Parametro(4, objAnuncio.getActividades()));
            lstP.add(new Parametro(5, objAnuncio.getUbicacion()));
            
           
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
