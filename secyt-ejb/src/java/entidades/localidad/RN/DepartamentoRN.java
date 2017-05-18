/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.localidad.RN;

import DAO.DepartamentoFacadeLocal;
import DAO.ProvinciaFacadeLocal;
import entidades.localidad.Departamento;
import entidades.localidad.Provincia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class DepartamentoRN implements DepartamentoRNLocal {

    @EJB
    private DepartamentoFacadeLocal departamentoFacadeLocal;

    @EJB
    private ProvinciaFacadeLocal provinciaFacadeLocal;

    @Override
    public List<Departamento> findDepartamentosByProvincia(Provincia provincia) throws Exception {
        return departamentoFacadeLocal.findDepartamentosByProvincia(provincia);
    }

    @Override
    public Departamento find(Long id) {
        return departamentoFacadeLocal.find(id);
    }

    @Override
    public List<Departamento> findDepartamentosCatamarca() throws Exception {
        Provincia provincia = provinciaFacadeLocal.find(2L);
        return departamentoFacadeLocal.findDepartamentosByProvincia(provincia);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
