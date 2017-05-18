/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.UnidadAcademica;
import entidades.categorizacion.CategoriaAnterior;
import entidades.categorizacion.CategoriaAsignada;
import entidades.categorizacion.CategoriaSolicitada;
import entidades.categorizacion.Categorizacion;
import entidades.categorizacion.ComisionCategorizacion;
import entidades.categorizacion.Llamado;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class CategorizacionBean {

    private Categorizacion categorizacion;    
    
    public CategorizacionBean() {
        
    }
    
    @PostConstruct
    public void init(){
        categorizacion = new Categorizacion();
        
        categorizacion.setUnidadAcademica(new UnidadAcademica());
        categorizacion.setComision(new ComisionCategorizacion());
        categorizacion.setLlamado(new Llamado());
        categorizacion.setCategoriaAsignada(new CategoriaAsignada());
    }

    public Categorizacion getCategorizacion() {
        return categorizacion;
    }

    public void setCategorizacion(Categorizacion categorizacion) {
        this.categorizacion = categorizacion;
    }
    
    
}//fin clase
