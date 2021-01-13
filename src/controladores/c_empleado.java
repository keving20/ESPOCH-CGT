/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.ciudad;
import entidades.departamento;
import entidades.empleado;
import entidades.estado_civil;
import entidades.provincia;
import entidades.rol;
import entidades.sexo;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelos.m_ciudad;
import modelos.m_departamento;
import modelos.m_empleado;
import modelos.m_estado_civil;
import modelos.m_provincia;
import modelos.m_rol;
import modelos.m_sexo;

import recursos.recursoMensajes;

/**
 *
 * @author USER
 */
@ViewScoped
@ManagedBean
public class c_empleado {

    public empleado objEmpleado;   
    public empleado objEmpleadoSel;
    public rol objRol;
    public sexo objSexo;
    public estado_civil objEstadocivil;
    public provincia objProvincia;
    public ciudad objCiudad;
    public departamento objDepartamento;

    public ArrayList<empleado> listaEmpleado;
    public ArrayList<provincia> listaProvincia;
    public ArrayList<ciudad> listaCiudad;
    public ArrayList<departamento> listaDepartamento;
    public ArrayList<rol> listaRol;
    public ArrayList<estado_civil> listaEstadocivil;
    public ArrayList<sexo> listaSexo;

    private void reinit() {
       
        this.objEmpleado = new empleado();
        this.objEmpleadoSel = new empleado();
        this.objRol = new rol();
        this.objEstadocivil = new estado_civil();
        this.objProvincia = new provincia();
        this.objCiudad = new ciudad();
        this.objDepartamento = new departamento();
        this.objSexo= new sexo();

        objEmpleado.setObjCiudad(objCiudad);
        objEmpleado.setObjDepartamento(objDepartamento);
        objEmpleado.setObjEstado_civil(objEstadocivil);
        objEmpleado.setObjProvincia(objProvincia);
        objEmpleado.setObjSexo(objSexo);
        objEmpleado.setObjrol(objRol);
        objEmpleado.setObjEstado_civil(objEstadocivil);

        objEmpleadoSel.setObjCiudad(objCiudad);
        objEmpleadoSel.setObjDepartamento(objDepartamento);
        objEmpleadoSel.setObjEstado_civil(objEstadocivil);
        objEmpleadoSel.setObjProvincia(objProvincia);
        objEmpleadoSel.setObjSexo(objSexo);
        objEmpleadoSel.setObjrol(objRol);
        objEmpleadoSel.setObjEstado_civil(objEstadocivil);

        listaCiudad = new ArrayList<>();
        listaDepartamento = new ArrayList<>();
        listaProvincia = new ArrayList<>();
        listaEmpleado = new ArrayList<>();
        listaRol = new ArrayList<>();
        listaEstadocivil = new ArrayList<>();
        listaSexo= new ArrayList<>();

        this.cargarEmpleado();
    }

    public c_empleado() {
        this.reinit();

    }

    public ArrayList<estado_civil> getListaEstadocivil() {
        return listaEstadocivil;
    }

    public void setListaEstadocivil(ArrayList<estado_civil> listaEstadocivil) {
        this.listaEstadocivil = listaEstadocivil;
    }

    public ArrayList<rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(ArrayList<rol> listaRol) {
        this.listaRol = listaRol;
    }

    public ArrayList<empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public empleado getObjEmpleadoSel() {
        return objEmpleadoSel;
    }

    public void setObjEmpleadoSel(empleado objEmpleadoSel) {
        this.objEmpleadoSel = objEmpleadoSel;
    }

    public rol getObjRol() {
        return objRol;
    }

    public void setObjRol(rol objRol) {
        this.objRol = objRol;
    }

    public sexo getObjSexo() {
        return objSexo;
    }

    public void setObjSexo(sexo objSexo) {
        this.objSexo = objSexo;
    }

    public estado_civil getObjEstadocivil() {
        return objEstadocivil;
    }

    public void setObjEstadocivil(estado_civil objEstadocivil) {
        this.objEstadocivil = objEstadocivil;
    }

    public provincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(provincia objProvincia) {
        this.objProvincia = objProvincia;
    }

    public ciudad getObjCiudad() {
        return objCiudad;
    }

    public void setObjCiudad(ciudad objCiudad) {
        this.objCiudad = objCiudad;
    }

    public departamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    public ArrayList<provincia> getListaProvincia() {
        return listaProvincia;
    }

    public void setListaProvincia(ArrayList<provincia> listaProvincia) {
        this.listaProvincia = listaProvincia;
    }

    public ArrayList<ciudad> getListaCiudad() {
        return listaCiudad;
    }

