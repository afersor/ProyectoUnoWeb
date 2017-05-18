/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import entidades.localidad.RN.DepartamentoRNLocal;
import entidades.localidad.RN.LocalidadRNLocal;
import entidades.proyecto.AreaTematica;
import entidades.proyecto.DisciplinaCientifica;
import entidades.proyecto.ProyectoDatosComplementarios;
import entidades.proyecto.RN.AreaTematicaRNLocal;
import entidades.proyecto.RN.DisciplinaCientificaRNLocal;
import entidades.proyecto.RN.ProyectoDatosComplementariosRNLocal;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author hugo
 */
@ManagedBean
@ViewScoped
public class MapaBean implements Serializable {

    @EJB
    private ProyectoDatosComplementariosRNLocal proyectoDatosComplementariosRNLocal;
    @EJB
    private AreaTematicaRNLocal areaTematicaRNLocal;

    @EJB
    private DisciplinaCientificaRNLocal disciplinaCientificaRNLocal;

    @EJB
    private DepartamentoRNLocal departamentoRNLocal;

    @EJB
    private LocalidadRNLocal localidadRNLocal;

    private List<AreaTematica> areaTematicas;
    private AreaTematica areaTematica;

    private List<DisciplinaCientifica> disciplinaCientificas;
    private DisciplinaCientifica disciplinaCientifica;

    private List<Departamento> departamentos;
    private Departamento departamento;

    private List<Localidad> localidades;
    private Localidad localidad;

