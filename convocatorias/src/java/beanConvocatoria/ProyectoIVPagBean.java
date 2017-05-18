/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyectoWeb.ParticipacionWeb;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class ProyectoIVPagBean {

    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public ProyectoIVPagBean() {
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    public void quitarParticipacionWeb(ParticipacionWeb p){
        
        int cantPart = this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().size();
        for(int i=0; i < cantPart; i++){
            
            if(this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(i).getInvestigador()!=null){
            if(this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().get(i).getInvestigador().equals(p.getInvestigador())){
                this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().remove(i);
                break;
            }//fin if
            }
            
        }//fin for
        
    }//fin quitarParticipacionWeb
}
