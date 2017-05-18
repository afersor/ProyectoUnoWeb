/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.AreaTematica;
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
public class AreaTematicaBean {

    @ManagedProperty("#{disciplinaCientificaLstBean}")
    private DisciplinaCientificaLstBean disciplinaCientificaLstBean;
    
    public AreaTematicaBean() {
    }

    public DisciplinaCientificaLstBean getDisciplinaCientificaLstBean() {
        return disciplinaCientificaLstBean;
    }

    public void setDisciplinaCientificaLstBean(DisciplinaCientificaLstBean disciplinaCientificaLstBean) {
        this.disciplinaCientificaLstBean = disciplinaCientificaLstBean;
    }
        
    //cambio del valor del combo
    public void handleChange(ValueChangeEvent event){  

        if(event.getNewValue()!=null){
        if(!event.getNewValue().equals("Seleccionar")){
       // if(event.getNewValue() != null){
            this.getDisciplinaCientificaLstBean().setLstDisciplinaCientifica(
                ((AreaTematica)event.getNewValue()).getDisciplinasCientificas());
        
            this.getDisciplinaCientificaLstBean().cargarSIDisplinasCientificas();
        }//fin if
        }
    }//fin handleChange
}
