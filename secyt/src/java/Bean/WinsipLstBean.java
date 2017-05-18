/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.categorizacion.RN.WinsipRNLocal;
import entidades.categorizacion.Winsip;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class WinsipLstBean {

    private List<Winsip> lstWinsip;
    
    @EJB
    private WinsipRNLocal winsipRNLocal;
    
    public WinsipLstBean() {
    }

    public List<Winsip> getLstWinsip() {
        return lstWinsip;
    }

    public void setLstWinsip(List<Winsip> lstWinsip) {
        this.lstWinsip = lstWinsip;
    }
    
    public void findByProyecto(Long idProyecto) throws Exception{
        this.setLstWinsip(winsipRNLocal.findByProyecto(idProyecto));
    }//fin ver Winzip
    
}
