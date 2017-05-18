/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.economico.BienConsumo;
import entidades.economico.BienNoPersonal;
import entidades.economico.BienUso;
import entidades.economico.Cobro;
import entidades.economico.GastoViaje;
import entidades.economico.PagoEconomico;
import entidades.economico.Rendicion;
import entidades.proyecto.Proyecto;
import entidades.proyecto.RN.ProyectoRNLocal;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class investigadorRendicionBean {

    /**
     * Creates a new instance of investigadorRendicionBean
     */
    @EJB
    private ProyectoRNLocal proyectoRNLocal;
    
    private Proyecto proyecto;
    private String sOcultarAcordinPanel = "hidden";
    private int i = 0;
    private BigDecimal subTotal;
    private BigDecimal totalGeneral;
    private Boolean bPagos = Boolean.FALSE;
    private Boolean bPresupuesto = Boolean.FALSE;
    private Boolean bRendicion = Boolean.FALSE;
    private Boolean bRetiroDeFondoYSaldo = Boolean.FALSE;
    private Boolean bResoluciones = Boolean.FALSE;
    
    public investigadorRendicionBean() {
    }
    
    @PostConstruct
    private void init(){
        proyecto = new Proyecto();
        
        totalGeneral = new BigDecimal(0);
        i = 0;
    }//fin init

    public Boolean getbResoluciones() {
        return bResoluciones;
    }

    public void setbResoluciones(Boolean bResoluciones) {
        this.bResoluciones = bResoluciones;
    }
    
    public Boolean getbPagos() {
        return bPagos;
    }

    public void setbPagos(Boolean bPagos) {
        this.bPagos = bPagos;
    }

    public Boolean getbPresupuesto() {
        return bPresupuesto;
    }

    public void setbPresupuesto(Boolean bPresupuesto) {
        this.bPresupuesto = bPresupuesto;
    }

    public Boolean getbRendicion() {
        return bRendicion;
    }

    public void setbRendicion(Boolean bRendicion) {
        this.bRendicion = bRendicion;
    }

    public Boolean getbRetiroDeFondoYSaldo() {
        return bRetiroDeFondoYSaldo;
    }

    public void setbRetiroDeFondoYSaldo(Boolean bRetiroDeFondoYSaldo) {
        this.bRetiroDeFondoYSaldo = bRetiroDeFondoYSaldo;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getsOcultarAcordinPanel() {
        return sOcultarAcordinPanel;
    }

    public void setsOcultarAcordinPanel(String sOcultarAcordinPanel) {
        this.sOcultarAcordinPanel = sOcultarAcordinPanel;
    }
    
    public void onTabChange(TabChangeEvent event){  
        
        this.limpiarBoolean();
        
        this.findProyectoById();

        if(event.getTab().getId().equals("tPagos")){
            this.setbPagos(Boolean.TRUE);
        }else{
            if(event.getTab().getId().equals("tPresupuesto")){
                this.setbPresupuesto(Boolean.TRUE);
            }else{
                if(event.getTab().getId().equals("tRendicion")){
                    this.setbRendicion(Boolean.TRUE);
                }else{
                    if(event.getTab().getId().equals("tRetiroDeFondoYSaldo")){
                        this.setbRetiroDeFondoYSaldo(Boolean.TRUE);
                    }else{
                        this.setbResoluciones(Boolean.TRUE);
                    }
                }
            }
        }
        
    }//fin onTabChange
    
    public void findProyectoById(){
        try {
            this.setProyecto(proyectoRNLocal.find(proyecto.getId()));
            
        }catch (Exception ex) {
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        
    }//fin findProyectoById
    
    public BigDecimal obtenerSubTotalPresupuesto(){
        
        System.out.println("Sub Total presupuesto");
        subTotal = new BigDecimal(0);

        if (proyecto.getPresupuesto() != null) {
            switch (i) {
                case 0:
                    List<BienConsumo> lstBienComsumoAux = proyecto.getPresupuesto().getBienConsumo();
                    for (BienConsumo bc : lstBienComsumoAux) {
                        subTotal = subTotal.add(bc.getValor());
                    }//fin for
                    break;
                case 1:
                    List<BienNoPersonal> lstBienNoPersonalAux = proyecto.getPresupuesto().getBienNoPersonal();
                    for (BienNoPersonal bnp : lstBienNoPersonalAux) {
                        subTotal = subTotal.add(bnp.getValor());
                    }//fin for
                    break;
                case 2:
                    List<GastoViaje> lstGastosViajeAux = proyecto.getPresupuesto().getGastosViaje();
                    for (GastoViaje gv : lstGastosViajeAux) {
                        subTotal = subTotal.add(gv.getValor());
                    }//fin for
                    break;
                case 3:
                    List<BienUso> lstBienUsoAux = proyecto.getPresupuesto().getBienUso();
                    for (BienUso bu : lstBienUsoAux) {
                        subTotal = subTotal.add(bu.getValor());
                    }//fin for
                    break;
            }//fin switch


            //calcular el subtotal y ir acumulando en el total general
            //el i es la posicion de la lista de la tabla
            i++;
        }//fin if
         return subTotal;
    }//fin obtenerSubTotalPresupuesto
    
     public BigDecimal obtenerTotalGeneralPresupuesto(){
         System.out.println("Total presupuesto");
        

         totalGeneral = new BigDecimal(0);
         System.out.println(" Pasos 1");
         System.out.println(" Pasos : " + proyecto);
         System.out.println(" Pasos : " + proyecto.getPresupuesto());

         if (proyecto.getPresupuesto() != null) {
             List<BienConsumo> lstBienComsumoAux = proyecto.getPresupuesto().getBienConsumo();
             for (BienConsumo bc : lstBienComsumoAux) {
                 totalGeneral = totalGeneral.add(bc.getValor());
             }//fin for
             System.out.println(" Pasos 2");
             List<BienNoPersonal> lstBienNoPersonalAux = proyecto.getPresupuesto().getBienNoPersonal();
             for (BienNoPersonal bnp : lstBienNoPersonalAux) {
                 totalGeneral = totalGeneral.add(bnp.getValor());
             }//fin for
             System.out.println(" Pasos 3");
             List<GastoViaje> lstGastosViajeAux = proyecto.getPresupuesto().getGastosViaje();
             for (GastoViaje gv : lstGastosViajeAux) {
                 totalGeneral = totalGeneral.add(gv.getValor());
             }//fin for
             System.out.println(" Pasos 4");
             List<BienUso> lstBienUsoAux = proyecto.getPresupuesto().getBienUso();
             for (BienUso bu : lstBienUsoAux) {
                 totalGeneral = totalGeneral.add(bu.getValor());
             }//fin for
         }//fin if


         System.out.println(" Pasos 5");
         //calcular el subtotal y ir acumulando en el total general
         //el i es la posicion de la lista de la tabla

         return totalGeneral;
    }//fin obtenerSubTotalPresupuesto
    
    public BigDecimal obtenerSubTotalRendicion(PagoEconomico pe){
        
        subTotal = new BigDecimal(0);

         
         for(Rendicion r : pe.getRendiciones()){             
             subTotal = subTotal.add(r.getMontoRendido());
         }//fin for                  
               
         return subTotal;
    }//fin obtenerSubTotalRendicion
    
    public BigDecimal obtenerTotalGeneralRendicion(){
                
        totalGeneral = new BigDecimal(0);

         
        for (PagoEconomico pe : this.proyecto.getPagos()) {
            for (Rendicion r : pe.getRendiciones()) {
                totalGeneral = totalGeneral.add(r.getMontoRendido());
            }//fin for
        }//fin for
         
        return totalGeneral;
    }//fin obtenerTotalGeneralRendicion
    
    public BigDecimal obtenerSubTotalRetiroDeFondoYSaldo(){
        
        
        subTotal = new BigDecimal(0);

        
         for(Cobro cob : this.proyecto.getPagos().get(i).getCobros()){             
             subTotal = subTotal.add(cob.getMontoCobrado());
         }//fin for
                  
               
         i++;
         return subTotal;
    }//fin obtenerSubTotalRendicion
    
    public BigDecimal obtenerTotalGeneralRetiroDeFondoYSaldo(){
        
        
        totalGeneral = new BigDecimal(0);

         
        for (PagoEconomico pe : this.proyecto.getPagos()) {
            for (Cobro cob : pe.getCobros()) {
                totalGeneral = totalGeneral.add(cob.getMontoCobrado());
            }//fin for
        }//fin for
         
        return totalGeneral;
    }//fin obtenerTotalGeneralRendicion
    
    public void mostrarAcoordingPanel(){
        this.setsOcultarAcordinPanel("visible;");
        this.limpiarBoolean();
        this.setbPagos(Boolean.TRUE);
    }//fin mostrarAcoordingPanel
    
    private void limpiarBoolean(){
        bPagos = Boolean.FALSE;
        bPresupuesto = Boolean.FALSE;
        bRendicion = Boolean.FALSE;
        bRetiroDeFondoYSaldo = Boolean.FALSE;
        bRendicion = Boolean.FALSE;
        
        totalGeneral = new BigDecimal(0);
        i = 0;
    }//fin limpiarBoolean
    
    public List<Rendicion> getRendicionesOrdenadasPorFecha(PagoEconomico pe) throws Exception{
        return proyectoRNLocal.getRendicionesOrdenadasPorFecha(pe);
    }//fin getRendicionesOrdenadasPorAño HUGO
    
    
    
    
}//FIN CLASE
