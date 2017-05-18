/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.titulo.RN.TituloGradoRNLocal;
import entidades.titulo.RN.TituloPosgradoRNLocal;
import entidades.titulo.TituloGrado;
import entidades.titulo.TituloPosgrado;
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
public class TituloPosgradoLstBean implements Serializable {

    /**
     * Creates a new instance of TituloGradoLstBean
     */
    @EJB
    private TituloPosgradoRNLocal tituloPosgradoRNLocal;
    private List<SelectItem> lstSITituloPosgrado;
    private List<TituloPosgrado> listaTituloPosgrado;

    public List<SelectItem> getLstSITituloPosgrado() {
        return lstSITituloPosgrado;
    }

    public void setLstSITituloPosgrado(List<SelectItem> lstSITituloPosgrado) {
        this.lstSITituloPosgrado = lstSITituloPosgrado;
    }

    public List<TituloPosgrado> getListaTituloPosgrado() {
        return listaTituloPosgrado;
    }

    public void setListaTituloPosgrado(List<TituloPosgrado> listaTituloPosgrado) {
        this.listaTituloPosgrado = listaTituloPosgrado;
    }

    
    
    public TituloPosgradoLstBean() {
    }
    @PostConstruct
    private void init(){
        listaTituloPosgrado=new ArrayList<>();
        cargarTitulosPosgrado();
    }

    private void cargarTitulosPosgrado() {
        try {
            this.setListaTituloPosgrado(tituloPosgradoRNLocal.buscarTitulosPosgrado());
            lstSITituloPosgrado =new ArrayList<>();
            for (TituloPosgrado tituloPosgrado : this.getListaTituloPosgrado()) {
                lstSITituloPosgrado.add(new SelectItem(tituloPosgrado, tituloPosgrado.toString()));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(TituloPosgradoLstBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
