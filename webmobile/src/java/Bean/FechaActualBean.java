/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author USUARIO
 */
@ManagedBean(name="fechaActualBean")
@ApplicationScoped
public class FechaActualBean implements Serializable{

    private String fechaActual;
    /** Creates a new instance of FechaActualBean */
    public FechaActualBean() {
    }

    public String getFechaActual() {
        Calendar diaActual = Calendar.getInstance();
        int iDiaSemana = diaActual.get(diaActual.DAY_OF_WEEK)-2;
        int iDia = diaActual.get(diaActual.DATE);
        int iMes = diaActual.get(diaActual.MONTH);
        int iAno = diaActual.get(diaActual.YEAR);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String sDia="";
        
        switch(iDiaSemana){
            case -1:
                sDia = "Domingo";
                break;
            case 0:
                sDia = "Lunes";
                break;
             case 1:
                sDia = "Martes";
                break;
             case 2:
                sDia = "Miercoles";
                break;
             case 3:
                sDia = "Jueves";
                break;
             case 4:
                sDia = "Viernes";
                break;
             case 5:
                sDia = "Sabado";
                break;
             
        }//finswitch
        
        String sMes = "";
        switch(iMes){
            case 0:
                sMes="enero";
                break;
            case 1:
                sMes="febrero";
                break;
            case 2:
                sMes="marzo";
                break;
            case 3:
                sMes="abril";
                break;
            case 4:
                sMes="mayo";
                break;
            case 5:
                sMes="junio";
                break;
            case 6:
                sMes="julio";
                break;
            case 7:
                sMes="agosto";
                break;
            case 8:
                sMes="septiembre";
                break;
            case 9:
                sMes="octubre";
                break;
            case 10:
                sMes="noviembre";
                break;
            case 11:
                sMes="diciembre";
                break;
                
        }//findel switch

        return sDia + ", " + iDia + " de " + sMes + " de " + iAno;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }



}
