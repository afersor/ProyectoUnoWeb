/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.categorizacion.Llamado;
import entidades.categorizacion.RN.LlamadoRNLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class LlamadoLstBean implements Serializable {

    private List<Llamado> lstLlamado;
    
    private List<SelectItem> lstSILlamado;
    
    @EJB
    private LlamadoRNLocal llamadoRNLocal;
    
    public LlamadoLstBean() {
    }

    public List<Llamado> getLstLlamado() {
        return lstLlamado;
    }

    public void setLstLlamado(List<Llamado> lstLlamado) {
        this.lstLlamado = lstLlamado;
    }

    public List<SelectItem> getLstSILlamado() {
        return lstSILlamado;
    }

    public void setLstSILlamado(List<SelectItem> lstSILlamado) {
        this.lstSILlamado = lstSILlamado;
    }
    
    public void findAllLlamado() throws Exception{
        this.setLstLlamado(llamadoRNLocal.findAll());
    }//fin findUnidadesAcademicas
    
    public void cargarSILlamado(){
        this.setLstSILlamado(new ArrayList<SelectItem>());
        for(Llamado l : this.getLstLlamado()){
            SelectItem si = new SelectItem(l, l.getDescripcion());
            this.getLstSILlamado().add(si);
        }//fin for
    }//fin cargarSIUnidadesAcademicas
    
}
