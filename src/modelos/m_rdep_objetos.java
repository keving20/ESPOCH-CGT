/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.aplica_convenio_doble_imposicion;
import entidades.beneficio_provincia_galapagos;
import entidades.condicion_trabajador_respecto_discapacidades;
import entidades.enfermedad_catastrofica;
import entidades.pais;
import entidades.rdep_objetos;
import entidades.residencia_trabajador;
import entidades.tipo_identificacion;
import entidades.tipos_sistema_salario;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.u_empleado;
import utilidades.u_rdep;

/**
 *
 * @author USER
 */
public class m_rdep_objetos {
    
     public static boolean insertarRdepobjetos(rdep_objetos objrdep) throws Exception {
        boolean bandera = false;
        try {
            ////declaro un arreglo de parametros para llenar la informacion que se insertara en la tabla dependencia
            ArrayList<Parametro> lstP = new ArrayList<>();
                 
            
           String sql = "select * from public.f_insert_rdep(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         
            
            ///OJOOO CAMBIAR ANIOOOOOOOOOOOOOOOOOOOO
            
            
            lstP.add(new Parametro(1, objrdep.getRuc_empleador()));
            lstP.add(new Parametro(2, objrdep.getAnio()));
            lstP.add(new Parametro(3, objrdep.getObjBeneficio_galapagos().getCodigo()));
            lstP.add(new Parametro(4, objrdep.getObjTrabajador_enfermedad_cat().getCodigo()));
            lstP.add(new Parametro(5, objrdep.getObjTipo_identificacion().getCodigo()));
            lstP.add(new Parametro(6, objrdep.getIdentificacion_trabajador()));            
            lstP.add(new Parametro(7, objrdep.getApellidos_trabajador()));
            lstP.add(new Parametro(8, objrdep.getNombres_trabajador()));
            lstP.add(new Parametro(9, objrdep.getCodigo_establecimiento()));
            lstP.add(new Parametro(10,objrdep.getObjResidencia_trabajador().getCodigo()));
            lstP.add(new Parametro(11, objrdep.getObjPais_residencia().getCodigo()));
            lstP.add(new Parametro(12, objrdep.getObjConvenio_doble_imp().getCodigo()));
            lstP.add(new Parametro(13, objrdep.getObjCond_trabajador_resp_discapacidad().getCodigo()));
            lstP.add(new Parametro(14, objrdep.getPorcentaje_discapacidad()));
            lstP.add(new Parametro(15, objrdep.getObjTipo_ident_per_discap().getCodigo()));
            lstP.add(new Parametro(16, objrdep.getIdentificacion_persona_discap()));            
            lstP.add(new Parametro(17, objrdep.getSueldo()));
            lstP.add(new Parametro(18, objrdep.getSobresueldo()));
            lstP.add(new Parametro(19, objrdep.getPart_utilidades()));            
            lstP.add(new Parametro(20, objrdep.getIngresos_gravados_o_simple()));
            lstP.add(new Parametro(21, objrdep.getImp_renta_asumido()));
            lstP.add(new Parametro(22, objrdep.getDecimo_tercer_sueldo()));
            lstP.add(new Parametro(23, objrdep.getDecimo_cuarto_sueldo()));
            lstP.add(new Parametro(24, objrdep.getFondo_reserva()));
            lstP.add(new Parametro(25, objrdep.getSalario_digno()));
            lstP.add(new Parametro(26, objrdep.getIngresos_no_gravados()));
            lstP.add(new Parametro(27, objrdep.getIngresos_gravados()));
            lstP.add(new Parametro(28, objrdep.getObjSistema_salario_neto().getCodigo()));
            lstP.add(new Parametro(29, objrdep.getAporte_iess()));
            lstP.add(new Parametro(30, objrdep.getAporte_otro_empleador()));
            lstP.add(new Parametro(31, objrdep.getDeduccion_vivienda()));
            lstP.add(new Parametro(32, objrdep.getDeduccion_salud()));
            lstP.add(new Parametro(33, objrdep.getDeduccion_educacion_arte()));
            lstP.add(new Parametro(34, objrdep.getDeduccion_alimentacion()));
            lstP.add(new Parametro(35, objrdep.getDeduccion_vestimenta()));
            lstP.add(new Parametro(36, objrdep.getExoneracion_discapacidad()));
            lstP.add(new Parametro(37, objrdep.getExoneracion_tercera_edad()));
            lstP.add(new Parametro(38, objrdep.getBase_imponible_gravada()));
            lstP.add(new Parametro(39, objrdep.getImpuesto_renta_causado()));
            lstP.add(new Parametro(40, objrdep.getValor_impuesto_retenido()));
            lstP.add(new Parametro(41, objrdep.getValor_impuesto_asumido()));
            lstP.add(new Parametro(42, objrdep.getValor_impuesto_retenido_por_empleador()));
              
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
    public static ArrayList<rdep_objetos> llenarRdep_objetos(ConjuntoResultado rs) throws Exception {
        ArrayList<rdep_objetos> lst = new ArrayList<>();
        rdep_objetos objRdep = null;
        try {    
            while (rs.next()) {
                
                beneficio_provincia_galapagos objBgalapagos = new beneficio_provincia_galapagos();
                objBgalapagos.setDescripcion(rs.getString(3));
                
                enfermedad_catastrofica objEnfermedad= new enfermedad_catastrofica();
                objEnfermedad.setDescripcion(rs.getString(4));
                
                tipo_identificacion objTipoidentificacion= new tipo_identificacion();
                objTipoidentificacion.setDescripcion(rs.getString(5));
                
                residencia_trabajador objResidencia= new residencia_trabajador();
                objResidencia.setDescripcion(rs.getString(10));
                
                pais objPais = new pais();
                objPais.setPais(rs.getString(11));
                
                aplica_convenio_doble_imposicion objAplicaconvenio= new aplica_convenio_doble_imposicion();
                objAplicaconvenio.setDescripcion(rs.getString(12));
                
                condicion_trabajador_respecto_discapacidades objCondiciontdiscapacidades= new condicion_trabajador_respecto_discapacidades();
                objCondiciontdiscapacidades.setDescripcion(rs.getString(13));
                
                tipo_identificacion objTipoidentificaciondiscapacidad= new tipo_identificacion();
                objTipoidentificaciondiscapacidad.setDescripcion(rs.getString(15));
                
                tipos_sistema_salario objSistemasalarioneto= new tipos_sistema_salario();
                objSistemasalarioneto.setDescripcion(rs.getString(28));
                
                
                objRdep = new rdep_objetos(rs.getInt(0),rs.getString(1),rs.getString(2),objBgalapagos,objEnfermedad,objTipoidentificacion,
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),objResidencia,objPais,objAplicaconvenio,
                        objCondiciontdiscapacidades,rs.getInt(14),objTipoidentificaciondiscapacidad,rs.getString(16),rs.getBigDecimal(17),
                        rs.getBigDecimal(18),rs.getBigDecimal(19),rs.getBigDecimal(20),rs.getBigDecimal(21),rs.getBigDecimal(22),
                        rs.getBigDecimal(23),rs.getBigDecimal(24),rs.getBigDecimal(25),rs.getBigDecimal(26),rs.getBigDecimal(27),
                        objSistemasalarioneto,rs.getBigDecimal(29),rs.getBigDecimal(30),rs.getBigDecimal(31),rs.getBigDecimal(32),
                        rs.getBigDecimal(33),rs.getBigDecimal(34),rs.getBigDecimal(35),rs.getBigDecimal(36),rs.getBigDecimal(37),
                        rs.getBigDecimal(38),rs.getBigDecimal(39),rs.getBigDecimal(40),rs.getBigDecimal(41),rs.getBigDecimal(42));
                lst.add(objRdep);
            }
                    } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    
       ///////seleccionar todas las dependencias
    public static ArrayList<rdep_objetos> obtenerTodosrdep_objetos() throws Exception {
        ArrayList<rdep_objetos> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM public.f_select_rdep() ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRdep_objetos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
      
      
}
