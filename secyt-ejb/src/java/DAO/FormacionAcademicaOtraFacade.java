/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.investigador.formacionAcademica.FormacionAcademicaOtra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hugo
 */
@Stateless
public class FormacionAcademicaOtraFacade extends AbstractFacade<FormacionAcademicaOtra> implements FormacionAcademicaOtraFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormacionAcademicaOtraFacade() {
        super(FormacionAcademicaOtra.class);
    }
    
}
