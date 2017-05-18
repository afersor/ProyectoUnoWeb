/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.*;
import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import entidades.proyecto.AreaTematica;
import entidades.proyecto.DisciplinaCientifica;
import entidades.proyecto.ProyectoDatosComplementarios;
import entidades.proyecto.SubDisciplinaCientifica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author franco
 */
@Local
public interface ProyectoDatosComplementariosRNLocal {

    void create(ProyectoDatosComplementarios proyectoDatosComplementarios);

    void edit(ProyectoDatosComplementarios proyectoDatosComplementarios);

    void remove(ProyectoDatosComplementarios proyectoDatosComplementarios);

    ProyectoDatosComplementarios find(Object id);

    List<ProyectoDatosComplementarios> findAll();

    List<ProyectoDatosComplementarios> findRange(int[] range);

    int count();

    public List<ProyectoDatosComplementarios> findLatLong() throws Exception;

    public List<ProyectoDatosComplementarios> findByNombre(String nombre) throws Exception;

    public List<ProyectoDatosComplementarios> findBySubdisciplina(Long id) throws Exception;

    public List<ProyectoDatosComplementarios> findByNombreLocalidadDisciplina(String titulo, AreaTematica areaTematica, DisciplinaCientifica disciplinaCientifica, Localidad localidad, Departamento departamento);
}
