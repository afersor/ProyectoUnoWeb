/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@FacesValidator("validarNumeroDosDecimales")
public class ValidarNumeroDosDecimales implements Validator {

    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        if(o!=null){
        if(!o.toString().matches("\\d+.\\d\\d")){
       
            FacesMessage msg = 
				new FacesMessage("Debe ingresar un número con dos decimales separados por un punto");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }//fin if
        }//fin if
        
    }
    
}//FIN CLASE
