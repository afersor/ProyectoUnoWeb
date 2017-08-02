/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.resultado.TipoContrato;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author alumno
 */
@Named(value = "tipoContratoLstBean")
@SessionScoped
public class TipoContratoLstBean implements Serializable {
private List<TipoContrato> lstTipoContrato;
    
    private List<SelectItem> lstSITipoContrato;
    /**
     * Creates a new instance of TipoContratoLstBean
     */
    public TipoContratoLstBean() {
    }
    
}
