/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.Proyecto;
import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.CapituloLibro;
import entidades.proyecto.resultado.Congreso;
import entidades.proyecto.resultado.Contrato;
import entidades.proyecto.resultado.FormacionRRHH;
import entidades.proyecto.resultado.Intelectual;
import entidades.proyecto.resultado.Libro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class InvestigadorProduccionBean {
    
    @ManagedProperty(value="#{publicacionLstBean}")
    private PublicacionLstBean publicacionLstBean;
    
    @ManagedProperty(value="#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    @ManagedProperty(value="#{propiedadLstBean}")
    private PropiedadLstBean propiedadLstBean;

    private Proyecto proyecto;
    private Class  cTipoDeDato;
    private String sTabSelect;
    
    private Boolean bArticulosRevistas= Boolean.FALSE;
    private Boolean bCapitulosDeLibros= Boolean.FALSE;
    private Boolean bCongresos= Boolean.FALSE;
    private Boolean bContratos= Boolean.FALSE;
    private Boolean bFormacionRRHH= Boolean.FALSE;
    private Boolean bLibros= Boolean.FALSE;
    private Boolean bPropiedadIntelectual= Boolean.FALSE;
    private Boolean bPropiedadIndustrial= Boolean.FALSE;
    private String sOcultarAcordinPanel = "hidden";
    
    public InvestigadorProduccionBean() {
        proyecto = new Proyecto();
    }

    public String getsOcultarAcordinPanel() {
        return sOcultarAcordinPanel;
    }

    public void setsOcultarAcordinPanel(String sOcultarAcordinPanel) {
        this.sOcultarAcordinPanel = sOcultarAcordinPanel;
    }
    
    public Boolean getbPropiedadIndustrial() {
        return bPropiedadIndustrial;
    }

    public void setbPropiedadIndustrial(Boolean bPropiedadIndustrial) {
        this.bPropiedadIndustrial = bPropiedadIndustrial;
    }
    
    public PropiedadLstBean getPropiedadLstBean() {
        return propiedadLstBean;
    }

    public void setPropiedadLstBean(PropiedadLstBean propiedadLstBean) {
        this.propiedadLstBean = propiedadLstBean;
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }
    
    public PublicacionLstBean getPublicacionLstBean() {
        return publicacionLstBean;
    }

    public void setPublicacionLstBean(PublicacionLstBean publicacionLstBean) {
        this.publicacionLstBean = publicacionLstBean;
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Class getcTipoDeDato() {
        return cTipoDeDato;
    }

    public void setcTipoDeDato(Class cTipoDeDato) {
        this.cTipoDeDato = cTipoDeDato;
    }

    public String getsTabSelect() {
        return sTabSelect;
    }

    public void setsTabSelect(String sTabSelect) {
        this.sTabSelect = sTabSelect;
    }

    public Boolean getbArticulosRevistas() {
        return bArticulosRevistas;
    }

    public void setbArticulosRevistas(Boolean bArticulosRevistas) {
        this.bArticulosRevistas = bArticulosRevistas;
    }

    public Boolean getbCapitulosDeLibros() {
        return bCapitulosDeLibros;
    }

    public void setbCapitulosDeLibros(Boolean bCapitulosDeLibros) {
        this.bCapitulosDeLibros = bCapitulosDeLibros;
    }

    public Boolean getbCongresos() {
        return bCongresos;
    }

    public void setbCongresos(Boolean bCongresos) {
        this.bCongresos = bCongresos;
    }

    public Boolean getbContratos() {
        return bContratos;
    }

    public void setbContratos(Boolean bContratos) {
        this.bContratos = bContratos;
    }

    public Boolean getbFormacionRRHH() {
        return bFormacionRRHH;
    }

    public void setbFormacionRRHH(Boolean bFormacionRRHH) {
        this.bFormacionRRHH = bFormacionRRHH;
    }

    public Boolean getbLibros() {
        return bLibros;
    }

    public void setbLibros(Boolean bLibros) {
        this.bLibros = bLibros;
    }

    public Boolean getbPropiedadIntelectual() {
        return bPropiedadIntelectual;
    }

    public void setbPropiedadIntelectual(Boolean bPropiedadIntelectual) {
        this.bPropiedadIntelectual = bPropiedadIntelectual;
    }
    
    
    
    
     public void onTabChange(TabChangeEvent event) {  
       // FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab:" + event.getTab().getId());  
        
        this.limpiarBoolean();
        
        Object tabSelect = event.getTab().getId();
        
        this.setsTabSelect((String)tabSelect);
        
        Object[][] sIsTab = { {"tArticulosRevistas", ArticuloRevista.class}, 
            {"tCapitulosDeLibros",CapituloLibro.class }, 
            {"tCongresos", Congreso.class},
            {"tContratos", Contrato.class},
            {"tFormacionRRHH", FormacionRRHH.class},
            {"tLibros", Libro.class}, 
            {"tPropiedadIndustrial", Intelectual.class},
            {"tPropiedadIntelectual", Intelectual.class}};  
        
        int iSelect = 0;
        for(int i=0; i < 8; i++){
            if(sIsTab[i][0].equals(tabSelect)){
                this.setcTipoDeDato((Class)sIsTab[i][1]);
                this.habilitarBoolean(i);
                iSelect = i;
                i=8;
            }//fin if
        }//fin for
        
    System.out.println("select i: " + iSelect);
        if(iSelect <6){
            this.getPublicacionLstBean().cargarPublicacionesByInvestigador(this.getProyecto().getId(),
                    this.getInvestigadorLoginBean().getInvestigador().getId(), this.getcTipoDeDato());
        }else{
            this.getPropiedadLstBean().cargarPropiedadByTypoYProyecto(this.getProyecto().getId(), 
                    this.getInvestigadorLoginBean().getInvestigador().getId(), this.getcTipoDeDato());
        }
        
        
        
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
     
      private void limpiarBoolean(){
        bArticulosRevistas = Boolean.FALSE;
        bCapitulosDeLibros = Boolean.FALSE;
        bCongresos = Boolean.FALSE;
        bContratos = Boolean.FALSE;
        bFormacionRRHH = Boolean.FALSE;
        bLibros = Boolean.FALSE;
        bPropiedadIndustrial = Boolean.FALSE;
        bPropiedadIntelectual = Boolean.FALSE;
    }//fin limpiarBoolean
    
    private void habilitarBoolean(int i){
        switch(i){
            case 0:
                bArticulosRevistas = Boolean.TRUE;
                break;
            case 1:
                bCapitulosDeLibros = Boolean.TRUE;
                break;
            case 2:
                bCongresos = Boolean.TRUE;
                break;
            case 3:
                bContratos = Boolean.TRUE;
                break;
            case 4:
                bFormacionRRHH = Boolean.TRUE;
                break;
            case 5:
                bLibros = Boolean.TRUE;
                break;
            case 6:
                bPropiedadIndustrial = Boolean.TRUE;
                break;
            case 7:
                bPropiedadIntelectual = Boolean.TRUE;
                break;
        }//din switch
    }//fin habilitarBoolean
    
    public void limpiar(){
        this.getPropiedadLstBean().setLstPropiedad(null);
        sOcultarAcordinPanel = "visible;";
        
        this.getPublicacionLstBean().cargarPublicacionesByInvestigador(this.getProyecto().getId(),
                    this.getInvestigadorLoginBean().getInvestigador().getId(), ArticuloRevista.class);
        bArticulosRevistas = Boolean.TRUE;
    }
    
}//FIN CLASE
