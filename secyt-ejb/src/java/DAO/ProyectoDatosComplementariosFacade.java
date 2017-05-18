/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import entidades.proyecto.AreaTematica;
import entidades.proyecto.DisciplinaCientifica;
import entidades.proyecto.ProyectoDatosComplementarios;
import entidades.proyecto.SubDisciplinaCientifica;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author franco
 */
@Stateless
public class ProyectoDatosComplementariosFacade extends AbstractFacade<ProyectoDatosComplementarios> implements ProyectoDatosComplementariosFacadeLocal {

    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoDatosComplementariosFacade() {
        super(ProyectoDatosComplementarios.class);
    }

    @Override
    public List<ProyectoDatosComplementarios> findLatLong() throws Exception {
        Query q = em.createNamedQuery("ProyectoDatosComplementarios.findLatLong");
        return q.getResultList();
    }//fin findByPublicacionYInvestigador

    @Override
    public List<ProyectoDatosComplementarios> findBySubdisciplina(Long id) throws Exception {
        Query q = em.createNamedQuery("ProyectoDatosComplementarios.findBySubdisciplina");
        q.setParameter("id", id);
        return q.getResultList();
    }//fin findBySubdisciplina

    @Override
    public List<ProyectoDatosComplementarios> findByNombre(String nombre) throws Exception {
        Query q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombre");
        q.setParameter("nombre", "%" + nombre + "%");
        return q.getResultList();
    }//fin findByNombre

    @Override
    public List<ProyectoDatosComplementarios> findByNombreLocalidadDisciplina(String titulo, AreaTematica areaTematica, DisciplinaCientifica disciplinaCientifica, Localidad localidad, Departamento departamento) {
        String[] palabras = titulo.split("\\s+");
        //utilizo 3 variables dependiendo de los parametros
        String nombre1 = "";
        String nombre2 = "";
        String nombre3 = "";
        if (palabras.length < 2 || palabras.length > 3) {
            nombre1 = titulo;
            nombre2 = titulo;
            nombre3 = titulo;
        } else if (palabras.length == 2) {
            nombre1 = palabras[0];
            nombre2 = palabras[0];
            nombre3 = palabras[1];
        } else if (palabras.length == 3) {
            nombre1 = palabras[0];
            nombre2 = palabras[1];
            nombre3 = palabras[2];
        }

        Query q = null;
        if (areaTematica != null) {
            if (departamento != null) {
                if (localidad != null) {
                    q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreLocalidadAreaTematica");
                    q.setParameter("nombre", "%" + nombre1 + "%");
                    q.setParameter("nombre2", "%" + nombre2 + "%");
                    q.setParameter("nombre3", "%" + nombre3 + "%");
                    q.setParameter("areaTematica", areaTematica);
                    q.setParameter("localidad", localidad);
                } else {
                    q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreDepartamentoAreaTematica");
                    q.setParameter("nombre", "%" + nombre1 + "%");
                    q.setParameter("nombre2", "%" + nombre2 + "%");
                    q.setParameter("nombre3", "%" + nombre3 + "%");
                    q.setParameter("areaTematica", areaTematica);
                    q.setParameter("departamento", departamento);
                }
            } else {
                q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreAreaTematica");
                q.setParameter("nombre", "%" + nombre1 + "%");
                q.setParameter("nombre2", "%" + nombre2 + "%");
                q.setParameter("nombre3", "%" + nombre3 + "%");
                q.setParameter("areaTematica", areaTematica);
            }
        } else if (disciplinaCientifica != null) {
            if (departamento != null) {
                if (localidad != null) {
                    q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreLocalidadDisciplina");
                    q.setParameter("nombre", "%" + nombre1 + "%");
                    q.setParameter("nombre2", "%" + nombre2 + "%");
                    q.setParameter("nombre3", "%" + nombre3 + "%");
                    q.setParameter("disciplinaCientifica", disciplinaCientifica);
                    q.setParameter("localidad", localidad);
                } else {
                    q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreDepartamentoDisciplina");
                    q.setParameter("nombre", "%" + nombre1 + "%");
                    q.setParameter("nombre2", "%" + nombre2 + "%");
                    q.setParameter("nombre3", "%" + nombre3 + "%");
                    q.setParameter("disciplinaCientifica", disciplinaCientifica);
                    q.setParameter("departamento", departamento);
                }
            } else {
                q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreDisciplina");
                q.setParameter("nombre", "%" + nombre1 + "%");
                q.setParameter("nombre2", "%" + nombre2 + "%");
                q.setParameter("nombre3", "%" + nombre3 + "%");
                q.setParameter("disciplinaCientifica", disciplinaCientifica);
            }
        } else if (departamento != null) {
            if (localidad != null) {
                q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreLocalidad");
                q.setParameter("nombre", "%" + nombre1 + "%");
                q.setParameter("nombre2", "%" + nombre2 + "%");
                q.setParameter("nombre3", "%" + nombre3 + "%");
                q.setParameter("localidad", localidad);
            } else {
                q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombreDepartamento");
                q.setParameter("nombre", "%" + nombre1 + "%");
                q.setParameter("nombre2", "%" + nombre2 + "%");
                q.setParameter("nombre3", "%" + nombre3 + "%");
                q.setParameter("departamento", departamento);
            }
        } else {
            q = em.createNamedQuery("ProyectoDatosComplementarios.findByNombre");
            q.setParameter("nombre", "%" + nombre1 + "%");
            q.setParameter("nombre2", "%" + nombre2 + "%");
            q.setParameter("nombre3", "%" + nombre3 + "%");
        }
        try {
            return q.getResultList();

        } catch (Exception e) {
            return new ArrayList<ProyectoDatosComplementarios>();
        }

    }
}
