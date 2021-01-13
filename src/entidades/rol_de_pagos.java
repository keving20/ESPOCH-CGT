/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author USER
 */
@ManagedBean(name = "rolService")
@ApplicationScoped
public class rol_de_pagos {

    int id_rol_pagos;
    String fecha_rol_pago;
    int dias_trabajados;
    BigDecimal horas_extras;
    BigDecimal comisiones;
    BigDecimal total_ingresos;
    BigDecimal aporte_personal;
    BigDecimal multas;
    BigDecimal anticipo_sueldos;
    BigDecimal comisariato;
    BigDecimal total_deducciones;
    BigDecimal fonde_reserva;
    BigDecimal liquido_a_recibir;
    empresa objEmpresa;
    empleado objEmpleado;
    departamento objDepartamento;
    rol objRol;
    BigDecimal bonificaciones;
    BigDecimal ingresosnograbados;
    BigDecimal alimentacion;
    BigDecimal otros;
    BigDecimal horassuplementarias;
    BigDecimal horasnocturnas;
    BigDecimal decimo_tercer;
    BigDecimal decimo_cuarto;
    BigDecimal atrasos;
    BigDecimal uniformes;
    String cheque;
    
    int horas_trabajadas;
    BigDecimal vacaciones;
    BigDecimal prestamo_iess;
    estado_aprobacion objEstado;
    
    int canthorasextra;
    int canthorassuplementarias;
    int canthorasnocturas;
    int cantatrasos;
    usuario objEncargado;

    public rol_de_pagos() {
    }

    public rol_de_pagos(int id_rol_pagos, String fecha_rol_pago, int dias_trabajados, BigDecimal horas_extras, BigDecimal comisiones, BigDecimal total_ingresos, BigDecimal aporte_personal, BigDecimal multas, BigDecimal anticipo_sueldos, BigDecimal comisariato, BigDecimal total_deducciones, BigDecimal fonde_reserva, BigDecimal liquido_a_recibir, empresa objEmpresa, empleado objEmpleado,departamento objDepartamento,rol objRol, BigDecimal bonificaciones, BigDecimal ingresosnograbados, BigDecimal alimentacion, BigDecimal otros, BigDecimal horassuplementarias, BigDecimal horasnocturnas,BigDecimal decimo_tercer,BigDecimal decimo_cuarto,BigDecimal atrasos,BigDecimal uniformes, int canthorasextra, int canthorassuplementarias, int canthorasnocturas, usuario objEncargado, String cheque, int horas_trabajadas, BigDecimal vacaciones, BigDecimal prestamos_iess, estado_aprobacion objEstado) {
        this.id_rol_pagos = id_rol_pagos;
        this.fecha_rol_pago = fecha_rol_pago;
        this.dias_trabajados = dias_trabajados;
        this.horas_extras = horas_extras;
        this.comisiones = comisiones;
        this.total_ingresos = total_ingresos;
        this.aporte_personal = aporte_personal;
        this.multas = multas;
        this.anticipo_sueldos = anticipo_sueldos;
        this.comisariato = comisariato;
        this.total_deducciones = total_deducciones;
        this.fonde_reserva = fonde_reserva;
        this.liquido_a_recibir = liquido_a_recibir;
        this.objEmpresa = objEmpresa;
        this.objEmpleado = objEmpleado;
        this.objDepartamento = objDepartamento;
        this.objRol = objRol;
        this.bonificaciones = bonificaciones;
        this.ingresosnograbados = ingresosnograbados;
        this.alimentacion = alimentacion;
        this.otros = otros;
        this.horassuplementarias = horassuplementarias;
        this.horasnocturnas = horasnocturnas;
        this.canthorasextra = canthorasextra;
        this.canthorassuplementarias = canthorassuplementarias;
        this.canthorasnocturas = canthorasnocturas;
        this.decimo_tercer = decimo_tercer;
        this.decimo_cuarto = decimo_cuarto;
        this.atrasos = atrasos;
        this.uniformes = uniformes;
        this.objEncargado = objEncargado;
        this.cheque = cheque;
        this.horas_trabajadas = horas_trabajadas;
        this.vacaciones = vacaciones;
        this.prestamo_iess = prestamos_iess;
        this.objEstado = objEstado;
        
    }

