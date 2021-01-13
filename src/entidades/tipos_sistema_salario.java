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
public class tipos_sistema_salario {
    int id_tipo_sistema_salario;
    int codigo;
    String descripcion;

    public tipos_sistema_salario() {
    }

    public tipos_sistema_salario(int id_tipo_sistema_salario, int codigo, String descripcion) {
        this.id_tipo_sistema_salario = id_tipo_sistema_salario;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getId_tipo_sistema_salario() {
        return id_tipo_sistema_salario;
    }

    public void setId_tipo_sistema_salario(int id_tipo_sistema_salario) {
        this.id_tipo_sistema_salario = id_tipo_sistema_salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
