/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class PosicionMapaBean {

    private MapModel draggableModel;
     
    private Marker marker;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public PosicionMapaBean() {
        draggableModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coordCatamarca = new LatLng(-28.46890823359409, -65.77899905009463);

          
        //Draggable
        draggableModel.addOverlay(new Marker(coordCatamarca, "Seleccion"));

          
        for(Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }//fin for
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    
    @PostConstruct
    public void init() {
        
    }//fin init
    
    public MapModel getDraggableModel() {
        return draggableModel;
    }
      
    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();
        
        this.getProyectoWebBean().getProyectoWeb().setLatitud(marker.getLatlng().getLat());
        this.getProyectoWebBean().getProyectoWeb().setLongitud(marker.getLatlng().getLng());
        
        System.out.println("Posicion select: " + "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng());
    }
    
}
