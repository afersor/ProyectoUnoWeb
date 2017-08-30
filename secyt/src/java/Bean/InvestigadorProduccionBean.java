
package Bean;

import DAO.InvestigadorFacadeLocal;
import DAO.ProyectoFacadeLocal;
import DAO.PublicacionFacadeLocal;
import static com.sun.faces.facelets.util.Path.context;
import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import entidades.proyecto.RN.ContratoRNLocal;
import entidades.proyecto.RN.FormacionRNLocal;
import entidades.proyecto.RN.PropiedadRNLocal;
//import entidades.proyecto.RN.PropiedadRNLocal;
import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.CapituloLibro;
import entidades.proyecto.resultado.Congreso;
import entidades.proyecto.resultado.Contrato;
import entidades.proyecto.resultado.FormacionRRHH;
import entidades.proyecto.resultado.Industrial;
import entidades.proyecto.resultado.Intelectual;
import entidades.proyecto.resultado.Libro;
import entidades.proyecto.resultado.Publicacion;
import entidades.proyecto.resultado.RN.PublicacionRNLocal;
import entidades.proyecto.resultado.TipoContrato;
import entidades.proyecto.resultado.TipoEdicion;
import entidades.proyecto.resultado.TipoReferato;
import entidades.proyecto.resultado.TipoRegistroIndustrial;
import entidades.proyecto.resultado.TipoRegistroIntelectual;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class InvestigadorProduccionBean {

    @EJB
    private InvestigadorFacadeLocal investigadorFacadeLocal;
    @EJB
    private PublicacionFacadeLocal publicacionFacadeLocal;
    @EJB
    private ProyectoFacadeLocal proyectoFacadeLocal;
    @EJB
    private PublicacionRNLocal publicacionRNLocal;
    @EJB
    private PropiedadRNLocal propiedadRNLocal;
    @EJB
    private ContratoRNLocal contratoRNLocal;
    @EJB
    private FormacionRNLocal formacionRNLocal;
    @ManagedProperty(value = "#{publicacionLstBean}")
    private PublicacionLstBean publicacionLstBean;
    @ManagedProperty(value = "#{pickListView}")
    private PickListView pickListView;

    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;

    @ManagedProperty(value = "#{propiedadLstBean}")
    private PropiedadLstBean propiedadLstBean;
    @ManagedProperty(value = "#{contratoLstBean}")
    private ContratoLstBean contratoLstBean;
    @ManagedProperty(value = "#{formacionRRHHLstBean}")
    private FormacionRRHHLstBean formacionRRHHLstBean;
    @ManagedProperty(value = "#{librosLstBean}")
    private LibrosLstBean librosLstBean;

    private Boolean bCamposEditables;
    private CommandButton cbAction;
    private Proyecto proyecto;
    private Class cTipoDeDato;
    private String sTabSelect;
    private Libro[] arrayLibroSelect;
    private DataTable dataTableLibro;
    private Boolean bArticulosRevistas = Boolean.TRUE;
    private Boolean bCapitulosDeLibros = Boolean.FALSE;
    private Boolean bCongresos = Boolean.FALSE;
    private Boolean bContratos = Boolean.FALSE;
    private Boolean bFormacionRRHH = Boolean.FALSE;
    private Boolean bLibros = Boolean.FALSE;
    private Boolean bPropiedadIntelectual = Boolean.FALSE;
    private Boolean bPropiedadIndustrial = Boolean.FALSE;
    private String sOcultarAcordinPanel = "hidden";

    private DualListModel<Investigador> investigadores;
    private List<Investigador> lstInvestigadorTodos;
    private List<Investigador> lstInvestigadorParticipantes;
    private ArticuloRevista articuloRevista;
    private ArticuloRevista articuloRevistaIterar;

    private List<ArticuloRevista> lstArticuloRevista;
    private Libro libro;
    private List<Libro> lstLibro;
    private int iActionBtnSelect;
    public String nombreDeLaClase;

    private Industrial propiedadIndustrial;
    private Intelectual propiedadIntelectual;
    private Congreso congreso;
    private CapituloLibro capituloLibro;
    private List<Congreso> lstCongreso;
    private List<CapituloLibro> lstCapituloLibro;
    private Contrato contrato;
    private List<Contrato> lstContrato;
    private FormacionRRHH formacionRRHH;
    private List<FormacionRRHH> lstFormacionRRHH;
    private String busqueda;

    private int esIntelectual = 0; //usada para diferenciar una propidad industral de una intelectual

    public InvestigadorProduccionBean() {
        proyecto = new Proyecto();
        articuloRevista = new ArticuloRevista();
        libro = new Libro();

        //Lista de investigadores para el pickList
        lstInvestigadorTodos = new ArrayList<>();
        lstInvestigadorParticipantes = new ArrayList<>();
        lstArticuloRevista = new ArrayList<>();
        propiedadIndustrial = new Industrial();
        propiedadIntelectual = new Intelectual();
        capituloLibro = new CapituloLibro();
       // capituloLibro.setLibro(new Libro());
        lstCapituloLibro = new ArrayList<>();
        congreso = new Congreso();
        lstCongreso = new ArrayList<>();
        contrato = new Contrato();
        lstContrato = new ArrayList<>();
        formacionRRHH = new FormacionRRHH();
        lstFormacionRRHH = new ArrayList<>();

    }

    public String getsOcultarAcordinPanel() {
        return sOcultarAcordinPanel;
    }

    public Libro[] getArrayLibroSelect() {
        return arrayLibroSelect;
    }

    public void setArrayLibroSelect(Libro[] arrayLibroSelect) {
        this.arrayLibroSelect = arrayLibroSelect;
    }

    public DataTable getDataTableLibro() {
        return dataTableLibro;
    }

    public void setDataTableLibro(DataTable dataTableLibro) {
        this.dataTableLibro = dataTableLibro;
    }

    public void setsOcultarAcordinPanel(String sOcultarAcordinPanel) {
        this.sOcultarAcordinPanel = sOcultarAcordinPanel;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public Boolean getbPropiedadIndustrial() {
        return bPropiedadIndustrial;
    }

    public FormacionRNLocal getFormacionRNLocal() {
        return formacionRNLocal;
    }

    public void setFormacionRNLocal(FormacionRNLocal formacionRNLocal) {
        this.formacionRNLocal = formacionRNLocal;
    }

    public void setbPropiedadIndustrial(Boolean bPropiedadIndustrial) {
        this.bPropiedadIndustrial = bPropiedadIndustrial;
    }

    public FormacionRRHHLstBean getFormacionRRHHLstBean() {
        return formacionRRHHLstBean;
    }

    public PublicacionFacadeLocal getPublicacionFacadeLocal() {
        return publicacionFacadeLocal;
    }

    public void setPublicacionFacadeLocal(PublicacionFacadeLocal publicacionFacadeLocal) {
        this.publicacionFacadeLocal = publicacionFacadeLocal;
    }

    public LibrosLstBean getLibrosLstBean() {
        return librosLstBean;
    }

    public void setLibrosLstBean(LibrosLstBean librosLstBean) {
        this.librosLstBean = librosLstBean;
    }

    public void setFormacionRRHHLstBean(FormacionRRHHLstBean formacionRRHHLstBean) {
        this.formacionRRHHLstBean = formacionRRHHLstBean;
    }

    public ContratoRNLocal getContratoRNLocal() {
        return contratoRNLocal;
    }

    public void setContratoRNLocal(ContratoRNLocal contratoRNLocal) {
        this.contratoRNLocal = contratoRNLocal;
    }

    public ContratoLstBean getContratoLstBean() {
        return contratoLstBean;
    }

    public void setContratoLstBean(ContratoLstBean contratoLstBean) {
        this.contratoLstBean = contratoLstBean;
    }

    public PropiedadLstBean getPropiedadLstBean() {
        return propiedadLstBean;
    }

    public PropiedadRNLocal getPropiedadRNLocal() {
        return propiedadRNLocal;
    }

    public FormacionRRHH getFormacionRRHH() {
        return formacionRRHH;
    }

    public void setFormacionRRHH(FormacionRRHH formacionRRHH) {
        this.formacionRRHH = formacionRRHH;
    }

    public List<FormacionRRHH> getLstFormacionRRHH() {
        return lstFormacionRRHH;
    }

    public void setLstFormacionRRHH(List<FormacionRRHH> lstFormacionRRHH) {
        this.lstFormacionRRHH = lstFormacionRRHH;
    }

    public void setPropiedadRNLocal(PropiedadRNLocal propiedadRNLocal) {
        this.propiedadRNLocal = propiedadRNLocal;
    }

    public Congreso getCongreso() {
        return congreso;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public List<Contrato> getLstContrato() {
        return lstContrato;
    }

    public void setLstContrato(List<Contrato> lstContrato) {
        this.lstContrato = lstContrato;
    }

    public void setCongreso(Congreso congreso) {
        this.congreso = congreso;
    }

    public CapituloLibro getCapituloLibro() {
        return capituloLibro;
    }

    public void setCapituloLibro(CapituloLibro capituloLibro) {
        this.capituloLibro = capituloLibro;
    }

    public List<Congreso> getLstCongreso() {
        return lstCongreso;
    }

    public void setLstCongreso(List<Congreso> lstCongreso) {
        this.lstCongreso = lstCongreso;
    }

    public List<CapituloLibro> getLstCapituloLibro() {
        return lstCapituloLibro;
    }

    public void setLstCapituloLibro(List<CapituloLibro> lstCapituloLibro) {
        this.lstCapituloLibro = lstCapituloLibro;
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

    public ArticuloRevista getArticuloRevista() {
        return articuloRevista;
    }

    public void setArticuloRevista(ArticuloRevista articuloRevista) {
        this.articuloRevista = articuloRevista;
    }

    public InvestigadorFacadeLocal getInvestigadorFacadeLocal() {
        return investigadorFacadeLocal;
    }

    public void setInvestigadorFacadeLocal(InvestigadorFacadeLocal investigadorFacadeLocal) {
        this.investigadorFacadeLocal = investigadorFacadeLocal;
    }

    public DualListModel<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(DualListModel<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public List<Investigador> getLstInvestigadorTodos() {
        return lstInvestigadorTodos;
    }

    public void setLstInvestigadorTodos(List<Investigador> lstInvestigadorTodos) {
      
        this.lstInvestigadorTodos = lstInvestigadorTodos;
    }

    public List<Investigador> getLstInvestigadorParticipantes() {
        return lstInvestigadorParticipantes;
    }

    public void setLstInvestigadorParticipantes(List<Investigador> lstInvestigadorParticipantes) throws Exception {
      
        this.lstInvestigadorParticipantes = lstInvestigadorParticipantes;
    }

    public ProyectoFacadeLocal getProyectoFacadeLocal() {
        return proyectoFacadeLocal;
    }

    public void setProyectoFacadeLocal(ProyectoFacadeLocal proyectoFacadeLocal) {
        this.proyectoFacadeLocal = proyectoFacadeLocal;
    }

    public Boolean getbCamposEditables() {
        return bCamposEditables;
    }

    public void setbCamposEditables(Boolean bCamposEditables) {
        this.bCamposEditables = bCamposEditables;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public PickListView getPickListView() {
        return pickListView;
    }

    public void setPickListView(PickListView pickListView) {
        this.pickListView = pickListView;
    }

    public List<ArticuloRevista> getLstArticuloRevista() {
        return lstArticuloRevista;
    }

    public void setLstArticuloRevista(List<ArticuloRevista> lstArticuloRevista) {
        this.lstArticuloRevista = lstArticuloRevista;
    }

    public ArticuloRevista getArticuloRevistaIterar() {
        return articuloRevistaIterar;
    }

    public void setArticuloRevistaIterar(ArticuloRevista articuloRevistaIterar) {
        this.articuloRevistaIterar = articuloRevistaIterar;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public PublicacionRNLocal getPublicacionRNLocal() {
        return publicacionRNLocal;
    }

    public void setPublicacionRNLocal(PublicacionRNLocal publicacionRNLocal) {
        this.publicacionRNLocal = publicacionRNLocal;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getLstLibro() {
        return lstLibro;
    }

    public void setLstLibro(List<Libro> lstLibro) {
        this.lstLibro = lstLibro;
    }
/*
    public DualListModel<Investigador> getPickListInvestigadores() {
        if (investigadores == null) {
            investigadores = new DualListModel<>();
        }
        investigadores.setSource(cargarLstInvestigadorTodos());
        investigadores.setTarget(cargarLstInvestigadorParticipantes());
        return investigadores;

    }*/

    public TipoReferato[] getTipoReferato() {
        return TipoReferato.values();
    }

    public TipoContrato[] getTipoContrato() {
        return TipoContrato.values();
    }

    public TipoEdicion[] getTipoEdicion() {
        return TipoEdicion.values();
    }

    public TipoRegistroIndustrial[] getTipoRegistroIndustrial() {
        return TipoRegistroIndustrial.values();
    }

    public TipoRegistroIntelectual[] getTipoRegistroIntelectual() {
        return TipoRegistroIntelectual.values();
    }

    public String getNombreDeLaClase() {
        return nombreDeLaClase;
    }

    public void setNombreDeLaClase(String nombreDeLaClase) {
        this.nombreDeLaClase = nombreDeLaClase;
    }

    public Industrial getPropiedadIndustrial() {
        return propiedadIndustrial;
    }

    public void setPropiedadIndustrial(Industrial propiedadIndustrial) {
        this.propiedadIndustrial = propiedadIndustrial;
    }

    public int getEsIntelectual() {
        return esIntelectual;
    }

    public void setEsIntelectual(int esIntelectual) {
        this.esIntelectual = esIntelectual;
    }

    public Intelectual getPropiedadIntelectual() {
        return propiedadIntelectual;
    }

    public void setPropiedadIntelectual(Intelectual propiedadIntelectual) {
        this.propiedadIntelectual = propiedadIntelectual;
    }
    
public void buscarLibros(){
this.getLibrosLstBean().cargar_libros();
}
    public void onTabChange(TabChangeEvent event) {
        // FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab:" + event.getTab().getId());  
        System.out.println("ENTRO AL onTabChange >>>>");
        this.limpiarBoolean();
       

        Object tabSelect = event.getTab().getId();

        this.setsTabSelect((String) tabSelect);

        Object[][] sIsTab = {{"tArticulosRevistas", ArticuloRevista.class},
        {"tCapitulosDeLibros", CapituloLibro.class},
        {"tCongresos", Congreso.class},
        {"tContratos", Contrato.class},
        {"tFormacionRRHH", FormacionRRHH.class},
        {"tLibros", Libro.class},
        {"tPropiedadIndustrial", Industrial.class},
        {"tPropiedadIntelectual", Intelectual.class}};

        int iSelect = 0;
        for (int i = 0; i < 8; i++) {
            if (sIsTab[i][0].equals(tabSelect)) {
                this.setcTipoDeDato((Class) sIsTab[i][1]);
                this.habilitarBoolean(i);
                iSelect = i;
                i = 8;
            }//fin if
        }//fin for

        System.out.println("select i: " + iSelect);

        System.out.println("EN EL ONtabCHANGE class name" + cTipoDeDato.getSimpleName()); //este es el que me devuelve el nombre de la clase como string

        this.getPublicacionLstBean().setNombreClasePublicacion(cTipoDeDato.getSimpleName());

        if (iSelect < 3) {
            System.out.println("entro al menor de 3: ");
            this.getPublicacionLstBean().cargarPublicacionesByInvestigador(this.getProyecto().getId(),
                    this.getInvestigadorLoginBean().getInvestigador().getId(), this.getcTipoDeDato());
            this.getLibrosLstBean().cargar_libros();
            //RequestContext context = RequestContext.getCurrentInstance();
            //context.update(":frmUser:capitulos:somCarrera");

        }
        if (iSelect == 3) {

            this.getContratoLstBean().cargarContratoByTypoYProyecto(this.getProyecto().getId(),
                    this.getInvestigadorLoginBean().getInvestigador().getId());
        }
        if (iSelect == 4) {
            this.getFormacionRRHHLstBean().cargarFormacionByTypoYProyecto(this.getProyecto().getId(), this.getInvestigadorLoginBean().getInvestigador().getId());

        }
        if (iSelect == 5) {
            this.getPublicacionLstBean().cargarPublicacionesByInvestigador(this.getProyecto().getId(),
                    this.getInvestigadorLoginBean().getInvestigador().getId(), this.getcTipoDeDato());
        }
        if (iSelect > 5 && iSelect < 8) {
            this.getPropiedadLstBean().cargarPropiedadByTypoYProyecto(this.getProyecto().getId(),
                    this.getInvestigadorLoginBean().getInvestigador().getId(), this.getcTipoDeDato());
        }

       // RequestContext context = RequestContext.getCurrentInstance();

       // context.update("InvestigadorProduccion");
    }

    private void limpiarBoolean() {
        bArticulosRevistas = Boolean.FALSE;
        bCapitulosDeLibros = Boolean.FALSE;
        bCongresos = Boolean.FALSE;
        bContratos = Boolean.FALSE;
        bFormacionRRHH = Boolean.FALSE;
        bLibros = Boolean.FALSE;
        bPropiedadIndustrial = Boolean.FALSE;
        bPropiedadIntelectual = Boolean.FALSE;
    }//fin limpiarBoolean

    private void habilitarBoolean(int i) {
        switch (i) {
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

    private List<Investigador> cargarLstInvestigadorParticipantes() {

        try {
            this.setLstInvestigadorParticipantes(this.proyectoFacadeLocal.getTodosIntegrantes(proyecto));
            return lstInvestigadorParticipantes;
        } catch (Exception ex) {
            Logger.getLogger(InvestigadorProduccionBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private List<Investigador> cargarLstInvestigadorTodos() {

        try {
            this.setLstInvestigadorTodos(this.investigadorFacadeLocal.findAll());
            return lstInvestigadorTodos;
        } catch (Exception ex) {
            Logger.getLogger(InvestigadorProduccionBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void limpiar() {

        this.getPropiedadLstBean().setLstPropiedad(null);
        sOcultarAcordinPanel = "visible;";

        this.getPublicacionLstBean().cargarPublicacionesByInvestigador(this.getProyecto().getId(),
                this.getInvestigadorLoginBean().getInvestigador().getId(), ArticuloRevista.class);

        bArticulosRevistas = Boolean.TRUE;
        this.getPublicacionLstBean().setNombreClasePublicacion("ArticuloRevista");
        System.out.println("---------------------------------.......--------------" + bArticulosRevistas + bLibros);

    }

    public void actionBtn() {
        //System.out.println("he si estoy aca" + this.getListaUsersBean().getiActionBtnSelect());
        switch (this.getPublicacionLstBean().getiActionBtnSelect()) {

            case 0:
                create();
                //limíar campos
                //this.limpiar();
                break;
            case 1:
                this.edit();
                break;
            case 2:
                //deshabilita el campo
                this.eliminar();
                break;
            case 3:
                //habilita el campo
                // this.activate(Boolean.TRUE);
                break;

        }//fin switch
    }
    //BOTON CREAR DOCENTE

    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();

        System.out.println("boton select: " + btnSelect.getId());
        System.out.println("NOMBRE DE LA CLASE::::::::::::---> " + this.getPublicacionLstBean().getNombreClasePublicacion());
        //0 crea
        //1: edit
        //2 delete
        //activo el boton
        this.getCbAction().setDisabled(false);

        switch (btnSelect.getId()) {
            case "cbCreate":
            case "cbCreateLibro":
            case "cbCreatePropiedadIndustrial":
            case "cbCreatePropiedadIntelectual":
            case "cbCreate2":
            case "cbCreate3":
            case "cbCreate4":
            case "cbCreate5":
                this.getCbAction().setValue("Crear");
                System.out.println("botoooonnnn CbAction: " + getCbAction().getValue());
                this.pickListView.submit(proyecto);
                this.getPublicacionLstBean().setiActionBtnSelect(0);
                this.limpiarObjetos();
                break;

            case "cbDelete":
                this.getCbAction().setValue("Eliminar");
                this.getPublicacionLstBean().setiActionBtnSelect(2);
                // this.setbCamposSoloLectura(true);

                break;
            case "cbEdit":
            case "cbEditLibro":
                System.out.println("Boton edittt-----------------------: ");
                this.getCbAction().setValue("Modificar");
                this.getPublicacionLstBean().setiActionBtnSelect(1);

                break;
        }

    }//FIN setBtnSelect 
/*
     public void setBtnSelect(ActionEvent e) {
     CommandButton btnSelect = (CommandButton) e.getSource();
     System.out.println("boton select: " + btnSelect.getId());
     //0 crea
     //1: edit
     //2 delete
     //activo el boton
     this.getCbAction().setDisabled(false);
     if (btnSelect.getId().equals("cbCreate") || btnSelect.getId().equals("cbNuevoUsers")) {
     this.getListaAlumnoBean().setiActionBtnSelect(0);
     System.out.println("he si estoy aca" + this.getListaAlumnoBean().getiActionBtnSelect());
     this.getCbAction().setValue("Guardar");
     //campos requeridos
     //this.setbCamposRequeridos(true);
     } else if (btnSelect.getId().equals("cbEdit")) {
     this.getCbAction().setValue("Modificar");
            
     this.getListaAlumnoBean().setiActionBtnSelect(1);
     //campos requeridos
     //this.setbCamposRequeridos(true);
     } else if (btnSelect.getId().equals("cbDeshabilitado")) {
     this.getListaAlumnoBean().setiActionBtnSelect(2);
     this.setbCamposEditables(true);
     this.getCbAction().setValue("Desactivar");
     } else if (btnSelect.getId().equals("cbHabilitado")) {
     this.getListaAlumnoBean().setiActionBtnSelect(3);
     this.setbCamposEditables(true);
     this.getCbAction().setValue("Reactivar");
     }
     //fin else
     }
     */

    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        RequestContext context = RequestContext.getCurrentInstance();

        try {

            //a = new Alumno();
            System.out.println("Paso por acÃ¡!!!!!!!! el target del pickList es --->>" + pickListView.getInvestigadorDualListModel().getTarget());
            System.out.println("Antes de entrar a los if" + this.getPublicacionLstBean().getNombreClasePublicacion());
            if (proyecto != null) {
                List<Proyecto> proyectos = new ArrayList<Proyecto>();

                proyectos.add(proyecto);

                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                    System.out.println("Entro al IF de la clase articulo Revista");
                    articuloRevista.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                    System.out.println("Entro al IF de la clase Libro");
                    libro.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                    System.out.println("Entro al IF de la clase FormacionRRHH");
                    formacionRRHH.setProyecto(proyecto);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                    System.out.println("Entro al IF de la clase Industrial");

                    propiedadIndustrial.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                    System.out.println("Entro al IF de la clase Intelectual");

                    propiedadIntelectual.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                    System.out.println("Entro al IF de la clase Congreso");
                    congreso.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                    System.out.println("Entro al IF de la clase capituloLibro");
                    capituloLibro.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                    System.out.println("Entro al IF de la clase contrato");
                    contrato.setProyectos(proyectos);
                }

            } else {
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                    System.out.println("Entro al IF de la clase articulo Revista");
                    articuloRevista.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                    System.out.println("Entro al IF de la clase Libro");
                    libro.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                    System.out.println("Entro al IF de la clase PropiedadIndustrial");
                    propiedadIndustrial.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                    System.out.println("Entro al IF de la clase PropiedadIntelectual");
                    propiedadIntelectual.setProyectos(null);
                }

                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                    System.out.println("Entro al IF de la clase Congreso");
                    congreso.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                    System.out.println("Entro al IF de la clase CongcapituloLibroreso");
                    capituloLibro.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                    System.out.println("Entro al IF de la clase Contrato");
                    contrato.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                    System.out.println("Entro al IF de la clase FormacionRRHH");
                    formacionRRHH.setProyecto(null);
                }

            }

            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                articuloRevista.setProyectosVinculacion(null);

                articuloRevista.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.create(articuloRevista, this.getPublicacionLstBean().getNombreClasePublicacion());
                this.getPublicacionLstBean().getLstPublicacion().add(this.articuloRevista);
                context.execute("PF('dlgArticuloRevistaCreateDlg').hide();");

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                libro.setProyectosVinculacion(null);
                libro.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.create(libro, this.getPublicacionLstBean().getNombreClasePublicacion());
                this.getPublicacionLstBean().getLstPublicacion().add(this.libro);
                context.execute("PF('dlgLibro').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                congreso.setProyectosVinculacion(null);
                congreso.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.create(congreso, this.getPublicacionLstBean().getNombreClasePublicacion());
                this.getPublicacionLstBean().getLstPublicacion().add(this.congreso);
                context.execute("PF('dlgCongresoCreateDlg').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                capituloLibro.setProyectosVinculacion(null);
                capituloLibro.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
               // System.out.println("el libro seleccionado es" + capituloLibro.getLibro().getTitulo());
                publicacionRNLocal.create(capituloLibro, this.getPublicacionLstBean().getNombreClasePublicacion());
                this.getPublicacionLstBean().getLstPublicacion().add(this.capituloLibro);
                context.execute("PF('dlgCapituloCreateDlg').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                contrato.setProyectosVinculacion(null);

                contratoRNLocal.create(contrato);
                //this.getContratoLstBean().getLstContrato().add(this.contrato);
                context.execute("PF('dlgContratoCreateDlg').hide();");

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                formacionRRHH.setProyectoVinculacion(null);

                formacionRNLocal.create(formacionRRHH);
                this.getFormacionRRHHLstBean().getLstFormacionRRHH().add(this.formacionRRHH);
                context.execute("PF('dlgFormacionCreateDlg').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                System.out.println("Paso por acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:");
                propiedadIndustrial.setProyectosVinculacion(null);
                propiedadIndustrial.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                propiedadRNLocal.create(propiedadIndustrial, this.getPublicacionLstBean().getNombreClasePublicacion());
                this.getPropiedadLstBean().getLstPropiedad().add(this.propiedadIndustrial);
                context.execute("PF('dlgPropiedadIndustrial').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                System.out.println("Paso por acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:");
                propiedadIntelectual.setProyectosVinculacion(null);
                propiedadIntelectual.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                propiedadRNLocal.create(propiedadIntelectual, this.getPublicacionLstBean().getNombreClasePublicacion());
                this.getPropiedadLstBean().getLstPropiedad().add(this.propiedadIntelectual);
                context.execute("PF('dlgPropiedadIntelectual').hide();");
            }

            System.out.println("Paso por acÃ¡!!!!!!!!--->>:::::");

            sMensaje = "Articulo guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            //  this.getCbAction().setDisabled(true);

            //limpiar campos
            this.limpiarObjetos();
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear

    public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        RequestContext context = RequestContext.getCurrentInstance();
        String dialogo;
        try {
            if (proyecto != null) {
                List<Proyecto> proyectos = new ArrayList<Proyecto>();

                proyectos.add(proyecto);
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                    System.out.println("Entro al IF de la clase articulo Revista");
                    articuloRevista.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                    System.out.println("Entro al IF de la clase Libro");
                    libro.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                    System.out.println("Entro al IF de la clase contrato");
                    contrato.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                    System.out.println("Entro al IF de la clase FormacionRRHH");
                    formacionRRHH.setProyecto(proyecto);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                    System.out.println("Entro al IF de la clase Industrial");

                    propiedadIndustrial.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                    System.out.println("Entro al IF de la clase Intelectual");

                    propiedadIntelectual.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                    System.out.println("Entro al IF de la clase Congreso");
                    congreso.setProyectos(proyectos);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                    System.out.println("Entro al IF de la clase capituloLibro");
                    capituloLibro.setProyectos(proyectos);
                }

            } else {
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                    System.out.println("Entro al IF de la clase articulo Revista");
                    articuloRevista.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                    System.out.println("Entro al IF de la clase Libro");
                    libro.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                    System.out.println("Entro al IF de la clase PropiedadIndustrial");
                    propiedadIndustrial.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                    System.out.println("Entro al IF de la clase contrato");
                    contrato.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                    System.out.println("Entro al IF de la clase FormacionRRHH");
                    formacionRRHH.setProyecto(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                    System.out.println("Entro al IF de la clase PropiedadIntelectual");
                    propiedadIntelectual.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                    System.out.println("Entro al IF de la clase Congreso");
                    congreso.setProyectos(null);
                }
                if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                    System.out.println("Entro al IF de la clase capituloLibro");
                    capituloLibro.setProyectos(null);
                }

            }

            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                articuloRevista.setProyectosVinculacion(null);

                articuloRevista.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.edit(articuloRevista, this.getPublicacionLstBean().getNombreClasePublicacion());

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                libro.setProyectosVinculacion(null);
                libro.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.edit(libro, this.getPublicacionLstBean().getNombreClasePublicacion());
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                congreso.setProyectosVinculacion(null);
                congreso.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.edit(congreso, this.getPublicacionLstBean().getNombreClasePublicacion());
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                contrato.setProyectosVinculacion(null);

                contratoRNLocal.edit(contrato);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                formacionRRHH.setProyectoVinculacion(null);

                formacionRNLocal.edit(formacionRRHH);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                capituloLibro.setProyectosVinculacion(null);
                capituloLibro.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                publicacionRNLocal.edit(capituloLibro, this.getPublicacionLstBean().getNombreClasePublicacion());
            }

            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                System.out.println("Paso por acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:");
                propiedadIndustrial.setProyectosVinculacion(null);
                propiedadIndustrial.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                propiedadRNLocal.edit(propiedadIndustrial, this.getPublicacionLstBean().getNombreClasePublicacion());
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                System.out.println("Paso por acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:");
                propiedadIntelectual.setProyectosVinculacion(null);
                propiedadIntelectual.setInvestigadores(pickListView.getInvestigadorDualListModel().getTarget());
                propiedadRNLocal.edit(propiedadIntelectual, this.getPublicacionLstBean().getNombreClasePublicacion());
            }

            System.out.println("Paso por acÃ¡!!!!!!!!--->>:::::");

            System.out.println("E33333");
            sMensaje = "Información actualizada con éxito";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            //int iPos = this.getListaAlumnoBean().getLstUsers().indexOf(this.getUsers());
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.articuloRevista);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);
                this.getPublicacionLstBean().getLstPublicacion().add(iPos, this.articuloRevista);
                context.execute("PF('dlgArticuloRevistaCreateDlg').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.libro);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);
                this.getPublicacionLstBean().getLstPublicacion().add(iPos, this.libro);
                context.execute("PF('dlgLibro').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.congreso);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);
                this.getPublicacionLstBean().getLstPublicacion().add(iPos, this.congreso);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.capituloLibro);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);
                this.getPublicacionLstBean().getLstPublicacion().add(iPos, this.capituloLibro);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                int iPos = this.getPropiedadLstBean().getLstPropiedad().indexOf(this.propiedadIntelectual);
                this.getPropiedadLstBean().getLstPropiedad().remove(iPos);
                this.getPropiedadLstBean().getLstPropiedad().add(iPos, this.propiedadIntelectual);
                context.execute("PF('dlgPropiedadIntelectual').hide();");
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                int iPos = this.getPropiedadLstBean().getLstPropiedad().indexOf(this.propiedadIndustrial);
                this.getPropiedadLstBean().getLstPropiedad().remove(iPos);
                this.getPropiedadLstBean().getLstPropiedad().add(iPos, this.propiedadIndustrial);
                context.execute("PF('dlgPropiedadIndustrial').hide();");
            }

            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                int iPos = this.getContratoLstBean().getLstContrato().indexOf(this.contrato);
                this.getContratoLstBean().getLstContrato().remove(iPos);
                this.getContratoLstBean().getLstContrato().add(iPos, this.contrato);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                int iPos = this.getFormacionRRHHLstBean().getLstFormacionRRHH().indexOf(this.formacionRRHH);
                this.getFormacionRRHHLstBean().getLstFormacionRRHH().remove(iPos);
                this.getFormacionRRHHLstBean().getLstFormacionRRHH().add(iPos, this.formacionRRHH);
            }

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);

            //this.setbCamposRequeridos(false);
            this.limpiarObjetos();
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al actualizar: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin edit

    public void eliminar() {
        System.out.println("Entro al eliminar");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {

                publicacionRNLocal.remove(articuloRevista);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {

                publicacionRNLocal.remove(libro);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {

                contratoRNLocal.remove(contrato);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {

                formacionRNLocal.remove(formacionRRHH);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {

                publicacionRNLocal.remove(congreso);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {

                publicacionRNLocal.remove(capituloLibro);
            }

            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {

                propiedadRNLocal.remove(propiedadIndustrial);
            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {

                propiedadRNLocal.remove(propiedadIntelectual);
            }

            System.out.println("Paso por acÃ¡!!!!!!!!--->>:::::");

            System.out.println("E33333");
            sMensaje = "Información eliminada con éxito";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            //int iPos = this.getListaAlumnoBean().getLstUsers().indexOf(this.getUsers());
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.articuloRevista);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Libro")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.libro);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Congreso")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.congreso);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Contrato")) {
                int iPos = this.getContratoLstBean().getLstContrato().indexOf(this.contrato);
                this.getContratoLstBean().getLstContrato().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("FormacionRRHH")) {
                int iPos = this.getFormacionRRHHLstBean().getLstFormacionRRHH().indexOf(this.formacionRRHH);
                this.getFormacionRRHHLstBean().getLstFormacionRRHH().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("CapituloLibro")) {
                int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.capituloLibro);
                this.getPublicacionLstBean().getLstPublicacion().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Intelectual")) {
                int iPos = this.getPropiedadLstBean().getLstPropiedad().indexOf(this.propiedadIntelectual);
                this.getPropiedadLstBean().getLstPropiedad().remove(iPos);

            }
            if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("Industrial")) {
                int iPos = this.getPropiedadLstBean().getLstPropiedad().indexOf(this.propiedadIndustrial);
                this.getPropiedadLstBean().getLstPropiedad().remove(iPos);

            }

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);

            //this.setbCamposRequeridos(false);
            this.limpiarObjetos();

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al eliminar: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin edit

    /*
     public void activate(Boolean bEstado) {
     String sMensaje = "";
     FacesMessage fm;
     FacesMessage.Severity severity = null;
     try {
     if (this.getPublicacionLstBean().getNombreClasePublicacion().equals("ArticuloRevista")) {
     publicacionRNLocal.activate(this.getArticuloRevista(), bEstado);
            
            
     //elimino el organismo de la lista
     //int iPos = this.getListaAlumnoBean().getLstAlumno()).indexOf(this.getAlumno());
     int iPos = this.getPublicacionLstBean().getLstPublicacion().indexOf(this.getArticuloRevista());
     this.setArticuloRevista((ArticuloRevista) this.getPublicacionLstBean().getLstPublicacion().get(iPos));
     this.getArticuloRevista().setActive(bEstado);
            
     this.getPublicacionLstBean().getLstPublicacion().remove(iPos);
     this.getPublicacionLstBean().getLstPublicacion().add(iPos, this.getArticuloRevista());
     }
     if (!bEstado) {
     sMensaje = "Producción desactivada con éxito";
     } else {
     sMensaje = "Producción reactivado con éxito ";
     }
            
            
     severity = FacesMessage.SEVERITY_INFO;
     this.getCbAction().setDisabled(true);
     //limíar campos
            
     //this.setbCamposRequeridos(false);
     } catch (Exception ex) {
     severity = FacesMessage.SEVERITY_ERROR;
     sMensaje = "An error ocurred during activation: " + ex.getMessage();
     } finally {
     fm = new FacesMessage(severity, sMensaje, null);
     FacesContext fc = FacesContext.getCurrentInstance();
     fc.addMessage(null, fm);
     }
     }
     */
    public void verQuetiene() {
        System.out.println("ENTROOOOOOOOOOOOOOOOOOOOOA VER QUE TIENEEEEEEEEEEEEEEEE");
        System.out.println("el articulo esssss --->" + articuloRevista);
    }

    public void setTargetPickListPublicacion() {
        this.pickListView.getInvestigadorDualListModel().setTarget(articuloRevista.getInvestigadores());
    }

    public void limpiarObjetos() {
    
        articuloRevista = new ArticuloRevista();
        libro = new Libro();
        propiedadIndustrial = new Industrial();
        propiedadIntelectual = new Intelectual();
        congreso = new Congreso();
        //capituloLibro = new CapituloLibro();
        contrato = new Contrato();
        proyecto = new Proyecto();
        
        
    }
/*
    public void buscarLibros() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            this.getLibrosLstBean().setLstLibros(publicacionFacadeLocal.getLibros());
        } catch (Exception e) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + e.getMessage();
            //this.getMensajeBean().setMensaje("Error: " + e.getMessage());
            // RequestContext.getCurrentInstance().update("dMensaje");
            // RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }
    public void devolverAlumno() {
        RequestContext.getCurrentInstance().update("frmUser:capitulos:otAlumno4");//outPutText cobros generales
    }
    public void abrirDlgFindLibro() {
        // btnSelect = (CommandButton) e.getSource();
        //RequestContext.getCurrentInstance().update("dFindTurnoExamen");
        this.getLibrosLstBean().setLstLibros(new ArrayList<Libro>());
        this.getLibrosLstBean().setLibroSelect(new Libro());
        RequestContext.getCurrentInstance().execute("PF('dlgFindLibro').show();");
    }
    public void cargarLibrosSelect(SelectEvent event) {
     System.out.println(" entra a cargarlibrosSelect: " + this.getCapituloLibro().getLibro());
        System.out.println(" entra a cargarlibrosSelect: " + event.getObject());
       
        this.getCapituloLibro().setLibro((Libro) event.getObject());
        System.out.println(" capitulo Libro: " + this.getCapituloLibro().getLibro());
    }
    public void seleccionLista() {
        Libro lib = (Libro) dataTableLibro.getRowData();
        System.out.println(" Libro: " + lib);
    }
*/
}//FIN CLASE

 