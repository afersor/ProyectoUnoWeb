/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.RN.UnidadAcademicaRNLocal;
import entidades.UnidadAcademica;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class UnidadAcademicaBean {

    private UnidadAcademica unidadAcademica;
    
    @EJB
    private UnidadAcademicaRNLocal unidadAcademicaRNLocal;
    
    public UnidadAcademicaBean() {
        unidadAcademica = new UnidadAcademica();
    }

    public UnidadAcademica getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
    
    public void create() throws Exception{
        System.out.println("Entro al create unidada Aca: " + unidadAcademica.getDescripcion());
        unidadAcademicaRNLocal.create(unidadAcademica);
        System.out.println("termino");
    }//fin create
    
    
}
