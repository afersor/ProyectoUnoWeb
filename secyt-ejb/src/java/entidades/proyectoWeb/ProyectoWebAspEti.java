/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb;

import java.io.Serializable;
import javax.persistence.Entity;
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
@Table(name = "proyectoweb_aspectos_eticos")
public class ProyectoWebAspEti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //IX. Aspectos Éticos
    private Boolean eticoSeguridad;
    
    private Boolean comprendeInvestigacionHumana;
    
    private Boolean estudioFarmaTecno;
    
    private Boolean estudioClinQuiruBasi;
    
    private Boolean estudioEpideSociaPsico;
    
    private Boolean equipamientoMedico;
    
    private Boolean equipamientoImgRadia;
    
    private Boolean usoHistoClinica;
    
    private Boolean usoMuestBiolog;
    
    private Boolean estudioComunAborig;
    
    private Boolean informePlanInv;

    
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstudioEpideSociaPsico() {
        return estudioEpideSociaPsico;
    }

    public void setEstudioEpideSociaPsico(Boolean estudioEpideSociaPsico) {
        this.estudioEpideSociaPsico = estudioEpideSociaPsico;
    }
    

    public Boolean getEticoSeguridad() {
        return eticoSeguridad;
    }

    public void setEticoSeguridad(Boolean eticoSeguridad) {
        this.eticoSeguridad = eticoSeguridad;
    }

    public Boolean getComprendeInvestigacionHumana() {
        return comprendeInvestigacionHumana;
    }

    public void setComprendeInvestigacionHumana(Boolean comprendeInvestigacionHumana) {
        this.comprendeInvestigacionHumana = comprendeInvestigacionHumana;
    }

    public Boolean getEstudioFarmaTecno() {
        return estudioFarmaTecno;
    }

    public void setEstudioFarmaTecno(Boolean estudioFarmaTecno) {
        this.estudioFarmaTecno = estudioFarmaTecno;
    }

    public Boolean getEstudioClinQuiruBasi() {
        return estudioClinQuiruBasi;
    }

    public void setEstudioClinQuiruBasi(Boolean estudioClinQuiruBasi) {
        this.estudioClinQuiruBasi = estudioClinQuiruBasi;
    }

    public Boolean getEquipamientoMedico() {
        return equipamientoMedico;
    }

    public void setEquipamientoMedico(Boolean equipamientoMedico) {
        this.equipamientoMedico = equipamientoMedico;
    }

    public Boolean getEquipamientoImgRadia() {
        return equipamientoImgRadia;
    }

    public void setEquipamientoImgRadia(Boolean equipamientoImgRadia) {
        this.equipamientoImgRadia = equipamientoImgRadia;
    }

    public Boolean getUsoHistoClinica() {
        return usoHistoClinica;
    }

    public void setUsoHistoClinica(Boolean usoHistoClinica) {
        this.usoHistoClinica = usoHistoClinica;
    }

    public Boolean getUsoMuestBiolog() {
        return usoMuestBiolog;
    }

    public void setUsoMuestBiolog(Boolean usoMuestBiolog) {
        this.usoMuestBiolog = usoMuestBiolog;
    }

    public Boolean getEstudioComunAborig() {
        return estudioComunAborig;
    }

    public void setEstudioComunAborig(Boolean estudioComunAborig) {
        this.estudioComunAborig = estudioComunAborig;
    }

    public Boolean getInformePlanInv() {
        return informePlanInv;
    }

    public void setInformePlanInv(Boolean informePlanInv) {
        this.informePlanInv = informePlanInv;
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
        if (!(object instanceof ProyectoWebAspEti)) {
            return false;
        }
        ProyectoWebAspEti other = (ProyectoWebAspEti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.proyectoWeb.ProyectoWebAspEti[ id=" + id + " ]";
    }
    
}
