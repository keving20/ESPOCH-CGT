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
public class estado_civil {
    int id_estadocivil;
    String estado;

    public estado_civil() {
    }

    public estado_civil(int id_estadocivil, String estado) {
        this.id_estadocivil = id_estadocivil;
        this.estado = estado;
    }

    public int getId_estadocivil() {
        return id_estadocivil;
    }

    public void setId_estadocivil(int id_estadocivil) {
        this.id_estadocivil = id_estadocivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
  
    
    
}
