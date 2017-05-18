/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author AFerSor
 */
@FacesConverter(value="ConversorAprobadoProyecto")
public class ConversorAprobadoProyecto implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Boolean bValue = (Boolean)value;
        
        if(bValue){
            return "Aprobado";
        }else{
            return "En revisión";
        }//fin else
    }
    
}
