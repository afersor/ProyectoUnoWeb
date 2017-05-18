/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

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
public class PalabraClaveFindDlgBean {

    private String palabra;
    private int tipo;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public PalabraClaveFindDlgBean() {
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
    
    
    public void definirComponentesActualizar() {
        try {

            if (this.getPalabra().isEmpty()) {
                throw new Exception("Debe ingresar la palabra clave.");
            }//fin if

            RequestContext context = RequestContext.getCurrentInstance();

            System.out.println("Tipo: " + this.getTipo());
            switch (this.getTipo()) {
                case 0:

                    if (this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves() == null) {
                        this.getProyectoWebBean().getProyectoWeb().setPalabrasClaves(new ArrayList<String>());
                    }//fin if

                    for (String s : this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves()) {
                        if (s.trim().toLowerCase().equals(this.getPalabra().trim().toLowerCase())) {
                            throw new Exception("La palabra ya fue ingresada.");
                        }//fin if
                    }//fin for

                    this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves().add(this.getPalabra());


                    context.update("frmUser:dtPalabrasClaves");
                    break;

                case 1:

                    if (this.getProyectoWebBean().getProyectoWeb().getKeywords() == null) {
                        this.getProyectoWebBean().getProyectoWeb().setKeywords(new ArrayList<String>());
                    }//fin if

                    for (String s : this.getProyectoWebBean().getProyectoWeb().getKeywords()) {
                        if (s.trim().toLowerCase().equals(this.getPalabra().trim().toLowerCase())) {
                            throw new Exception("La palabra ya fue ingresada.");
                        }//fin if
                    }//fin for

                    this.getProyectoWebBean().getProyectoWeb().getKeywords().add(this.getPalabra());

                    context.update("frmUser:dtKeywords");
                    break;
            }//fin switch

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar
    
    
}
