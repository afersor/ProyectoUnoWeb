/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.investigador.formacionAcademica;

import entidades.Universidad;
import entidades.titulo.TituloGrado;
import entidades.titulo.TituloPosgrado;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name="formacionacademicaposgrado")
public class FormacionAcademicaPosgrado extends FormacionAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToOne
    private TituloPosgrado tituloPosgrado;
    @OneToOne
    private Universidad universidad;

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
    public TituloPosgrado getTituloPosgrado() {
        return tituloPosgrado;
    }

    public void setTituloPosgrado(TituloPosgrado tituloPosgrado) {
        this.tituloPosgrado = tituloPosgrado;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += tituloPosgrado.getDescripcion();
        if (super.getAnoEgreso() != 0) {
            salida += " - Egresado en " + super.getAnoEgreso();
        } else {
            salida += " - Actualmente cursando";
        }
        return salida;
    }
}
