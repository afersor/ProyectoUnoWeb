/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import DAO.ContenidoBloqueFacadeLocal;
import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.ContenidoBloque;
import java.io.Serializable;
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
public class ContenidoBloqueLstBean implements Serializable {

    private List<ContenidoBloque> lstContenidoBloque;
    
    @EJB
    private ContenidoBloqueFacadeLocal contenidoBloqueFacadeLocal;
    
    public ContenidoBloqueLstBean() {
    }

    public List<ContenidoBloque> getLstContenidoBloque() {
        return lstContenidoBloque;
    }

    public void setLstContenidoBloque(List<ContenidoBloque> lstContenidoBloque) {
        this.lstContenidoBloque = lstContenidoBloque;
    }
    
    public void findAllByBloque(Bloque bloque) throws Exception{
        this.setLstContenidoBloque(contenidoBloqueFacadeLocal.findByBLoque(bloque));
    }//fin findAllByBloque
}
