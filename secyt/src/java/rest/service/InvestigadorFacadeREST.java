/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author franco
 */
@Stateless
@Path("investigador")
public class InvestigadorFacadeREST {

    @EJB
    private InvestigadorRNLocal investigadorRNLocal;

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Investigador find(@PathParam("id") String id) {
        try {
            return investigadorRNLocal.findInvestigadorByCUIL(id);
        } catch (Exception ex) {
            Logger.getLogger(InvestigadorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    @GET
//    @Produces({"application/xml", "application/json"})
//    public List<Investigador> findAll() {
//        try {
//            List<Investigador> resultadoInvestigadores = investigadorRNLocal.findLikeNombreyApellido("rojas");
//            return resultadoInvestigadores;
//        } catch (Exception ex) {
//            Logger.getLogger(InvestigadorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//
//    }

}
