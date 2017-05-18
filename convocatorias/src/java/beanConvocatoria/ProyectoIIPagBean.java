/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;


import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class ProyectoIIPagBean {

    private String palabraClaveUno;
    private String palabraClaveDos;
    private String palabraClaveTres;
    private String palabraClaveCuatro;
    private String palabraClaveCinco;
    
    private String keywordUno;
    private String keywordDos;
    private String keywordTres;
    private String keywordCuatro;
    private String keywordCinco;
    
    public ProyectoIIPagBean() {
    }

    public String getPalabraClaveUno() {
        return palabraClaveUno;
    }

    public void setPalabraClaveUno(String palabraClaveUno) {
        this.palabraClaveUno = palabraClaveUno;
    }

    public String getPalabraClaveDos() {
        return palabraClaveDos;
    }

    public void setPalabraClaveDos(String palabraClaveDos) {
        this.palabraClaveDos = palabraClaveDos;
    }

    public String getPalabraClaveTres() {
        return palabraClaveTres;
    }

    public void setPalabraClaveTres(String palabraClaveTres) {
        this.palabraClaveTres = palabraClaveTres;
    }

    public String getPalabraClaveCuatro() {
        return palabraClaveCuatro;
    }

    public void setPalabraClaveCuatro(String palabraClaveCuatro) {
        this.palabraClaveCuatro = palabraClaveCuatro;
    }

    public String getPalabraClaveCinco() {
        return palabraClaveCinco;
    }

    public void setPalabraClaveCinco(String palabraClaveCinco) {
        this.palabraClaveCinco = palabraClaveCinco;
    }

    public String getKeywordUno() {
        return keywordUno;
    }

    public void setKeywordUno(String keywordUno) {
        this.keywordUno = keywordUno;
    }

    public String getKeywordDos() {
        return keywordDos;
    }

    public void setKeywordDos(String keywordDos) {
        this.keywordDos = keywordDos;
    }

    public String getKeywordTres() {
        return keywordTres;
    }

    public void setKeywordTres(String keywordTres) {
        this.keywordTres = keywordTres;
    }

    public String getKeywordCuatro() {
        return keywordCuatro;
    }

    public void setKeywordCuatro(String keywordCuatro) {
        this.keywordCuatro = keywordCuatro;
    }

    public String getKeywordCinco() {
        return keywordCinco;
    }

    public void setKeywordCinco(String keywordCinco) {
        this.keywordCinco = keywordCinco;
    }
    
}
