/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.ContrasenaFacadeLocal;
import DAO.InvestigadorFacadeLocal;
import entidades.persona.investigador.Contrasena;
import entidades.persona.investigador.Investigador;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class ContrasenaRN implements ContrasenaRNLocal {

    @EJB
    private ContrasenaFacadeLocal contrasenaFacadeLocal;
    
    @EJB
    private InvestigadorFacadeLocal investigadorFacadeLocal;
    
    @Override
    public void create(String cuil, String contrasena) throws Exception {
        Investigador inv =  this.investigadorFacadeLocal.findInvestigadorByCUIL(cuil);
        this.validar(cuil, inv);
        Contrasena c = new Contrasena();
        c.setInvestigador(inv);
        c.setContrasena(contrasena);
        this.contrasenaFacadeLocal.create(c);
    }

    @Override
    public void edit(String cuil, String contrasena) throws Exception {
        this.contrasenaFacadeLocal.updateContrasena(cuil, contrasena);
    }

    private void validar(String cuil, Investigador inv ) throws Exception{
        
        if(inv == null){
           throw new Exception("No hay registrado un investigador con el cuil ingresado"); 
        }//fin if
        
        if(this.contrasenaFacadeLocal.bFindByInvestigador(cuil)){
            throw new Exception("El investigador ya esta registrado. No es posible repetir la operación");
        }//fin if
        
    }//fin validar

    @Override
    public Boolean bFindByInvestigadorYcontrasena(String cuil, String contrasena) throws Exception {
        return this.contrasenaFacadeLocal.bFindByInvestigadorYcontrasena(cuil, contrasena);
    }//fin bFindByInvestigadorYcontrasena

}
