/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.FormacionRRHHFacadeLocal;
import entidades.proyecto.resultado.FormacionRRHH;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author alumno
 */
@Stateless
public class FormacionRN implements FormacionRNLocal {

    @EJB
    private FormacionRRHHFacadeLocal formacionRRHHFacadeLocal;

    @Override
    public List<FormacionRRHH> findByTypeYProyecto(Long idProyecto, Long idInvestigador) throws Exception {
        return (this.formacionRRHHFacadeLocal.findByTypeYProyecto(idProyecto, idInvestigador));
    }

    @Override
    public void create(FormacionRRHH formacionRRHH) throws Exception {
    
        this.formacionRRHHFacadeLocal.create(formacionRRHH);
    }

    @Override
    public void edit(FormacionRRHH formacionRRHH) throws Exception {
        this.formacionRRHHFacadeLocal.edit(formacionRRHH);
    }

    @Override
    public void remove(FormacionRRHH formacionRRHH) throws Exception {
        this.formacionRRHHFacadeLocal.remove(formacionRRHH);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   

    
}
