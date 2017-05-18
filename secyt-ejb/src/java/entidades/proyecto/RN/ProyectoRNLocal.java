/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

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
public interface ProyectoRNLocal {

    public List<Proyecto> findByPublicacionYInvestigador(Long idInvestigador) throws Exception;

    public List<Proyecto> findByInvestigadorYRol(Long idInvestigador, String rol) throws Exception;

    public Proyecto find(Object id) throws Exception;

    public List<Proyecto> findByAnio(Integer anio) throws Exception;

    public List<Proyecto> findAll() throws Exception;

    public java.util.List<java.lang.Integer> getAnios() throws java.lang.Exception;

    public java.lang.String getDirector(entidades.proyecto.Proyecto proyecto) throws java.lang.Exception;

    public Investigador getDirectorInvestigador(entidades.proyecto.Proyecto proyecto) throws java.lang.Exception;

    public List<Rendicion> getRendicionesOrdenadasPorFecha(PagoEconomico pe) throws Exception;

    public List<Proyecto> findByCodigo(String codigo) throws Exception;

    public List<Proyecto> findByNombre(String nombre) throws Exception;

    public java.util.List<entidades.proyecto.Proyecto> findByNombreCodigo(java.lang.String nombre, java.lang.String codigo) throws java.lang.Exception;

    public java.util.List<entidades.proyecto.Proyecto> findByAnioNombreCodigo(java.lang.Integer anio, java.lang.String nombre, java.lang.String codigo) throws java.lang.Exception;

    public java.util.List<entidades.proyecto.Proyecto> findByAnioNombre(java.lang.Integer anio, java.lang.String nombre) throws java.lang.Exception;

    public List<Proyecto> findByAnioNombreCodigoResumen(Integer anio,String codigo,String nombre,String resumen)throws Exception;

    public List<Proyecto> findByNombreCodigoResumen(String codigo,String nombre,String resumen)throws Exception;

    public List<Proyecto> findByAnioResumen(Integer anio, String resumen)throws Exception;

    public List<Proyecto> findByResumen(String resumen)throws Exception;
}
