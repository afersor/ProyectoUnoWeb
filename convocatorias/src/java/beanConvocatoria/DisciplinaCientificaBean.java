/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.DisciplinaCientifica;
import entidades.proyecto.SubDisciplinaCientifica;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;



/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class DisciplinaCientificaBean {

    @ManagedProperty("#{subDisciplinaCientificaLstBean}")
    private SubDisciplinaCientificaLstBean subDisciplinaCientificaLstBean;
    
    public DisciplinaCientificaBean() {
    }

    public SubDisciplinaCientificaLstBean getSubDisciplinaCientificaLstBean() {
        return subDisciplinaCientificaLstBean;
    }

    public void setSubDisciplinaCientificaLstBean(SubDisciplinaCientificaLstBean subDisciplinaCientificaLstBean) {
        this.subDisciplinaCientificaLstBean = subDisciplinaCientificaLstBean;
    }
    
    //cambio del valor del combo
    public void handleChange(ValueChangeEvent event){  
        
        if (!event.getNewValue().equals("Seleccionar")) {
       // if(event.getNewValue() != null){
            this.getSubDisciplinaCientificaLstBean().setLstSubDisciplinaCientifica(
                    ((DisciplinaCientifica) event.getNewValue()).getSubDisciplinasCientificas());

            this.getSubDisciplinaCientificaLstBean().cargarSISubDisciplinasCientificas();
        }//fin if
    }//fin handleChange
}
