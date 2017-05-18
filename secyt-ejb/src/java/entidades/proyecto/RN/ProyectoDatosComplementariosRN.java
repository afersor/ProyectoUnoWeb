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
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author franco
 */
@Stateless
public class ProyectoDatosComplementariosRN implements ProyectoDatosComplementariosRNLocal {

    @EJB
    private ProyectoDatosComplementariosFacadeLocal proyectoDatosComplementariosFacadeLocal;

    @Override
    public List<ProyectoDatosComplementarios> findLatLong() throws Exception {
        return proyectoDatosComplementariosFacadeLocal.findLatLong();
    }//fin findByPublicacionYInvestigador

    @Override
    public void create(ProyectoDatosComplementarios proyectoDatosComplementarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(ProyectoDatosComplementarios proyectoDatosComplementarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(ProyectoDatosComplementarios proyectoDatosComplementarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProyectoDatosComplementarios find(Object id) {
        return proyectoDatosComplementariosFacadeLocal.find(id);
    }

    @Override
    public List<ProyectoDatosComplementarios> findAll() {
        return proyectoDatosComplementariosFacadeLocal.findAll();
    }

    @Override
    public List<ProyectoDatosComplementarios> findRange(int[] range) {
        return proyectoDatosComplementariosFacadeLocal.findRange(range);
    }

    @Override
    public int count() {
        return proyectoDatosComplementariosFacadeLocal.count();
    }

    @Override
    public List<ProyectoDatosComplementarios> findBySubdisciplina(Long id) throws Exception {
        return proyectoDatosComplementariosFacadeLocal.findBySubdisciplina(id);

    }//fin findBySubdisciplina

    @Override
    public List<ProyectoDatosComplementarios> findByNombre(String nombre) throws Exception {
        return proyectoDatosComplementariosFacadeLocal.findByNombre(nombre);

    }//fin findByNombre

    @Override
    public List<ProyectoDatosComplementarios> findByNombreLocalidadDisciplina(String titulo, AreaTematica areaTematica, DisciplinaCientifica disciplinaCientifica, Localidad localidad, Departamento departamento) {
        return proyectoDatosComplementariosFacadeLocal.findByNombreLocalidadDisciplina(titulo, areaTematica, disciplinaCientifica, localidad, departamento);
    }

}
