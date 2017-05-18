/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class MensajeBean implements Serializable{

    private String mensaje;
    private String pagCerrar;
    private char tipoIcono;
    
    public MensajeBean() {
    }

    public char getTipoIcono() {
        return tipoIcono;
    }

    public void setTipoIcono(char tipoIcono) {
        this.tipoIcono = tipoIcono;
    }    

    public String getPagCerrar() {
        return pagCerrar;
    }

    public void setPagCerrar(String pagCerrar) {
        this.pagCerrar = pagCerrar;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        
        this.mensaje = mensaje;
    }
    
    public String icono(){
        String nombreIcono = "";
        switch(this.getTipoIcono()){
            
            case 'I': //informacion
                nombreIcono = "/resources/imagenes/info.ico";
                break;

            case 'A': //advertencia
                nombreIcono = "/resources/imagenes/warning.ico";
                break;
                
            case 'R' : //error
                nombreIcono = "/resources/imagenes/error.png";
                break;

        }//fin switch
        return nombreIcono ;
    }//icono
    
    public void cerrar(){
        RequestContext.getCurrentInstance().execute("dlgMensaje.hide();");
        
        if( this.getPagCerrar() != null && !this.getPagCerrar().isEmpty()){
            
           RequestContext.getCurrentInstance().execute(this.getPagCerrar()); 
        }//fin if
        
    }//fin cerrar
    
}
