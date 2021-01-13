/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.aplica_convenio_doble_imposicion;
import entidades.beneficio_provincia_galapagos;
import entidades.condicion_trabajador_respecto_discapacidades;
import entidades.empleado;
import entidades.enfermedad_catastrofica;
import entidades.pais;
import entidades.rdep_objetos;
import entidades.residencia_trabajador;
import entidades.tipo_identificacion;
import entidades.tipos_sistema_salario;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import modelos.m_empleado;
import modelos.m_pais;
import modelos.m_rdep_objetos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_rdep {

    public static String xml;
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("accesodatos.database");
    public String creacionxml = Configuracion.getString("xml");
    public BigDecimal SumaIngresos;
    public BigDecimal SumaDeducciones;
    public BigDecimal Total;
    public rdep_objetos objRdep;
    public rdep_objetos objSeleccionadoRdep;
    public beneficio_provincia_galapagos objBeneficio_galapagos;
    public enfermedad_catastrofica objTrabajador_enfermedad_cat;
    public tipo_identificacion objTipo_identificacion;
    public residencia_trabajador objResidencia_trabajador;
    public pais objPais_residencia;
    public aplica_convenio_doble_imposicion objConvenio_doble_imp;
    public condicion_trabajador_respecto_discapacidades objCond_trabajador_resp_discapacidad;
    public tipo_identificacion objTipo_ident_per_discap;
    public tipos_sistema_salario objSistema_salario_neto;
    public empleado objEmpleado;
    public ArrayList<rdep_objetos> listaRdep;
    public ArrayList<rdep_objetos> listaRdep1;
    public ArrayList<pais> listaPais;
    public String cedula;

    private void reinit() {
        this.objRdep = new rdep_objetos();

        objRdep.setSueldo(BigDecimal.ZERO);
        objRdep.setSobresueldo(BigDecimal.ZERO);
        objRdep.setPart_utilidades(BigDecimal.ZERO);
        objRdep.setIngresos_gravados_o_simple(BigDecimal.ZERO);
        objRdep.setImp_renta_asumido(BigDecimal.ZERO);
        objRdep.setDecimo_tercer_sueldo(BigDecimal.ZERO);
        objRdep.setDecimo_cuarto_sueldo(BigDecimal.ZERO);
        objRdep.setFondo_reserva(BigDecimal.ZERO);
        objRdep.setSalario_digno(BigDecimal.ZERO);
        objRdep.setIngresos_no_gravados(BigDecimal.ZERO);
        objRdep.setIngresos_gravados(BigDecimal.ZERO);
        objRdep.setAporte_iess(BigDecimal.ZERO);
        objRdep.setAporte_otro_empleador(BigDecimal.ZERO);
        objRdep.setDeduccion_alimentacion(BigDecimal.ZERO);
        objRdep.setDeduccion_educacion_arte(BigDecimal.ZERO);
        objRdep.setDeduccion_salud(BigDecimal.ZERO);
        objRdep.setDeduccion_vestimenta(BigDecimal.ZERO);
        objRdep.setDeduccion_vivienda(BigDecimal.ZERO);
        objRdep.setExoneracion_discapacidad(BigDecimal.ZERO);
        objRdep.setExoneracion_tercera_edad(BigDecimal.ZERO);
        objRdep.setBase_imponible_gravada(BigDecimal.ZERO);
        objRdep.setImpuesto_renta_causado(BigDecimal.ZERO);
        objRdep.setValor_impuesto_asumido(BigDecimal.ZERO);
        objRdep.setValor_impuesto_retenido(BigDecimal.ZERO);
        objRdep.setValor_impuesto_retenido_por_empleador(BigDecimal.ZERO);
        objRdep.setIdentificacion_persona_discap("999");

        this.objSeleccionadoRdep = new rdep_objetos();
       // this.objEmpleado = new empleado();

        this.objBeneficio_galapagos = new beneficio_provincia_galapagos();
        objRdep.setObjBeneficio_galapagos(objBeneficio_galapagos);

        this.objTrabajador_enfermedad_cat = new enfermedad_catastrofica();
        objRdep.setObjTrabajador_enfermedad_cat(objTrabajador_enfermedad_cat);

        this.objTipo_identificacion = new tipo_identificacion();
        objRdep.setObjTipo_identificacion(objTipo_identificacion);

        this.objResidencia_trabajador = new residencia_trabajador();
        objRdep.setObjResidencia_trabajador(objResidencia_trabajador);

        this.objPais_residencia = new pais();
        objRdep.setObjPais_residencia(objPais_residencia);

        this.objConvenio_doble_imp = new aplica_convenio_doble_imposicion();
        objRdep.setObjConvenio_doble_imp(objConvenio_doble_imp);

        this.objCond_trabajador_resp_discapacidad = new condicion_trabajador_respecto_discapacidades();
        objRdep.setObjCond_trabajador_resp_discapacidad(objCond_trabajador_resp_discapacidad);

        this.objTipo_ident_per_discap = new tipo_identificacion();
        objRdep.setObjTipo_ident_per_discap(objTipo_ident_per_discap);

        this.objSistema_salario_neto = new tipos_sistema_salario();
        objRdep.setObjSistema_salario_neto(objSistema_salario_neto);

        this.listaRdep = new ArrayList<>();
        this.listaRdep1 = new ArrayList<>();
        this.listaPais = new ArrayList<>();
        this.cargarRdep();
    }

    public c_rdep() {
        this.reinit();
    }

    public BigDecimal getSumaIngresos() {
        return SumaIngresos;
    }

    public void setSumaIngresos(BigDecimal SumaIngresos) {
        this.SumaIngresos = SumaIngresos;
    }

    public BigDecimal getSumaDeducciones() {
        return SumaDeducciones;
    }

    public void setSumaDeducciones(BigDecimal SumaDeducciones) {
        this.SumaDeducciones = SumaDeducciones;
    }

    public BigDecimal getTotal() {
        return Total;
    }

    public void setTotal(BigDecimal Total) {
        this.Total = Total;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public rdep_objetos getObjRdep() {
        return objRdep;
    }

    public void setObjRdep(rdep_objetos objRdep) {
        this.objRdep = objRdep;
    }

    public rdep_objetos getObjSeleccionadoRdep() {
        return objSeleccionadoRdep;
    }

    public void setObjSeleccionadoRdep(rdep_objetos objSeleccionadoRdep) {
        this.objSeleccionadoRdep = objSeleccionadoRdep;
    }

    public ArrayList<rdep_objetos> getListaRdep() {
        return listaRdep;
    }

    public void setListaRdep(ArrayList<rdep_objetos> listaRdep) {
        this.listaRdep = listaRdep;
    }

    public ArrayList<rdep_objetos> getListaRdep1() {
        return listaRdep1;
    }

    public void setListaRdep1(ArrayList<rdep_objetos> listaRdep1) {
        this.listaRdep1 = listaRdep1;
    }

    public beneficio_provincia_galapagos getObjBeneficio_galapagos() {
        return objBeneficio_galapagos;
    }

    public void setObjBeneficio_galapagos(beneficio_provincia_galapagos objBeneficio_galapagos) {
        this.objBeneficio_galapagos = objBeneficio_galapagos;
    }

    public enfermedad_catastrofica getObjTrabajador_enfermedad_cat() {
        return objTrabajador_enfermedad_cat;
    }

    public void setObjTrabajador_enfermedad_cat(enfermedad_catastrofica objTrabajador_enfermedad_cat) {
        this.objTrabajador_enfermedad_cat = objTrabajador_enfermedad_cat;
    }

    public tipo_identificacion getObjTipo_identificacion() {
        return objTipo_identificacion;
    }

    public void setObjTipo_identificacion(tipo_identificacion objTipo_identificacion) {
        this.objTipo_identificacion = objTipo_identificacion;
    }

    public residencia_trabajador getObjResidencia_trabajador() {
        return objResidencia_trabajador;
    }

    public void setObjResidencia_trabajador(residencia_trabajador objResidencia_trabajador) {
        this.objResidencia_trabajador = objResidencia_trabajador;
    }

    public pais getObjPais_residencia() {
        return objPais_residencia;
    }

    public void setObjPais_residencia(pais objPais_residencia) {
        this.objPais_residencia = objPais_residencia;
    }

    public aplica_convenio_doble_imposicion getObjConvenio_doble_imp() {
        return objConvenio_doble_imp;
    }

    public void setObjConvenio_doble_imp(aplica_convenio_doble_imposicion objConvenio_doble_imp) {
        this.objConvenio_doble_imp = objConvenio_doble_imp;
    }

    public condicion_trabajador_respecto_discapacidades getObjCond_trabajador_resp_discapacidad() {
        return objCond_trabajador_resp_discapacidad;
    }

    public void setObjCond_trabajador_resp_discapacidad(condicion_trabajador_respecto_discapacidades objCond_trabajador_resp_discapacidad) {
        this.objCond_trabajador_resp_discapacidad = objCond_trabajador_resp_discapacidad;
    }

    public tipo_identificacion getObjTipo_ident_per_discap() {
        return objTipo_ident_per_discap;
    }

    public void setObjTipo_ident_per_discap(tipo_identificacion objTipo_ident_per_discap) {
        this.objTipo_ident_per_discap = objTipo_ident_per_discap;
    }

    public tipos_sistema_salario getObjSistema_salario_neto() {
        return objSistema_salario_neto;
    }

    public void setObjSistema_salario_neto(tipos_sistema_salario objSistema_salario_neto) {
        this.objSistema_salario_neto = objSistema_salario_neto;
    }

    public ArrayList<pais> getListaPais() {
        return listaPais;
    }

    public void setListaPais(ArrayList<pais> listaPais) {
        this.listaPais = listaPais;
    }

    public void cargarRdep() {
        try {

            listaRdep = m_rdep_objetos.obtenerTodosrdep_objetos();
            listaRdep1 = m_rdep_objetos.obtenerTodosrdep_objetos();
            listaPais = m_pais.obtenerTodospais();

        } catch (Exception e) {
        }
    }

    public void calcularIngresos() {
        SumaIngresos = new BigDecimal("0.00");
        SumaIngresos = objEmpleado.getSueldo().add(objRdep.getSobresueldo()).add(objRdep.getPart_utilidades()).add(objRdep.getIngresos_gravados_o_simple()).add(objRdep.getImp_renta_asumido());
     
    }

    public void calcularDeducciones() {
        SumaDeducciones = new BigDecimal("0.00");
        SumaDeducciones = objRdep.getAporte_iess().add(objRdep.getAporte_otro_empleador()).add(objRdep.getDeduccion_vivienda()).add(objRdep.getDeduccion_salud()).add(objRdep.getDeduccion_educacion_arte()).add(objRdep.getDeduccion_alimentacion()).add(objRdep.getDeduccion_vestimenta()).add(objRdep.getExoneracion_discapacidad()).add(objRdep.getExoneracion_tercera_edad());
       calcularTotal();
       
    }

    public void calcularTotal() {
        Total = SumaIngresos.subtract(SumaDeducciones);
        
    }

    public void cargarEmpleado() {
        try {
            objEmpleado = m_empleado.buscarEmpleado(cedula);
             
        objRdep.setIdentificacion_trabajador(objEmpleado.getCedula());
        objRdep.setApellidos_trabajador(objEmpleado.getApellidos());
        objRdep.setNombres_trabajador(objEmpleado.getNombres());
        objRdep.setCodigo_establecimiento(objEmpleado.getCod_empresa());
        objRdep.setSueldo(objEmpleado.getSueldo());
        } catch (Exception e) {
        }

    }

    public void insertarRdep() {
        String message;
         objRdep.setIngresos_gravados(SumaIngresos);
        objRdep.setBase_imponible_gravada(Total);
        
        
        try {

            boolean resultado = m_rdep_objetos.insertarRdepobjetos(objRdep);
            if (resultado == true) {

                message = "¡" + objRdep.getApellidos_trabajador() + " HA SIDO REGISTRADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
                CrearXml(objRdep);
            } else {
                message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO REALIZADO!"+e.toString();
            recursoMensajes.addSuccessMessage(message);
        }
    }

    public static void CrearXml(rdep_objetos objRdep) throws Exception {
        try {
             Date fecha = new Date();
             java.sql.Date fechafin= new java.sql.Date(fecha.getTime());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //Elemento raÃ­z
            Document doc = docBuilder.newDocument();
            Element rdep = doc.createElement("rdep");
            doc.appendChild(rdep);

            Element numRuc = doc.createElement("numRuc");
            numRuc.setTextContent(objRdep.getRuc_empleador());// OJO IR PONIENDO VALORES REALES
            rdep.appendChild(numRuc);

            Element anio = doc.createElement("anio");
            anio.setTextContent(objRdep.getAnio());// OJO IR PONIENDO VALORES REALES
            rdep.appendChild(anio);

            //Primer elemento
            Element retRelDep = doc.createElement("retRelDep");

            //  rdep.appendChild(datRetDep);
            Element datRetRelDep = doc.createElement("datRetRelDep");
            //  rdep.appendChild(empleado);
            Element empleado = doc.createElement("empleado");

            Element benGalpg = doc.createElement("benGalpg");
            benGalpg.setTextContent(objRdep.getObjBeneficio_galapagos().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(benGalpg);

            Element enfcatastro = doc.createElement("enfcatastro");
            enfcatastro.setTextContent(objRdep.getObjTrabajador_enfermedad_cat().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(enfcatastro);

            Element tipIdRet = doc.createElement("tipIdRet");
            tipIdRet.setTextContent(objRdep.getObjTipo_identificacion().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(tipIdRet);

            Element IdRet = doc.createElement("IdRet");
            IdRet.setTextContent(objRdep.getIdentificacion_trabajador());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(IdRet);

            Element apellidoTrab = doc.createElement("apellidoTrab");
            apellidoTrab.setTextContent(objRdep.getApellidos_trabajador());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(apellidoTrab);

            Element nombreTrab = doc.createElement("nombreTrab");
            nombreTrab.setTextContent(objRdep.getNombres_trabajador());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(nombreTrab);

            Element estab = doc.createElement("estab");
            estab.setTextContent(objRdep.getCodigo_establecimiento());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(estab);

            Element residenciaTrab = doc.createElement("residenciaTrab");
            residenciaTrab.setTextContent(objRdep.getObjResidencia_trabajador().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(residenciaTrab);

            Element paisResidencia = doc.createElement("paisResidencia");
            paisResidencia.setTextContent(objRdep.getObjPais_residencia().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(paisResidencia);

            Element aplicaConvenio = doc.createElement("aplicaConvenio");
            aplicaConvenio.setTextContent(objRdep.getObjConvenio_doble_imp().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(aplicaConvenio);

            Element tipoTrabajDiscap = doc.createElement("tipoTrabajDiscap");
            tipoTrabajDiscap.setTextContent(objRdep.getObjCond_trabajador_resp_discapacidad().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(tipoTrabajDiscap);

            Element porcentajeDiscap = doc.createElement("porcentajeDiscap");
            porcentajeDiscap.setTextContent(String.valueOf(objRdep.getPorcentaje_discapacidad()));// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(porcentajeDiscap);

            Element tipIdDiscap = doc.createElement("tipIdDiscap");
            tipIdDiscap.setTextContent(objRdep.getObjTipo_ident_per_discap().getCodigo());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(tipIdDiscap);

            Element idDiscap = doc.createElement("idDiscap");
            idDiscap.setTextContent(objRdep.getIdentificacion_persona_discap());// OJO IR PONIENDO VALORES REALES
            empleado.appendChild(idDiscap);

            datRetRelDep.appendChild(empleado);

            //Agrego datos empleado
            //Agrego Datos datRetRelDep
            Element suelSal = doc.createElement("suelSal");
            suelSal.setTextContent(String.valueOf(objRdep.getSueldo()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(suelSal);

            Element sobSuelComRemu = doc.createElement("sobSuelComRemu");
            sobSuelComRemu.setTextContent(String.valueOf(objRdep.getSobresueldo()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(sobSuelComRemu);

            Element partUtil = doc.createElement("partUtil");
            partUtil.setTextContent(String.valueOf(objRdep.getPart_utilidades()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(partUtil);

            Element intGrabGen = doc.createElement("intGrabGen");
            intGrabGen.setTextContent(String.valueOf(objRdep.getIngresos_gravados_o_simple()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(intGrabGen);

            Element impRentEmpl = doc.createElement("impRentEmpl");
            impRentEmpl.setTextContent(String.valueOf(objRdep.getImp_renta_asumido()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(impRentEmpl);

            Element decimTer = doc.createElement("decimTer");
            decimTer.setTextContent(String.valueOf(objRdep.getDecimo_tercer_sueldo()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(decimTer);

            Element decimCuar = doc.createElement("decimCuar");
            decimCuar.setTextContent(String.valueOf(objRdep.getDecimo_cuarto_sueldo()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(decimCuar);

            Element fondoReserva = doc.createElement("fondoReserva");
            fondoReserva.setTextContent(String.valueOf(objRdep.getFondo_reserva()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(fondoReserva);

            Element salarioDigno = doc.createElement("salarioDigno");
            salarioDigno.setTextContent(String.valueOf(objRdep.getSalario_digno()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(salarioDigno);

            Element otrosIngRenGrav = doc.createElement("otrosIngRenGrav");
            otrosIngRenGrav.setTextContent(String.valueOf(objRdep.getIngresos_no_gravados()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(otrosIngRenGrav);

            Element ingGravConEsteEmpl = doc.createElement("ingGravConEsteEmpl");
            ingGravConEsteEmpl.setTextContent(String.valueOf(objRdep.getIngresos_gravados()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(ingGravConEsteEmpl);

            Element sisSalNet = doc.createElement("sisSalNet");
            sisSalNet.setTextContent(String.valueOf(objRdep.getObjSistema_salario_neto().getCodigo()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(sisSalNet);

            Element apoPerIess = doc.createElement("apoPerIess");
            apoPerIess.setTextContent(String.valueOf(objRdep.getAporte_iess()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(apoPerIess);

            Element aporPerIessConOtrosEmpls = doc.createElement("aporPerIessConOtrosEmpls");
            aporPerIessConOtrosEmpls.setTextContent(String.valueOf(objRdep.getAporte_otro_empleador()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(aporPerIessConOtrosEmpls);

            Element deducVivienda = doc.createElement("deducVivienda");
            deducVivienda.setTextContent(String.valueOf(objRdep.getDeduccion_vivienda()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(deducVivienda);

            Element deducSalud = doc.createElement("deducSalud");
            deducSalud.setTextContent(String.valueOf(objRdep.getDeduccion_salud()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(deducSalud);

            Element deducEducartcult = doc.createElement("deducEducartcult");
            deducEducartcult.setTextContent(String.valueOf(objRdep.getDeduccion_educacion_arte()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(deducEducartcult);

            Element deducAliement = doc.createElement("deducAliement");
            deducAliement.setTextContent(String.valueOf(objRdep.getDeduccion_alimentacion()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(deducAliement);

            Element deducVestim = doc.createElement("deducVestim");
            deducVestim.setTextContent(String.valueOf(objRdep.getDeduccion_vestimenta()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(deducVestim);

            Element exoDiscap = doc.createElement("exoDiscap");
            exoDiscap.setTextContent(String.valueOf(objRdep.getExoneracion_discapacidad()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(exoDiscap);

            Element exoTerEd = doc.createElement("exoTerEd");
            exoTerEd.setTextContent(String.valueOf(objRdep.getExoneracion_tercera_edad()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(exoTerEd);

            Element basImp = doc.createElement("basImp");
            basImp.setTextContent(String.valueOf(objRdep.getBase_imponible_gravada()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(basImp);

            Element impRentCaus = doc.createElement("impRentCaus");
            impRentCaus.setTextContent(String.valueOf(objRdep.getImpuesto_renta_causado()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(impRentCaus);

            Element valRetAsuOtrosEmpls = doc.createElement("valRetAsuOtrosEmpls");
            valRetAsuOtrosEmpls.setTextContent(String.valueOf(objRdep.getValor_impuesto_retenido()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(valRetAsuOtrosEmpls);

            Element valImpAsuEsteEmpl = doc.createElement("valImpAsuEsteEmpl");
            valImpAsuEsteEmpl.setTextContent(String.valueOf(objRdep.getValor_impuesto_asumido()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(valImpAsuEsteEmpl);

            Element valRet = doc.createElement("valRet");
            valRet.setTextContent(String.valueOf(objRdep.getValor_impuesto_retenido_por_empleador()));// OJO IR PONIENDO VALORES REALES
            datRetRelDep.appendChild(valRet);

            retRelDep.appendChild(datRetRelDep);

            rdep.appendChild(retRelDep);

            xml = doc.toString();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("accesodatos.database");
            String creacionxml = Configuracion.getString("xml");

            StreamResult result = new StreamResult(new File(creacionxml + objRdep.getIdentificacion_trabajador()+fechafin + ".xml"));
            transformer.transform(source, result);

            System.out.println("EL VALOR del XML ESSSS : " + objRdep.getNombres_trabajador());
            
        } catch (ParserConfigurationException | TransformerException pce) {
            System.out.println(" el error es" + pce);
        }

    }

}
