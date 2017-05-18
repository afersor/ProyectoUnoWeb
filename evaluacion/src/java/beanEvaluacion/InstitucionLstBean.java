/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.Institucion;
import entidades.RN.InstitucionRNLocal;
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
@ManagedBean(name = "institucionLstBean")
@SessionScoped
public class InstitucionLstBean implements Serializable {

    /**
     * Creates a new instance of InstitucionLstBean
     */
    @EJB
    private InstitucionRNLocal institucionRNLocal;
    private List<SelectItem> lstSIInstitucion;
    private List<Institucion> listaInstitucion;
    private Institucion institucion;
    
    public InstitucionLstBean() {
    }

    public List<SelectItem> getLstSIInstitucion() {
        return lstSIInstitucion;
    }

    public void setLstSIInstitucion(List<SelectItem> lstSIInstitucion) {
        this.lstSIInstitucion = lstSIInstitucion;
    }

    public List<Institucion> getListaInstitucion() {
        return listaInstitucion;
    }

    public void setListaInstitucion(List<Institucion> listaInstitucion) {
        this.listaInstitucion = listaInstitucion;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
    
    /*@PostConstruct
    private void init(){
        listaInstitucion=new ArrayList<>();
        cargarInstituciones();
    }*/
    
    public void cargarInstituciones() {
        try {
            
            System.out.println("Lista1: ");
            this.setListaInstitucion(institucionRNLocal.buscarInstituciones());
            System.out.println("Lista2: ");
            lstSIInstitucion=new ArrayList<>();
            
            System.out.println("Lista3: " + this.getListaInstitucion());
            for (Institucion inst : this.getListaInstitucion()) {
                lstSIInstitucion.add(new SelectItem(inst, inst.toString()));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(InstitucionLstBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
