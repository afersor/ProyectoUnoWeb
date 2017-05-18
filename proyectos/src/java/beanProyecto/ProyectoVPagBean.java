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
import entidades.proyectoPidWeb.RecursoSubsidioPid;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class ProyectoVPagBean {

     private int contador=0;
     
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public ProyectoVPagBean() {
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    
    //1-Plan de ejecución financiera para los dos y/o cuatro años:
    public BigDecimal calcularTotal(PresupuestoPidWeb presupuestoWeb){
        BigDecimal bdSuma = new BigDecimal(0);
        
        if(presupuestoWeb.getBienConsumo() != null){
            for(BienConsumo bc : presupuestoWeb.getBienConsumo()){
                bdSuma = bdSuma.add(bc.getValor());
            }//fin for
            
        }//fin if
        
        
        
        if(presupuestoWeb.getBienNoPersonal() != null){
            for(BienNoPersonal bnp : presupuestoWeb.getBienNoPersonal()){
                bdSuma = bdSuma.add(bnp.getValor());
            }//fin for
            
        }//fin if
        
        
        if(presupuestoWeb.getBienUso() != null){
            for(BienUso bu : presupuestoWeb.getBienUso()){
                bdSuma = bdSuma.add(bu.getValor());
            }//fin for
            
        }//fin if
        
        if(presupuestoWeb.getGastosViaje() != null){
            for(GastoViaje gv : presupuestoWeb.getGastosViaje()){
                bdSuma = bdSuma.add(gv.getValor());
            }//fin for

        }//fin if
        
        return bdSuma;
    }//fin calcularTotal
     
    public BigDecimal calcularTotalColumna(PresupuestoPidWeb presupuestoWeb){
        

        BigDecimal bdSuma = new BigDecimal(0);
        
        try{
        if(presupuestoWeb.getBienConsumo() != null){
            bdSuma = bdSuma.add(presupuestoWeb.getBienConsumo().get(this.contador).getValor());
        }//fin if
        
        
        
        if(presupuestoWeb.getBienNoPersonal() != null){
            bdSuma = bdSuma.add(presupuestoWeb.getBienNoPersonal().get(this.contador).getValor());
        }//fin if
        
        
        if(presupuestoWeb.getBienUso() != null){
            bdSuma = bdSuma.add(presupuestoWeb.getBienUso().get(this.contador).getValor());
        }//fin if
        
        if(presupuestoWeb.getGastosViaje() != null){
            bdSuma = bdSuma.add(presupuestoWeb.getGastosViaje().get(this.contador).getValor());
        }//fin if
        
        }catch(Exception e){
            
        }
        
        
        contador++;
        return bdSuma;
    }//fin
    
    public BigDecimal calcularTotalFila(List lista, int tipo){
        
        BigDecimal bdSuma = new BigDecimal(0);
        
        for(int i=0; i < lista.size(); i++){
            switch(tipo){
                case 0:
                    bdSuma = bdSuma.add(((BienConsumo)lista.get(i)).getValor());

                    break;
                case 1:
                    bdSuma = bdSuma.add( ((BienNoPersonal)lista.get(i)).getValor());
                    break;
                case 2:
                    bdSuma = bdSuma.add( ((BienUso)lista.get(i)).getValor());
                    break;
                case 3:
                    bdSuma = bdSuma.add( ((GastoViaje)lista.get(i)).getValor());
                    break;
            }

        }//FIN FOR
        
        return bdSuma;
    }//fin
    
    
    //3-Plan de ejecución financiera para el primer año:
    

    public BigDecimal obtenerSubTotalBienConsumo(int tipo) {
        BigDecimal suma = BigDecimal.ZERO;
        
        switch(tipo){
            case 1:
                if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno() != null) {
                    if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienConsumoWeb() != null) {
                        for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienConsumoWeb()) {
                            suma = suma.add(bcw.getValor());
                        }//fin for
                    }//fin if
                }
                break;
           case 2:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos()!= null) {
                    if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienConsumoWeb() != null) {
                        for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienConsumoWeb()) {
                            suma = suma.add(bcw.getValor());
                        }//fin for
                    }//fin if
                }
                break;
          case 3:
              
              if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres()!= null) {
                    if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienConsumoWeb() != null) {
                        for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienConsumoWeb()) {
                            suma = suma.add(bcw.getValor());
                        }//fin for
                    }//fin if
                }
                break;
           case 4:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro()!= null) {
                    if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienConsumoWeb() != null) {
                        for (BienConsumoPidWeb bcw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienConsumoWeb()) {
                            suma = suma.add(bcw.getValor());
                        }//fin for
                    }//fin if
                }
               
                break;
                
        }//sin switch
        
        

        return suma;
       
   }//fin obtenerSubTotalBienConsumo
    
   public BigDecimal obtenerSubTotalBienNoPersonal(int tipo){
       
       BigDecimal suma = BigDecimal.ZERO;
       switch(tipo){
           case 1:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno() != null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienNoPersonalWeb() != null) {
                       for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienNoPersonalWeb()) {
                           suma = suma.add(bnpw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
           case 2:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienNoPersonalWeb() != null) {
                       for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienNoPersonalWeb()) {
                           suma = suma.add(bnpw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
           case 3:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienNoPersonalWeb() != null) {
                       for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienNoPersonalWeb()) {
                           suma = suma.add(bnpw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
           case 4:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienNoPersonalWeb() != null) {
                       for (BienNoPersonalPidWeb bnpw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienNoPersonalWeb()) {
                           suma = suma.add(bnpw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
               
       }//fin switch
       
        

        return suma;
       
   }//fin obtenerSubTotalBienNoPersonal
   
   public BigDecimal obtenerSubTotalBienUso(int tipo){
       BigDecimal suma = BigDecimal.ZERO;
       switch(tipo){
           case 1:
                
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno() != null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienUsoWeb() != null) {
                       for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienUsoWeb()) {
                           suma = suma.add(buw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               
               break;
           case 2:
               
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienUsoWeb() != null) {
                       for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienUsoWeb()) {
                           suma = suma.add(buw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
           case 3:
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienUsoWeb() != null) {
                       for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienUsoWeb()) {
                           suma = suma.add(buw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
           case 4:
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienUsoWeb() != null) {
                       for (BienUsoPidWeb buw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienUsoWeb()) {
                           suma = suma.add(buw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
       }
       

        return suma;
       
   }//fin obtenerSubTotalBienUso
   
   public BigDecimal obtenerSubTotalGastoViajes(int tipo){
       
       BigDecimal suma = BigDecimal.ZERO;
       switch(tipo){
           case 1:
        
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno() != null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getGastosViajeWeb() != null) {
                       for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getGastosViajeWeb()) {
                           suma = suma.add(gvw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
          
           case 2:
                             
               if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getGastosViajeWeb() != null) {
                       for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getGastosViajeWeb()) {
                           suma = suma.add(gvw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               
               break;
               
          case 3:
              
              if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getGastosViajeWeb() != null) {
                       for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getGastosViajeWeb()) {
                           suma = suma.add(gvw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
              
               break;
              
          case 4:
              if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro()!= null) {
                   if (this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getGastosViajeWeb() != null) {
                       for (GastoViajePidWeb gvw : this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getGastosViajeWeb()) {
                           suma = suma.add(gvw.getValor());
                       }//fin for
                   }//fin if
               }//fin if
               break;
       }
       
        

        return suma;
       
   }//fin obtenerSubTotalGastoViajes

   public BigDecimal obtenerTotalGastos(int tipo){
       
        
        return this.obtenerSubTotalBienConsumo(tipo).add(
                this.obtenerSubTotalBienNoPersonal(tipo)).add(
                this.obtenerSubTotalBienUso(tipo)).add(
                this.obtenerSubTotalGastoViajes(tipo));
       
   }//fin obtenerSubTotalGastoViajes
   
   public void quitarBienConsumoAnios(BienConsumoPidWeb bc, int anio){
       
       switch(anio){
           case 1:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienConsumoWeb().remove(bc);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().get(0).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().
                       get(0).getValor().subtract(bc.getValor()));
               
               RequestContext.getCurrentInstance().update("frmUser:dtBienConsumoAU");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienConsumo");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGasto");
               break;
               
           case 2:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienConsumoWeb().remove(bc);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().get(1).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().
                       get(1).getValor().subtract(bc.getValor()));
               
               RequestContext.getCurrentInstance().update("frmUser:dtBienConsumoAD");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienConsumoAD");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAD");
               
               break;
           case 3:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienConsumoWeb().remove(bc);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().get(2).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().
                       get(2).getValor().subtract(bc.getValor()));
               
               RequestContext.getCurrentInstance().update("frmUser:dtBienConsumoAT");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienConsumoAT");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAT");
               
               break;
           case 4:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienConsumoWeb().remove(bc);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().get(3).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienConsumo().
                       get(3).getValor().subtract(bc.getValor()));
               
               RequestContext.getCurrentInstance().update("frmUser:dtBienConsumoAC");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienConsumoAC");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAC");
               
               break;
       }//fin switch
        
        
        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");
       
        
    }//fin quitarSubDisciplinaCientifica
    
    public void quitarBienNoPersonalAnios(BienNoPersonalPidWeb bnp, int anio){
        
        switch(anio){
           case 1:
                this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienNoPersonalWeb().remove(bnp);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().get(0).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().
                       get(0).getValor().subtract(bnp.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienNoPersonalAU");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienNoPersonal");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGasto");
               break;
           case 2:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienNoPersonalWeb().remove(bnp);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().get(1).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().
                       get(1).getValor().subtract(bnp.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienNoPersonalAD");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienNoPersonalAD");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAD");
               break;
           case 3:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienNoPersonalWeb().remove(bnp);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().get(2).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().
                       get(2).getValor().subtract(bnp.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienNoPersonalAT");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienNoPersonalAT");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAT");
               break;
           case 4:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienNoPersonalWeb().remove(bnp);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().get(3).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienNoPersonal().
                       get(3).getValor().subtract(bnp.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienNoPersonalAC");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienNoPersonalAC");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAC");
               break;
        }//fin switch
        
        
        
        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");
        
        
        
    }//fin quitarBienNoPersonalAnioUno
    
    public void quitarBienUsoAnios(BienUsoPidWeb bu, int anio){
        
        switch(anio){
           case 1:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getBienUsoWeb().remove(bu);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().get(0).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().
                       get(0).getValor().subtract(bu.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienUsoAU");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienUso");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGasto");
               break;
           case 2:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getBienUsoWeb().remove(bu);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().get(1).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().
                       get(1).getValor().subtract(bu.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienUsoAD");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienUsoAD");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAD");
               break;
           case 3:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getBienUsoWeb().remove(bu);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().get(2).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().
                       get(2).getValor().subtract(bu.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienUsoAT");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienUsoAT");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAT");
               break;
           case 4:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getBienUsoWeb().remove(bu);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().get(3).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getBienUso().
                       get(3).getValor().subtract(bu.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtBienUsoAC");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalBienUsoAC");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAC");
               break;
        }//fin switch
        
        
        
        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");
        
    }//fin quitarSubDisciplinaCientifica
    
    public void quitarGastoViajeAnios(GastoViajePidWeb gv, int anio){
        
        switch(anio){
           case 1:
               
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno().getGastosViajeWeb().remove(gv);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().get(0).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().
                       get(0).getValor().subtract(gv.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtGastoViajeAU");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalGastoViaje");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGasto");
        
               break;
           case 2:
               
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioDos().getGastosViajeWeb().remove(gv);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().get(1).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().
                       get(1).getValor().subtract(gv.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtGastoViajeAD");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalGastoViajeAD");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAD");
               
               break;
           case 3:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioTres().getGastosViajeWeb().remove(gv);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().get(2).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().
                       get(2).getValor().subtract(gv.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtGastoViajeAT");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalGastoViajeAT");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAT");
               break;
           case 4:
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioCuatro().getGastosViajeWeb().remove(gv);

               //para actualizar los valore de la tabla presupuesto dos o cuatro años
               this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().get(3).setValor(
                       this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb().getGastosViaje().
                       get(3).getValor().subtract(gv.getValor()));
               RequestContext.getCurrentInstance().update("frmUser:dtGastoViajeAC");
               RequestContext.getCurrentInstance().update("frmUser:otSubTotalGastoViajeAC");
               RequestContext.getCurrentInstance().update("frmUser:otTotalGastoAC");
               break;
        }//fin switch
            
        
        
        RequestContext.getCurrentInstance().update("frmUser:dtPresupuesto");
        
    }//fin quitarSubDisciplinaCientifica
    
    
    //4-Resursos provistos por otras instituciones para el proyecto:
    public void quitarRecursoSubsidio(RecursoSubsidioPid rs){
        this.getProyectoWebBean().getProyectoWeb().getRecursosSubsidios().remove(rs);
    }//fin quitarSubDisciplinaCientifica
}//fin clase
