/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.economico.BienConsumo;
import entidades.economico.BienNoPersonal;
import entidades.economico.BienUso;
import entidades.economico.GastoViaje;
import entidades.proyecto.UnidadInvestigacion;
import entidades.proyectoWeb.BienConsumoWeb;
import entidades.proyectoWeb.ParticipacionWeb;
import entidades.proyectoWeb.PresupuestoWeb;
import entidades.proyectoWeb.ProyectoWeb;
import entidades.proyectoWeb.ProyectoWebFGP;
import entidades.proyectoWeb.RN.ProyectoWebRNLocal;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import org.primefaces.context.RequestContext;
import recursos.GenerarReportesBean;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class ProyectoWebBean implements Serializable {

    private ProyectoWeb proyectoWeb;
    private List<String> lstAniosPresupuesto;
    @ManagedProperty("#{proyectoIIPagBean}")
    private ProyectoIIPagBean proyectoIIPagBean;
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    @ManagedProperty("#{generarReportesBean}")
    private GenerarReportesBean generarReportesBean;
    @ManagedProperty("#{proyectoWebLstBean}")
    private ProyectoWebLstBean proyectoWebLstBean;
    
    @ManagedProperty("#{ubicacionLstBean}")
    private UbicacionLstBean ubicacionLstBean;
    @EJB
    private ProyectoWebRNLocal proyectoWebRnLocal;

    public ProyectoWebBean() {
        proyectoWeb = new ProyectoWeb();
        proyectoWeb.setProyectoWebFGP(new ProyectoWebFGP());

    }

    public UbicacionLstBean getUbicacionLstBean() {
        return ubicacionLstBean;
    }

    public void setUbicacionLstBean(UbicacionLstBean ubicacionLstBean) {
        this.ubicacionLstBean = ubicacionLstBean;
    }
    
    public ProyectoWebLstBean getProyectoWebLstBean() {
        return proyectoWebLstBean;
    }

    public void setProyectoWebLstBean(ProyectoWebLstBean proyectoWebLstBean) {
        this.proyectoWebLstBean = proyectoWebLstBean;
    }

    public ProyectoIIPagBean getProyectoIIPagBean() {
        return proyectoIIPagBean;
    }

    public void setProyectoIIPagBean(ProyectoIIPagBean proyectoIIPagBean) {
        this.proyectoIIPagBean = proyectoIIPagBean;
    }

    @PostConstruct
    private void init() {
        this.setLstAniosPresupuesto(new ArrayList<String>());
        String[] arrayAnio = {"Año 1", "Año 2", "Año 3", "Año 4"};
        if (this.getProyectoWeb().getPresupuestoWeb() != null) {
            int cant = this.getProyectoWeb().getPresupuestoWeb().getBienConsumo().size();
            this.setLstAniosPresupuesto(new ArrayList<String>());
            for (int i = 0; i < cant; i++) {
                this.getLstAniosPresupuesto().add(arrayAnio[i]);
            }//fin for
        }
        
        System.out.println("proyectoWEBFGP: " + this.getProyectoWeb().getProyectoWebFGP());
    }//fin init

    public List getLstAniosPresupuesto() {

        return lstAniosPresupuesto;
    }

    public void setLstAniosPresupuesto(List lstAniosPresupuesto) {
        this.lstAniosPresupuesto = lstAniosPresupuesto;
    }

    public GenerarReportesBean getGenerarReportesBean() {
        return generarReportesBean;
    }

    public void setGenerarReportesBean(GenerarReportesBean generarReportesBean) {
        this.generarReportesBean = generarReportesBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public ProyectoWeb getProyectoWeb() {
        return proyectoWeb;
    }

    public void setProyectoWeb(ProyectoWeb proyectoWeb) {
        this.proyectoWeb = proyectoWeb;
    }

    public int activarBotonAnio() {
        if (proyectoWeb.getFechaInicio() != null && proyectoWeb.getFechaFinalizacion() != null) {

            Calendar calIni = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calIni.setTime(proyectoWeb.getFechaInicio());
            calFin.setTime(proyectoWeb.getFechaFinalizacion());
            calFin.add(Calendar.DATE, 1);
            Long dif = calFin.getTimeInMillis() - calIni.getTimeInMillis();
            //long difDia = dif / (24 * 60 * 60 * 1000);  
            long difDia = (calFin.get(Calendar.DATE) - calIni.get(Calendar.DATE))
                    + (calFin.get(Calendar.MONTH) - calIni.get(Calendar.MONTH))
                    + (calFin.get(Calendar.YEAR) - calIni.get(Calendar.YEAR));

            if (difDia == 2) {
                return 2;
            }//fin if

            if (difDia == 4) {
                return 4;
            }//fin if
        }//fin if

        return 0;
    }//fin 

    public int activarBotonPresupuesto() {
        String[] arrayAnio = {"Año 1", "Año 2", "Año 3", "Año 4"};
        //la fecha inicial y finalal deben tener una diferencia de 2 o 4 años

        if (proyectoWeb.getFechaInicio() != null && proyectoWeb.getFechaFinalizacion() != null) {

            Calendar calIni = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calIni.setTime(proyectoWeb.getFechaInicio());
            calFin.setTime(proyectoWeb.getFechaFinalizacion());
            calFin.add(Calendar.DATE, 1);
            Long dif = calFin.getTimeInMillis() - calIni.getTimeInMillis();
            //long difDia = dif / (24 * 60 * 60 * 1000);  
            long difDia = (calFin.get(Calendar.DATE) - calIni.get(Calendar.DATE))
                    + (calFin.get(Calendar.MONTH) - calIni.get(Calendar.MONTH))
                    + (calFin.get(Calendar.YEAR) - calIni.get(Calendar.YEAR));

            if (difDia == 2) {

                if (this.getProyectoWeb().getPresupuestoWeb() != null) {
                    int cant = 0;
                    if (this.getProyectoWeb().getPresupuestoWeb().getBienConsumo() != null) {
                        cant = this.getProyectoWeb().getPresupuestoWeb().getBienConsumo().size();
                    } else {
                        if (this.getProyectoWeb().getPresupuestoWeb().getBienNoPersonal() != null) {
                            cant = this.getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size();
                        } else {
                            if (this.getProyectoWeb().getPresupuestoWeb().getBienUso() == null) {
                                cant = this.getProyectoWeb().getPresupuestoWeb().getBienUso().size();
                            } else {
                                cant = this.getProyectoWeb().getPresupuestoWeb().getGastosViaje().size();
                            }//fin if-else
                        }//fin if-else

                    }//fin if-else

                    this.setLstAniosPresupuesto(new ArrayList<String>());
                    for (int i = 0; i < cant; i++) {
                        this.getLstAniosPresupuesto().add(arrayAnio[i]);
                    }//fin for
                }
                return 2;
            }//fin if

            if (difDia == 4) {
                if (this.getProyectoWeb().getPresupuestoWeb() != null) {
                    int cant = 0;
                    if (this.getProyectoWeb().getPresupuestoWeb().getBienConsumo() != null) {
                        cant = this.getProyectoWeb().getPresupuestoWeb().getBienConsumo().size();
                    } else {
                        if (this.getProyectoWeb().getPresupuestoWeb().getBienNoPersonal() != null) {
                            cant = this.getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size();
                        } else {
                            if (this.getProyectoWeb().getPresupuestoWeb().getBienUso() == null) {
                                cant = this.getProyectoWeb().getPresupuestoWeb().getBienUso().size();
                            } else {
                                cant = this.getProyectoWeb().getPresupuestoWeb().getGastosViaje().size();
                            }//fin if-else
                        }//fin if-else

                    }//fin if-else

                    this.setLstAniosPresupuesto(new ArrayList<String>());
                    for (int i = 0; i < cant; i++) {
                        this.getLstAniosPresupuesto().add(arrayAnio[i]);
                    }//fin for
                }

                return 4;
            }//fin if
        }//fin if

        return 0;

    }//fin activarBotonPresupuesto

    public void guardar(int pantalla) {

        Boolean banderaFinalizado = Boolean.FALSE;
        try {


            
            
            if (proyectoWeb.getFinalizado()) {
                if (proyectoWeb.getObservaciones() == null || proyectoWeb.getObservaciones().isEmpty()) {
                    throw new Exception("El proyecto esta finalizado no puede realizar cambios");
                }
            }//fin if

//            if (proyectoWeb.getAprobado()) {
//                throw new Exception("El proyecto esta aprobado no puede realizar cambios");
//
//            }//fin if


            this.getProyectoWeb().setPalabrasClaves(new ArrayList<String>());

            if (this.getProyectoIIPagBean().getPalabraClaveUno() != null) {
                if (!this.getProyectoIIPagBean().getPalabraClaveUno().isEmpty()) {
                    this.getProyectoWeb().getPalabrasClaves().add(this.getProyectoIIPagBean().getPalabraClaveUno());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getPalabraClaveDos() != null) {
                if (!this.getProyectoIIPagBean().getPalabraClaveDos().isEmpty()) {
                    this.getProyectoWeb().getPalabrasClaves().add(this.getProyectoIIPagBean().getPalabraClaveDos());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getPalabraClaveTres() != null) {
                if (!this.getProyectoIIPagBean().getPalabraClaveTres().isEmpty()) {
                    this.getProyectoWeb().getPalabrasClaves().add(this.getProyectoIIPagBean().getPalabraClaveTres());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getPalabraClaveCuatro() != null) {
                if (!this.getProyectoIIPagBean().getPalabraClaveCuatro().isEmpty()) {
                    this.getProyectoWeb().getPalabrasClaves().add(this.getProyectoIIPagBean().getPalabraClaveCuatro());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getPalabraClaveCinco() != null) {
                if (!this.getProyectoIIPagBean().getPalabraClaveCinco().isEmpty()) {
                    this.getProyectoWeb().getPalabrasClaves().add(this.getProyectoIIPagBean().getPalabraClaveCinco());
                }//fin if
            }

            this.getProyectoWeb().setKeywords(new ArrayList<String>());

            if (this.getProyectoIIPagBean().getKeywordUno() != null) {
                if (!this.getProyectoIIPagBean().getKeywordUno().isEmpty()) {
                    this.getProyectoWeb().getKeywords().add(this.getProyectoIIPagBean().getKeywordUno());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getKeywordDos() != null) {
                if (!this.getProyectoIIPagBean().getKeywordDos().isEmpty()) {
                    this.getProyectoWeb().getKeywords().add(this.getProyectoIIPagBean().getKeywordDos());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getKeywordTres() != null) {
                if (!this.getProyectoIIPagBean().getKeywordTres().isEmpty()) {
                    this.getProyectoWeb().getKeywords().add(this.getProyectoIIPagBean().getKeywordTres());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getKeywordCuatro() != null) {
                if (!this.getProyectoIIPagBean().getKeywordCuatro().isEmpty()) {
                    this.getProyectoWeb().getKeywords().add(this.getProyectoIIPagBean().getKeywordCuatro());
                }//fin if
            }

            if (this.getProyectoIIPagBean().getKeywordCinco() != null) {
                if (!this.getProyectoIIPagBean().getKeywordCinco().isEmpty()) {
                    this.getProyectoWeb().getKeywords().add(this.getProyectoIIPagBean().getKeywordCinco());
                }//fin if
            }

            if (proyectoWeb.getFechaInicio() != null
                    && proyectoWeb.getFechaFinalizacion() != null
                    && !proyectoWeb.getParticipacionesWeb().isEmpty()) {

                for (ParticipacionWeb p : proyectoWeb.getParticipacionesWeb()) {
                    p.setFechaDesde(proyectoWeb.getFechaInicio());
                    p.setFechaHasta(proyectoWeb.getFechaFinalizacion());
                }//fin for
            }//fin if

            if (pantalla == 11) {
                this.getProyectoWeb().setFinalizado(Boolean.TRUE);
            }
            
            banderaFinalizado = Boolean.TRUE;

            this.getProyectoWeb().setAprobado(Boolean.FALSE);

            //algo

            if (this.activarBotonAnio() == 2 && proyectoWeb.getPresupuestoWeb() != null) {


                proyectoWeb.setPresupuestoWebAnioTres(null);
                proyectoWeb.setPresupuestoWebAnioCuatro(null);


                //BIEN CONSUMO
                List<BienConsumo> lstAuxBienConsumo = proyectoWeb.getPresupuestoWeb().getBienConsumo();
                proyectoWeb.getPresupuestoWeb().setBienConsumo(new ArrayList<BienConsumo>());

                PresupuestoWeb pw = new PresupuestoWeb();

                if (lstAuxBienConsumo != null) {
                    for (BienConsumo bc : lstAuxBienConsumo) {


                        if (bc.getAnio().trim().equals("1")
                                || bc.getAnio().trim().equals("2")) {

                            proyectoWeb.getPresupuestoWeb().getBienConsumo().add(bc);
                            //lstAuxBienConsumo.remove(bc);
                        }//fin if
                    }//fin for
                }

                //BIN USO
                List<BienUso> lstAuxBienUso = proyectoWeb.getPresupuestoWeb().getBienUso();
                proyectoWeb.getPresupuestoWeb().setBienUso(new ArrayList<BienUso>());

                if (lstAuxBienUso != null) {
                    for (BienUso bu : lstAuxBienUso) {


                        if (bu.getAnio().trim().equals("1")
                                || bu.getAnio().trim().equals("2")) {

                            proyectoWeb.getPresupuestoWeb().getBienUso().add(bu);
                            //lstAuxBienConsumo.remove(bc);
                        }//fin if
                    }//fin for
                }

                //BIEN NO PERSONAL
                List<BienNoPersonal> lstAuxBienNoPersonal = proyectoWeb.getPresupuestoWeb().getBienNoPersonal();
                proyectoWeb.getPresupuestoWeb().setBienNoPersonal(new ArrayList<BienNoPersonal>());



                if (lstAuxBienNoPersonal != null) {
                    for (BienNoPersonal bnp : lstAuxBienNoPersonal) {



                        if (bnp.getAnio().trim().equals("1")
                                || bnp.getAnio().trim().equals("2")) {

                            proyectoWeb.getPresupuestoWeb().getBienNoPersonal().add(bnp);
                            //lstAuxBienConsumo.remove(bc);
                        }//fin if
                    }//fin for
                }



                //GASTOS VIAJE
                List<GastoViaje> lstAuxGastoViaje = proyectoWeb.getPresupuestoWeb().getGastosViaje();
                proyectoWeb.getPresupuestoWeb().setGastosViaje(new ArrayList<GastoViaje>());

                if (lstAuxGastoViaje != null) {
                    for (GastoViaje gv : lstAuxGastoViaje) {



                        if (gv.getAnio().trim().equals("1")
                                || gv.getAnio().trim().equals("2")) {

                            proyectoWeb.getPresupuestoWeb().getGastosViaje().add(gv);
                            //lstAuxBienConsumo.remove(bc);
                        }//fin if
                    }//fin for
                }

                //pw.setBienConsumo(lstAuxBienConsumo);
                //proyectoWeb.setPresupuestoWeb(pw);

            }//fin if

            
            //PARA OTRAS LOCALIZACIONES
            proyectoWeb.setLstUbicaciones(this.getUbicacionLstBean().getLstUbicacion());
            this.proyectoWebRnLocal.guardar(proyectoWeb, pantalla);

            this.getProyectoWeb().setId(
                    this.proyectoWebRnLocal.findIdProyectoWebByCodigo(
                            this.getProyectoWeb().getCodigo()));

            //this.setProyectoWeb(new ProyectoWeb());
            if (pantalla == 11) {

                this.getProyectoWebLstBean().setLstProyectoWeb(new ArrayList<ProyectoWeb>());

                this.getMensajeBean().setMensaje("Los datos fueron guardados");
                RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
                RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

            } else {
                if (getProyectoWeb().getFinalizado() != true) {
                    this.getProyectoWeb().setFinalizado(Boolean.FALSE);
                }
                this.getMensajeBean().setMensaje("Los datos fueron guardados");
                RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
                RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            }

        } catch (Exception ex) {


            if (getProyectoWeb().getFinalizado() != true) {
                this.getProyectoWeb().setFinalizado(Boolean.FALSE);
            }
            
            if (banderaFinalizado) {
                this.getProyectoWeb().setFinalizado(Boolean.FALSE);
            }
            
            
            if(ex.getMessage().equals("Transaction aborted")){
                this.getMensajeBean().setMensaje("Error: Al cargar el plan de ejecucion financiera "
                        + "la descripcion de alguno de los gastos es demasiado extensa." );
            }else{
                this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            }
            

            
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

        }
    }//fin create

    public void delete(ProyectoWeb pw) throws Exception {
        this.proyectoWebRnLocal.delete(pw);
    }//fin delete

    //es la localizacion
    public void quitarUnidadInvestigacion(UnidadInvestigacion ui) {
        this.getProyectoWeb().getLocalizaciones().remove(ui);
    }//fin quitarUnidadInvestigacion

    /*public void quitarPalabraClave(String s, int tipo){

     switch(tipo){
     case 0:
     this.getProyectoWeb().getPalabrasClaves().remove(s);
     break;
     case 1:
     this.getProyectoWeb().getKeywords().remove(s);
     break;
     }//fin switch
        
     }//fin quitarSubDisciplinaCientifica*/
    public void generarReporte(int reporte) {

        try {


            HashMap hm = new HashMap();

            //ver si es una actuacion 
            String nombreReporte = "";
            

            switch (reporte) {
                case 0: //vista previa
                    nombreReporte = "reporteProyectoVistaPrevia.jasper";
                    break;
                case 1: //reporte final
                    nombreReporte = "reporteProyecto.jasper";
                    break;
            }//fin switch


            EntityManagerFactory emf = Persistence.createEntityManagerFactory("secyt-ejbPU");
            EntityManager em = emf.createEntityManager();
            String image = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/unca.jpg");
            hm.put("IMAGEN", image);
            //"JPA_ENTITY_MANAGER"
            hm.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);
            //quito html
            ProyectoWeb proyecto = this.getProyectoWeb();
            if(proyecto.getProyectoWebFGP()!=null){
            proyecto.getProyectoWebFGP().setCronogramaTrabajo(proyecto.getProyectoWebFGP().getCronogramaTrabajo());
            if (proyecto.getProyectoWebFGP().getCapacitacionFormacionRH() != null) {
                if (!proyecto.getProyectoWebFGP().getCapacitacionFormacionRH().isEmpty()) {
                    proyecto.getProyectoWebFGP().setCapacitacionFormacionRH(proyecto.getProyectoWebFGP().getCapacitacionFormacionRH());
                }
            }
            }

            
            Collections.sort(proyecto.getParticipacionesWeb());
            

            hm.put("proyecto", proyecto);
            //hm.put("fecha", new Date());*/

            this.getGenerarReportesBean().generar(hm, nombreReporte);
            
        } catch (Exception ex) {
            //mostrar mensaje

            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            System.out.println(ex);
            RequestContext.getCurrentInstance().update("frmAdmin:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        FacesContext.getCurrentInstance().responseComplete();

    }//fin imprimirCaratulaReporte

    //para mostrar los botones siguiente anterior guardar
    public Boolean mostrarBotonASG() {

        if (this.getProyectoWeb().getId() != null) {
            Date fechaActual = new Date();

            if (this.getProyectoWeb().getFechaArchivo() != null && this.getProyectoWeb().getConvocatoria().getFechaFin().compareTo(fechaActual) < 0
                    && this.getProyectoWeb().getFechaArchivo().compareTo(fechaActual) >= 0) {
                return false;
            }//fin if
        }//fin if

        return true;
    }//FIN mostrarBotonASG

    public void probar() {
        System.out.println("Entro al evento");
    }//fin probar

    public static String filterHTMLTags(String html) {

        // save valid tags:
        String striped = html.replaceAll("(?i)\\<(\\s*/?(a|h\\d|b|i|em|cite|code|strong|pre|br|li|ul|ol).*?/?)\\>", "{{$1}}");
        // remove all tags:
        striped = striped.replaceAll("\\<(/?[^\\>]+)\\>", " ");
        // restore valid tags:
        striped = striped.replaceAll("\\{\\{(.+?)\\}\\}", "<$1>");

        return striped;
    }
}
