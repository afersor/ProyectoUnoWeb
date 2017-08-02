/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.resultado.FormacionRRHH;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface FormacionRNLocal {
    public List<FormacionRRHH> findByTypeYProyecto(Long idProyecto,Long idInvestigador) throws Exception;
    public void create (FormacionRRHH formacionRRHH) throws Exception;
    public void edit (FormacionRRHH formacionRRHH) throws Exception;

    public void remove(FormacionRRHH formacionRRHH) throws Exception;
}
