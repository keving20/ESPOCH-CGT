
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jonathan Araujo
 */
public class consulta2 {
    String antecedente;
    String antecedentesel;

    
    public consulta2(){}

    public consulta2(String antecedente, String antecedentesel) {
        this.antecedente = antecedente;
        this.antecedentesel = antecedentesel;
       
    }

    
    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getAntecedentesel() {
        return antecedentesel;
    }

    public void setAntecedentesel(String antecedentesel) {
        this.antecedentesel = antecedentesel;
    }
    
    
}