    private List<SelectItem> listaDepartamentos;
    private List<SelectItem> listaLocalidades;
    private String titulo;
    private Long areaTematicaL;
    private Long disciplinaCientificaL;
    private Long localidadL;
    private Long departamentoL;
    private List<ProyectoDatosComplementarios> proyectos = new ArrayList<ProyectoDatosComplementarios>();
    private Marker marker;
    private MapModel simpleModel = new DefaultMapModel();
    private List<Marker> markers = new ArrayList<Marker>();

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }

    public List<ProyectoDatosComplementarios> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<ProyectoDatosComplementarios> proyectos) {
        this.proyectos = proyectos;
    }

    public void mostrarMarcadores() {
        simpleModel = new DefaultMapModel();
        for (Marker markerLista : markers) {
            simpleModel.addOverlay(markerLista);
        }
    }

    public void cargarMarcadores(List<ProyectoDatosComplementarios> proyectos) {
        try {
            //Shared coordinates

            for (ProyectoDatosComplementarios pw : proyectos) {
                if (pw.getLatitud() != pw.getLongitud()) //Basic marker
                {
                    LatLng latLng = new LatLng(pw.getLatitud(), pw.getLongitud());
                    String contenido = " Título: ";
                    contenido += pw.getProyecto().getTitulo().replace("\"", "").replace("\'", "");
                    try {
                        if (pw.getProyecto().getProyectoDatosComplementarios().getLocalidad() != null) {
                            contenido += "\r\n Localización del Proyecto: ";
                            contenido += pw.getProyecto().getProyectoDatosComplementarios().getLocalidad();
                        }
                    } catch (Exception e) {
                    }
                    try {
                        contenido += "\r\n Área Temática: ";
                        contenido += pw.getProyecto().getSubDisciplinasCientificas()
                                .get(0).getDisciplinaCientifica().getAreaTematica().getDescripcion();
                        contenido += "\r\n Disciplina Científica: ";
                        contenido += pw.getProyecto().getSubDisciplinasCientificas()
                                .get(0).getDisciplinaCientifica().getDescripcion();
                    } catch (Exception e) {
                    }
                    try {
                        contenido += "\r\n Entidad Financiadora: ";
                        contenido += pw.getProyecto().getEntidadFinanciadora().getDescripcion();
                    } catch (Exception e) {
                    }
                    //busco el icono
                    String icono = null;

                    try {
                        Long id = pw.getProyecto().getSubDisciplinasCientificas().get(0).
                                getDisciplinaCientifica().getAreaTematica().getId();
                        if (id == 1) {
                            icono = "yellow";
                        } else if (id == 2) {
                            icono = "yellow-dot";
                        } else if (id == 3) {
                            icono = "blue";
                        } else if (id == 5) {
                            icono = "blue-dot";
                        } else if (id == 6) {
                            icono = "green";
                        } else if (id == 7) {
                            icono = "green-dot";
                        } else if (id == 8) {
                            icono = "lightblue";
                        } else if (id == 9) {
                            icono = "ltblue-dot";
                        } else if (id == 10) {
                            icono = "orange";
                        } else if (id == 11) {
                            icono = "orange-dot";
                        } else if (id == 12) {
                            icono = "pink";
                        } else if (id == 13) {
                            icono = "pink-dot";
                        } else if (id == 14) {
                            icono = "purple";
                        } else if (id == 15) {
                            icono = "purple-dot";
                        } else if (id == 16) {
                            icono = "red";
                        } else if (id == 17) {
                            icono = "red-dot";
                        } else if (id == 18) {
                            icono = "ylw-pushpin";
                        } else if (id == 19) {
                            icono = "blue-pushpin";
                        } else if (id == 20) {
                            icono = "grn-pushpin";
                        }
                    } catch (Exception e) {
                        icono = "grn-pushpin";
                    }

                    //fin buscar icono
                    String icon = "http://maps.google.com/mapfiles/ms/micons/" + icono + ".png";
                    Marker markerProyecto = new Marker(latLng, contenido, contenido, icon);
                    markers.add(markerProyecto);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onload() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            try {
                cargarParametros();
                cargarProyectos();
                cargarMarcadores(proyectos);
                mostrarMarcadores();
            } catch (Exception ex) {
                Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Long getAreaTematicaL() {
        return areaTematicaL;
    }

    public void setAreaTematicaL(Long areaTematicaL) {
        this.areaTematicaL = areaTematicaL;
    }

    public Long getDisciplinaCientificaL() {
        return disciplinaCientificaL;
    }

    public void setDisciplinaCientificaL(Long disciplinaCientificaL) {
        this.disciplinaCientificaL = disciplinaCientificaL;
    }

    public Long getLocalidadL() {
        return localidadL;
    }

    public void setLocalidadL(Long localidadL) {
        this.localidadL = localidadL;
    }

    public Long getDepartamentoL() {
        return departamentoL;
    }

    public void setDepartamentoL(Long departamentoL) {
        this.departamentoL = departamentoL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public DepartamentoRNLocal getDepartamentoRNLocal() {
        return departamentoRNLocal;
    }

    public void setDepartamentoRNLocal(DepartamentoRNLocal departamentoRNLocal) {
        this.departamentoRNLocal = departamentoRNLocal;
    }

    public LocalidadRNLocal getLocalidadRNLocal() {
        return localidadRNLocal;
    }

    public void setLocalidadRNLocal(LocalidadRNLocal localidadRNLocal) {
        this.localidadRNLocal = localidadRNLocal;
    }

    public List<SelectItem> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<SelectItem> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<SelectItem> getListaLocalidades() {
        return listaLocalidades;
    }

    public void setListaLocalidades(List<SelectItem> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    public ProyectoDatosComplementariosRNLocal getProyectoDatosComplementariosRNLocal() {
        return proyectoDatosComplementariosRNLocal;
    }

    public void setProyectoDatosComplementariosRNLocal(ProyectoDatosComplementariosRNLocal proyectoDatosComplementariosRNLocal) {
        this.proyectoDatosComplementariosRNLocal = proyectoDatosComplementariosRNLocal;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public AreaTematicaRNLocal getAreaTematicaRNLocal() {
        return areaTematicaRNLocal;
    }

    public void setAreaTematicaRNLocal(AreaTematicaRNLocal areaTematicaRNLocal) {
        this.areaTematicaRNLocal = areaTematicaRNLocal;
    }

    public DisciplinaCientificaRNLocal getDisciplinaCientificaRNLocal() {
        return disciplinaCientificaRNLocal;
    }

    public void setDisciplinaCientificaRNLocal(DisciplinaCientificaRNLocal disciplinaCientificaRNLocal) {
        this.disciplinaCientificaRNLocal = disciplinaCientificaRNLocal;
    }

    public List<DisciplinaCientifica> getDisciplinaCientificas() {
        return disciplinaCientificas;
    }

    public void setDisciplinaCientificas(List<DisciplinaCientifica> disciplinaCientificas) {
        this.disciplinaCientificas = disciplinaCientificas;
    }

    public DisciplinaCientifica getDisciplinaCientifica() {
        return disciplinaCientifica;
    }

    public void setDisciplinaCientifica(DisciplinaCientifica disciplinaCientifica) {
        this.disciplinaCientifica = disciplinaCientifica;
    }

    public List<AreaTematica> getAreaTematicas() {
        return areaTematicas;
    }

    public void setAreaTematicas(List<AreaTematica> areaTematicas) {
        this.areaTematicas = areaTematicas;
    }

    public AreaTematica getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }

    @PostConstruct
    public void init() {
        try {
            onLoad();
        } catch (Exception ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void onLoad() {
        cargarAreasTeamaticas();
        cargarDepartamentos();
        // RequestContext.getCurrentInstance().execute("actualizarInfoWindow()");
    }

    public void cargarParametros() {

        try {
            if (areaTematicaL != null) {
                areaTematica = areaTematicaRNLocal.find(areaTematicaL);
            }
        } catch (Exception e) {
            System.out.println("Error cargando parametro: " + e);
        }
        try {
            if (disciplinaCientificaL != null) {
                disciplinaCientifica = disciplinaCientificaRNLocal.find(disciplinaCientificaL);
            }
        } catch (Exception e) {
            System.out.println("Error cargando parametro: " + e);
        }
        try {
            if (localidadL != null) {
                localidad = localidadRNLocal.find(localidadL);
            }
        } catch (Exception e) {
            System.out.println("Error cargando parametro: " + e);
        }
        try {
            if (departamentoL != null) {
                departamento = departamentoRNLocal.find(departamentoL);
            }
        } catch (Exception e) {
            System.out.println("Error cargando parametro: " + e);
        }

    }

    private void cargarProyectos() {
        try {
            if (titulo == null && areaTematica == null && disciplinaCientifica == null
                    && localidad == null && departamento == null) {
                proyectos = proyectoDatosComplementariosRNLocal.findLatLong();
            } else {
                proyectos = proyectoDatosComplementariosRNLocal.findByNombreLocalidadDisciplina(titulo, areaTematica, disciplinaCientifica, localidad, departamento);
            }
        } catch (Exception exception) {
            System.out.println("Error cargando Proyectos: " + exception);
        }
    }

    private void cargarAreasTeamaticas() {
        try {
            areaTematicas = areaTematicaRNLocal.findAreasTematicas();
        } catch (Exception ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarDisciplinasCientificas() {
        try {
            disciplinaCientificas = disciplinaCientificaRNLocal.findDisciplinasCientificasByAreaTematica(areaTematica);
        } catch (Exception ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarDepartamentos() {
        try {
            listaDepartamentos = new ArrayList<SelectItem>();

            for (Departamento depto : departamentoRNLocal.findDepartamentosCatamarca()) {
                listaDepartamentos.add(new SelectItem(depto, depto.toString()));
            }
        } catch (Exception ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarLocalidades() {

        try {
            listaLocalidades = new ArrayList<SelectItem>();
            for (Localidad loc : localidadRNLocal.findLocalidadesByDpto(departamento)) {
                listaLocalidades.add(new SelectItem(loc, loc.toString()));

            }
        } catch (Exception ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarFiltros() {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            String url = "/mapa.xhtml?faces-redirect=true&includeViewParams=true";
            url += "&titulo=" + URLEncoder.encode(titulo, "UTF-8");
            try {
                url += "&areaTematicaL=" + areaTematica.getId();
            } catch (Exception e) {
            }
            try {
                url += "&disciplinaCientificaL=" + disciplinaCientifica.getId();
            } catch (Exception e) {
            }
            try {
                url += "&localidadL=" + localidad.getId();
            } catch (Exception e) {
            }
            try {
                url += "&departamentoL=" + departamento.getId();
            } catch (Exception e) {
            }
            String path = context.getRequestContextPath() + url;

            context.redirect(path);
        } catch (IOException ex) {
            Logger.getLogger(MapaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
