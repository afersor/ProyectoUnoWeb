/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.categorizacion.Categorizacion;
import entidades.categorizacion.ValorCategoria;
import entidades.economico.BienConsumo;
import entidades.economico.BienNoPersonal;
import entidades.economico.BienUso;
import entidades.economico.GastoViaje;
import entidades.proyecto.Rol;
import entidades.proyecto.SubDisciplinaCientifica;
import entidades.proyecto.UnidadInvestigacion;
import entidades.proyectoWeb.Convocatoria;
import entidades.proyectoWeb.ParticipacionWeb;
import entidades.proyectoWeb.ProyectoWeb;
import entidades.proyectoWeb.ProyectoWebAspEti;
import entidades.proyectoWeb.ProyectoWebFGP;
import entidades.proyectoWeb.ProyectoWebSegSaludBioseg;
import entidades.proyectoWeb.RN.ProyectoWebRNLocal;
import entidades.proyectoWeb.SectorPrioritario;
import entidades.proyectoWeb.TipoFinanciamiento;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class NavegarBean {
    
    @ManagedProperty(value = "#{convocatoriaPagBean}")
    private ConvocatoriaPagBean convocatoriaPagBean;
    @ManagedProperty(value = "#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    @ManagedProperty(value = "#{lineaInvestigacionLstBean}")
    private LineaInvestigacionLstBean lineaInvestigacionLstBean;
    @ManagedProperty(value = "#{unidadEjecutoraLstBean}")
    private UnidadEjecutoraLstBean unidadEjecutoraLstBean;
    @ManagedProperty(value = "#{unidadAcademicaLstBean}")
    private UnidadAcademicaLstBean unidadAcademicaLstBean;
    @ManagedProperty(value = "#{areaTematicaLstBean}")
    private AreaTematicaLstBean areaTematicaLstBean;
    @ManagedProperty(value = "#{objetivoSocioEconomicoLstBean}")
    private ObjetivoSocioEconomicoLstBean objetivoSocioEconomicoLstBean;
    @ManagedProperty(value = "#{tipoProyectoLstBean}")
    private TipoProyectoLstBean tipoProyectoLstBean;
    @ManagedProperty(value = "#{rolLstBean}")
    private RolLstBean rolLstBean;
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    @ManagedProperty(value = "#{proyectoWebLstBean}")
    private ProyectoWebLstBean proyectoWebLstBean;
    @ManagedProperty(value = "#{proyectoIIPagBean}")
    private ProyectoIIPagBean proyectoIIPagBean;
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty(value = "#{tipoFinanciamientoLstBean}")
    private TipoFinanciamientoLstBean tipoFinanciamientoLstBean;
    
    @ManagedProperty(value = "#{tipoRespuestaLstBean}")
    private TipoRespuestaLstBean tipoRespuestaLstBean;
    
    @ManagedProperty(value = "#{sectorPrioritarioLstBean}")
    private SectorPrioritarioLstBean sectorPrioritarioLstBean;
    
    @ManagedProperty(value = "#{posicionMapaBean}")
    private PosicionMapaBean posicionMapaBean;
    
    @ManagedProperty("#{ubicacionLstBean}")
    private UbicacionLstBean ubicacionLstBean;
    
    @EJB
    private ProyectoWebRNLocal proyectoWebRNLocal;
    
    public NavegarBean() {
    }

    public UbicacionLstBean getUbicacionLstBean() {
        return ubicacionLstBean;
    }

    public void setUbicacionLstBean(UbicacionLstBean ubicacionLstBean) {
        this.ubicacionLstBean = ubicacionLstBean;
    }
    
    public TipoRespuestaLstBean getTipoRespuestaLstBean() {
        return tipoRespuestaLstBean;
    }

    public void setTipoRespuestaLstBean(TipoRespuestaLstBean tipoRespuestaLstBean) {
        this.tipoRespuestaLstBean = tipoRespuestaLstBean;
    }
    

    public PosicionMapaBean getPosicionMapaBean() {
        return posicionMapaBean;
    }

    public void setPosicionMapaBean(PosicionMapaBean posicionMapaBean) {
        this.posicionMapaBean = posicionMapaBean;
    }
    
    public SectorPrioritarioLstBean getSectorPrioritarioLstBean() {
        return sectorPrioritarioLstBean;
    }

    public void setSectorPrioritarioLstBean(SectorPrioritarioLstBean sectorPrioritarioLstBean) {
        this.sectorPrioritarioLstBean = sectorPrioritarioLstBean;
    }
    

    public TipoFinanciamientoLstBean getTipoFinanciamientoLstBean() {
        return tipoFinanciamientoLstBean;
    }

    public void setTipoFinanciamientoLstBean(TipoFinanciamientoLstBean tipoFinanciamientoLstBean) {
        this.tipoFinanciamientoLstBean = tipoFinanciamientoLstBean;
    }
    
    public ProyectoIIPagBean getProyectoIIPagBean() {
        return proyectoIIPagBean;
    }
    
    public void setProyectoIIPagBean(ProyectoIIPagBean proyectoIIPagBean) {
        this.proyectoIIPagBean = proyectoIIPagBean;
    }
    
    public ProyectoWebLstBean getProyectoWebLstBean() {
        return proyectoWebLstBean;
    }
    
    public void setProyectoWebLstBean(ProyectoWebLstBean proyectoWebLstBean) {
        this.proyectoWebLstBean = proyectoWebLstBean;
    }
    
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }
    
    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }
    
    public RolLstBean getRolLstBean() {
        return rolLstBean;
    }
    
    public void setRolLstBean(RolLstBean rolLstBean) {
        this.rolLstBean = rolLstBean;
    }
    
    public TipoProyectoLstBean getTipoProyectoLstBean() {
        return tipoProyectoLstBean;
    }
    
    public void setTipoProyectoLstBean(TipoProyectoLstBean tipoProyectoLstBean) {
        this.tipoProyectoLstBean = tipoProyectoLstBean;
    }
    
    public ObjetivoSocioEconomicoLstBean getObjetivoSocioEconomicoLstBean() {
        return objetivoSocioEconomicoLstBean;
    }
    
    public void setObjetivoSocioEconomicoLstBean(ObjetivoSocioEconomicoLstBean objetivoSocioEconomicoLstBean) {
        this.objetivoSocioEconomicoLstBean = objetivoSocioEconomicoLstBean;
    }
    
    public AreaTematicaLstBean getAreaTematicaLstBean() {
        return areaTematicaLstBean;
    }
    
    public void setAreaTematicaLstBean(AreaTematicaLstBean areaTematicaLstBean) {
        this.areaTematicaLstBean = areaTematicaLstBean;
    }
    
    public UnidadEjecutoraLstBean getUnidadEjecutoraLstBean() {
        return unidadEjecutoraLstBean;
    }
    
    public void setUnidadEjecutoraLstBean(UnidadEjecutoraLstBean unidadEjecutoraLstBean) {
        this.unidadEjecutoraLstBean = unidadEjecutoraLstBean;
    }
    
    public UnidadAcademicaLstBean getUnidadAcademicaLstBean() {
        return unidadAcademicaLstBean;
    }
    
    public void setUnidadAcademicaLstBean(UnidadAcademicaLstBean unidadAcademicaLstBean) {
        this.unidadAcademicaLstBean = unidadAcademicaLstBean;
    }
    
    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }
    
    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    public LineaInvestigacionLstBean getLineaInvestigacionLstBean() {
        return lineaInvestigacionLstBean;
    }
    
    public void setLineaInvestigacionLstBean(LineaInvestigacionLstBean lineaInvestigacionLstBean) {
        this.lineaInvestigacionLstBean = lineaInvestigacionLstBean;
    }
    
    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }
    
    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    public ConvocatoriaPagBean getConvocatoriaPagBean() {
        return convocatoriaPagBean;
    }
    
    public void setConvocatoriaPagBean(ConvocatoriaPagBean convocatoriaPagBean) {
        this.convocatoriaPagBean = convocatoriaPagBean;
    }
    
    public String entrarPagConvocatorias() {
        
        this.getConvocatoriaPagBean().findConvocatoriasAbiertas();
        this.getProyectoWebLstBean().cargarProyectoWebByFechas(new Date());
        
        return "usuario/convocatorias.xhtml?faces-redirect=true";
        //return "proyectoI.xhtml";
        //?faces-redirect=true
    }//fin entrarPagConvocatorias

    public String entrarPagConvocatoriasOnce() {
        
        this.getConvocatoriaPagBean().findConvocatoriasAbiertas();
        this.getProyectoWebLstBean().setLstProyectoWeb(new ArrayList<ProyectoWeb>());
        this.getProyectoWebLstBean().cargarProyectoWebByFechas(new Date());
        
        return "convocatorias.xhtml?faces-redirect=true";
        //return "proyectoI.xhtml";
        //?faces-redirect=true
    }//fin entrarPagConvocatorias

    public String entrarPagProyectoI(Convocatoria convocatoria) {
        try {
            /**
             * Valido las categorias permitidas
             */
            List<ValorCategoria> categoriasConvocatoria = new ArrayList<>();
            List<Categorizacion> categorizacionesInvestigador = new ArrayList<>();
            //cargo las categorias en lista para que no de indectlist
            Iterator<ValorCategoria> iteratorCategorias = convocatoria.getCategorias().iterator();
            while (iteratorCategorias.hasNext()) {
                categoriasConvocatoria.add(iteratorCategorias.next());
            }
            Iterator<Categorizacion> iteratorCategorizacion = this.getInvestigadorLoginBean().getInvestigador().getCategorizaciones().iterator();
            while (iteratorCategorizacion.hasNext()) {
                categorizacionesInvestigador.add(iteratorCategorizacion.next());
            }
            
            System.out.println("Validando Categoria: " + categoriasConvocatoria + " -"
                    + categorizacionesInvestigador);
            
            if (!categoriasConvocatoria.isEmpty()) {
                if (!categorizacionesInvestigador.isEmpty()) {
                    Collections.sort(categorizacionesInvestigador);
                    Categorizacion ultimaCategoria = categorizacionesInvestigador.get(categorizacionesInvestigador.size() - 1);
                    if (!categoriasConvocatoria.contains(ultimaCategoria.getCategoriaAsignada().getValorCategoria())) {
                        throw new Exception("No puede ingresar a la convocatoria,"
                                + "solo estan permitidos investigadores con las siguientes categorías: "
                                + categoriasConvocatoria);
                    }
                } else {
                    throw new Exception("No puede ingresar a la convocatoria, No posee categoria y "
                            + "solo estan permitidos investigadores con las siguientes categorías: "
                            + categoriasConvocatoria);
                }
            }

            /**
             * fin de validacion de categoria permitida
             */
            if (this.proyectoWebRNLocal.findProyectoWebByDirectorYConvocatoria(
                    this.getInvestigadorLoginBean().getInvestigador().getId(), convocatoria.getId())
                    .size() > 1) {
                throw new Exception("No puede cargar mas proyectos. Solo se permiten dos por convocatoria");
            }//fin if

            /* valida que no este en otra convocatoria */
            /*List<ProyectoWeb> findProyectoWebByDirector =
                    this.proyectoWebRNLocal.findProyectoWebByDirector(
                    this.getInvestigadorLoginBean().getInvestigador().getId());
            if (findProyectoWebByDirector.size() > 1) {
                for (ProyectoWeb proyectoWeb : findProyectoWebByDirector) {
                    if (proyectoWeb.getConvocatoria().getId() != convocatoria.getId()) {
                        throw new Exception("No se puede inscribir en más de una convocatoria");
                    }
                }
            }//fin if
            /* valida dos proyectos por convocatoria */
            if (this.proyectoWebRNLocal.findProyectoWebByDirectorYConvocatoria(
                    this.getInvestigadorLoginBean().getInvestigador().getId(), convocatoria.getId())
                    .size() > 1) {
                throw new Exception("No puede cargar mas proyectos. Solo se permiten dos por convocatoria");
            }//fin if
            
            
            this.getProyectoWebBean().setProyectoWeb(new ProyectoWeb());
            this.getProyectoWebBean().getProyectoWeb().setFinalizado(Boolean.FALSE);
            this.getProyectoWebBean().getProyectoWeb().setConvocatoria(convocatoria);

            //asigno el director
            this.getProyectoWebBean().getProyectoWeb().setParticipacionesWeb(
                    new ArrayList<ParticipacionWeb>());
            
            ParticipacionWeb pw = new ParticipacionWeb();
            pw.setInvestigador(this.getInvestigadorLoginBean().getInvestigador());
            Rol rol = new Rol();
            rol.setId(1L);
            rol.setDescripcion("Director");
            pw.setRol(rol);
            pw.setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());
            
            this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().add(0, pw);
            
             //PARA EL CODIRECTOR
            ParticipacionWeb pwcd = new ParticipacionWeb();

            pwcd.setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());
            this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().add(1, pwcd);

