/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.titulo.RN.TituloGradoRNLocal;
import entidades.titulo.TituloGrado;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author hugo
 */
@ManagedBean
@SessionScoped
public class TituloGradoLstBean implements Serializable {

    /**
     * Creates a new instance of TituloGradoLstBean
     */
    @EJB
    private TituloGradoRNLocal tituloGradoRNLocal;
    private List<SelectItem> lstSITituloGrado;
    private List<TituloGrado> listaTituloGrado;

    public List<SelectItem> getLstSITituloGrado() {
        return lstSITituloGrado;
    }

    public void setLstSITituloGrado(List<SelectItem> lstSITituloGrado) {
        this.lstSITituloGrado = lstSITituloGrado;
    }

    public List<TituloGrado> getListaTituloGrado() {
        return listaTituloGrado;
    }

    public void setListaTituloGrado(List<TituloGrado> listaTituloGrado) {
        this.listaTituloGrado = listaTituloGrado;
    }
    
    public TituloGradoLstBean() {
    }
    /*@PostConstruct
    private void init(){
        listaTituloGrado=new ArrayList<>();
        //cargarTitulosGrado();
    }*/

    public void cargarTitulosGrado() {
        try {
            this.setListaTituloGrado(tituloGradoRNLocal.buscarTitulos());
            lstSITituloGrado =new ArrayList<>();
            for (TituloGrado titulo : this.getListaTituloGrado()) {
                lstSITituloGrado.add(new SelectItem(titulo, titulo.toString()));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(TituloGradoLstBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
