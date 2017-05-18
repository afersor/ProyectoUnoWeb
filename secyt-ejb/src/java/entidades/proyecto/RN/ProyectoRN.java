/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.ProyectoFacadeLocal;
import entidades.economico.PagoEconomico;
import entidades.economico.Rendicion;
import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class ProyectoRN implements ProyectoRNLocal {

    @EJB
    private ProyectoFacadeLocal proyectoFacadeLocal;

    @Override
    public List<Proyecto> findByPublicacionYInvestigador(Long idInvestigador) throws Exception {
        return proyectoFacadeLocal.findByPublicacionYInvestigador(idInvestigador);
    }//fin findByPublicacionYInvestigador

    @Override
    public List<Proyecto> findByInvestigadorYRol(Long idInvestigador, String rol) throws Exception {
        return proyectoFacadeLocal.findByInvestigadorYRol(idInvestigador, rol);
    }

    @Override
    public Proyecto find(Object id) throws Exception {
        return proyectoFacadeLocal.find(id);
    }

    @Override
    public List<Proyecto> findByAnio(Integer anio) throws Exception {
        return proyectoFacadeLocal.findByAnio(anio);
    }

    @Override
    public List<Proyecto> findAll() throws Exception {
        return proyectoFacadeLocal.findAll();
    }

    @Override
    public List<Integer> getAnios() throws Exception {
        return proyectoFacadeLocal.getAnios();
    }

    @Override
    public String getDirector(Proyecto proyecto) throws Exception {
        return proyectoFacadeLocal.getDirector(proyecto);
    }

    @Override
    public List<Rendicion> getRendicionesOrdenadasPorFecha(PagoEconomico pe) throws Exception {
        return proyectoFacadeLocal.getRendicionesOrdenadasPorFecha(pe);
    }

    @Override
    public List<Proyecto> findByCodigo(String codigo) throws Exception {
        return proyectoFacadeLocal.findByCodigo(codigo);
    }

    @Override
    public List<Proyecto> findByNombre(String nombre) throws Exception {
        return proyectoFacadeLocal.findByNombre(nombre);
    }

    @Override
    public java.util.List<entidades.proyecto.Proyecto> findByNombreCodigo(java.lang.String nombre, java.lang.String codigo) throws Exception {
        return proyectoFacadeLocal.findByNombreCodigo(nombre, codigo);
    }

    @Override
    public java.util.List<entidades.proyecto.Proyecto> findByAnioNombreCodigo(java.lang.Integer anio, java.lang.String nombre, java.lang.String codigo) throws Exception {
        return proyectoFacadeLocal.findByAnioNombreCodigo(anio, nombre, codigo);
    }

    @Override
    public List<Proyecto> findByAnioNombre(Integer anio, String nombre) throws Exception {
        return proyectoFacadeLocal.findByAnioNombre(anio, nombre);
    }

    @Override
    public Investigador getDirectorInvestigador(Proyecto proyecto) throws Exception {
        return proyectoFacadeLocal.getDirectorInvestigador(proyecto);
    }

    @Override
    public List<Proyecto> findByAnioNombreCodigoResumen(Integer anio,String codigo,String nombre,String resumen) throws Exception {
        return proyectoFacadeLocal.findByAnioNombreCodigoResumen(anio,codigo,nombre,resumen);
    }

    @Override
    public List<Proyecto> findByNombreCodigoResumen(String codigo,String nombre,String resumen) throws Exception {
        return proyectoFacadeLocal.findByNombreCodigoResumen(codigo,nombre,resumen);
    }

    @Override
    public List<Proyecto> findByAnioResumen(Integer anio, String resumen) throws Exception {
        return proyectoFacadeLocal.findByAnioResumen(anio,resumen);
    }

    @Override
    public List<Proyecto> findByResumen(String resumen) throws Exception {
        return proyectoFacadeLocal.findByResumen(resumen);
    }
}
