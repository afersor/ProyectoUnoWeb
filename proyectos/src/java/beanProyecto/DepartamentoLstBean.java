/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.localidad.Departamento;
import entidades.localidad.Provincia;
import entidades.localidad.RN.DepartamentoRNLocal;
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
public class DepartamentoLstBean {

    private List<Departamento> lstDepartamento;
    
    private List<SelectItem> lstSIDepartamento;
    
    @EJB
    private DepartamentoRNLocal departamentoRNLocal;
    
    public DepartamentoLstBean() {
    }

    public List<Departamento> getLstDepartamento() {
        return lstDepartamento;
    }

    public void setLstDepartamento(List<Departamento> lstDepartamento) {
        this.lstDepartamento = lstDepartamento;
    }

    public List<SelectItem> getLstSIDepartamento() {
        return lstSIDepartamento;
    }

    public void setLstSIDepartamento(List<SelectItem> lstSIDepartamento) {
        this.lstSIDepartamento = lstSIDepartamento;
    }
    
    
    public void findDepartamentosByProvincia(Provincia p) throws Exception{
        this.setLstDepartamento(this.departamentoRNLocal.findDepartamentosByProvincia(p));
    }//fin findDepartamentos()
    
    public void cargarSIDepartamentos(){
        this.setLstSIDepartamento(new ArrayList<SelectItem>());
        for(Departamento sdc : this.getLstDepartamento()){
            SelectItem si = new SelectItem(sdc, sdc.getDescripcion());
            this.getLstSIDepartamento().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
}
