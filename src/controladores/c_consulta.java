/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.antecedentes;
import entidades.consulta;
import entidades.consulta2;
import entidades.resultados;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelos.m_antecedentes;
import modelos.m_reglas;
import recursos.recursoMensajes;

/**
 *
 * @author Jonathan Araujo
 */
@ViewScoped
@ManagedBean
public class c_consulta {

    public antecedentes objAntecedente;
    public antecedentes objAntecedente2;
    public antecedentes objAntecedenteSel;

    public consulta objConsulta;
    public consulta objConsultaSel;
    public consulta2 objCons2;
    public resultados objResultado;
    public resultados objResultadoSel;

    public ArrayList<antecedentes> listaAntecedente;

    public ArrayList<consulta> listaConsulta;
    public ArrayList<consulta> listaConsulta2;

    public ArrayList<consulta2> listaConsultafin;
    
    public ArrayList<resultados> listaResultado;

    public boolean result;
    public boolean mostrar = true;
    public boolean mostrarRegre = true;
    public int total;
    public int cont = 0;
    public String regla = "";

    private void reinit() {
        this.objAntecedente = new antecedentes();
        this.objAntecedente2 = new antecedentes();
        this.objAntecedenteSel = new antecedentes();
        this.listaAntecedente = new ArrayList<>();

        this.objConsulta = new consulta();
        this.objConsultaSel = new consulta();
        this.listaConsulta = new ArrayList<>();
        this.listaConsulta2 = new ArrayList<>();

        this.objResultado = new resultados();
        this.objResultadoSel = new resultados();
        this.listaResultado = new ArrayList<>();

        this.mostrar = true;

        this.cargarConsulta();
        //this.cargarRegresion(regla);
    }

    public c_consulta() {
        this.reinit();
    }

    public boolean isMostrarRegre() {
        return mostrarRegre;
    }

    public void setMostrarRegre(boolean mostrarRegre) {
        this.mostrarRegre = mostrarRegre;
    }

    public ArrayList<consulta> getListaConsulta2() {
        return listaConsulta2;
    }

    public void setListaConsulta2(ArrayList<consulta> listaConsulta2) {
        this.listaConsulta2 = listaConsulta2;
    }

    public consulta2 getObjCons2() {
        return objCons2;
    }

    public void setObjCons2(consulta2 objCons2) {
        this.objCons2 = objCons2;
    }

    public ArrayList<consulta2> getListaConsultafin() {
        return listaConsultafin;
    }

    public void setListaConsultafin(ArrayList<consulta2> listaConsultafin) {
        this.listaConsultafin = listaConsultafin;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }

    public antecedentes getObjAntecedente() {
        return objAntecedente;
    }

    public void setObjAntecedente(antecedentes objAntecedente) {
        this.objAntecedente = objAntecedente;
    }

    public antecedentes getObjAntecedente2() {
        return objAntecedente2;
    }

    public void setObjAntecedente2(antecedentes objAntecedente2) {
        this.objAntecedente2 = objAntecedente2;
    }

    public antecedentes getObjAntecedenteSel() {
        return objAntecedenteSel;
    }

    public void setObjAntecedenteSel(antecedentes objAntecedenteSel) {
        this.objAntecedenteSel = objAntecedenteSel;
    }

    public ArrayList<antecedentes> getListaAntecedente() {
        return listaAntecedente;
    }

    public consulta getObjConsulta() {
        return objConsulta;
    }

    public resultados getObjResultado() {
        return objResultado;
    }

    public void setObjResultado(resultados objResultado) {
        this.objResultado = objResultado;
    }

    public resultados getObjResultadoSel() {
        return objResultadoSel;
    }

    public void setObjResultadoSel(resultados objResultadoSel) {
        this.objResultadoSel = objResultadoSel;
    }

    public ArrayList<resultados> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(ArrayList<resultados> listaResultado) {
        this.listaResultado = listaResultado;
    }

    public void setObjConsulta(consulta objConsulta) {
        this.objConsulta = objConsulta;
    }

