/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import entidades.investigador.formacionAcademica.FormacionAcademicaOtra;
import entidades.investigador.formacionAcademica.FormacionAcademicaPosgrado;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author hugo
 */

@ManagedBean
@SessionScoped
public class LstFormacionAcademicaBean implements Serializable {

    /**
     * Creates a new instance of LstFormacionAcademicaBean
     */
    private List<FormacionAcademicaGrado> lstFormacionAcademicaGrado;
    private List<FormacionAcademicaPosgrado> lstFormacionAcademicaPosgrado;
    private List<FormacionAcademicaOtra> lstFormacionAcademicaOtra;
   @ManagedProperty("#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty(value = "#{dlgFormacionAcademicaOtraBea}")
    private dlgFormacionAcademicaOtraBean dlgFormacionAcademicaOtraBea;
    
    private DataTable dtGrado;
    private DataTable dtPosgrado;
    private DataTable dtOtra;
    private FormacionAcademicaGrado formacionAcademicaGrado;
    private FormacionAcademicaPosgrado formacionAcademicaPosgrado;
    
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    public LstFormacionAcademicaBean() {
    }

    public dlgFormacionAcademicaOtraBean getDlgFormacionAcademicaOtraBea() {
        return dlgFormacionAcademicaOtraBea;
    }

    public void setDlgFormacionAcademicaOtraBea(dlgFormacionAcademicaOtraBean dlgFormacionAcademicaOtraBea) {
        this.dlgFormacionAcademicaOtraBea = dlgFormacionAcademicaOtraBea;
    }
    

    public DataTable getDtPosgrado() {
        return dtPosgrado;
    }

    public void setDtPosgrado(DataTable dtPosgrado) {
        this.dtPosgrado = dtPosgrado;
    }

    public DataTable getDtOtra() {
        return dtOtra;
    }

    public void setDtOtra(DataTable dtOtra) {
        this.dtOtra = dtOtra;
    }
    
    
    public FormacionAcademicaGrado getFormacionAcademicaGrado() {
        return formacionAcademicaGrado;
    }

    public void setFormacionAcademicaGrado(FormacionAcademicaGrado formacionAcademicaGrado) {
        this.formacionAcademicaGrado = formacionAcademicaGrado;
    }
    
    public List<FormacionAcademicaGrado> getLstFormacionAcademicaGrado() {
        return lstFormacionAcademicaGrado;
    }

    public void setLstFormacionAcademicaGrado(List<FormacionAcademicaGrado> lstFormacionAcademicaGrado) {
        this.lstFormacionAcademicaGrado = lstFormacionAcademicaGrado;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public DataTable getDtGrado() {
        return dtGrado;
    }

    public void setDtGrado(DataTable dtGrado) {
        this.dtGrado = dtGrado;
    }

    public List<FormacionAcademicaPosgrado> getLstFormacionAcademicaPosgrado() {
        return lstFormacionAcademicaPosgrado;
    }

    public void setLstFormacionAcademicaPosgrado(List<FormacionAcademicaPosgrado> lstFormacionAcademicaPosgrado) {
        this.lstFormacionAcademicaPosgrado = lstFormacionAcademicaPosgrado;
    }

    public FormacionAcademicaPosgrado getFormacionAcademicaPosgrado() {
        return formacionAcademicaPosgrado;
    }

    public void setFormacionAcademicaPosgrado(FormacionAcademicaPosgrado formacionAcademicaPosgrado) {
        this.formacionAcademicaPosgrado = formacionAcademicaPosgrado;
    }

    public List<FormacionAcademicaOtra> getLstFormacionAcademicaOtra() {
        return lstFormacionAcademicaOtra;
    }

    public void setLstFormacionAcademicaOtra(List<FormacionAcademicaOtra> lstFormacionAcademicaOtra) {
        this.lstFormacionAcademicaOtra = lstFormacionAcademicaOtra;
    }
    
    
    @PostConstruct
    private void init() {
        //Lista formacion academica Grado
        this.setLstFormacionAcademicaGrado(new ArrayList<FormacionAcademicaGrado>());
        this.setFormacionAcademicaGrado(new FormacionAcademicaGrado());
        //Lista formacion Posgrado
        this.setLstFormacionAcademicaPosgrado(new ArrayList<FormacionAcademicaPosgrado>());
        this.setFormacionAcademicaPosgrado(new FormacionAcademicaPosgrado());
        
        
    }
    // FORMACION GRADO
    public List<FormacionAcademicaGrado> getFormacionesAcademicasInvestigadorLogin(Investigador inv){
        this.setLstFormacionAcademicaGrado(inv.getFormacionesAcademicasGrado());
        return this.getLstFormacionAcademicaGrado();
    }
    public void quitarFormacionAcademicaGrado(Long idFormacionAcademica) {
        
        try {
            System.out.println("idFormacionAcademica: " + idFormacionAcademica);
            for(FormacionAcademicaGrado fag : lstFormacionAcademicaGrado){
                if(fag.getId() == idFormacionAcademica){
                    lstFormacionAcademicaGrado.remove(fag);
                    break;
                }//fin if
            }//fin for
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().setFormacionesAcademicasGrado(lstFormacionAcademicaGrado);
            investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
        } catch (Exception ex) {
            Logger.getLogger(LstFormacionAcademicaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //FORMACION POSGRADO
     public List<FormacionAcademicaPosgrado> getFormacionesAcademicasPosgradoInvestigadorLogin(Investigador inv){
        this.setLstFormacionAcademicaPosgrado(inv.getFormacionesAcademicasPosgrado());
        return this.getLstFormacionAcademicaPosgrado();
    }
    public void quitarFormacionAcademicaPosgrado(Long idFormacionAcademica) {
        try {
            
            for(FormacionAcademicaPosgrado fap : lstFormacionAcademicaPosgrado){
                if(fap.getId() == idFormacionAcademica){
                    lstFormacionAcademicaPosgrado.remove(fap);
                    break;
                }//fin if
            }//fin for
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().setFormacionesAcademicasPosgrado(lstFormacionAcademicaPosgrado);
            investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
        } catch (Exception ex) {
            Logger.getLogger(LstFormacionAcademicaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    //FORMACION OTRA
     public List<FormacionAcademicaOtra> getFormacionesAcademicasOtraInvestigadorLogin(Investigador inv){
        this.setLstFormacionAcademicaOtra(inv.getFormacionesAcademicasOtras());
        return this.getLstFormacionAcademicaOtra();
    }
    public void quitarFormacionAcademicaOtra(Long idFormacionAcademica) {

        try {
            
            for(FormacionAcademicaOtra fao : lstFormacionAcademicaOtra){
                if(fao.getId() == idFormacionAcademica){
                    lstFormacionAcademicaOtra.remove(fao);
                    break;
                }//fin if
            }//fin for
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().setFormacionesAcademicasOtras(lstFormacionAcademicaOtra);
            investigadorRNLocal.edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
        } catch (Exception ex) {
            Logger.getLogger(LstFormacionAcademicaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
