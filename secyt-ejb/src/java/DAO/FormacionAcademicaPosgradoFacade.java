/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.investigador.formacionAcademica.FormacionAcademicaPosgrado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hugo
 */
@Stateless
public class FormacionAcademicaPosgradoFacade extends AbstractFacade<FormacionAcademicaPosgrado> implements FormacionAcademicaPosgradoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormacionAcademicaPosgradoFacade() {
        super(FormacionAcademicaPosgrado.class);
    }
    
}
