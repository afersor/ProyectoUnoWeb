/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.Persona;
import recursos.MensajeBean;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import entidades.proyecto.Rol;
import entidades.proyectoPidWeb.ParticipacionPidWeb;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class InvestigadorFindDlgBean implements Serializable {

    private String sNombreApellido;
    private Investigador investigadorSelect;
    @ManagedProperty("#{investigadorLstBean}")
    private InvestigadorLstBean investigadorLstBean;
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    @ManagedProperty("#{participacionWebFindDlgBean}")
    private ParticipacionWebFindDlgBean participacionWebFindDlgBean;
    private int tipo;

    public InvestigadorFindDlgBean() {
    }

    public ParticipacionWebFindDlgBean getParticipacionWebFindDlgBean() {
        return participacionWebFindDlgBean;
    }

    public void setParticipacionWebFindDlgBean(ParticipacionWebFindDlgBean participacionWebFindDlgBean) {
        this.participacionWebFindDlgBean = participacionWebFindDlgBean;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public String getsNombreApellido() {
        return sNombreApellido;
    }

    public void setsNombreApellido(String sNombreApellido) {
        this.sNombreApellido = sNombreApellido;
    }

    public Investigador getInvestigadorSelect() {
        return investigadorSelect;
    }

    public void setInvestigadorSelect(Investigador investigadorSelect) {
        this.investigadorSelect = investigadorSelect;
    }

    public InvestigadorLstBean getInvestigadorLstBean() {
        return investigadorLstBean;
    }

    public void setInvestigadorLstBean(InvestigadorLstBean investigadorLstBean) {
        this.investigadorLstBean = investigadorLstBean;
    }

    //para saber que tengo que actualizar en la pantalla
    public void definirComponentesActualizar() {

        try {

            if (this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb() == null) {
                this.getProyectoWebBean().getProyectoWeb().setParticipacionesWeb(new ArrayList<ParticipacionPidWeb>());
            }//fin if

            if (this.getInvestigadorSelect() == null) {
                throw new Exception("Debe seleccionar el investigador de la tabla");
            }//fin if

            RequestContext context = RequestContext.getCurrentInstance();


            switch (this.getTipo()) {

                case 0: //DIRECTOR
                    ParticipacionPidWeb pw = new ParticipacionPidWeb();
                    pw.setInvestigador(this.getInvestigadorSelect());
                    pw.setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());
                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().add(0, pw);

                    //actualizar

                    context.update("frmUser:otDirector");
                    break;

//                case 1: //CODIRECTOR
//
////                    if (this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(0).equals(
////                            this.getInvestigadorSelect())) {
////                        throw new Exception("El Codirector no puede ser el mismo que el director");
////                    }//fin if
//
//
//
//                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).
//                            setInvestigador(this.getInvestigadorSelect());
//                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).
//                            setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());
//
//                    Rol rol = new Rol();
//                    rol.setId(2L);
//                    rol.setDescripcion("Co-Director");
//                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).setRol(rol);
//
//
//                    //actualizar 
//                    context.update("frmUser:otCoDirector");
//
//                    break;

                case 2:

                    this.getParticipacionWebFindDlgBean().setParticipacionWeb(new ParticipacionPidWeb());


                    this.getParticipacionWebFindDlgBean().getParticipacionWeb().setInvestigador(this.getInvestigadorSelect());



                    //actualizar 
                    context.update("frmUser:pgInvestigador");

                    break;
            }//fin switch
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar

    public void findLikeNombreApellido() {
        try {

            if (!this.getsNombreApellido().isEmpty()) {
                this.getInvestigadorLstBean().findLikeNombreyApellido(this.getsNombreApellido());

            } else {
                throw new Exception("Error. No ingreso un valor a buscar.");
            }
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin findLikeNombreApellido
}//FIN CLASE
