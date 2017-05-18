/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;


import DAO.UnidadInvestigacionFacadeLocal;
import entidades.proyecto.UnidadInvestigacion;
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
public class UnidadInvestigacionLstBean implements Serializable {

    private List<UnidadInvestigacion> lstUnidadInvestigacion;
    
    @EJB
    private UnidadInvestigacionFacadeLocal unidadInvestigacionFacadeLocal;
    
    public UnidadInvestigacionLstBean() {
    }

    public List<UnidadInvestigacion> getLstUnidadInvestigacion() {
        return lstUnidadInvestigacion;
    }

    public void setLstUnidadInvestigacion(List<UnidadInvestigacion> lstUnidadInvestigacion) {
        this.lstUnidadInvestigacion = lstUnidadInvestigacion;
    }
    
    public void findLikeDescripcion(String cadena) throws Exception{
        this.setLstUnidadInvestigacion(this.unidadInvestigacionFacadeLocal.findLikeDescripcion(cadena));
    }
}
