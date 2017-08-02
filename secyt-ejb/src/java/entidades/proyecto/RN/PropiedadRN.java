/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.PropiedadFacadeLocal;
import entidades.proyecto.resultado.Industrial;
import entidades.proyecto.resultado.Intelectual;
import entidades.proyecto.resultado.Propiedad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;


/**
 *
 * @author AFerSor
 */
@Stateless
public class PropiedadRN implements PropiedadRNLocal {

    @EJB
    private PropiedadFacadeLocal propiedadFacadeLocal;
    
    @Override
    public List<Propiedad> findByTypeYProyecto(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        return propiedadFacadeLocal.findByTypeYProyecto(idProyecto,idInvestigador, tipo);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void create(Propiedad propiedad, String clase) throws Exception {
        this.validar(propiedad, 0, clase);
       this.propiedadFacadeLocal.create(propiedad);
    }

    @Override
    public void edit(Propiedad propiedad, String clase) throws Exception {
        this.validar(propiedad, 0, clase);
       this.propiedadFacadeLocal.edit(propiedad);
    }

    @Override
    public void remove(Propiedad propiedad) throws Exception {
        this.propiedadFacadeLocal.remove(propiedad);
    }

     private void validar(Propiedad p, int op, String clase) throws Exception {
        System.out.println("ENTRO A VALIDAR la clase es ---->" +clase);
        if (p.getTitulo().trim().length() == 0) {
            throw new Exception("Debe ingresar un título");
        }

        if (clase.equals("Industrial")) {
            Industrial ar = (Industrial) p;

            if (ar.getTitulo().trim().length() == 0) {
                throw new Exception("Debe ingresar un título");
            }
            if (ar.getTitulares().trim().length() == 0) {
                throw new Exception("Debe ingresar el/los titular/es del registro");
            }
             if (ar.getNroRegistro().trim().length() == 0) {
                throw new Exception("Debe ingresar el número de registro");
            }
            if (!cadenas.es_numero(ar.getNroRegistro())) {
                throw new Exception("El número de registro debe contener solo caracteres numéricos");
            }
             if (ar.getFecha()== null) {
                throw new Exception("Debe ingresar la fecha");
            }
             if (ar.getPais().trim().length() == 0) {
                throw new Exception("Debe ingresar el país");
            }

        }
        if (clase.equals("Intelectual")) {
            Intelectual ar = (Intelectual) p;

            if (ar.getTitulo().trim().length() == 0) {
                throw new Exception("Debe ingresar un título");
            }
            if (ar.getTitulares().trim().length() == 0) {
                throw new Exception("Debe ingresar el/los titular/es del registro");
            }
             if (ar.getNroRegistro().trim().length() == 0) {
                throw new Exception("Debe ingresar el número de registro");
            }
            if (!cadenas.es_numero(ar.getNroRegistro())) {
                throw new Exception("El número de registro debe contener solo caracteres numéricos");
            }
             if (ar.getFecha()== null) {
                throw new Exception("Debe ingresar la fecha");
            }
             if (ar.getPais().trim().length() == 0) {
                throw new Exception("Debe ingresar el país");
            }

        }
    }//fin validar

}
