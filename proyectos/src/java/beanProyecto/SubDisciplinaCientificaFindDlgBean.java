/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyecto.SubDisciplinaCientifica;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class SubDisciplinaCientificaFindDlgBean {

    private SubDisciplinaCientifica subDisciplinaCientificaSelect;
    private int tipo;
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;

    public SubDisciplinaCientificaFindDlgBean() {
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public SubDisciplinaCientifica getSubDisciplinaCientificaSelect() {
        return subDisciplinaCientificaSelect;
    }

    public void setSubDisciplinaCientificaSelect(SubDisciplinaCientifica subDisciplinaCientificaSelect) {
        this.subDisciplinaCientificaSelect = subDisciplinaCientificaSelect;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    public void abrirDialog(){
        
        try{

            if(!this.getProyectoWebBean().getProyectoWeb().getSubDisciplinasCientificas().isEmpty()){
            
                throw new Exception("Solo puede agregar un dato");
            }//fin if
            
            RequestContext.getCurrentInstance().execute("dlgFindSubDisciplinaCientifica.show()");
        }catch(Exception ex){
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
 
    }//fin abrirDialog

    //para saber que tengo que actualizar en la pantalla
    public void definirComponentesActualizar() {
        try {
            System.out.println("Seleccion: " + this.getSubDisciplinaCientificaSelect());

            if (this.getSubDisciplinaCientificaSelect() == null) {
                throw new Exception("No selecciono la Subdisciplina Científica");
            }//fin if*/

            if (this.getProyectoWebBean().getProyectoWeb().getSubDisciplinasCientificas() == null) {
                this.getProyectoWebBean().getProyectoWeb().setSubDisciplinasCientificas(new ArrayList<SubDisciplinaCientifica>());
            }//fin if

            switch (this.getTipo()) {

                case 0:

                    if (this.getProyectoWebBean().getProyectoWeb().getSubDisciplinasCientificas().contains(
                            this.getSubDisciplinaCientificaSelect())) {
                        throw new Exception("Ya esta cargada la subDisciplina científica");

                    }//fin

                    this.getProyectoWebBean().getProyectoWeb().getSubDisciplinasCientificas().add(
                            this.getSubDisciplinaCientificaSelect());


                    //actualizar
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.update("frmUser:dtSubDisciplinaCientifica");
                    context.update("frmUser:otraSubdisciplina");

                    break;
            }//fin switch
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar
}