    public void setListaCiudad(ArrayList<ciudad> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public ArrayList<departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(ArrayList<departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public ArrayList<sexo> getListaSexo() {
        return listaSexo;
    }

    public void setListaSexo(ArrayList<sexo> listaSexo) {
        this.listaSexo = listaSexo;
    }
    
    
    
    
    

    public void cargarEmpleado() {
        try {
            listaEmpleado = m_empleado.obtenerTodosempleado();
            listaCiudad = m_ciudad.obtenerTodosciudad();
            listaDepartamento = m_departamento.obtenerTodosdepartamento();
            listaProvincia = m_provincia.obtenerTodosprovincia();
            listaRol = m_rol.obtenerTodosrol();
            listaEstadocivil = m_estado_civil.obtenerTodosestadocivil();
            listaSexo=m_sexo.obtenerTodossexo();

        } catch (Exception e) {
        }
    }

    public void insertarEmpleado() {
        String message;
        try {
            System.out.println(""+objEmpleado.getApellidos());
            System.out.println(""+objEmpleado.getNombres());
            System.out.println(""+objEmpleado.getCedula());
            System.out.println(""+objEmpleado.getDireccion());
            System.out.println(""+objEmpleado.getExperiencia());
            System.out.println(""+objEmpleado.getTelefono());
            System.out.println(""+objEmpleado.getUniversidad());
            System.out.println(""+objEmpleado.getSueldo());
            System.out.println(""+objEmpleado.getFecha_inicio());
            System.out.println(""+objEmpleado.getObjrol().getId_rol());
            System.out.println(""+objEmpleado.getObjDepartamento().getId_departamento());
            System.out.println(""+objEmpleado.getObjEstado_civil().getId_estadocivil());
            System.out.println(""+objEmpleado.getObjCiudad().getId_ciudad());
            System.out.println(""+objEmpleado.getObjProvincia().getId_provincia());
            System.out.println(""+objEmpleado.getObjSexo().getId_sexo());
            System.out.println("CodEst"+objEmpleado.getCod_empresa());
            
            
            
            boolean resultado = m_empleado.insertarEmpleado(objEmpleado);
            if (resultado == true) {
            cargarEmpleado();
                message = "¡" + objEmpleado.getApellidos() + "" + objEmpleado.getNombres() + " HA SIDO REGISTRADO CON ÉXITO!";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();
      this.reinit();
            } else {
                message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
                recursoMensajes.addSuccessMessage(message);
            }

        } catch (Exception e) {
            message = "¡DATOS INCORECTOS, REGISTRO NO COMPLETADO!";
            recursoMensajes.addSuccessMessage(message);
        }
    }

    public void modificarEmpleado() {
        String message;
        System.out.println(""+objEmpleadoSel.getId_empleado());
        
        System.out.println(""+objEmpleadoSel.getApellidos());
            System.out.println(""+objEmpleadoSel.getNombres());
            System.out.println(""+objEmpleadoSel.getCedula());
            System.out.println(""+objEmpleadoSel.getDireccion());
            System.out.println(""+objEmpleadoSel.getExperiencia());
            System.out.println(""+objEmpleadoSel.getTelefono());
            System.out.println(""+objEmpleadoSel.getUniversidad());
            System.out.println(""+objEmpleadoSel.getSueldo());
            System.out.println(""+objEmpleadoSel.getFecha_inicio());
            System.out.println(""+objEmpleadoSel.getObjrol().getId_rol());
            System.out.println(""+objEmpleadoSel.getObjDepartamento().getId_departamento());
            System.out.println(""+objEmpleadoSel.getObjEstado_civil().getId_estadocivil());
            System.out.println(""+objEmpleadoSel.getObjCiudad().getId_ciudad());
            System.out.println(""+objEmpleadoSel.getObjProvincia().getId_provincia());
            System.out.println(""+objEmpleadoSel.getObjSexo().getId_sexo());
            System.out.println(""+objEmpleadoSel.getCod_empresa());
            
        
        
        try {
            boolean resultado = m_empleado.modificarEmpleado(objEmpleadoSel);
            if (resultado == true) {
                cargarEmpleado();
                message = "DATOS ACTUALIZADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();
            } else {
                message = "DATOS NO ACTUALIZADOS";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR EN DATOS ACTUALIZAR";
            recursoMensajes.addSuccessMessageLogin(message);
        }
    }

    public void eliminarEmpleado() {
        String message;
        try {
            boolean resultado = m_empleado.eliminarEmpleado(objEmpleadoSel.getId_empleado());
            if (resultado == true) {
                cargarEmpleado();
                message = "DATOS ELIMINADOS CON ÉXITO";
                recursoMensajes.addSuccessMessage(message);
                this.reinit();

            } else {
                message = "DATOS NO SE  ELIMINO";
                recursoMensajes.addSuccessMessageLogin(message);
            }
        } catch (Exception e) {
            message = "ERROR AL ELIMINAR DATOS";
            recursoMensajes.addSuccessMessageLogin(message);

        }
    }

}