    public int getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(int horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    public BigDecimal getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(BigDecimal vacaciones) {
        this.vacaciones = vacaciones;
    }

    public BigDecimal getPrestamo_iess() {
        return prestamo_iess;
    }

    public void setPrestamo_iess(BigDecimal prestamo_iess) {
        this.prestamo_iess = prestamo_iess;
    }

    public estado_aprobacion getObjEstado() {
        return objEstado;
    }

    public void setObjEstado(estado_aprobacion objEstado) {
        this.objEstado = objEstado;
    }
    
  

    public int getId_rol_pagos() {
        return id_rol_pagos;
    }

    public void setId_rol_pagos(int id_rol_pagos) {
        this.id_rol_pagos = id_rol_pagos;
    }

    public String getFecha_rol_pago() {
        return fecha_rol_pago;
    }

    public void setFecha_rol_pago(String fecha_rol_pago) {
        this.fecha_rol_pago = fecha_rol_pago;
    }

    public int getDias_trabajados() {
        return dias_trabajados;
    }

    public void setDias_trabajados(int dias_trabajados) {
        this.dias_trabajados = dias_trabajados;
    }

    public BigDecimal getHoras_extras() {
        return horas_extras;
    }

    public void setHoras_extras(BigDecimal horas_extras) {
        this.horas_extras = horas_extras;
    }

    public BigDecimal getComisiones() {
        return comisiones;
    }

    public void setComisiones(BigDecimal comisiones) {
        this.comisiones = comisiones;
    }

    public BigDecimal getTotal_ingresos() {
        return total_ingresos;
    }

    public void setTotal_ingresos(BigDecimal total_ingresos) {
        this.total_ingresos = total_ingresos;
    }

    public BigDecimal getAporte_personal() {
        return aporte_personal;
    }

    public void setAporte_personal(BigDecimal aporte_personal) {
        this.aporte_personal = aporte_personal;
    }

    public BigDecimal getMultas() {
        return multas;
    }

    public void setMultas(BigDecimal multas) {
        this.multas = multas;
    }

    public BigDecimal getAnticipo_sueldos() {
        return anticipo_sueldos;
    }

    public void setAnticipo_sueldos(BigDecimal anticipo_sueldos) {
        this.anticipo_sueldos = anticipo_sueldos;
    }

    public BigDecimal getComisariato() {
        return comisariato;
    }

    public void setComisariato(BigDecimal comisariato) {
        this.comisariato = comisariato;
    }

    public BigDecimal getTotal_deducciones() {
        return total_deducciones;
    }

    public void setTotal_deducciones(BigDecimal total_deducciones) {
        this.total_deducciones = total_deducciones;
    }

    public BigDecimal getFonde_reserva() {
        return fonde_reserva;
    }

    public void setFonde_reserva(BigDecimal fonde_reserva) {
        this.fonde_reserva = fonde_reserva;
    }

    public BigDecimal getLiquido_a_recibir() {
        return liquido_a_recibir;
    }

    public void setLiquido_a_recibir(BigDecimal liquido_a_recibir) {
        this.liquido_a_recibir = liquido_a_recibir;
    }

    public empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public departamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    public rol getObjRol() {
        return objRol;
    }

    public void setObjRol(rol objRol) {
        this.objRol = objRol;
    }

    
    
    public BigDecimal getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(BigDecimal bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    public BigDecimal getIngresosnograbados() {
        return ingresosnograbados;
    }

    public void setIngresosnograbados(BigDecimal ingresosnograbados) {
        this.ingresosnograbados = ingresosnograbados;
    }

    public BigDecimal getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(BigDecimal alimentacion) {
        this.alimentacion = alimentacion;
    }

    public BigDecimal getOtros() {
        return otros;
    }

    public void setOtros(BigDecimal otros) {
        this.otros = otros;
    }

    public BigDecimal getHorassuplementarias() {
        return horassuplementarias;
    }

    public void setHorassuplementarias(BigDecimal horassuplementarias) {
        this.horassuplementarias = horassuplementarias;
    }

    public BigDecimal getHorasnocturnas() {
        return horasnocturnas;
    }

    public void setHorasnocturnas(BigDecimal horasnocturnas) {
        this.horasnocturnas = horasnocturnas;
    }

    public int getCanthorasextra() {
        return canthorasextra;
    }

    public void setCanthorasextra(int canthorasextra) {
        this.canthorasextra = canthorasextra;
    }

    public int getCanthorassuplementarias() {
        return canthorassuplementarias;
    }

    public void setCanthorassuplementarias(int canthorassuplementarias) {
        this.canthorassuplementarias = canthorassuplementarias;
    }

    public int getCanthorasnocturas() {
        return canthorasnocturas;
    }

    public void setCanthorasnocturas(int canthorasnocturas) {
        this.canthorasnocturas = canthorasnocturas;
    }

    public usuario getObjEncargado() {
        return objEncargado;
    }

    public void setObjEncargado(usuario objEncargado) {
        this.objEncargado = objEncargado;
    }

    public BigDecimal getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(BigDecimal atrasos) {
        this.atrasos = atrasos;
    }

    public int getCantatrasos() {
        return cantatrasos;
    }

    public void setCantatrasos(int cantatrasos) {
        this.cantatrasos = cantatrasos;
    }


    public BigDecimal getDecimo_tercer() {
        return decimo_tercer;
    }

    public void setDecimo_tercer(BigDecimal decimo_tercer) {
        this.decimo_tercer = decimo_tercer;
    }

    public BigDecimal getDecimo_cuarto() {
        return decimo_cuarto;
    }

    public void setDecimo_cuarto(BigDecimal decimo_cuarto) {
        this.decimo_cuarto = decimo_cuarto;
    }

    public BigDecimal getUniformes() {
        return uniformes;
    }

    public void setUniformes(BigDecimal uniformes) {
        this.uniformes = uniformes;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

   
    
    public String[] getArray() {
        
        String[] datos = {"Fecha: "+fecha_rol_pago,"Apellidos: "+objEmpleado.apellidos,"Nombres: "+objEmpleado.nombres,"Días Trabajados: "+String.valueOf(dias_trabajados),"Bonificaciones: "+String.valueOf(bonificaciones),"IngresosNoGrabados: "+String.valueOf(ingresosnograbados),"Horas Extras: "+String.valueOf(horas_extras),"Horas Nocturnas: "+String.valueOf(horasnocturnas),"Horas Suplementarias: "+String.valueOf(horassuplementarias),"Décimo Tercer Sueldo: "+String.valueOf(decimo_tercer),"Décimo Cuarto Sueldo: "+String.valueOf(decimo_cuarto),"Comisiones: "+String.valueOf(comisiones),"Total de Ingresos: "+String.valueOf(total_ingresos),"Aportes Personales: "+String.valueOf(aporte_personal),"Multas: "+String.valueOf(multas),"Atrasos: "+String.valueOf(atrasos),"Uniformes: "+String.valueOf(uniformes),"Anticipos de Sueldo: "+String.valueOf(anticipo_sueldos),"Total de Deducciones: "+String.valueOf(total_deducciones),"Fondos de Reserva: "+String.valueOf(fonde_reserva),"Líquido a Recibir: "+String.valueOf(liquido_a_recibir)};
                return datos;
    }
    

}
