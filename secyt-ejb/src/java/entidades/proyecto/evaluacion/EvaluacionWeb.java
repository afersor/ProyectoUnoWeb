/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion;

import entidades.Documento;
import entidades.persona.Evaluador;
import entidades.proyecto.Proyecto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author franco
 */
@Entity
@Table(name = "evaluacion_realizada")
@NamedQueries({
    @NamedQuery(name = "EvaluacionWeb.findAllByEvaluador",
    query = "SELECT e FROM EvaluacionWeb e WHERE e.evaluador.id =:idEvaluador "),
         @NamedQuery(name = "EvaluacionWeb.findByProyecto",
    query = "SELECT e FROM EvaluacionWeb e WHERE e.proyecto.id =:idProyecto ")})

public class EvaluacionWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Proyecto proyecto;
    @OneToOne
    private Evaluador evaluador;
    @OneToOne 
    private TipoEvaluacion tipoEvaluacion;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BloqueEvaluado> bloquesEvaluados;
    
    @Enumerated(EnumType.STRING)
    private CalificacionGlobal calificacionGlobal;
    
    @Lob
    private String comentariosFinales;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Documento> documentos;
    
    private Boolean finalizado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
    
    

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public List<BloqueEvaluado> getBloquesEvaluados() {
        return bloquesEvaluados;
    }

    public void setBloquesEvaluados(List<BloqueEvaluado> bloquesEvaluados) {
        this.bloquesEvaluados = bloquesEvaluados;
    }

    public CalificacionGlobal getCalificacionGlobal() {
        return calificacionGlobal;
    }

    public void setCalificacionGlobal(CalificacionGlobal calificacionGlobal) {
        this.calificacionGlobal = calificacionGlobal;
    }

    public String getComentariosFinales() {
        return comentariosFinales;
    }

    public void setComentariosFinales(String comentariosFinales) {
        this.comentariosFinales = comentariosFinales;
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
        if (!(object instanceof EvaluacionWeb)) {
            return false;
        }
        EvaluacionWeb other = (EvaluacionWeb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.proyecto.toString();
    }
}
