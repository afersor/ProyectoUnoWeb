/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import DAO.UnidadAcademicaFacadeLocal;
import entidades.UnidadAcademica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class UnidadAcademicaRN implements UnidadAcademicaRNLocal {

    @EJB
    private UnidadAcademicaFacadeLocal unidadAcademicaFacadeLocal;
    
    @Override
    public List<UnidadAcademica> findUnidadesAcademicasUNCa() throws Exception {
        return this.unidadAcademicaFacadeLocal.findUnidadesAcademicasUnca();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<UnidadAcademica> findAll() throws Exception {
        return this.unidadAcademicaFacadeLocal.findAll();
    }

    @Override
    public void create(UnidadAcademica unidadAcademica) throws Exception {
        
        if(unidadAcademica.getDescripcion().isEmpty()){
            throw new Exception("No ingreso el nombre de la unidad academica");
        }//fin if
        
        //valida si existe otra con el mismo nombre
        if(this.unidadAcademicaFacadeLocal.findUnidadAcademicaByNombre(unidadAcademica.getDescripcion())){
            throw new Exception("Ya existe una unidad academica con el nombre ingresado");
        }//fin if
        
        this.unidadAcademicaFacadeLocal.create(unidadAcademica);
    }

}
