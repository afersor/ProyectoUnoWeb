/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.economico.PagoEconomico;
import entidades.economico.Rendicion;
import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ProyectoFacadeLocal {

    void create(Proyecto proyecto);

    void edit(Proyecto proyecto);

    void remove(Proyecto proyecto);

    Proyecto find(Object id);

    List<Proyecto> findAll();

    List<Proyecto> findRange(int[] range);

    int count();

    public List<Proyecto> findByPublicacionYInvestigador(Long idInvestigador) throws Exception;

    public List<Proyecto> findByInvestigadorYRol(Long idInvestigador, String rol) throws Exception;

    public List<Proyecto> findByAnio(Integer anio) throws Exception;

    public java.util.List<Integer> getAnios() throws java.lang.Exception;

    public java.lang.String getDirector(entidades.proyecto.Proyecto proy) throws java.lang.Exception;

    public List<Rendicion> getRendicionesOrdenadasPorFecha(PagoEconomico pe) throws Exception;

    public List<Proyecto> findByAnioCodigo(Integer anio, String codigo);

    public List<Proyecto> findByNombre(String nombre);

    public List<Proyecto> findByCodigo(String codigo);

    public java.util.List<entidades.proyecto.Proyecto> findByNombreCodigo(java.lang.String nombre, java.lang.String codigo);

    public java.util.List<entidades.proyecto.Proyecto> findByAnioNombreCodigo(java.lang.Integer anio, java.lang.String nombre, java.lang.String codigo);

    public java.util.List<entidades.proyecto.Proyecto> findByAnioNombre(java.lang.Integer anio, java.lang.String nombre) throws java.lang.Exception;

    public Investigador getDirectorInvestigador(Proyecto proyecto);

    public List<Proyecto> findByAnioNombreCodigoResumen(Integer anio,String codigo,String nombre,String resumen)throws Exception;

    public List<Proyecto> findByNombreCodigoResumen(String codigo,String nombre,String resumen)throws Exception;

    public List<Proyecto> findByAnioResumen(Integer anio, String resumen)throws Exception;

    public List<Proyecto> findByResumen(String resumen)throws Exception;
    
    public List<Investigador> getTodosIntegrantes(Proyecto proyecto)throws Exception;
    
}
