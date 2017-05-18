/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.Institucion;
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
import entidades.titulo.TituloOtro;
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
@ManagedBean(name = "dlgFormacionAcademicaOtraBean")
@SessionScoped
public class dlgFormacionAcademicaOtraBean implements Serializable {

    /**
     * Creates a new instance of dlgFormacionAcademicaBean
     */
    @ManagedProperty(value = "#{tituloOtroLstBean}")
    private TituloOtroLstBean tituloOtroLstBean;
    @ManagedProperty("#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    private FormacionAcademicaOtra formacionAcademicaOtra;
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    private TituloOtro tituloOtro;
    private Institucion institucion;
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

    public dlgFormacionAcademicaOtraBean() {
        formacionAcademicaOtra = new FormacionAcademicaOtra();
    }
    

    public FormacionAcademicaOtra getFormacionAcademicaOtra() {
        return formacionAcademicaOtra;
    }

    public void setFormacionAcademicaOtra(FormacionAcademicaOtra formacionAcademicaOtra) {
        this.formacionAcademicaOtra = formacionAcademicaOtra;
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public TituloOtroLstBean getTituloOtroLstBean() {
        return tituloOtroLstBean;
    }

    public void setTituloOtroLstBean(TituloOtroLstBean tituloOtroLstBean) {
        this.tituloOtroLstBean = tituloOtroLstBean;
    }

    public TituloOtro getTituloOtro() {
        return tituloOtro;
    }

    public void setTituloOtro(TituloOtro tituloOtro) {
        this.tituloOtro = tituloOtro;
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
        tituloOtro = new TituloOtro();
        formacionAcademicaOtra = new FormacionAcademicaOtra();

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

    public void accionOtra() {
        
        //ACCIONES Otra
        if (this.getTipoOperacionFormacionAcademica().equals("AltaOtra")) {

            this.setFormacionAcademicaOtra(new FormacionAcademicaOtra());
            this.getFormacionAcademicaOtra().setAnoEgreso(anoEgreso);
            this.getFormacionAcademicaOtra().setAnoIngreso(anoIngreso);
            this.getFormacionAcademicaOtra().setTituloOtro(tituloOtro);
            this.getFormacionAcademicaOtra().setInstitucion(institucion);
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasOtras().add(this.getFormacionAcademicaOtra());
            try {
                investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
                System.out.println("INVESTIGADOR EDITADO!!!!");
            } catch (Exception ex) {
                Logger.getLogger(dlgFormacionAcademicaOtraBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getTipoOperacionFormacionAcademica().equals("ModificaciónOtra")) {


            this.getFormacionAcademicaOtra().setAnoEgreso(anoEgreso);
            this.getFormacionAcademicaOtra().setAnoIngreso(anoIngreso);
            this.getFormacionAcademicaOtra().setTituloOtro(tituloOtro);
            this.getFormacionAcademicaOtra().setInstitucion(institucion);
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasOtras().
                    set(this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getFormacionesAcademicasOtras().
                    indexOf(this.getFormacionAcademicaOtra()), this.getFormacionAcademicaOtra());
            try {
                investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
                System.out.println("INVESTIGADOR EDITADO!!!!");
            } catch (Exception ex) {
                Logger.getLogger(dlgFormacionAcademicaOtraBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    public void accion(ActionEvent e) {

        this.setBotonSeleccionado((CommandButton) e.getSource());
        RequestContext context = RequestContext.getCurrentInstance();

        if (this.getBotonSeleccionado().getId().equals("cbAgregarFormacionOtra")) {
            this.setTipoOperacionFormacionAcademica("AltaOtra");
            context.execute("dlgFormacionAcademicaOtra.show();");
        }
        if (this.getBotonSeleccionado().getId().equals("cbModificarFormacionOtra")) {
            this.setTipoOperacionFormacionAcademica("ModificaciónOtra");
            /*this.setFormacionAcademicaOtra((FormacionAcademicaOtra) this.getLstFormacionAcademicaBean().getDtOtra().getRowData());
            this.setInstitucion(this.getFormacionAcademicaOtra().getInstitucion());
            this.setTituloOtro(this.getFormacionAcademicaOtra().getTituloOtro());
            this.setAnoIngreso(this.getFormacionAcademicaOtra().getAnoIngreso());
            this.setAnoEgreso(this.getFormacionAcademicaOtra().getAnoEgreso());*/
            context.execute("dlgFormacionAcademicaOtra.show();");
        }

    }
}