    public consulta getObjConsultaSel() {
        return objConsultaSel;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public void setObjConsultaSel(consulta objConsultaSel) {
        this.objConsultaSel = objConsultaSel;
    }

    public ArrayList<consulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(ArrayList<consulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }

    public void setListaAntecedente(ArrayList<antecedentes> listaAntecedente) {
        this.listaAntecedente = listaAntecedente;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void cargarConsulta() {
        try {
            listaConsulta = m_antecedentes.obtenerConsultaAntecedentes();
            total = listaConsulta.size();
            objAntecedente.setDescripcion("¿" + listaConsulta.get(0).getAntecedente() + "?");
        } catch (Exception e) {
        }
    }

    public void ingresar(boolean op) throws Exception {
        String message;
        if (cont < total) {
            try {
                boolean resultado = m_antecedentes.ingresoTemporal(listaConsulta.get(cont).getAntecedente(), listaConsulta.get(cont).getValor());
                cont++;
                objAntecedente.setDescripcion("¿" + listaConsulta.get(cont).getAntecedente() + "?");
                if (resultado == true) {
                    message = "¡ok!";
                    recursoMensajes.addSuccessMessage(message);
                } else {
                    message = "¡oh no!";
                    recursoMensajes.addSuccessMessage(message);
                }
            } catch (Exception e) {
                message = "¡Exception!";
                recursoMensajes.addSuccessMessage(message);
            }
        } else {
            mostrar = false;

            listaResultado = m_antecedentes.obtenerResultados();
            double min = listaResultado.get(0).getValor().doubleValue();
            double hecho = listaResultado.get(0).getV_hecho().doubleValue();
            double resultado;
            double fin;
            if (hecho > min) {
                resultado = (min - hecho) / (1 - hecho);
            } else {
                if (hecho < min) {
                resultado = (hecho- min)/hecho;
                resultado = 0- resultado;
                }
                else
                    resultado = 0;
            }
            fin= (resultado - hecho)*100;
            
            DecimalFormat df = new DecimalFormat("#.00");
        
            objAntecedente.setDescripcion("Se infiere que el hecho es: " + listaResultado.get(0).getResultado()+"\n"+ " Con un Valor Inicial del Hecho de:"+String.format("%.2f", hecho*100)+"%"+ "\nun Mejora en un : " + String.format("%.2f", fin)+"%");
            m_antecedentes.borrarTemporal();
        }

    }

    public void noingresar(boolean op) throws Exception {
        String message;
        if (cont < total) {
            try {
                message = "¡ok!";
                recursoMensajes.addSuccessMessage(message);
                cont++;
                objAntecedente.setDescripcion("¿" + listaConsulta.get(cont).getAntecedente() + "?");
            } catch (Exception e) {
                message = "¡Exception!";
                recursoMensajes.addSuccessMessage(message);
            }
        } else {
            mostrar = false;
           listaResultado = m_antecedentes.obtenerResultados();
            double min = listaResultado.get(0).getValor().doubleValue();
            double hecho = listaResultado.get(0).getV_hecho().doubleValue();
            double resultado;
            double fin;
            if (hecho > min) {
                resultado = (min - hecho) / (1 - hecho);
            } else {
                if (hecho < min) {
                resultado = (hecho- min)/hecho;
                resultado = 0- resultado;
                }
                else
                    resultado = 0;
            }
            fin= (resultado - hecho)*100;
            
            DecimalFormat df = new DecimalFormat("#.00");
        
             objAntecedente.setDescripcion("Se infiere que el hecho es: " + listaResultado.get(0).getResultado()+"\num"+ " Con un Valor Inicial del Hecho de: "+String.format("%.2f", hecho*100)+"%"+ "\nun Mejora en un : " + String.format("%.2f", fin)+"%");
            m_antecedentes.borrarTemporal();
        }

    }

/////REGRESIVO
    public void cargarRegresion(String reglas) {
        try {
            mostrar = false;
            listaConsultafin = m_antecedentes.obtenerConsultaAntecedentesRegresion(reglas);

            total = listaConsulta2.size();

            objAntecedente2.setDescripcion("¿" + listaConsulta2.get(0).getAntecedente() + "?");
        } catch (Exception e) {
        }
    }

    public void ingresarRegre(boolean op) throws Exception {
        String message;
        System.out.println(total);
        try {
            if (cont < total) {
                boolean resultado = m_antecedentes.ingresoTemporal(listaConsulta2.get(cont).getAntecedente(), listaConsulta2.get(cont).getValor());
                cont++;
                objAntecedente2.setDescripcion("¿" + listaConsulta2.get(cont).getAntecedente() + "?");
                if (resultado == true) {
                    message = "¡ok!";
                    recursoMensajes.addSuccessMessage(message);
                } else {
                    message = "¡oh no!";
                    recursoMensajes.addSuccessMessage(message);
                }

            } else {

                listaResultado = m_antecedentes.obtenerResultados();
                if (listaResultado.get(0).getResultado().equals(regla)) {
                    objAntecedente2.setDescripcion("Es un: " + regla);
                } else {
                    objAntecedente2.setDescripcion("No es un: " + regla);
                }
                m_antecedentes.borrarTemporal();
                mostrarRegre = false;
            }
        } catch (Exception e) {
            message = "¡Exception!";
            recursoMensajes.addSuccessMessage(message);
        }

    }

    public void noingresarRegre(boolean op) throws Exception {
        String message;
        System.out.println(total);
        try {
            if (cont < total) {
                boolean resultado = m_antecedentes.ingresoTemporal(listaConsulta2.get(cont).getAntecedente(), listaConsulta2.get(cont).getValor());
                cont++;
                objAntecedente2.setDescripcion("¿" + listaConsulta2.get(cont).getAntecedente() + "?");
                if (resultado == true) {
                    message = "¡ok!";
                    recursoMensajes.addSuccessMessage(message);
                } else {
                    message = "¡oh no!";
                    recursoMensajes.addSuccessMessage(message);
                }

            } else {

                listaResultado = m_antecedentes.obtenerResultados();
                if (listaResultado.get(0).getResultado().equals(regla)) {
                    objAntecedente2.setDescripcion("No Es un: " + regla);
                } else {
                    objAntecedente2.setDescripcion("Es un: " + regla);
                }
                m_antecedentes.borrarTemporal();
                mostrarRegre = false;
            }
        } catch (Exception e) {
            message = "¡Exception!";
            recursoMensajes.addSuccessMessage(message);
        }
    }

}
