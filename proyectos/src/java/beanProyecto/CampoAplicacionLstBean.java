/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyecto.CampoAplicacion;
import entidades.proyecto.RN.CampoAplicacionRNLocal;
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
public class CampoAplicacionLstBean implements Serializable {

    private List<CampoAplicacion> lstCampoAplicacion;
    
    @EJB
    private CampoAplicacionRNLocal campoAplicacionRNLocal;
    
    public CampoAplicacionLstBean() {
    }

    public List<CampoAplicacion> getLstCampoAplicacion() {
        return lstCampoAplicacion;
    }

    public void setLstCampoAplicacion(List<CampoAplicacion> lstCampoAplicacion) {
        this.lstCampoAplicacion = lstCampoAplicacion;
    }
    
    public void findLikeDescripcion(String cadena) throws Exception{
        this.setLstCampoAplicacion(this.campoAplicacionRNLocal.findLikeDescripcion(cadena));
    }
    
}
