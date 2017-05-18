/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.persona.RN.SexoRNLocal;
import entidades.persona.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;


/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class SexoLstBean {

     private List<Sexo> lstSexo;
    
    private List<SelectItem> lstSISexo;
    
    @EJB
    private SexoRNLocal tipoDocumentoRNLocal;
    
    public SexoLstBean() {
    }

    public List<Sexo> getLstSexo() {
        return lstSexo;
    }

    public void setLstSexo(List<Sexo> lstSexo) {
        this.lstSexo = lstSexo;
    }

    public List<SelectItem> getLstSISexo() {
        return lstSISexo;
    }

    public void setLstSISexo(List<SelectItem> lstSISexo) {
        this.lstSISexo = lstSISexo;
    }
    
    public void findSexos() throws Exception{
        this.setLstSexo(this.tipoDocumentoRNLocal.findSexos());
    }//fin findSexos()
    
    public void cargarSISexos(){
        this.setLstSISexo(new ArrayList<SelectItem>());
        for(Sexo s : this.getLstSexo()){
            SelectItem si = new SelectItem(s, s.getDescripcion());
            this.getLstSISexo().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
}
