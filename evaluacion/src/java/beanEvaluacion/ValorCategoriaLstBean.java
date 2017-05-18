/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.categorizacion.RN.ValorCategoriaRNLocal;
import entidades.categorizacion.ValorCategoria;
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
public class ValorCategoriaLstBean implements Serializable {

    private List<ValorCategoria> lstValorCategoria;
    private List<SelectItem> lstSIValorCategoria;
    
    @EJB
    private ValorCategoriaRNLocal valorCategoriaRNLocal;
    
    public ValorCategoriaLstBean() {
    }

    public List<ValorCategoria> getLstValorCategoria() {
        return lstValorCategoria;
    }

    public void setLstValorCategoria(List<ValorCategoria> lstValorCategoria) {
        this.lstValorCategoria = lstValorCategoria;
    }

    public List<SelectItem> getLstSIValorCategoria() {
        return lstSIValorCategoria;
    }

    public void setLstSIValorCategoria(List<SelectItem> lstSIValorCategoria) {
        this.lstSIValorCategoria = lstSIValorCategoria;
    }
    
     public void findAllValorCategoria() throws Exception{
        this.setLstValorCategoria(valorCategoriaRNLocal.findAll());
    }//fin findUnidadesAcademicas
    
    public void cargarSIValorCategoria(){
        this.setLstSIValorCategoria(new ArrayList<SelectItem>());
        for(ValorCategoria cc : this.getLstValorCategoria()){
            SelectItem si = new SelectItem(cc, cc.getDescripcion());
            this.getLstSIValorCategoria().add(si);
        }//fin for
    }//fin cargarSIUnidadesAcademicas
}
