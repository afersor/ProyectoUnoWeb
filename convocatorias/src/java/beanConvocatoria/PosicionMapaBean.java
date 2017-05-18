/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.PointSelectEvent;
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
    @ManagedProperty("#{ubicacionBean}")
    private UbicacionBean ubicacionBean;

    public void entrar() {
        draggableModel = new DefaultMapModel();

        //Shared coordinates
        LatLng coordCatamarca = null;
        System.out.println("entrar: " + this.getProyectoWebBean().getProyectoWeb().getLatitud());
        if (this.getProyectoWebBean().getProyectoWeb().getLatitud() != -28.46890823359409) {
            coordCatamarca = new LatLng(this.getProyectoWebBean().getProyectoWeb().getLatitud(),
                    this.getProyectoWebBean().getProyectoWeb().getLongitud());
        } else {
            coordCatamarca = new LatLng(-28.46890823359409, -65.77899905009463);
        }

        //Draggable
        draggableModel.addOverlay(new Marker(coordCatamarca, "Seleccion"));

        for (Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }//fin for
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }

    public UbicacionBean getUbicacionBean() {
        return ubicacionBean;
    }

    public void setUbicacionBean(UbicacionBean ubicacionBean) {
        this.ubicacionBean = ubicacionBean;
    }

    public MapModel getDraggableModel() {
        return draggableModel;
    }

    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();

        this.getProyectoWebBean().getProyectoWeb().setLatitud(marker.getLatlng().getLat());
        this.getProyectoWebBean().getProyectoWeb().setLongitud(marker.getLatlng().getLng());

    }

    public void onMarkerDragUbicacion(MarkerDragEvent event) {
        marker = event.getMarker();
        this.getUbicacionBean().getUbicacion().setLatitud(marker.getLatlng().getLat());
        this.getUbicacionBean().getUbicacion().setLongitud(marker.getLatlng().getLng());

    }

    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        draggableModel.getMarkers().get(0).setLatlng(latlng);
        //draggableModel.addOverlay(marker);
        this.getProyectoWebBean().getProyectoWeb().setLatitud(latlng.getLat());
        this.getProyectoWebBean().getProyectoWeb().setLongitud(latlng.getLng());

    }

    public void onPointSelectUbicacion(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        draggableModel.getMarkers().get(0).setLatlng(latlng);
        //draggableModel.addOverlay(marker);
        this.getUbicacionBean().getUbicacion().setLatitud(latlng.getLat());
        this.getUbicacionBean().getUbicacion().setLongitud(latlng.getLng());

    }

    public void setPointSelect(double latitud, double longitud) {
        LatLng latlng = new LatLng(latitud, longitud);
        draggableModel.getMarkers().get(0);
    }

}
