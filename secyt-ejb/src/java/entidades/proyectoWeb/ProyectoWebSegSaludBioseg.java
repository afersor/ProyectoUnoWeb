/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "proyectoweb_seguridad_salud_Bioseg")
public class ProyectoWebSegSaludBioseg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //X Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad
    @Enumerated
    private TipoRespuesta incluyeTareaCampo;
    
    @Enumerated
    private TipoRespuesta cuentraProfesional;
    
    @Enumerated
    private TipoRespuesta existeComiteSegBioseg;
    
    @Enumerated
    private TipoRespuesta riesgosFisicos;
    
    @Enumerated
    private TipoRespuesta sustanciasQuimicas;
    
    private String sustancias;
    
    @Enumerated
    private TipoRespuesta campanaExtraccion;
    
    @Enumerated
    private TipoRespuesta riesgosBiologicos;
    
    private String nivelSeguridadInstalaciones;
    
    @Enumerated
    private TipoRespuesta aprobadoComite;
    
    @Enumerated
    private TipoRespuesta realizaInmunizacion;
    
    @Enumerated
    private TipoRespuesta advertenciaRiesgoMujeres;
    
    @Enumerated
    private TipoRespuesta existeGestionResiduos;
    
    @Enumerated
    private TipoRespuesta personalCapacitadoPrevencion;
    
    private Integer cantPersEspacioTrabajo;
    
    private Integer mtsCantPersonas;
    
    
    

    
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoRespuesta getIncluyeTareaCampo() {
        return incluyeTareaCampo;
    }

    public void setIncluyeTareaCampo(TipoRespuesta incluyeTareaCampo) {
        this.incluyeTareaCampo = incluyeTareaCampo;
    }

    public TipoRespuesta getCuentraProfesional() {
        return cuentraProfesional;
    }

    public void setCuentraProfesional(TipoRespuesta cuentraProfesional) {
        this.cuentraProfesional = cuentraProfesional;
    }

    public TipoRespuesta getExisteComiteSegBioseg() {
        return existeComiteSegBioseg;
    }

    public void setExisteComiteSegBioseg(TipoRespuesta existeComiteSegBioseg) {
        this.existeComiteSegBioseg = existeComiteSegBioseg;
    }

    public TipoRespuesta getRiesgosFisicos() {
        return riesgosFisicos;
    }

    public void setRiesgosFisicos(TipoRespuesta riesgosFisicos) {
        this.riesgosFisicos = riesgosFisicos;
    }

    public TipoRespuesta getSustanciasQuimicas() {
        return sustanciasQuimicas;
    }

    public void setSustanciasQuimicas(TipoRespuesta sustanciasQuimicas) {
        this.sustanciasQuimicas = sustanciasQuimicas;
    }

    public String getSustancias() {
        return sustancias;
    }

    public void setSustancias(String sustancias) {
        this.sustancias = sustancias;
    }

    public TipoRespuesta getCampanaExtraccion() {
        return campanaExtraccion;
    }

    public void setCampanaExtraccion(TipoRespuesta campanaExtraccion) {
        this.campanaExtraccion = campanaExtraccion;
    }

    public TipoRespuesta getRiesgosBiologicos() {
        return riesgosBiologicos;
    }

    public void setRiesgosBiologicos(TipoRespuesta riesgosBiologicos) {
        this.riesgosBiologicos = riesgosBiologicos;
    }

    public String getNivelSeguridadInstalaciones() {
        return nivelSeguridadInstalaciones;
    }

    public void setNivelSeguridadInstalaciones(String nivelSeguridadInstalaciones) {
        this.nivelSeguridadInstalaciones = nivelSeguridadInstalaciones;
    }

    public TipoRespuesta getAprobadoComite() {
        return aprobadoComite;
    }

    public void setAprobadoComite(TipoRespuesta aprobadoComite) {
        this.aprobadoComite = aprobadoComite;
    }

    public TipoRespuesta getRealizaInmunizacion() {
        return realizaInmunizacion;
    }

    public void setRealizaInmunizacion(TipoRespuesta realizaInmunizacion) {
        this.realizaInmunizacion = realizaInmunizacion;
    }

    public TipoRespuesta getAdvertenciaRiesgoMujeres() {
        return advertenciaRiesgoMujeres;
    }

    public void setAdvertenciaRiesgoMujeres(TipoRespuesta advertenciaRiesgoMujeres) {
        this.advertenciaRiesgoMujeres = advertenciaRiesgoMujeres;
    }

    public TipoRespuesta getExisteGestionResiduos() {
        return existeGestionResiduos;
    }

    public void setExisteGestionResiduos(TipoRespuesta existeGestionResiduos) {
        this.existeGestionResiduos = existeGestionResiduos;
    }

    public TipoRespuesta getPersonalCapacitadoPrevencion() {
        return personalCapacitadoPrevencion;
    }

    public void setPersonalCapacitadoPrevencion(TipoRespuesta personalCapacitadoPrevencion) {
        this.personalCapacitadoPrevencion = personalCapacitadoPrevencion;
    }

    public Integer getCantPersEspacioTrabajo() {
        return cantPersEspacioTrabajo;
    }

    public void setCantPersEspacioTrabajo(Integer cantPersEspacioTrabajo) {
        this.cantPersEspacioTrabajo = cantPersEspacioTrabajo;
    }

    public Integer getMtsCantPersonas() {
        return mtsCantPersonas;
    }

    public void setMtsCantPersonas(Integer mtsCantPersonas) {
        this.mtsCantPersonas = mtsCantPersonas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoWebSegSaludBioseg)) {
            return false;
        }
        ProyectoWebSegSaludBioseg other = (ProyectoWebSegSaludBioseg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.proyectoWeb.ProyectoWebSegSaludBioseg[ id=" + id + " ]";
    }
    
}
