/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.resultado;

import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import entidades.proyecto.vinculacion.ProyectoVinculacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hugo
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "resultado_propiedad")
@NamedQueries({
    @NamedQuery(name = "Propiedad.findByTypeYProyecto",
            query = "SELECT pint FROM Propiedad pint, IN (pint.proyectos) pr, IN (pr.participaciones) par WHERE TYPE(pint) = :tipo AND  pr.id = :idProyecto "
            + "AND par.investigador.id = :idInvestigador")
})
public abstract class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToMany
    private List<Proyecto> proyectos;
    @ManyToMany
    private List<ProyectoVinculacion> proyectosVinculacion;
    @ManyToMany
    private List<Investigador> investigadores;

    @XmlTransient
    public List<ProyectoVinculacion> getProyectosVinculacion() {
        return proyectosVinculacion;
    }

    public void setProyectosVinculacion(List<ProyectoVinculacion> proyectosVinculacion) {
        this.proyectosVinculacion = proyectosVinculacion;
    }

    @XmlTransient
    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    @XmlTransient
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @XmlElement(name = "proyectosNombre")
    public List<String> getProyectosNombreFromRest() {
        try {
            List<String> listaProyectos = new ArrayList<String>();
            for (Proyecto p : proyectos) {
                listaProyectos.add(p.toString());
            }
            return listaProyectos;
        } catch (Exception e) {
            return null;
        }
    }

    @XmlElement(name = "proyectos")
    public List<Long> getProyectosFromRest() {
        try {
            List<Long> listaProyectos = new ArrayList<Long>();
            for (Proyecto p : proyectos) {
                listaProyectos.add(p.getId());
            }
            return listaProyectos;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.proyecto.resultado.Propiedad[ id=" + id + " ]";
    }

}
