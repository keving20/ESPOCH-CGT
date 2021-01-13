/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author USER
 */
public class condicion_trabajador_respecto_discapacidades {
   int id_condicion_trabajador;
   String codigo;
   String descripcion;

    public condicion_trabajador_respecto_discapacidades() {
    }

    public condicion_trabajador_respecto_discapacidades(int id_condicion_trabajador, String codigo, String descripcion) {
        this.id_condicion_trabajador = id_condicion_trabajador;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_condicion_trabajador() {
        return id_condicion_trabajador;
    }

    public void setId_condicion_trabajador(int id_condicion_trabajador) {
        this.id_condicion_trabajador = id_condicion_trabajador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   
}
