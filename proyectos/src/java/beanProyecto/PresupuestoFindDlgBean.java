/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.economico.BienConsumo;
import entidades.economico.BienNoPersonal;
import entidades.economico.BienUso;
import entidades.economico.GastoViaje;
import entidades.proyectoPidWeb.BienConsumoPidWeb;
import entidades.proyectoPidWeb.BienNoPersonalPidWeb;
import entidades.proyectoPidWeb.BienUsoPidWeb;
import entidades.proyectoPidWeb.GastoViajePidWeb;
import entidades.proyectoPidWeb.PresupuestoPidWeb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class PresupuestoFindDlgBean {

    private BienConsumo bienConsumo;
    private BienNoPersonal bienNoPersonal;
    private BienUso bienUso;
    private GastoViaje gastoViaje;
    private int tipo;
    private static int banderaAnios;
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;

    public PresupuestoFindDlgBean() {
        bienConsumo = new BienConsumo();
        bienNoPersonal = new BienNoPersonal();
        bienUso = new BienUso();
        gastoViaje = new GastoViaje();



    }

    public int getBanderaAnios() {

        return banderaAnios;
    }

    public void setBanderaAnios(int banderaAnios) {

        this.banderaAnios = banderaAnios;
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }

    public BienNoPersonal getBienNoPersonal() {
        return bienNoPersonal;
    }

    public void setBienNoPersonal(BienNoPersonal bienNoPersonal) {
        this.bienNoPersonal = bienNoPersonal;
    }

    public BienUso getBienUso() {
        return bienUso;
    }

    public void setBienUso(BienUso bienUso) {
        this.bienUso = bienUso;
    }

    public GastoViaje getGastoViaje() {
        return gastoViaje;
    }

    public void setGastoViaje(GastoViaje gastoViaje) {
        this.gastoViaje = gastoViaje;
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

    public BienConsumo getBienConsumo() {
        return bienConsumo;
    }

    public void setBienConsumo(BienConsumo bienConsumo) {
        this.bienConsumo = bienConsumo;
    }

    /*public void handleChange(ValueChangeEvent event){ 
        
     try{
            
     //validar que se cargue primero para el primerAño
     if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno() == null){
     throw new Exception("Debe completar el plan de ejecucipon financiera para el primer año.");
     }//fin if
        
     int bandera = 0;
        
     if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienConsumoWeb() == null ||
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienConsumoWeb().isEmpty()){
            
     bandera++;
                        
     }//fin if
        
     if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienNoPersonalWeb() == null || 
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienNoPersonalWeb().isEmpty()){
     bandera++;
     }//fin if
        
     if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienUsoWeb() == null || 
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienUsoWeb().isEmpty()){
     bandera++;
     }//fin if
        
     if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getGastosViajeWeb() == null || 
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getGastosViajeWeb().isEmpty()){
     bandera++;
     }//fin if
        
     if(bandera == 0){
     throw new Exception("Debe completar el plan de ejecucipon financiera para el primer año.");
     }//fin if
        
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienConsumo() == null){
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().setBienConsumo(new ArrayList<BienConsumo>());
     }//fin if
            
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienConsumo().isEmpty()){
                
     BienConsumo bc = new BienConsumo();
     bc.setAnio("1");
     bc.setValor(new BigDecimal("0"));
     bc.setValorA(new BigDecimal("0"));
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienConsumo().add(
     bc);
                
     }//fin if
            
  
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienNoPersonal() == null){
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().setBienNoPersonal(new ArrayList<BienNoPersonal>());
     }//fin if
            
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienNoPersonal().isEmpty()){
     BienNoPersonal bnp = new BienNoPersonal();
     bnp.setAnio("1");
     bnp.setValor(new BigDecimal("0"));
     bnp.setValorA(new BigDecimal("0"));
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienNoPersonal().add(
     bnp);
     }//fin if
            
            
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienUso() == null){
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().setBienUso(new ArrayList<BienUso>());
     }//fin if
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienUso().isEmpty()){
                
     BienUso bu = new BienUso();
     bu.setAnio("1");
     bu.setValor(new BigDecimal("0"));
     bu.setValorA(new BigDecimal("0"));
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getBienUso().add(
     bu);
     }//fin if
            
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getGastosViaje() == null){
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().setGastosViaje(new ArrayList<GastoViaje>());
     }//fin if
            
     if(this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getGastosViaje().isEmpty()){
     GastoViaje gv = new GastoViaje();
     gv.setAnio("1");
     gv.setValor(new BigDecimal("0"));
     gv.setValorA(new BigDecimal("0"));
     this.getProyectoWebBean().getProyectoWeb().
     getPresupuestoWeb().getGastosViaje().add(
     gv);
     }//fin if
        
     System.out.println("BANDRA ANIOS: " + event.getNewValue());
     if(((Integer)event.getNewValue())==2){
            
     System.out.println("Entro");
     //elimino el elemento
     int tam = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size()-1;
            
     for(int i = tam ; i > 1; i--){
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().remove(i);
     }//fin for
            
            
     tam = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size()-1;
     for(int i = tam ; i > 1; i--){
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().remove(i);
     }//fin for
            
     tam = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().size()-1;
     for(int i = tam ; i > 1; i--){
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().remove(i);
     }//fin for
            
     tam = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().size()-1;
     for(int i = tam ; i > 1; i--){
     this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().remove(i);
     }//fin for

     }//fin if
        
        
     RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");
     RequestContext.getCurrentInstance().update("frmUser:pBotonesAnios");
        
     } catch (Exception ex) {
     this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
     RequestContext.getCurrentInstance().update("frmUser:dMensaje");
     RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
     }

     }//fin handleChange*/
    public void actualizarPresupuestoAniosBienConsumo(int anio) {

        
        BienConsumo bienConsumoAux = new BienConsumo();
        bienConsumoAux.setAnio(String.valueOf(anio));
        bienConsumoAux.setValor(new BigDecimal("0"));
        bienConsumoAux.setValorA(new BigDecimal("0"));

        /* if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb() == null) {
         this.getProyectoWebBean().getProyectoWeb().setPresupuestoWeb(new PresupuestoWeb());
         }//fin if

         if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo() == null) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
         setBienConsumo(new ArrayList<BienConsumo>());
         }//fin if*/

        switch (anio) {
            case 1:

                for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getBienConsumoWeb()) {

                    bienConsumoAux.setValor(bienConsumoAux.getValor().add(bcw.getValor()));

                }//fin for


                break;
            case 2:

                for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioDos().getBienConsumoWeb()) {

                    bienConsumoAux.setValor(bienConsumoAux.getValor().add(bcw.getValor()));

                }//fin for

                break;
            case 3:

                for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioTres().getBienConsumoWeb()) {

                    bienConsumoAux.setValor(bienConsumoAux.getValor().add(bcw.getValor()));

                }//fin for

                break;
            case 4:

                for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioCuatro().getBienConsumoWeb()) {

                    bienConsumoAux.setValor(bienConsumoAux.getValor().add(bcw.getValor()));

                }//fin for
                break;
        }//fin switch


        System.out.println("anio: " + anio);
        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().add(anio - 1, bienConsumoAux);
        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().remove(anio);
        
        for(BienConsumo bc : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo()){
            System.out.println("i: " + bc.getAnio());
            System.out.println("i: " + bc.getValor());
        }

        /*int dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size();

         while (anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size() > 1) {

         BienConsumo bienConsumoAux2 = new BienConsumo();
         bienConsumoAux2.setAnio(String.valueOf(
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size() + 1));
         bienConsumoAux2.setValor(new BigDecimal("0"));
         bienConsumoAux2.setValorA(new BigDecimal("0"));

         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().add(bienConsumoAux2);

         dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size();

         }//fin while

         System.out.println("dif anio bien consumo: " + anio + " - " + 
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size() + " = " + dif);

         if (dif <= 0) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().set(anio - 1, bienConsumoAux);
         } else {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().add(bienConsumoAux);
         }*/


        /*if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().isEmpty()) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().add(bienConsumoAux);
         } else {
         //this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().get(0).setValor(bienConsumoAux.getValor());
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().set(0, bienConsumoAux);
         }*/




        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");


    }//fin definirPresupuestoAniosBienConsumo

    public void actualizarPresupuestoAniosBienNoPersonal(int anio) {
        
        BienNoPersonal bienNoPersonalAux = new BienNoPersonal();
        bienNoPersonalAux.setAnio(String.valueOf(anio));
        bienNoPersonalAux.setValor(new BigDecimal("0"));
        bienNoPersonalAux.setValorA(new BigDecimal("0"));

        /*if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb() == null) {
         this.getProyectoWebBean().getProyectoWeb().setPresupuestoWeb(new PresupuestoWeb());
         }//fin if

         if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal() == null) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
         setBienNoPersonal(new ArrayList<BienNoPersonal>());
         }//fin if*/


        switch (anio) {
            case 1:

                for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getBienNoPersonalWeb()) {

                    bienNoPersonalAux.setValor(bienNoPersonalAux.getValor().add(bnpw.getValor()));

                }//fin for


                break;
            case 2:

                for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioDos().getBienNoPersonalWeb()) {

                    bienNoPersonalAux.setValor(bienNoPersonalAux.getValor().add(bnpw.getValor()));

                }//fin for

                break;
            case 3:

                for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioTres().getBienNoPersonalWeb()) {

                    bienNoPersonalAux.setValor(bienNoPersonalAux.getValor().add(bnpw.getValor()));

                }//fin for

                break;
            case 4:

                for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioCuatro().getBienNoPersonalWeb()) {

                    bienNoPersonalAux.setValor(bienNoPersonalAux.getValor().add(bnpw.getValor()));

                }//fin for
                break;
        }//fin switch


        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().add(anio - 1, bienNoPersonalAux);
        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().remove(anio);
        //this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().set(anio - 1, bienNoPersonalAux);

        /*int dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size();
        
         System.out.println("tamaño bien no personal: " + dif);

         while (anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size() > 1) {

         BienNoPersonal bienNoPersonalAux2 = new BienNoPersonal();
         bienNoPersonalAux2.setAnio(String.valueOf(
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size() + 1));
         bienNoPersonalAux2.setValor(new BigDecimal("0"));
         bienNoPersonalAux2.setValorA(new BigDecimal("0"));

         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().add(bienNoPersonalAux2);

         dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size();

         }//fin while


         System.out.println("dif anio bien no personal: " + anio + " - " + 
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size() + " = " + dif);
        
         if (dif <= 0) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().set(anio - 1, bienNoPersonalAux);
         } else {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().add(bienNoPersonalAux);
         }       */


        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");


    }//fin definirPresupuestoAniosBienNoPersonal

    public void actualizarPresupuestoAniosBienUso(int anio) {

        
        System.out.println("actualizar bien uso anio: " + anio);
        BienUso bienUsoAux = new BienUso();
        bienUsoAux.setAnio(String.valueOf(anio));
        bienUsoAux.setValor(new BigDecimal("0"));
        bienUsoAux.setValorA(new BigDecimal("0"));

        /*if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb() == null) {
         this.getProyectoWebBean().getProyectoWeb().setPresupuestoWeb(new PresupuestoWeb());
         }//fin if

         if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso() == null) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
         setBienUso(new ArrayList<BienUso>());
         }//fin if*/

        switch (anio) {
            case 1:

                for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getBienUsoWeb()) {

                    bienUsoAux.setValor(bienUsoAux.getValor().add(buw.getValor()));

                }//fin for


                break;
            case 2:

                for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioDos().getBienUsoWeb()) {

                    bienUsoAux.setValor(bienUsoAux.getValor().add(buw.getValor()));

                }//fin for

                break;
            case 3:

                for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioTres().getBienUsoWeb()) {

                    bienUsoAux.setValor(bienUsoAux.getValor().add(buw.getValor()));

                }//fin for

                break;
            case 4:

                for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioCuatro().getBienUsoWeb()) {

                    bienUsoAux.setValor(bienUsoAux.getValor().add(buw.getValor()));

                }//fin for
                break;
        }//fin switch

        
        

        System.out.println("cambio el anio: " + anio);
        
        
        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().add(anio - 1, bienUsoAux);
        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().remove(anio);
        //this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().set(anio - 1, bienUsoAux);
        
        for(BienUso bu : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso()){
            System.out.println("i: " + bu.getAnio());
            System.out.println("i: " + bu.getValor());
        }

        /*int dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().size();

         //para las filas
         while (anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().size() > 1) {

         BienUso bienUsoAux2 = new BienUso();
         bienUsoAux2.setAnio(String.valueOf(
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().size() + 1));
         bienUsoAux2.setValor(new BigDecimal("0"));
         bienUsoAux2.setValorA(new BigDecimal("0"));

         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().add(bienUsoAux2);

         dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().size();

         }//fin while


         if (dif <= 0) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().set(anio - 1, bienUsoAux);
         } else {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().add(bienUsoAux);
         }*/

        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");


    }//fin definirPresupuestoAniosBienUso

    public void actualizarPresupuestoAniosGastosViaje(int anio) {


        GastoViaje gastoViajeAux = new GastoViaje();
        gastoViajeAux.setAnio(String.valueOf(anio));
        gastoViajeAux.setValor(new BigDecimal("0"));
        gastoViajeAux.setValorA(new BigDecimal("0"));

        /*if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb() == null) {
         this.getProyectoWebBean().getProyectoWeb().setPresupuestoWeb(new PresupuestoWeb());
         }//fin if

         if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje() == null) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
         setGastosViaje(new ArrayList<GastoViaje>());
         }//fin if*/

        switch (anio) {
            case 1:

                for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getGastosViajeWeb()) {

                    gastoViajeAux.setValor(gastoViajeAux.getValor().add(gvw.getValor()));

                }//fin for


                break;
            case 2:

                for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioDos().getGastosViajeWeb()) {

                    gastoViajeAux.setValor(gastoViajeAux.getValor().add(gvw.getValor()));

                }//fin for

                break;
            case 3:

                for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioTres().getGastosViajeWeb()) {

                    gastoViajeAux.setValor(gastoViajeAux.getValor().add(gvw.getValor()));

                }//fin for

                break;
            case 4:

                for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioCuatro().getGastosViajeWeb()) {

                    gastoViajeAux.setValor(gastoViajeAux.getValor().add(gvw.getValor()));

                }//fin for
                break;
        }//fin switch


        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().add(anio - 1, gastoViajeAux);
        this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().remove(anio);
        //this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().set(anio - 1, gastoViajeAux);

        /*int dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().size();

         while (anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().size() > 1) {

         GastoViaje gastoViajeAux2 = new GastoViaje();
         gastoViajeAux2.setAnio(String.valueOf(
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().size() + 1));
         gastoViajeAux2.setValor(new BigDecimal("0"));
         gastoViajeAux2.setValorA(new BigDecimal("0"));

         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().add(gastoViajeAux2);

         dif = anio - this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().size();

         }//fin while


         if (dif <= 0) {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().set(anio - 1, gastoViajeAux);
         } else {
         this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().add(gastoViajeAux);
         }*/






        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");


    }//fin definirPresupuestoAniosGastoViaje

    public void definirComponentesActualizar() {
        try {

            if (this.getBienConsumo().getValor() == null) {
                throw new Exception("No ingreso el presupuesto de bienes de cosumo.");
            }//fin if


            if (this.getBienNoPersonal().getValor() == null) {
                throw new Exception("No ingreso el presupuesto de bienes no personales.");
            }//fin if


            if (this.getBienUso().getValor() == null) {
                throw new Exception("No ingreso el presupuesto de bienes de uso.");
            }//fin if

            if (this.getGastoViaje().getValor() == null) {
                throw new Exception("No ingreso el presupuesto de gastos de viajes.");
            }//fin if


            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb() == null) {
                this.getProyectoWebBean().getProyectoWeb().
                        setPresupuestoWeb(new PresupuestoPidWeb());
            }//fin if

            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienConsumo() == null) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().setBienConsumo(new ArrayList<BienConsumo>());
            }//fin if

            /*if(this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienConsumo().isEmpty()){
                
             BienConsumo bc = new BienConsumo();
             bc.setAnio("1");
             bc.setValor(new BigDecimal("0"));
             bc.setValorA(new BigDecimal("0"));
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienConsumo().add(
             bc);
                
             }//fin if*/


            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienNoPersonal() == null) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().setBienNoPersonal(new ArrayList<BienNoPersonal>());
            }//fin if

            /*if(this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienNoPersonal().isEmpty()){
             BienNoPersonal bnp = new BienNoPersonal();
             bnp.setAnio("1");
             bnp.setValor(new BigDecimal("0"));
             bnp.setValorA(new BigDecimal("0"));
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienNoPersonal().add(
             bnp);
             }//fin if*/


            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienUso() == null) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().setBienUso(new ArrayList<BienUso>());
            }//fin if
            /*if(this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienUso().isEmpty()){
                
             BienUso bu = new BienUso();
             bu.setAnio("1");
             bu.setValor(new BigDecimal("0"));
             bu.setValorA(new BigDecimal("0"));
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienUso().add(
             bu);
             }//fin if*/

            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getGastosViaje() == null) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().setGastosViaje(new ArrayList<GastoViaje>());
            }//fin if

            /*if(this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getGastosViaje().isEmpty()){
             GastoViaje gv = new GastoViaje();
             gv.setAnio("1");
             gv.setValor(new BigDecimal("0"));
             gv.setValorA(new BigDecimal("0"));
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getGastosViaje().add(
             gv);
             }//fin if*/


            /*int cantDatos = this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienConsumo().size() + 
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienNoPersonal().size() + 
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getBienNoPersonal().size() + 
             this.getProyectoWebBean().getProyectoWeb().
             getPresupuestoWeb().getGastosViaje().size();
            
             if(cantDatos<this.getTipo() && cantDatos!=this.getTipo()){
                
             int iAnio = cantDatos + 1;
             throw new Exception("Primero debe ingresar el año " + iAnio);
             }//fin if*/

            /*if(cantDatos==this.getTipo() || cantDatos==0){

             }//fin if*/



            /*if (this.getGastoViaje().getValorA()== null) {
             this.getGastoViaje().setValorA(new BigDecimal("0"));
             }//fin if*/



            RequestContext context = RequestContext.getCurrentInstance();
            ;


            this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().setProyectoWeb(
                    this.getProyectoWebBean().getProyectoWeb());

            this.getBienConsumo().setAnio(String.valueOf(this.getTipo() + 1));



            if (bienConsumo.getValorA() == null) {
                bienConsumo.setValorA(new BigDecimal("0"));
            }



            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienConsumo().isEmpty() && this.getTipo() > 0) {


                BienConsumoPidWeb bcw = new BienConsumoPidWeb();
                bcw.setValor(new BigDecimal("0"));

                if (this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getBienConsumoWeb() == null) {
                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().setBienConsumoWeb(new ArrayList<BienConsumoPidWeb>());
                }
                /*this.getProyectoWebBean().getProyectoWeb().
                 getPresupuestoWebAnioUno().getBienConsumoWeb().add(bcw);*/

                BienConsumo bc = new BienConsumo();
                bc.setValor(new BigDecimal("0"));
                bc.setValorA(new BigDecimal("0"));

                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienConsumo().add(bc);

            }//fin if



            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienConsumo().size() > this.getTipo()) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienConsumo().set(this.getTipo(), bienConsumo);
            } else {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienConsumo().add(bienConsumo);
            }


            if (bienNoPersonal.getValorA() == null) {
                bienNoPersonal.setValorA(new BigDecimal("0"));
            }
            this.getBienNoPersonal().setAnio(String.valueOf(this.getTipo() + 1));


            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienNoPersonal().isEmpty() && this.getTipo() > 0) {


                BienNoPersonalPidWeb bnpw = new BienNoPersonalPidWeb();
                bnpw.setValor(new BigDecimal("0"));

                if (this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getBienNoPersonalWeb() == null) {
                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().setBienNoPersonalWeb(new ArrayList<BienNoPersonalPidWeb>());
                }

                /*this.getProyectoWebBean().getProyectoWeb().
                 getPresupuestoWebAnioUno().getBienNoPersonalWeb().add(bnpw);*/

                BienNoPersonal bnp = new BienNoPersonal();
                bnp.setValor(new BigDecimal("0"));
                bnp.setValorA(new BigDecimal("0"));

                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienNoPersonal().add(bnp);
            }//fin if


            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienNoPersonal().size() > this.getTipo()) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienNoPersonal().set(this.getTipo(), bienNoPersonal);
            } else {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienNoPersonal().add(bienNoPersonal);
            }


            this.getBienUso().setAnio(String.valueOf(this.getTipo() + 1));

            if (bienUso.getValorA() == null) {
                bienUso.setValorA(new BigDecimal("0"));
            }


            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienUso().isEmpty() && this.getTipo() > 0) {


                BienUsoPidWeb buw = new BienUsoPidWeb();
                buw.setValor(new BigDecimal("0"));

                if (this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getBienUsoWeb() == null) {
                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().setBienUsoWeb(new ArrayList<BienUsoPidWeb>());
                }
                /*this.getProyectoWebBean().getProyectoWeb().
                 getPresupuestoWebAnioUno().getBienUsoWeb().add(buw);*/

                BienUso bu = new BienUso();
                bu.setValor(new BigDecimal("0"));
                bu.setValorA(new BigDecimal("0"));

                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienUso().add(bu);
            }//fin if

            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getBienUso().size() > this.getTipo()) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienUso().set(this.getTipo(), bienUso);
            } else {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getBienUso().add(bienUso);
            }


            this.getGastoViaje().setAnio(String.valueOf(this.getTipo() + 1));

            if (gastoViaje.getValorA() == null) {
                gastoViaje.setValorA(new BigDecimal("0"));
            }

            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getGastosViaje().isEmpty() && this.getTipo() > 0) {

                GastoViajePidWeb gvw = new GastoViajePidWeb();
                gvw.setValor(new BigDecimal("0"));

                if (this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().getGastosViajeWeb() == null) {
                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().setGastosViajeWeb(new ArrayList<GastoViajePidWeb>());
                }

                /*this.getProyectoWebBean().getProyectoWeb().
                 getPresupuestoWebAnioUno().getGastosViajeWeb().add(gvw);*/

                GastoViaje gv = new GastoViaje();
                gv.setValor(new BigDecimal("0"));
                gv.setValorA(new BigDecimal("0"));
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getGastosViaje().add(gv);


            }//fin if

            if (this.getProyectoWebBean().getProyectoWeb().
                    getPresupuestoWeb().getGastosViaje().size() > this.getTipo()) {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getGastosViaje().set(this.getTipo(), gastoViaje);
            } else {
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWeb().getGastosViaje().add(gastoViaje);
            }

            context.update("frmUser:dtPresupuesto");
            context.execute("dlgPresupuesto.hide()");

            /*if (this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves() == null) {
             this.getProyectoWebBean().getProyectoWeb().setPalabrasClaves(new ArrayList<String>());
             }//fin if

             for (String s : this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves()) {
             if (s.trim().toLowerCase().equals(this.getPalabra().trim().toLowerCase())) {
             throw new Exception("La palabra ya fue ingresada.");
             }//fin if
             }//fin for

             this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves().add(this.getPalabra());


             context.update("frmUser:dtPalabrasClaves");*/




        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar

    public void cargarTabla(int anio) {

        if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb() == null) {
            this.getProyectoWebBean().getProyectoWeb().setPresupuestoWeb(new PresupuestoPidWeb());
            this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().setProyectoWeb(this.getProyectoWebBean().getProyectoWeb());
        }//fin if

        if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo() == null) {
            this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
                    setBienConsumo(new ArrayList<BienConsumo>());
        } 
        
        if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal() == null) {
            this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
                    setBienNoPersonal(new ArrayList<BienNoPersonal>());
        } 
        if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso() == null) {
            this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
                    setBienUso(new ArrayList<BienUso>());
        } 
        if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje() == null) {
            this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().
                    setGastosViaje(new ArrayList<GastoViaje>());
        } 




        int cantAnios = this.getProyectoWebBean().activarBotonAnio();

        System.out.println("cantidad de anios: " + cantAnios);
        
        System.out.println("bienes de consumo: " + this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size());
        
        if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size()
                < cantAnios) {

            System.out.println("Entro al if");
            //bien consumo
            int ini = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().size();
            for (int i = ini; i < cantAnios; i++) {
                BienConsumo bc = new BienConsumo();
                bc.setAnio(String.valueOf(i+1));
                bc.setValor(BigDecimal.ZERO);
                bc.setValorA(BigDecimal.ZERO);
                this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().add(bc);
            }//fin for

            //bien no personal
            ini = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().size();
            for (int i = ini; i < cantAnios; i++) {
                BienNoPersonal bnp = new BienNoPersonal();
                bnp.setAnio(String.valueOf(i+1));
                bnp.setValor(BigDecimal.ZERO);
                bnp.setValorA(BigDecimal.ZERO);
                this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().add(bnp);
            }//fin for

            //bienuso
            ini = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().size();
            for (int i = ini; i < cantAnios; i++) {
                BienUso bu = new BienUso();
                bu.setAnio(String.valueOf(i+1));
                bu.setValor(BigDecimal.ZERO);
                bu.setValorA(BigDecimal.ZERO);
                this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().add(bu);
            }//fin for

            //Gasto viaje
            ini = this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().size();
            
            
            for (int i = ini; i < cantAnios; i++) {
                GastoViaje gv = new GastoViaje();
                gv.setAnio(String.valueOf(i+1));
                gv.setValor(BigDecimal.ZERO);
                gv.setValorA(BigDecimal.ZERO);
                this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().add(gv);
            }//fin for


        }//fin if
        
         try {
                Collections.sort(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo());
                Collections.sort(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal());
                Collections.sort(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso());
                Collections.sort(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje());
            } catch (Exception e) {
            }//fin if

    }//fin cargarTabla
}
