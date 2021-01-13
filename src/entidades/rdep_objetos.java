/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class rdep_objetos {
    int id_rdep;
    String ruc_empleador;
    String anio;
    beneficio_provincia_galapagos objBeneficio_galapagos;//******
    enfermedad_catastrofica objTrabajador_enfermedad_cat;//*****
    tipo_identificacion objTipo_identificacion;  //revisar***
    String identificacion_trabajador;
    String apellidos_trabajador;
    String nombres_trabajador;
    String codigo_establecimiento;
    residencia_trabajador objResidencia_trabajador;//*****
    pais objPais_residencia;//**
    aplica_convenio_doble_imposicion objConvenio_doble_imp;//******
    condicion_trabajador_respecto_discapacidades objCond_trabajador_resp_discapacidad;//**
    int porcentaje_discapacidad;
    tipo_identificacion objTipo_ident_per_discap;//******
    String identificacion_persona_discap;
    BigDecimal sueldo;
    BigDecimal sobresueldo;
    BigDecimal part_utilidades;
    BigDecimal ingresos_gravados_o_simple;
    BigDecimal imp_renta_asumido;
    BigDecimal decimo_tercer_sueldo;
    BigDecimal decimo_cuarto_sueldo;
    BigDecimal fondo_reserva;
    BigDecimal salario_digno;
    BigDecimal ingresos_no_gravados;
    BigDecimal ingresos_gravados;
    tipos_sistema_salario objSistema_salario_neto;//********
    BigDecimal aporte_iess;
    BigDecimal aporte_otro_empleador;
    BigDecimal deduccion_vivienda;
    BigDecimal deduccion_salud;
    BigDecimal deduccion_educacion_arte;
    BigDecimal deduccion_alimentacion;
    BigDecimal deduccion_vestimenta;
    BigDecimal exoneracion_discapacidad;
    BigDecimal exoneracion_tercera_edad;
    BigDecimal base_imponible_gravada;
    BigDecimal impuesto_renta_causado;
    BigDecimal valor_impuesto_retenido;
    BigDecimal valor_impuesto_asumido;
    BigDecimal valor_impuesto_retenido_por_empleador;

    public rdep_objetos() {
    }

    public rdep_objetos(int id_rdep, String ruc_empleador, String anio, beneficio_provincia_galapagos objBeneficio_galapagos, enfermedad_catastrofica objTrabajador_enfermedad_cat, tipo_identificacion objTipo_identificacion, String identificacion_trabajador, String apellidos_trabajador, String nombres_trabajador, String codigo_establecimiento, residencia_trabajador objResidencia_trabajador, pais objPais_residencia, aplica_convenio_doble_imposicion objConvenio_doble_imp, condicion_trabajador_respecto_discapacidades objCond_trabajador_resp_discapacidad, int porcentaje_discapacidad, tipo_identificacion objTipo_ident_per_discap, String identificacion_persona_discap, BigDecimal sueldo, BigDecimal sobresueldo, BigDecimal part_utilidades, BigDecimal ingresos_gravados_o_simple, BigDecimal imp_renta_asumido, BigDecimal decimo_tercer_sueldo, BigDecimal decimo_cuarto_sueldo, BigDecimal fondo_reserva, BigDecimal salario_digno, BigDecimal ingresos_no_gravados, BigDecimal ingresos_gravados, tipos_sistema_salario objSistema_salario_neto, BigDecimal aporte_iess, BigDecimal aporte_otro_empleador, BigDecimal deduccion_vivienda, BigDecimal deduccion_salud, BigDecimal deduccion_educacion_arte, BigDecimal deduccion_alimentacion, BigDecimal deduccion_vestimenta, BigDecimal exoneracion_discapacidad, BigDecimal exoneracion_tercera_edad, BigDecimal base_imponible_gravada, BigDecimal impuesto_renta_causado, BigDecimal valor_impuesto_retenido, BigDecimal valor_impuesto_asumido, BigDecimal valor_impuesto_retenido_por_empleador) {
        this.id_rdep = id_rdep;
        this.ruc_empleador = ruc_empleador;
        this.anio = anio;
        this.objBeneficio_galapagos = objBeneficio_galapagos;
        this.objTrabajador_enfermedad_cat = objTrabajador_enfermedad_cat;
        this.objTipo_identificacion = objTipo_identificacion;
        this.identificacion_trabajador = identificacion_trabajador;
        this.apellidos_trabajador = apellidos_trabajador;
        this.nombres_trabajador = nombres_trabajador;
        this.codigo_establecimiento = codigo_establecimiento;
        this.objResidencia_trabajador = objResidencia_trabajador;
        this.objPais_residencia = objPais_residencia;
        this.objConvenio_doble_imp = objConvenio_doble_imp;
        this.objCond_trabajador_resp_discapacidad = objCond_trabajador_resp_discapacidad;
        this.porcentaje_discapacidad = porcentaje_discapacidad;
        this.objTipo_ident_per_discap = objTipo_ident_per_discap;
        this.identificacion_persona_discap = identificacion_persona_discap;
        this.sueldo = sueldo;
        this.sobresueldo = sobresueldo;
        this.part_utilidades = part_utilidades;
        this.ingresos_gravados_o_simple = ingresos_gravados_o_simple;
        this.imp_renta_asumido = imp_renta_asumido;
        this.decimo_tercer_sueldo = decimo_tercer_sueldo;
        this.decimo_cuarto_sueldo = decimo_cuarto_sueldo;
        this.fondo_reserva = fondo_reserva;
        this.salario_digno = salario_digno;
        this.ingresos_no_gravados = ingresos_no_gravados;
        this.ingresos_gravados = ingresos_gravados;
        this.objSistema_salario_neto = objSistema_salario_neto;
        this.aporte_iess = aporte_iess;
        this.aporte_otro_empleador = aporte_otro_empleador;
        this.deduccion_vivienda = deduccion_vivienda;
        this.deduccion_salud = deduccion_salud;
        this.deduccion_educacion_arte = deduccion_educacion_arte;
        this.deduccion_alimentacion = deduccion_alimentacion;
        this.deduccion_vestimenta = deduccion_vestimenta;
        this.exoneracion_discapacidad = exoneracion_discapacidad;
        this.exoneracion_tercera_edad = exoneracion_tercera_edad;
        this.base_imponible_gravada = base_imponible_gravada;
        this.impuesto_renta_causado = impuesto_renta_causado;
        this.valor_impuesto_retenido = valor_impuesto_retenido;
        this.valor_impuesto_asumido = valor_impuesto_asumido;
        this.valor_impuesto_retenido_por_empleador = valor_impuesto_retenido_por_empleador;
    }

    public int getId_rdep() {
        return id_rdep;
    }

    public void setId_rdep(int id_rdep) {
        this.id_rdep = id_rdep;
    }

    public String getRuc_empleador() {
        return ruc_empleador;
    }

    public void setRuc_empleador(String ruc_empleador) {
        this.ruc_empleador = ruc_empleador;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
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

    public String getIdentificacion_trabajador() {
        return identificacion_trabajador;
    }

    public void setIdentificacion_trabajador(String identificacion_trabajador) {
        this.identificacion_trabajador = identificacion_trabajador;
    }

    public String getApellidos_trabajador() {
        return apellidos_trabajador;
    }

    public void setApellidos_trabajador(String apellidos_trabajador) {
        this.apellidos_trabajador = apellidos_trabajador;
    }

    public String getNombres_trabajador() {
        return nombres_trabajador;
    }

    public void setNombres_trabajador(String nombres_trabajador) {
        this.nombres_trabajador = nombres_trabajador;
    }

    public String getCodigo_establecimiento() {
        return codigo_establecimiento;
    }

    public void setCodigo_establecimiento(String codigo_establecimiento) {
        this.codigo_establecimiento = codigo_establecimiento;
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

    public int getPorcentaje_discapacidad() {
        return porcentaje_discapacidad;
    }

    public void setPorcentaje_discapacidad(int porcentaje_discapacidad) {
        this.porcentaje_discapacidad = porcentaje_discapacidad;
    }

    public tipo_identificacion getObjTipo_ident_per_discap() {
        return objTipo_ident_per_discap;
    }

    public void setObjTipo_ident_per_discap(tipo_identificacion objTipo_ident_per_discap) {
        this.objTipo_ident_per_discap = objTipo_ident_per_discap;
    }

    public String getIdentificacion_persona_discap() {
        return identificacion_persona_discap;
    }

    public void setIdentificacion_persona_discap(String identificacion_persona_discap) {
        this.identificacion_persona_discap = identificacion_persona_discap;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getSobresueldo() {
        return sobresueldo;
    }

    public void setSobresueldo(BigDecimal sobresueldo) {
        this.sobresueldo = sobresueldo;
    }

    public BigDecimal getPart_utilidades() {
        return part_utilidades;
    }

    public void setPart_utilidades(BigDecimal part_utilidades) {
        this.part_utilidades = part_utilidades;
    }

    public BigDecimal getIngresos_gravados_o_simple() {
        return ingresos_gravados_o_simple;
    }

    public void setIngresos_gravados_o_simple(BigDecimal ingresos_gravados_o_simple) {
        this.ingresos_gravados_o_simple = ingresos_gravados_o_simple;
    }

    public BigDecimal getImp_renta_asumido() {
        return imp_renta_asumido;
    }

    public void setImp_renta_asumido(BigDecimal imp_renta_asumido) {
        this.imp_renta_asumido = imp_renta_asumido;
    }

    public BigDecimal getDecimo_tercer_sueldo() {
        return decimo_tercer_sueldo;
    }

    public void setDecimo_tercer_sueldo(BigDecimal decimo_tercer_sueldo) {
        this.decimo_tercer_sueldo = decimo_tercer_sueldo;
    }

    public BigDecimal getDecimo_cuarto_sueldo() {
        return decimo_cuarto_sueldo;
    }

    public void setDecimo_cuarto_sueldo(BigDecimal decimo_cuarto_sueldo) {
        this.decimo_cuarto_sueldo = decimo_cuarto_sueldo;
    }

    public BigDecimal getFondo_reserva() {
        return fondo_reserva;
    }

    public void setFondo_reserva(BigDecimal fondo_reserva) {
        this.fondo_reserva = fondo_reserva;
    }

    public BigDecimal getSalario_digno() {
        return salario_digno;
    }

    public void setSalario_digno(BigDecimal salario_digno) {
        this.salario_digno = salario_digno;
    }

    public BigDecimal getIngresos_no_gravados() {
        return ingresos_no_gravados;
    }

    public void setIngresos_no_gravados(BigDecimal ingresos_no_gravados) {
        this.ingresos_no_gravados = ingresos_no_gravados;
    }

    public BigDecimal getIngresos_gravados() {
        return ingresos_gravados;
    }

    public void setIngresos_gravados(BigDecimal ingresos_gravados) {
        this.ingresos_gravados = ingresos_gravados;
    }

    public tipos_sistema_salario getObjSistema_salario_neto() {
        return objSistema_salario_neto;
    }

    public void setObjSistema_salario_neto(tipos_sistema_salario objSistema_salario_neto) {
        this.objSistema_salario_neto = objSistema_salario_neto;
    }

    public BigDecimal getAporte_iess() {
        return aporte_iess;
    }

    public void setAporte_iess(BigDecimal aporte_iess) {
        this.aporte_iess = aporte_iess;
    }

    public BigDecimal getAporte_otro_empleador() {
        return aporte_otro_empleador;
    }

    public void setAporte_otro_empleador(BigDecimal aporte_otro_empleador) {
        this.aporte_otro_empleador = aporte_otro_empleador;
    }

    public BigDecimal getDeduccion_vivienda() {
        return deduccion_vivienda;
    }

    public void setDeduccion_vivienda(BigDecimal deduccion_vivienda) {
        this.deduccion_vivienda = deduccion_vivienda;
    }

    public BigDecimal getDeduccion_salud() {
        return deduccion_salud;
    }

    public void setDeduccion_salud(BigDecimal deduccion_salud) {
        this.deduccion_salud = deduccion_salud;
    }

    public BigDecimal getDeduccion_educacion_arte() {
        return deduccion_educacion_arte;
    }

    public void setDeduccion_educacion_arte(BigDecimal deduccion_educacion_arte) {
        this.deduccion_educacion_arte = deduccion_educacion_arte;
    }

    public BigDecimal getDeduccion_alimentacion() {
        return deduccion_alimentacion;
    }

    public void setDeduccion_alimentacion(BigDecimal deduccion_alimentacion) {
        this.deduccion_alimentacion = deduccion_alimentacion;
    }

    public BigDecimal getDeduccion_vestimenta() {
        return deduccion_vestimenta;
    }

    public void setDeduccion_vestimenta(BigDecimal deduccion_vestimenta) {
        this.deduccion_vestimenta = deduccion_vestimenta;
    }

    public BigDecimal getExoneracion_discapacidad() {
        return exoneracion_discapacidad;
    }

    public void setExoneracion_discapacidad(BigDecimal exoneracion_discapacidad) {
        this.exoneracion_discapacidad = exoneracion_discapacidad;
    }

    public BigDecimal getExoneracion_tercera_edad() {
        return exoneracion_tercera_edad;
    }

    public void setExoneracion_tercera_edad(BigDecimal exoneracion_tercera_edad) {
        this.exoneracion_tercera_edad = exoneracion_tercera_edad;
    }

    public BigDecimal getBase_imponible_gravada() {
        return base_imponible_gravada;
    }

    public void setBase_imponible_gravada(BigDecimal base_imponible_gravada) {
        this.base_imponible_gravada = base_imponible_gravada;
    }

    public BigDecimal getImpuesto_renta_causado() {
        return impuesto_renta_causado;
    }

    public void setImpuesto_renta_causado(BigDecimal impuesto_renta_causado) {
        this.impuesto_renta_causado = impuesto_renta_causado;
    }

    public BigDecimal getValor_impuesto_retenido() {
        return valor_impuesto_retenido;
    }

    public void setValor_impuesto_retenido(BigDecimal valor_impuesto_retenido) {
        this.valor_impuesto_retenido = valor_impuesto_retenido;
    }

    public BigDecimal getValor_impuesto_asumido() {
        return valor_impuesto_asumido;
    }

    public void setValor_impuesto_asumido(BigDecimal valor_impuesto_asumido) {
        this.valor_impuesto_asumido = valor_impuesto_asumido;
    }

    public BigDecimal getValor_impuesto_retenido_por_empleador() {
        return valor_impuesto_retenido_por_empleador;
    }

    public void setValor_impuesto_retenido_por_empleador(BigDecimal valor_impuesto_retenido_por_empleador) {
        this.valor_impuesto_retenido_por_empleador = valor_impuesto_retenido_por_empleador;
    }

    
}
