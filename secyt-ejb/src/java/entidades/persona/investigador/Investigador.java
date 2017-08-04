/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador;

import entidades.DedicacionDocente;
import entidades.Resolucion;
import entidades.UnidadAcademica;
import entidades.Universidad;
import entidades.becas.PostulacionBeca;
import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import entidades.investigador.formacionAcademica.FormacionAcademicaOtra;
import entidades.investigador.formacionAcademica.FormacionAcademicaPosgrado;
import entidades.persona.Persona;
import entidades.persona.investigador.actividadConduccion.ActividadConduccion;
import entidades.persona.investigador.curso.CursoDictado;
import entidades.proyecto.Participacion;
import entidades.proyecto.resultado.Propiedad;
import entidades.proyecto.resultado.Publicacion;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "investigador")
@NamedQueries({
    @NamedQuery(name = "Investigador.findInvestigadorByCUIL",
            query = "SELECT i FROM Investigador i WHERE i.persona.cuil = :cuil"),

    @NamedQuery(name = "Investigador.findInvestigadorByCUILID",
            query = "SELECT i FROM Investigador i WHERE i.id <> :id AND i.persona.cuil = :cuil"),

    @NamedQuery(name = "Investigador.findLikeNombreyApellido",
            query = "SELECT i FROM Investigador i WHERE LOWER(i.persona.nombre) LIKE :cadena "
            + "OR LOWER(i.persona.apellido) LIKE :cadena ORDER BY i.persona.apellido, i.persona.nombre")
})
@XmlRootElement(name = "investigador")

public class Investigador implements Serializable {

    @ManyToMany(mappedBy = "investigadores")
    private List<Publicacion> publicaciones;
    @ManyToMany(mappedBy = "investigadores")
    private List<Propiedad> propiedades;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Persona persona;
    @OneToMany(mappedBy = "investigador")
    private List<Docencia> docencias;
    @OneToMany
    private List<CursoDictado> cursosDictados;
    @OneToMany
    private List<ActividadConduccion> actividadesConduccion;
    @OneToMany(mappedBy = "investigador")
    private List<Especializacion> especializaciones;
    @OneToOne
    private EspecialidadInvestigacion especialidadInvestigacion;
    @OneToOne
    private EspecialidadActividadAcademica especialidadActividadAcademica;
    @OneToMany
    private List<entidades.categorizacion.Categorizacion> categorizaciones;
    @OneToMany(mappedBy = "investigador")
    private List<Participacion> participacionesProyecto;
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "postulante")
    private List<PostulacionBeca> becas;
    @ManyToMany
    private List<Resolucion> resoluciones;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FormacionAcademicaGrado> formacionesAcademicasGrado;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FormacionAcademicaPosgrado> formacionesAcademicasPosgrado;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FormacionAcademicaOtra> formacionesAcademicasOtras;

    public List<Especializacion> getEspecializaciones() {
        return especializaciones;
    }

    public void setEspecializaciones(List<Especializacion> especializaciones) {
        this.especializaciones = especializaciones;
    }

    public List<FormacionAcademicaOtra> getFormacionesAcademicasOtras() {
        return formacionesAcademicasOtras;
    }

    public void setFormacionesAcademicasOtras(List<FormacionAcademicaOtra> formacionesAcademicasOtras) {
        this.formacionesAcademicasOtras = formacionesAcademicasOtras;

    }

    public List<FormacionAcademicaPosgrado> getFormacionesAcademicasPosgrado() {
        return formacionesAcademicasPosgrado;
    }

    public void setFormacionesAcademicasPosgrado(List<FormacionAcademicaPosgrado> formacionesAcademicasPosgrado) {
        this.formacionesAcademicasPosgrado = formacionesAcademicasPosgrado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<PostulacionBeca> getBecas() {
        return becas;
    }

    public void setBecas(List<PostulacionBeca> becas) {
        this.becas = becas;
    }

    public List<entidades.categorizacion.Categorizacion> getCategorizaciones() {
        return categorizaciones;
    }

    public void setCategorizaciones(List<entidades.categorizacion.Categorizacion> categorizaciones) {
        this.categorizaciones = categorizaciones;
    }

    public List<Participacion> getParticipacionesProyecto() {
        return participacionesProyecto;
    }

    public void setParticipacionesProyecto(List<Participacion> participacionesProyecto) {
        this.participacionesProyecto = participacionesProyecto;
    }

    public EspecialidadActividadAcademica getEspecialidadActividadAcademica() {
        return especialidadActividadAcademica;
    }

    public void setEspecialidadActividadAcademica(EspecialidadActividadAcademica especialidadActividadAcademica) {
        this.especialidadActividadAcademica = especialidadActividadAcademica;
    }

    public EspecialidadInvestigacion getEspecialidadInvestigacion() {
        return especialidadInvestigacion;
    }

    public void setEspecialidadInvestigacion(EspecialidadInvestigacion especialidadInvestigacion) {
        this.especialidadInvestigacion = especialidadInvestigacion;
    }

    public List<ActividadConduccion> getActividadesConduccion() {
        return actividadesConduccion;
    }

    public void setActividadesConduccion(List<ActividadConduccion> actividadesConduccion) {
        this.actividadesConduccion = actividadesConduccion;
    }

    public List<CursoDictado> getCursosDictados() {
        return cursosDictados;
    }

    public void setCursosDictados(List<CursoDictado> cursosDictados) {
        this.cursosDictados = cursosDictados;
    }

    @XmlTransient
    public List<Resolucion> getResoluciones() {
        return resoluciones;
    }

    public void setResoluciones(List<Resolucion> resoluciones) {
        this.resoluciones = resoluciones;
    }

    public List<FormacionAcademicaGrado> getFormacionesAcademicasGrado() {
        return formacionesAcademicasGrado;
    }

    public void setFormacionesAcademicasGrado(List<FormacionAcademicaGrado> formacionesAcademicasGrado) {
        this.formacionesAcademicasGrado = formacionesAcademicasGrado;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public List<Docencia> getDocencias() {
        return docencias;
    }

    public void setDocencias(List<Docencia> docencias) {
        this.docencias = docencias;
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
        if (!(object instanceof Investigador)) {
            return false;
        }
        Investigador other = (Investigador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + persona.getApellido() + " " + persona.getNombre();
    }
}
