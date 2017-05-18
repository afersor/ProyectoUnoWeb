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
import entidades.proyectoPidWeb.PresupuestoPidWebDetallado;
import entidades.proyectoPidWeb.PresupuestoPidWebDetalladoCuatro;
import entidades.proyectoPidWeb.PresupuestoPidWebDetalladoDos;
import entidades.proyectoPidWeb.PresupuestoPidWebDetalladoTres;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author diego
 */


@ManagedBean
@RequestScoped
public class PresupuestoAnioUnoFindDlgBean {
    
    private String nombre;
    
    private BigDecimal valor;
    
    private int tipo;

    @ManagedProperty("#{presupuestoFindDlgBean}")
    private PresupuestoFindDlgBean presupuestoFindDlgBean;
      
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public PresupuestoAnioUnoFindDlgBean() {

    }  

    public PresupuestoFindDlgBean getPresupuestoFindDlgBean() {
        return presupuestoFindDlgBean;
    }

    public void setPresupuestoFindDlgBean(PresupuestoFindDlgBean presupuestoFindDlgBean) {
        this.presupuestoFindDlgBean = presupuestoFindDlgBean;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
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
    
     public void definirComponentesActualizar() {
        try {
            
            if(this.getNombre().isEmpty() || this.getNombre() == null){
                throw new Exception("Debe ingresar el bien");
            }//fin if
            
            if(this.getValor() == null){
                throw new Exception("Debe ingresar el monto");
            }//fin if
            
            //AÑO UNO
            if(this.getProyectoWebBean().getProyectoWeb().
                                    getPresupuestoWebAnioUno() == null){
                
                this.getProyectoWebBean().getProyectoWeb().
                        setPresupuestoWebAnioUno(new PresupuestoPidWebDetallado());
                
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioUno().setProyectoWeb(
                        this.getProyectoWebBean().getProyectoWeb());
            }//fin if
            
            //AÑO DOS
            if(this.getProyectoWebBean().getProyectoWeb().
                                    getPresupuestoWebAnioDos() == null){
                
                this.getProyectoWebBean().getProyectoWeb().
                        setPresupuestoWebAnioDos(new PresupuestoPidWebDetalladoDos());
                
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioDos().setProyectoWeb(
                        this.getProyectoWebBean().getProyectoWeb());
            }//fin if
            
            //AÑO TRES
            if(this.getProyectoWebBean().getProyectoWeb().
                                    getPresupuestoWebAnioTres()== null){
                
                this.getProyectoWebBean().getProyectoWeb().
                        setPresupuestoWebAnioTres(new PresupuestoPidWebDetalladoTres());
                
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioTres().setProyectoWeb(
                        this.getProyectoWebBean().getProyectoWeb());
            }//fin if
            
             //AÑO CUATRO
            if(this.getProyectoWebBean().getProyectoWeb().
                                    getPresupuestoWebAnioCuatro()== null){
                
                this.getProyectoWebBean().getProyectoWeb().
                        setPresupuestoWebAnioCuatro(new PresupuestoPidWebDetalladoCuatro());
                
                this.getProyectoWebBean().getProyectoWeb().
                        getPresupuestoWebAnioCuatro().setProyectoWeb(
                        this.getProyectoWebBean().getProyectoWeb());
            }//fin if
            
            
            RequestContext context = RequestContext.getCurrentInstance();


            switch (this.getTipo()) {
                case 10: //bin consumo

                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienConsumoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioUno().setBienConsumoWeb(new ArrayList<BienConsumoPidWeb>());
                    }//fin if

                    BienConsumoPidWeb bcw = new BienConsumoPidWeb();
                    bcw.setDescripcion(this.getNombre());
                    bcw.setValor(this.getValor());

                    for (BienConsumoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienConsumoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bcw.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienConsumoWeb().add(bcw);
                    
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienConsumo(1);



                    context.update("frmUser:dtBienConsumoAU");
                    context.update("frmUser:otSubTotalBienConsumo");
                    context.update("frmUser:otTotalGasto");

                    break;
                case 11: //bien no persona
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienNoPersonalWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioUno().setBienNoPersonalWeb(new ArrayList<BienNoPersonalPidWeb>());
                    }//fin if

                    BienNoPersonalPidWeb bnpw = new BienNoPersonalPidWeb();
                    bnpw.setDescripcion(this.getNombre());
                    bnpw.setValor(this.getValor());

                    for (BienNoPersonalPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienNoPersonalWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bnpw.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienNoPersonalWeb().add(bnpw);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienNoPersonal(1);

                    context.update("frmUser:dtBienNoPersonalAU");
                    context.update("frmUser:otSubTotalBienNoPersonal");
                    context.update("frmUser:otTotalGasto");

                    break;

                case 12: //bin uso
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienUsoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioUno().setBienUsoWeb(new ArrayList<BienUsoPidWeb>());
                    }//fin if

                    BienUsoPidWeb buw = new BienUsoPidWeb();
                    buw.setDescripcion(this.getNombre());
                    buw.setValor(this.getValor());

                    for (BienUsoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienUsoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(buw.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getBienUsoWeb().add(buw);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienUso(1);

                    context.update("frmUser:dtBienUsoAU");
                    context.update("frmUser:otSubTotalBienUso");
                    context.update("frmUser:otTotalGasto");
                    break;
                    
                case 13: //gastos viajes
                    
                     if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getGastosViajeWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioUno().setGastosViajeWeb(new ArrayList<GastoViajePidWeb>());
                    }//fin if

                    GastoViajePidWeb gvw = new GastoViajePidWeb();
                    gvw.setDescripcion(this.getNombre());
                    gvw.setValor(this.getValor());

                    for (GastoViajePidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getGastosViajeWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(gvw.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioUno().getGastosViajeWeb().add(gvw);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosGastosViaje(1);
                    
                    context.update("frmUser:dtGastoViajeAU");
                    context.update("frmUser:otSubTotalGastoViaje");
                    context.update("frmUser:otTotalGasto");
                    break;
                    
                    //PARA EL AÑO DOS
                    
                    case 20: //bin consumo

                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienConsumoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioDos().setBienConsumoWeb(new ArrayList<BienConsumoPidWeb>());
                    }//fin if

                    BienConsumoPidWeb bcwd = new BienConsumoPidWeb();
                    bcwd.setDescripcion(this.getNombre());
                    bcwd.setValor(this.getValor());
                    
                    for (BienConsumoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienConsumoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bcwd.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for

                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienConsumoWeb().add(bcwd);
                    
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienConsumo(2);


                    context.update("frmUser:dtBienConsumoAD");
                    context.update("frmUser:otSubTotalBienConsumoAD");
                    context.update("frmUser:otTotalGastoAD");

                    break;
                case 21: //bien no persona
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienNoPersonalWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioDos().setBienNoPersonalWeb(new ArrayList<BienNoPersonalPidWeb>());
                    }//fin if

                    BienNoPersonalPidWeb bnpwd = new BienNoPersonalPidWeb();
                    bnpwd.setDescripcion(this.getNombre());
                    bnpwd.setValor(this.getValor());

                    for (BienNoPersonalPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienNoPersonalWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bnpwd.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienNoPersonalWeb().add(bnpwd);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienNoPersonal(2);

                    context.update("frmUser:dtBienNoPersonalAD");
                    context.update("frmUser:otSubTotalBienNoPersonalAD");
                    context.update("frmUser:otTotalGastoAD");

                    break;

                case 22: //bin uso
                    
                    System.out.println("Entro al 22");
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienUsoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioDos().setBienUsoWeb(new ArrayList<BienUsoPidWeb>());
                    }//fin if

                    BienUsoPidWeb buwd = new BienUsoPidWeb();
                    buwd.setDescripcion(this.getNombre());
                    buwd.setValor(this.getValor());

                    for (BienUsoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienUsoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(buwd.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getBienUsoWeb().add(buwd);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienUso(2);

                    context.update("frmUser:dtBienUsoAD");
                    context.update("frmUser:otSubTotalBienUsoAD");
                    context.update("frmUser:otTotalGastoAD");
                    break;
                    
                case 23: //gastos viajes
                    
                     if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getGastosViajeWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioDos().setGastosViajeWeb(new ArrayList<GastoViajePidWeb>());
                    }//fin if

                    GastoViajePidWeb gvwd = new GastoViajePidWeb();
                    gvwd.setDescripcion(this.getNombre());
                    gvwd.setValor(this.getValor());

                    for (GastoViajePidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getGastosViajeWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(gvwd.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioDos().getGastosViajeWeb().add(gvwd);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosGastosViaje(2);
                    
                    context.update("frmUser:dtGastoViajeAD");
                    context.update("frmUser:otSubTotalGastoViajeAD");
                    context.update("frmUser:otTotalGastoAD");
                    break;
                
                //PARA EL AÑO TRES
                    
                    case 30: //bin consumo

                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienConsumoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioTres().setBienConsumoWeb(new ArrayList<BienConsumoPidWeb>());
                    }//fin if
                    

                    BienConsumoPidWeb bcwt = new BienConsumoPidWeb();
                    bcwt.setDescripcion(this.getNombre());
                    bcwt.setValor(this.getValor());

                    
                    for (BienConsumoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienConsumoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bcwt.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for

                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienConsumoWeb().add(bcwt);
                    
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienConsumo(3);


                    context.update("frmUser:dtBienConsumoAT");
                    context.update("frmUser:otSubTotalBienConsumoAT");
                    context.update("frmUser:otTotalGastoAT");

                    break;
                case 31: //bien no persona
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienNoPersonalWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioTres().setBienNoPersonalWeb(new ArrayList<BienNoPersonalPidWeb>());
                    }//fin if

                    BienNoPersonalPidWeb bnpwt = new BienNoPersonalPidWeb();
                    bnpwt.setDescripcion(this.getNombre());
                    bnpwt.setValor(this.getValor());

                    for (BienNoPersonalPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienNoPersonalWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bnpwt.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienNoPersonalWeb().add(bnpwt);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienNoPersonal(3);

                    context.update("frmUser:dtBienNoPersonalAT");
                    context.update("frmUser:otSubTotalBienNoPersonalAT");
                    context.update("frmUser:otTotalGastoAT");

                    break;

                case 32: //bin uso
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienUsoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioTres().setBienUsoWeb(new ArrayList<BienUsoPidWeb>());
                    }//fin if

                    BienUsoPidWeb buwt = new BienUsoPidWeb();
                    buwt.setDescripcion(this.getNombre());
                    buwt.setValor(this.getValor());

                    for (BienUsoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienUsoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(buwt.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getBienUsoWeb().add(buwt);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienUso(3);
                    

                    context.update("frmUser:dtBienUsoAT");
                    context.update("frmUser:otSubTotalBienUsoAT");
                    context.update("frmUser:otTotalGastoAT");
                    break;
                    
                case 33: //gastos viajes
                    
                     if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getGastosViajeWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioTres().setGastosViajeWeb(new ArrayList<GastoViajePidWeb>());
                    }//fin if

                    GastoViajePidWeb gvwt = new GastoViajePidWeb();
                    gvwt.setDescripcion(this.getNombre());
                    gvwt.setValor(this.getValor());

                    for (GastoViajePidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getGastosViajeWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(gvwt.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioTres().getGastosViajeWeb().add(gvwt);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosGastosViaje(3);
                    
                    context.update("frmUser:dtGastoViajeAT");
                    context.update("frmUser:otSubTotalGastoViajeAT");
                    context.update("frmUser:otTotalGastoAT");
                    break;
                    
                    //PARA EL AÑO CUATRO
                    
                    case 40: //bin consumo

                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienConsumoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioCuatro().setBienConsumoWeb(new ArrayList<BienConsumoPidWeb>());
                    }//fin if
                    

                    BienConsumoPidWeb bcwc = new BienConsumoPidWeb();
                    bcwc.setDescripcion(this.getNombre());
                    bcwc.setValor(this.getValor());

                    
                    for (BienConsumoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienConsumoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bcwc.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for

                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienConsumoWeb().add(bcwc);
                    
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienConsumo(4);


                    context.update("frmUser:dtBienConsumoAC");
                    context.update("frmUser:otSubTotalBienConsumoAC");
                    context.update("frmUser:otTotalGastoAC");

                    break;
                case 41: //bien no persona
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienNoPersonalWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioCuatro().setBienNoPersonalWeb(new ArrayList<BienNoPersonalPidWeb>());
                    }//fin if

                    BienNoPersonalPidWeb bnpwc = new BienNoPersonalPidWeb();
                    bnpwc.setDescripcion(this.getNombre());
                    bnpwc.setValor(this.getValor());

                    for (BienNoPersonalPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienNoPersonalWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(bnpwc.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienNoPersonalWeb().add(bnpwc);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienNoPersonal(4);

                    context.update("frmUser:dtBienNoPersonalAC");
                    context.update("frmUser:otSubTotalBienNoPersonalAC");
                    context.update("frmUser:otTotalGastoAC");

                    break;

                case 42: //bin uso
                    
                    if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienUsoWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioCuatro().setBienUsoWeb(new ArrayList<BienUsoPidWeb>());
                    }//fin if

                    BienUsoPidWeb buwc = new BienUsoPidWeb();
                    buwc.setDescripcion(this.getNombre());
                    buwc.setValor(this.getValor());

                    for (BienUsoPidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienUsoWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(buwc.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getBienUsoWeb().add(buwc);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosBienUso(4);

                    context.update("frmUser:dtBienUsoAC");
                    context.update("frmUser:otSubTotalBienUsoAC");
                    context.update("frmUser:otTotalGastoAC");
                    break;
                    
                case 43: //gastos viajes
                    
                     if (this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getGastosViajeWeb() == null) {


                        this.getProyectoWebBean().getProyectoWeb().
                                getPresupuestoWebAnioCuatro().setGastosViajeWeb(new ArrayList<GastoViajePidWeb>());
                    }//fin if

                    GastoViajePidWeb gvwc = new GastoViajePidWeb();
                    gvwc.setDescripcion(this.getNombre());
                    gvwc.setValor(this.getValor());

                    for (GastoViajePidWeb b : this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getGastosViajeWeb()) {

                        if (b.getDescripcion().trim().toLowerCase().equals(gvwc.getDescripcion().trim().toLowerCase())) {
                            throw new Exception("Ya esta cargado el gasto " + b.getDescripcion());
                        }//fin if

                    }//fin for


                    this.getProyectoWebBean().getProyectoWeb().
                            getPresupuestoWebAnioCuatro().getGastosViajeWeb().add(gvwc);
                    
                    //llama a  presupuestoFind
                    this.getPresupuestoFindDlgBean().actualizarPresupuestoAniosGastosViaje(4);
                    
                    context.update("frmUser:dtGastoViajeAC");
                    context.update("frmUser:otSubTotalGastoViajeAC");
                    context.update("frmUser:otTotalGastoAC");
                    break;
                    
            }//fin switch

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar
    
}
