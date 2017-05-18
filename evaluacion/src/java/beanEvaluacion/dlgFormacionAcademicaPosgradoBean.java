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
import entidades.titulo.TituloPosgrado;
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
@ManagedBean(name = "dlgFormacionAcademicaPosgradoBean")
@SessionScoped
public class dlgFormacionAcademicaPosgradoBean implements Serializable {

    /**
     * Creates a new instance of dlgFormacionAcademicaBean
     */
    @ManagedProperty(value = "#{tituloPosgradoLstBean}")
    private TituloPosgradoLstBean tituloPosgradoLstBean;
    @ManagedProperty("#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    private FormacionAcademicaPosgrado formacionAcademicaPosgrado;
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    private TituloPosgrado tituloPosgrado;
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

    public dlgFormacionAcademicaPosgradoBean() {
        formacionAcademicaPosgrado = new FormacionAcademicaPosgrado();
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

    public FormacionAcademicaPosgrado getFormacionAcademicaPosgrado() {
        return formacionAcademicaPosgrado;
    }

    public void setFormacionAcademicaPosgrado(FormacionAcademicaPosgrado formacionAcademicaPosgrado) {
        this.formacionAcademicaPosgrado = formacionAcademicaPosgrado;
    }

    public TituloPosgrado getTituloPosgrado() {
        return tituloPosgrado;
    }

    public void setTituloPosgrado(TituloPosgrado tituloPosgrado) {
        this.tituloPosgrado = tituloPosgrado;
    }

    public TituloPosgradoLstBean getTituloPosgradoLstBean() {
        return tituloPosgradoLstBean;
    }

    public void setTituloPosgradoLstBean(TituloPosgradoLstBean tituloPosgradoLstBean) {
        this.tituloPosgradoLstBean = tituloPosgradoLstBean;
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
        tituloPosgrado = new TituloPosgrado();
        formacionAcademicaPosgrado = new FormacionAcademicaPosgrado();

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

        //ACCIONES POsgrado
        if (this.getTipoOperacionFormacionAcademica().equals("AltaPosgrado")) {

            this.setFormacionAcademicaPosgrado(new FormacionAcademicaPosgrado());
            this.getFormacionAcademicaPosgrado().setAnoEgreso(anoEgreso);
            this.getFormacionAcademicaPosgrado().setAnoIngreso(anoIngreso);
            this.getFormacionAcademicaPosgrado().setTituloPosgrado(tituloPosgrado);
            this.getFormacionAcademicaPosgrado().setUniversidad(universidad);
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasPosgrado().add(this.getFormacionAcademicaPosgrado());
            try {
                investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
                System.out.println("INVESTIGADOR EDITADO!!!!");
            } catch (Exception ex) {
                Logger.getLogger(dlgFormacionAcademicaPosgradoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getTipoOperacionFormacionAcademica().equals("ModificaciónPosgrado")) {


            this.getFormacionAcademicaPosgrado().setAnoEgreso(anoEgreso);
            this.getFormacionAcademicaPosgrado().setAnoIngreso(anoIngreso);
            this.getFormacionAcademicaPosgrado().setTituloPosgrado(tituloPosgrado);
            this.getFormacionAcademicaPosgrado().setUniversidad(universidad);
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasPosgrado().
                    set(this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasPosgrado().
                    indexOf(this.getFormacionAcademicaPosgrado()), this.getFormacionAcademicaPosgrado());
            try {
                investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
                System.out.println("INVESTIGADOR EDITADO!!!!");
            } catch (Exception ex) {
                Logger.getLogger(dlgFormacionAcademicaPosgradoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    public void accion(ActionEvent e) {

        this.setBotonSeleccionado((CommandButton) e.getSource());
        RequestContext context = RequestContext.getCurrentInstance();

        if (this.getBotonSeleccionado().getId().equals("cbAgregarFormacionPosgrado")) {
            this.setTipoOperacionFormacionAcademica("AltaPosgrado");
            context.execute("dlgFormacionAcademicaPosgrado.show();");
        }
        if (this.getBotonSeleccionado().getId().equals("cbModificarFormacionPosgrado")) {
            this.setTipoOperacionFormacionAcademica("ModificaciónPosgrado");
            /*this.setFormacionAcademicaPosgrado((FormacionAcademicaPosgrado) this.getLstFormacionAcademicaBean().getDtPosgrado().getRowData());
            this.setUniversidad(this.getFormacionAcademicaPosgrado().getUniversidad());
            this.setTituloPosgrado(this.getFormacionAcademicaPosgrado().getTituloPosgrado());
            this.setAnoIngreso(this.getFormacionAcademicaPosgrado().getAnoIngreso());
            this.setAnoEgreso(this.getFormacionAcademicaPosgrado().getAnoEgreso());*/
            context.execute("dlgFormacionAcademicaPosgrado.show();");
        }

    }
}
