/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author franco
 */
@Entity
@Table(name="evaluacion_bloque")
@NamedQueries({
    @NamedQuery(name = "Bloque.findAllOrderByDescripcion",
    query = "SELECT b FROM Bloque b ORDER BY b.descripcion")})
public class Bloque implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    
    @OneToMany(mappedBy = "bloque")
    private List<ContenidoBloque> lstContenidoBloque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ContenidoBloque> getLstContenidoBloque() {
        return lstContenidoBloque;
    }

    public void setLstContenidoBloque(List<ContenidoBloque> lstContenidoBloque) {
        this.lstContenidoBloque = lstContenidoBloque;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Bloque)) {
            return false;
        }
        Bloque other = (Bloque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    /*@Override
    public int compareTo(Bloque b) {
        int compareTo = 0;
        try {
            compareTo = this.descripcion.compareTo(b.descripcion);
        } catch (Exception ex) {
            System.out.println("Error comparando");
        }
        return compareTo;
    }*/
    
}
