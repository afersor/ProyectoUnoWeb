/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.localidad.RN;

import DAO.LocalidadFacadeLocal;
import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class LocalidadRN implements LocalidadRNLocal {

    @EJB
    private LocalidadFacadeLocal localidadFacadeLocal;

    @Override
    public List<Localidad> findLocalidadesByDpto(Departamento departamento) throws Exception {
        return localidadFacadeLocal.findLocalidadesByDpto(departamento);
    }

    @Override
    public Localidad find(Long id) {
        return localidadFacadeLocal.find(id);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
