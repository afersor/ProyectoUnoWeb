/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.InvestigadorFacadeLocal;
import entidades.persona.investigador.Investigador;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class InvestigadorRN implements InvestigadorRNLocal {

    @EJB
    private InvestigadorFacadeLocal investigadorFacadeLocal;

    @Override
    public Investigador findInvestigadorByCUIL(String cuil) throws Exception {
        return investigadorFacadeLocal.findInvestigadorByCUIL(cuil);
    }//fin findInvestigadoresByCUIL

    @Override
    public void edit(Investigador investigador) throws Exception {
        this.validar(investigador,2);
        investigadorFacadeLocal.edit(investigador);
    }

    @Override
    public List<Investigador> findLikeNombreyApellido(String cadena) throws Exception {
        return investigadorFacadeLocal.findLikeNombreyApellido(cadena);
    }

    @Override
    public void create(Investigador investigador) throws Exception {
        this.validar(investigador,0);
        investigadorFacadeLocal.create(investigador);
    }
    
    private void validar(Investigador investigador, int op) throws Exception{
        
        if(investigador.getPersona().getNombre().isEmpty() || investigador.getPersona().getNombre() == null){
            throw new Exception("Debe ingresar el nombre");
        }//fin if
        
        if(investigador.getPersona().getApellido().isEmpty() || investigador.getPersona().getApellido() == null){
            throw new Exception("Debe ingresar el apellido");
        }//fin if
        
        if(investigador.getPersona().getDocumentoIdentidad().getNumero() <= 0){
            throw new Exception("Debe ingresar el número del documento");
        }//fin if
        
        if(investigador.getPersona().getCuil().isEmpty() || investigador.getPersona().getCuil() == null){
            throw new Exception("Debe ingresar el número del CUIL");
        }//fin if
        
        switch(op){
            case 0:
                if (this.investigadorFacadeLocal.findInvestigadorByCUIL(investigador.getPersona().getCuil()) != null) {
                    throw new Exception("Ya existe un investigador con el cuil ingresado");
                }//fin if
                break;
            case 1:
                if (this.investigadorFacadeLocal.findInvestigadorByCUILID(investigador.getPersona().getCuil(), 
                        investigador.getId()) != null) {
                    throw new Exception("Ya existe un investigador con el cuil ingresado");
                }//fin if
                break;
        }
               
        
    }//fin validar

    @Override
    public Investigador findById(Long id) throws Exception {
        return investigadorFacadeLocal.find(id);
    }

    @Override
    public Investigador find(Object id) throws Exception {
        return investigadorFacadeLocal.find(id);
    }

    
    
}//FIN CLASE