//            ParticipacionWeb pw1 = new ParticipacionWeb();
//            this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().add(1,pw1);
            
            //cargar TipoFinanciamiento
            this.getTipoFinanciamientoLstBean().cargarSITipoFinanciamiento();
            this.getProyectoWebBean().getProyectoWeb().setTipoFinanciamiento(TipoFinanciamiento.SECyTUNCA);
            
            //participa en programa
            this.getProyectoWebBean().getProyectoWeb().setParticipaEnPrograma(Boolean.TRUE);
            
            
            //sector prioritario
            this.getSectorPrioritarioLstBean().cargarSISectorPrioritario();
            this.getProyectoWebBean().getProyectoWeb().setSectorPrioritario(SectorPrioritario.Tic);
            
            //latitud y longitud (Plaza 25)
            //longitud latitud
            
            
            this.getProyectoWebBean().getProyectoWeb().setLatitud(-28.46890823359409);
            this.getProyectoWebBean().getProyectoWeb().setLongitud(-65.77899905009463);
            
            this.getPosicionMapaBean().entrar();

            //cargar las unidades academicas
            this.getUnidadAcademicaLstBean().findUnidadesAcademicas();
            this.getUnidadAcademicaLstBean().cargarSIUnidadesAcademicas();

            //cargar las unidades ejecutoras
            this.getUnidadEjecutoraLstBean().findUnidadesEjecutoras();
            this.getUnidadEjecutoraLstBean().cargarSIUnidadesEjecutoras();

            //localizacion        
            this.getProyectoWebBean().getProyectoWeb().setLocalizaciones(new ArrayList<UnidadInvestigacion>());

            //lArea Temática - Disciplina Científica - Subdisciplinas Científicas       
            this.getProyectoWebBean().getProyectoWeb().setSubDisciplinasCientificas(new ArrayList<SubDisciplinaCientifica>());

            //cargar las lineas de investigacion
            this.getLineaInvestigacionLstBean().findLineasDeInvestigacion();
            this.getLineaInvestigacionLstBean().cargarSILineaInvestigacion();

            //cargar area tematica
            this.getAreaTematicaLstBean().findAreasTematicas();
            this.getAreaTematicaLstBean().cargarSIAreasTematicas();

            //cargar objetivosSocioEconomico
            this.getObjetivoSocioEconomicoLstBean().findObjetivosSocioEconomicos();
            this.getObjetivoSocioEconomicoLstBean().cargarSIObjetivosSocioEconomicos();

            //cargar tipo de actividades
            this.getTipoProyectoLstBean().findTiposProyectos();
            this.getTipoProyectoLstBean().cargarSITiposProyectos();

            //cargar roles
            this.getRolLstBean().findRolesSinDirector();
            this.getRolLstBean().cargarSIRolesSinDirector();

            
            //cargarTipoRespuesta
            this.getTipoRespuestaLstBean().cargarSITipoRespuesta();

            /*ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
             ec.getRequest().
             System.out.println("path: " + ec.getRequestContextPath());
            
             //ec.dispatch("proyectos.xhtml");
            
             FacesContext fc = FacesContext.getCurrentInstance();
             NavigationHandler nh = fc.getApplication().getNavigationHandler();
             nh.handleNavigation(fc, null, "/proyectos.xhtml");*/
            
            
            return "proyectoI.xhtml?faces-redirect=true";
            
        } catch (Exception ex) {
            /*FacesMessage  fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
             FacesContext fc = FacesContext.getCurrentInstance();
             fc.addMessage(null, fm); */
            
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        
        return null;
        
    }//fin entrarPagProyecto

    public String cargarProyectoSeleccionado(ProyectoWeb pw) {
        try {

            if(pw.getSubDisciplinasCientificas() == null){
                System.out.println("Caracteristicas 0: " + null);
            }else{
                
                System.out.println("Caracteristicas: " + pw.getSubDisciplinasCientificas().size());
            }
            
            //cargarUbicaciones
            this.getUbicacionLstBean().setLstUbicacion(pw.getLstUbicaciones());

            //cargar TipoFinanciamiento
            this.getTipoFinanciamientoLstBean().cargarSITipoFinanciamiento();
            
            //sector prioritario
            this.getSectorPrioritarioLstBean().cargarSISectorPrioritario();

            
            //lArea Temática - Disciplina Científica - Subdisciplinas Científicas       
            this.getProyectoWebBean().getProyectoWeb().setSubDisciplinasCientificas(new ArrayList<SubDisciplinaCientifica>());
            
                        
            //cargar las unidades academicas
            this.getUnidadAcademicaLstBean().findUnidadesAcademicas();
            this.getUnidadAcademicaLstBean().cargarSIUnidadesAcademicas();

            //cargar las unidades ejecutoras
            this.getUnidadEjecutoraLstBean().findUnidadesEjecutoras();
            this.getUnidadEjecutoraLstBean().cargarSIUnidadesEjecutoras();

            //cargar las lineas de investigacion
            this.getLineaInvestigacionLstBean().findLineasDeInvestigacion();
            this.getLineaInvestigacionLstBean().cargarSILineaInvestigacion();

            //cargar area tematica
            this.getAreaTematicaLstBean().findAreasTematicas();
            this.getAreaTematicaLstBean().cargarSIAreasTematicas();

            //cargar objetivosSocioEconomico
            this.getObjetivoSocioEconomicoLstBean().findObjetivosSocioEconomicos();
            this.getObjetivoSocioEconomicoLstBean().cargarSIObjetivosSocioEconomicos();

            //cargar tipo de actividades
            this.getTipoProyectoLstBean().findTiposProyectos();
            this.getTipoProyectoLstBean().cargarSITiposProyectos();

            //cargar roles
            this.getRolLstBean().findRolesSinDirector();
            this.getRolLstBean().cargarSIRolesSinDirector();
            
            //cargarTipoRespuesta
            this.getTipoRespuestaLstBean().cargarSITipoRespuesta();
            
            if (pw.getPalabrasClaves() != null) {
                try {
                    this.getProyectoIIPagBean().setPalabraClaveUno(pw.getPalabrasClaves().get(0));
                    this.getProyectoIIPagBean().setPalabraClaveDos(pw.getPalabrasClaves().get(1));
                    this.getProyectoIIPagBean().setPalabraClaveTres(pw.getPalabrasClaves().get(2));
                    this.getProyectoIIPagBean().setPalabraClaveCuatro(pw.getPalabrasClaves().get(3));
                    this.getProyectoIIPagBean().setPalabraClaveCinco(pw.getPalabrasClaves().get(4));
                } catch (Exception e) {
                }
            }//fin if

            if (pw.getKeywords() != null) {
                try {
                    this.getProyectoIIPagBean().setKeywordUno(pw.getKeywords().get(0));
                    this.getProyectoIIPagBean().setKeywordDos(pw.getKeywords().get(1));
                    this.getProyectoIIPagBean().setKeywordTres(pw.getKeywords().get(2));
                    this.getProyectoIIPagBean().setKeywordCuatro(pw.getKeywords().get(3));
                    this.getProyectoIIPagBean().setKeywordCinco(pw.getKeywords().get(4));
                } catch (Exception e) {
                }
            }//fin if

            try {
                Collections.sort(pw.getPresupuestoWeb().getBienConsumo());
            } catch (Exception e) {
            }
            try {
                Collections.sort(pw.getPresupuestoWeb().getBienNoPersonal());
            } catch (Exception e) {
            }
            try {
                Collections.sort(pw.getPresupuestoWeb().getBienUso());
            } catch (Exception e) {
            }
            try {
                Collections.sort(pw.getPresupuestoWeb().getGastosViaje());
            } catch (Exception e) {
            }
            
            System.out.println("proyecto: " + pw.getProyectoWebFGP());
            if(pw.getProyectoWebFGP()==null){
                pw.setProyectoWebFGP(new ProyectoWebFGP());
            }
            
            //ordenar la lista de participacionweb
            
          
            //order participaciones web por rol
            pw.getParticipacionesWeb().get(0);
            


            Collections.sort(pw.getParticipacionesWeb());
    
            
            this.getProyectoWebBean().setProyectoWeb(pw);       
            
            //longitud latitud
            this.getPosicionMapaBean().entrar();
            
            return "menuProyecto.xhtml";
            
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        return null;
    }//fin cargarProyectoSeleccionado

    //PARA LOS BOTONES ANTERIOR Y SIGUENTE
    public String entrarPagProyecto(int pag) {
        String pagina = "";
        
        System.out.println("Pag Proyecto: " + this.getProyectoWebBean().getProyectoWeb().getLatitud() + ", " + this.getProyectoWebBean().getProyectoWeb().getLongitud());
        
        switch (pag) {
            
            case 0:
                pagina = "menuProyecto.xhtml?faces-redirect=true";
                break;
            case 1:
                pagina = "proyectoI.xhtml?faces-redirect=true";
                break;
            
            case 2:
                pagina = "proyectoII.xhtml?faces-redirect=true";
                break;
            
            case 3:
                pagina = "proyectoIII.xhtml?faces-redirect=true";
                if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP() == null){
                this.getProyectoWebBean().getProyectoWeb().setProyectoWebFGP(new ProyectoWebFGP());
                }
                break;
            
            case 4:
                pagina = "proyectoIV.xhtml?faces-redirect=true";
                break;
            
            case 5:
                pagina = "proyectoV.xhtml?faces-redirect=true";
                if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP() == null){
                this.getProyectoWebBean().getProyectoWeb().setProyectoWebFGP(new ProyectoWebFGP());
                }
                break;
            
            case 6:
                pagina = "proyectoVI.xhtml?faces-redirect=true";
                break;
            
            case 7:
                pagina = "proyectoVII.xhtml?faces-redirect=true";
                break;
                
            case 8:
                pagina = "proyectoVIII.xhtml?faces-redirect=true";
                break;
            
            case 9:
                pagina = "proyectoIX.xhtml?faces-redirect=true";
                if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti()== null){
                    this.getProyectoWebBean().getProyectoWeb().setProyectoWebAspEti(new ProyectoWebAspEti());
                }
                break;
                
            case 10:
                pagina = "proyectoX.xhtml?faces-redirect=true";
                if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg()== null){
                    this.getProyectoWebBean().getProyectoWeb().setProyectoWebSegSaludBioseg(
                            new ProyectoWebSegSaludBioseg());
                }
                break;
            
            case 11:
                pagina = "proyectoXI.xhtml?faces-redirect=true";
                break;
        }//fin switch

        return pagina;
    }//fin entrarPagProyecto   

    public void ver() {
        System.out.println("this.getProyectoWebBean(): "
                + this.getProyectoWebBean().getProyectoWeb().getUnidadAcademica());
    }//fin ver
}
