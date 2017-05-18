/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.RN.RolRNLocal;
import entidades.proyecto.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class RolLstBean implements Serializable {

    private List<Rol> lstRol;
    private List<SelectItem> lstSIRol;

    @EJB
    private RolRNLocal rolRNLocal;

    public RolLstBean() {
    }

    public List<Rol> getLstRol() {
        return lstRol;
    }

    public void setLstRol(List<Rol> lstRol) {
        this.lstRol = lstRol;
    }

    public List<SelectItem> getLstSIRol() {
        return lstSIRol;
    }

    public void setLstSIRol(List<SelectItem> lstSIRol) {
        this.lstSIRol = lstSIRol;
    }

    public void findRolesSinDirector() throws Exception {
        this.setLstRol(rolRNLocal.findRolesSinDirector());
    }//fin findRolesSinDirector

    public void findRolesSinDirectorCoDirector() throws Exception {
        this.setLstRol(rolRNLocal.findRolesSinDirectorCoDirector());
    }//fin findRolesSinDirector

    public void cargarSIRolesSinDirector() {
        this.setLstSIRol(new ArrayList<SelectItem>());
        int i = 1;
        System.out.println("lista de roles: "+this.getLstRol());
        // OCULTAMOS EL ASESOR POR PEDIDO DEL DECANO DE SALUD (JAJAJ QUE PARCHE)
        for (Rol rol : this.getLstRol()) {
            if (!rol.getDescripcion().equals("Asesor")) {
                    SelectItem si = new SelectItem(rol, rol.getDescripcion());
                    this.getLstSIRol().add(si);
                }//fin if
            i++;
        }//fin 
    }//fin cargarSIRolesSinDirector

    public void cargarSIRolesSinDirectorCoDirector() {
        this.setLstSIRol(new ArrayList<SelectItem>());
        for (Rol r : this.getLstRol()) {

            SelectItem si = new SelectItem(r, r.getDescripcion());
            this.getLstSIRol().add(si);

        }//fin for
    }//fin cargarSIRolesSinDirector


}
