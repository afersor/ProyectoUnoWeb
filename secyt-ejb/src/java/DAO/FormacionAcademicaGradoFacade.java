/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hugo
 */
@Stateless
public class FormacionAcademicaGradoFacade extends AbstractFacade<FormacionAcademicaGrado> implements FormacionAcademicaGradoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormacionAcademicaGradoFacade() {
        super(FormacionAcademicaGrado.class);
    }
    
}
