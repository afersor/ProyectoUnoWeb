/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.titulo.RN.TituloGradoRNLocal;
import entidades.titulo.RN.TituloOtroRNLocal;
import entidades.titulo.RN.TituloPosgradoRNLocal;
import entidades.titulo.TituloGrado;
import entidades.titulo.TituloOtro;
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
public class TituloOtroLstBean implements Serializable {

    /**
     * Creates a new instance of TituloGradoLstBean
     */
    @EJB
    private TituloOtroRNLocal tituloOtroRNLocal;
    private List<SelectItem> lstSITituloOtro;
    private List<TituloOtro> listaTituloOtro;

    public List<SelectItem> getLstSITituloOtro() {
        return lstSITituloOtro;
    }

    public void setLstSITituloOtro(List<SelectItem> lstSITituloOtro) {
        this.lstSITituloOtro = lstSITituloOtro;
    }

    public List<TituloOtro> getListaTituloOtro() {
        return listaTituloOtro;
    }

    public void setListaTituloOtro(List<TituloOtro> listaTituloOtro) {
        this.listaTituloOtro = listaTituloOtro;
    }

        
    
    public TituloOtroLstBean() {
    }
    @PostConstruct
    private void init(){
        System.out.println("Entro al init");
        listaTituloOtro=new ArrayList<>();
        cargarTitulosOtro();
    }

    private void cargarTitulosOtro() {
        try {
            this.setListaTituloOtro(tituloOtroRNLocal.buscarTitulosOtro());
            lstSITituloOtro =new ArrayList<>();
            System.out.println("Titulos Otros: " + this.getListaTituloOtro());
            if(this.getListaTituloOtro()!=null){
            for (TituloOtro tituloOtro : this.getListaTituloOtro()) {
                lstSITituloOtro.add(new SelectItem(tituloOtro, tituloOtro.toString()));
            }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(TituloOtroLstBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
