/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.InvestigadorFacadeLocal;
import DAO.ProyectoFacadeLocal;
import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.Publicacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped
public class PickListView {

    @EJB
    private InvestigadorFacadeLocal investigadorFacadeLocal;
    @EJB
    private ProyectoFacadeLocal proyectoFacadeLocal;
    private List<Investigador> source;
    private List<Investigador> target;
    private DualListModel<Investigador> investigadorDualListModel;
    private Proyecto proyecto;

    public void setTarget(List<Investigador> list) {
        this.target = list;
    }

    public void setSource(List<Investigador> list) {
        this.source = list;
    }

    public InvestigadorFacadeLocal getInvestigadorFacadeLocal() {
        return investigadorFacadeLocal;
    }

    public void setInvestigadorFacadeLocal(InvestigadorFacadeLocal investigadorFacadeLocal) {
        this.investigadorFacadeLocal = investigadorFacadeLocal;
    }

    public ProyectoFacadeLocal getProyectoFacadeLocal() {
        return proyectoFacadeLocal;
    }

    public void setProyectoFacadeLocal(ProyectoFacadeLocal proyectoFacadeLocal) {
        this.proyectoFacadeLocal = proyectoFacadeLocal;
    }

    public DualListModel<Investigador> getInvestigadorDualListModel() {
        return investigadorDualListModel;
    }

    public void setInvestigadorDualListModel(DualListModel<Investigador> investigadorDualListModel) {
        this.investigadorDualListModel = investigadorDualListModel;
    }

    public List<Investigador> getSource() {
        return this.source;
    }

    public List<Investigador> getTarget() {
        return this.target;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public PickListView() {
        proyecto = new Proyecto();
    }

    @PostConstruct
    public void init() {
            this.source = this.investigadorFacadeLocal.findAll(); // return all my users in database
            this.target = new ArrayList<>();
            
            this.investigadorDualListModel = new DualListModel<>(this.source, this.target);
       
    }

  
    public void submit(Proyecto proyecto) {
         System.out.println("ENTROOO AL SUBMIT PICKLISTVIEW ::!:!:!:");
        try {
            System.out.println("proyecto?" + proyecto.getTitulo());
            this.setTarget(this.proyectoFacadeLocal.getTodosIntegrantes(proyecto));
            this.investigadorDualListModel = new DualListModel<>(this.source, this.target);
        } catch (Exception ex) {
            Logger.getLogger(PickListView.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public void cargarTargetDePublicacion(Publicacion publicacion) {
         System.out.println("ENTROOO AL SUBMIT de pickList publicacionnnn ::!:!:!:");
        try {
            
            this.setTarget(publicacion.getInvestigadores());
            this.investigadorDualListModel.setTarget(target);
        } catch (Exception ex) {
            Logger.getLogger(PickListView.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    /*
     public void displayTargetList() {
     System.out.println("Entering function");
     Iterator<User> iterator = this.target.iterator();
     while(iterator.hasNext()) {
     User u = iterator.next();
     System.out.println(u.getLogin());
     }
     }*/

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Investigador) item).getPersona().getNombre()).append("<br />");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }

    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }

}
