/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.resultado.TipoReferato;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class TipoReferatoLstBean {

      private List<TipoReferato> lstTipoReferato;
    
    private List<SelectItem> lstSITipoReferato;
    
    
    public TipoReferatoLstBean() {
    }
    
}
