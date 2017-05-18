/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.ObjetivoSocioeconomico;
import entidades.proyecto.RN.ObjetivoSocioEconomicoRNLocal;
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
public class ObjetivoSocioEconomicoLstBean {

    private List<ObjetivoSocioeconomico> lstObjetivoSocioEconomico;
    private List<SelectItem> lstSIObjetivoSocioEconomico;
    
    @EJB
    private ObjetivoSocioEconomicoRNLocal objetivoSocioEconomicoRNLocal;
    
    public ObjetivoSocioEconomicoLstBean() {
    }

    public List<ObjetivoSocioeconomico> getLstObjetivoSocioEconomico() {
        return lstObjetivoSocioEconomico;
    }

    public void setLstObjetivoSocioEconomico(List<ObjetivoSocioeconomico> lstObjetivoSocioEconomico) {
        this.lstObjetivoSocioEconomico = lstObjetivoSocioEconomico;
    }

    public List<SelectItem> getLstSIObjetivoSocioEconomico() {
        return lstSIObjetivoSocioEconomico;
    }

    public void setLstSIObjetivoSocioEconomico(List<SelectItem> lstSIObjetivoSocioEconomico) {
        this.lstSIObjetivoSocioEconomico = lstSIObjetivoSocioEconomico;
    }
    
    public void findObjetivosSocioEconomicos() throws Exception{
        this.setLstObjetivoSocioEconomico(this.objetivoSocioEconomicoRNLocal.findObjetivosSocioeconomicos());
    }//fin findObjetivosSocioEconomicos
    
    public void cargarSIObjetivosSocioEconomicos(){

        this.setLstSIObjetivoSocioEconomico(new ArrayList<SelectItem>());
        for(ObjetivoSocioeconomico o : this.getLstObjetivoSocioEconomico()){
            
            SelectItem si = new SelectItem(o, o.getDescripcion());
            this.getLstSIObjetivoSocioEconomico().add(si);

        }//fin for
    }
}
