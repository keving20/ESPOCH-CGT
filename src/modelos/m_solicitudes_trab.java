package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
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
public class m_solicitudes_trab {

    //////////////////////////////////////////////////////////////
    //para  llenar en memoria los datos que provienen de la BD hacemos lo siguiente
    public static ArrayList<solicitudes_trab> llenarSolicitudesTrab(ConjuntoResultado rs) throws Exception {
        ArrayList<solicitudes_trab> lst = new ArrayList<>();
        solicitudes_trab sol_trabajador = null;
        try {
            while (rs.next()) {

                sol_trabajador = new solicitudes_trab(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4),rs.getString(5),  rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
                lst.add(sol_trabajador);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
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

 ///////seleccionar las solicitudes de un trabjador por un id
    public static ArrayList<solicitudes_trab> obtenerSolicitudesTrab(int id_usuario) throws Exception {
        ArrayList<solicitudes_trab> lst = new ArrayList<>();
        ArrayList<Parametro> lstP = new ArrayList<>();
        try {
            String sql = "select * from public.f_select_solicitud_trabajador(?)";
            lstP.add(new Parametro(1, id_usuario));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarSolicitudesTrab(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }


    ///////eliminar
    public static boolean eliminarSolicitud(int idSolicitud) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            ////declaro una variable de tipo String que guardar el llamado a la funcion de postgres con los parametros representados por signo de integrracion
            String sql = "select * from public.f_delete_solicitud(?)";
            //////lenamos cada parametro de acuerdo al nuimer y orden establecido en la funcion
            lstP.add(new Parametro(1, idSolicitud));
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
