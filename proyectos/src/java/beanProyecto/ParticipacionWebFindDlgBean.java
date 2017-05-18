/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import entidades.persona.Persona;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import entidades.proyectoPidWeb.ParticipacionPidWeb;
import entidades.proyectoWeb.ParticipacionWeb;
import java.util.ArrayList;
import javax.ejb.EJB;
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
public class ParticipacionWebFindDlgBean {

    private ParticipacionPidWeb participacionPidWeb;
    
    private int tipo;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
     @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    
    public ParticipacionWebFindDlgBean() {
        participacionPidWeb = new ParticipacionPidWeb();
        participacionPidWeb.setInvestigador(new Investigador());
        participacionPidWeb.getInvestigador().setPersona(new Persona());
        participacionPidWeb.getInvestigador().setFormacionesAcademicasGrado(new ArrayList<FormacionAcademicaGrado>());

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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ParticipacionPidWeb getParticipacionWeb() {
        return participacionPidWeb;
    }

    public void setParticipacionWeb(ParticipacionPidWeb participacionWeb) {
        this.participacionPidWeb = participacionWeb;
    }

    //para saber que tengo que actualizar en la pantalla
    public void definirComponentesActualizar() {
        try {
            RequestContext context = RequestContext.getCurrentInstance();

            validar();
            
            switch (this.getTipo()) {

                case 0:
                    
                    //para que me muestre los cursos (listas)
                    this.getParticipacionWeb().setInvestigador(
                            this.investigadorRNLocal.findById(
                            this.getParticipacionWeb().getInvestigador().getId()));
                    
                    this.getParticipacionWeb().setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());

                    for (ParticipacionPidWeb pw : this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb()) {
                        if (pw.getInvestigador().equals(this.getParticipacionWeb().getInvestigador())) {
                            throw new Exception("Ya esta cargado el investigador seleccionado");
                        }//fin if
                    }//fin for

                    
                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().add(this.getParticipacionWeb());
                    

                    //actualizar

                    context.update("frmUser:dtPersonal");
                    break;
                case 1:

//                    if(this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).getInvestigador() == null){
//                        throw new Exception("Debe seleccionar el codirector primero");
//                    }//fin if
                    
                    //para que me muestre los cursos (listas)
                    this.getParticipacionWeb().setInvestigador(
                            this.investigadorRNLocal.findById(
                            this.getParticipacionWeb().getInvestigador().getId()));
                    
                    System.out.println("paso 0");
                    this.getParticipacionWeb().setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());

                    for (ParticipacionPidWeb pw : this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb()) {
                        if(pw.getInvestigador()!=null){
                            if (pw.getInvestigador().equals(this.getParticipacionWeb().getInvestigador())) {
                                throw new Exception("Ya esta cargado el investigador seleccionado");
                            }//fin if
                        }//fin if
                    }//fin for
                    
                    System.out.println("paso 1");
                    
                    if(this.getParticipacionWeb().getRol().getId()!=2l){
                        throw new Exception("El rol debe ser de Co-Director");
                    }//fin if
                    
                    System.out.println("paso 2");
                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).setInvestigador(
                    this.getParticipacionWeb().getInvestigador());
                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).setDedicacionSemanal(
                            this.getParticipacionWeb().getDedicacionSemanal());
                    this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(1).setRol(this.getParticipacionWeb().getRol());

                    
                    System.out.println("paso 3");
                    //actualizar

                    context.update("frmUser:otCoDirector");
                    context.update("frmUser:otDedicacionSemanalCoDirector");
                    
                    RequestContext.getCurrentInstance().execute("dlgFindParticipacionWeb.hide()");
                    
                    break;

            }//fin switch

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show();");
        }
    }//fin definirComponentesActualizar
    
    private void validar() throws Exception{
        if (this.getParticipacionWeb().getInvestigador().getId() == null) {
            throw new Exception("Debe seleccionar el investigador");
        }//fin if

        if (this.getParticipacionWeb().getRol() == null) {
            throw new Exception("Debe seleccionar la función");
        }//fin if

        if (this.getParticipacionWeb().getDedicacionSemanal() == null) {
            throw new Exception("La dedicación semanal debe ser un número entero mayor a o.");
        }//fin if

        if (this.getParticipacionWeb().getDedicacionSemanal() <= 0) {
            throw new Exception("La dedicación semanal debe ser un número entero mayor a o.");
        }//fin if
    }//fin validar
    
    
}//FIN CLASE
