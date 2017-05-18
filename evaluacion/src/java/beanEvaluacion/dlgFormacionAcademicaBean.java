/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.RN.UniversidadRNLocal;
import entidades.Universidad;
import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import entidades.investigador.formacionAcademica.FormacionAcademicaOtra;
import entidades.investigador.formacionAcademica.FormacionAcademicaPosgrado;
import entidades.investigador.formacionAcademica.RN.FormacionAcademicaGradoRNLocal;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import entidades.titulo.RN.TituloGradoRNLocal;
import entidades.titulo.Titulo;
import entidades.titulo.TituloGrado;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hugo
 */
@ManagedBean(name = "dlgFormacionAcademicaBean")
@SessionScoped
public class dlgFormacionAcademicaBean implements Serializable {

    /**
     * Creates a new instance of dlgFormacionAcademicaBean
     */
    @ManagedProperty(value = "#{tituloGradoLstBean}")
    private TituloGradoLstBean tituloGradoLstBean;
    @ManagedProperty("#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    private FormacionAcademicaGrado formacionAcademicaGrado;
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    private TituloGrado tituloGrado;
    private Universidad universidad;
    private int anoIngreso;
    private int anoEgreso;
    private SelectBooleanCheckbox selectBooleanCheckbox;
    private boolean cursandoActualmente;
    private boolean sinDatos;
    private boolean flagIngreso;
    private boolean flagEgreso;
    private boolean flagChkCursandoActualmente;
    private Investigador Investigador;
    @ManagedProperty("#{lstFormacionAcademicaBean}")
    private LstFormacionAcademicaBean lstFormacionAcademicaBean;
    private CommandButton botonSeleccionado;
    private String tipoOperacionFormacionAcademica;

    public dlgFormacionAcademicaBean() {
        formacionAcademicaGrado = new FormacionAcademicaGrado();
    }
    public LstFormacionAcademicaBean getLstFormacionAcademicaBean() {
        return lstFormacionAcademicaBean;
    }

    public void setLstFormacionAcademicaBean(LstFormacionAcademicaBean lstFormacionAcademicaBean) {
        this.lstFormacionAcademicaBean = lstFormacionAcademicaBean;
    }

    public String getTipoOperacionFormacionAcademica() {
        return tipoOperacionFormacionAcademica;
    }

    public void setTipoOperacionFormacionAcademica(String tipoOperacionFormacionAcademica) {
        this.tipoOperacionFormacionAcademica = tipoOperacionFormacionAcademica;
    }

    public CommandButton getBotonSeleccionado() {
        return botonSeleccionado;
    }

    public void setBotonSeleccionado(CommandButton botonSeleccionado) {
        this.botonSeleccionado = botonSeleccionado;
    }

    public Investigador getInvestigador() {
        return Investigador;
    }

    public void setInvestigador(Investigador Investigador) {
        this.Investigador = Investigador;
    }

    public boolean isFlagChkCursandoActualmente() {
        return flagChkCursandoActualmente;
    }

    public void setFlagChkCursandoActualmente(boolean flagChkCursandoActualmente) {
        this.flagChkCursandoActualmente = flagChkCursandoActualmente;
    }

    public boolean isFlagIngreso() {
        return flagIngreso;
    }

    public void setFlagIngreso(boolean flagIngreso) {
        this.flagIngreso = flagIngreso;
    }

    public boolean isFlagEgreso() {
        return flagEgreso;
    }

    public void setFlagEgreso(boolean flagEgreso) {
        this.flagEgreso = flagEgreso;
    }

    public boolean isCursandoActualmente() {
        return cursandoActualmente;
    }

    public void setCursandoActualmente(boolean cursandoActualmente) {
        this.cursandoActualmente = cursandoActualmente;
    }

    public boolean isSinDatos() {
        return sinDatos;
    }

    public void setSinDatos(boolean sinDatos) {
        this.sinDatos = sinDatos;
    }

    public SelectBooleanCheckbox getSelectBooleanCheckbox() {
        return selectBooleanCheckbox;
    }

    public void setSelectBooleanCheckbox(SelectBooleanCheckbox selectBooleanCheckbox) {
        this.selectBooleanCheckbox = selectBooleanCheckbox;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    public void setAnoIngreso(int anoIngreso) {
        this.anoIngreso = anoIngreso;
    }

    public int getAnoEgreso() {
        return anoEgreso;
    }

    public void setAnoEgreso(int anoEgreso) {
        this.anoEgreso = anoEgreso;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public TituloGrado getTituloGrado() {
        return tituloGrado;
    }

    public void setTituloGrado(TituloGrado tituloGrado) {
        this.tituloGrado = tituloGrado;
    }

    public FormacionAcademicaGrado getFormacionAcademicaGrado() {
        return formacionAcademicaGrado;
    }

    public void setFormacionAcademicaGrado(FormacionAcademicaGrado formacionAcademicaGrado) {
        this.formacionAcademicaGrado = formacionAcademicaGrado;
    }

    public TituloGradoLstBean getTituloGradoLstBean() {
        return tituloGradoLstBean;
    }

    public void setTituloGradoLstBean(TituloGradoLstBean tituloGradoLstBean) {
        this.tituloGradoLstBean = tituloGradoLstBean;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    @PostConstruct
    private void init() {
        this.setInvestigador(new Investigador());
        this.setAnoIngreso(0);
        this.setAnoEgreso(0);
        flagEgreso = Boolean.FALSE;
        flagIngreso = Boolean.FALSE;
        flagChkCursandoActualmente = Boolean.FALSE;
        tituloGrado = new TituloGrado();
        formacionAcademicaGrado = new FormacionAcademicaGrado();

    }

    public void accionAñoEgreso() {
        if (cursandoActualmente) {
            this.setAnoEgreso(0);
            this.setSinDatos(false);
            this.setFlagEgreso(Boolean.TRUE);
        } else {
            this.setFlagEgreso(Boolean.FALSE);

        }

    }

    public void accionSinDatos() {
        if (sinDatos) {
            this.setAnoIngreso(0);
            this.setAnoEgreso(0);
            this.setCursandoActualmente(false);
            this.setFlagEgreso(Boolean.TRUE);
            this.setFlagIngreso(Boolean.TRUE);
            this.setFlagChkCursandoActualmente(Boolean.TRUE);

        } else {
            this.setFlagEgreso(Boolean.FALSE);
            this.setFlagIngreso(Boolean.FALSE);
            this.setFlagChkCursandoActualmente(Boolean.FALSE);
        }

    }

    public void accionGrado() {
        
        //ACCIONES GRADO
        if (this.getTipoOperacionFormacionAcademica().equals("AltaGrado")) {
            
            formacionAcademicaGrado = new FormacionAcademicaGrado();
            formacionAcademicaGrado.setAnoEgreso(anoEgreso);
            formacionAcademicaGrado.setAnoIngreso(anoIngreso);
            formacionAcademicaGrado.setTituloGrado(tituloGrado);
            formacionAcademicaGrado.setUniversidad(universidad);
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasGrado().add(formacionAcademicaGrado);
            try {
                investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
                System.out.println("INVESTIGADOR EDITADO!!!!");
            } catch (Exception ex) {
                Logger.getLogger(dlgFormacionAcademicaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getTipoOperacionFormacionAcademica().equals("ModificaciónGrado")) {
            
            
            this.getFormacionAcademicaGrado().setAnoEgreso(anoEgreso);
            this.getFormacionAcademicaGrado().setAnoIngreso(anoIngreso);
            this.getFormacionAcademicaGrado().setTituloGrado(tituloGrado);
            this.getFormacionAcademicaGrado().setUniversidad(universidad);
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().
                    getFormacionesAcademicasGrado().set(
                    this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasGrado().indexOf(this.getFormacionAcademicaGrado()),this.getFormacionAcademicaGrado());
            try {
                investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
                System.out.println("INVESTIGADOR EDITADO!!!!");
            } catch (Exception ex) {
                Logger.getLogger(dlgFormacionAcademicaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        


    }

    public void accion(ActionEvent e) {
        this.setBotonSeleccionado((CommandButton) e.getSource());
        RequestContext context = RequestContext.getCurrentInstance();

        if (this.getBotonSeleccionado().getId().equals("cbAgregarFormacionGrado")) {
            this.setTipoOperacionFormacionAcademica("AltaGrado");
            context.execute("dlgFormacionAcademica.show();");
        }
        if (this.getBotonSeleccionado().getId().equals("cbModificarFormacionGrado")) {
            this.setTipoOperacionFormacionAcademica("ModificaciónGrado");
            /*this.setFormacionAcademicaGrado((FormacionAcademicaGrado) this.getLstFormacionAcademicaBean().getDtGrado().getRowData());
            this.setUniversidad(this.getFormacionAcademicaGrado().getUniversidad());
            this.setTituloGrado(this.getFormacionAcademicaGrado().getTituloGrado());
            this.setAnoIngreso(this.getFormacionAcademicaGrado().getAnoIngreso());
            this.setAnoEgreso(this.getFormacionAcademicaGrado().getAnoEgreso());*/
            context.execute("dlgFormacionAcademica.show();");
        }
        
    }
}
