/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.Documento;
import entidades.RN.DocumentoRNLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class DocumentoBean {

    private Documento documento;
    @EJB
    private DocumentoRNLocal documentoRNLocal;

    public DocumentoBean() {
        documento = new Documento();
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public void create() throws Exception {
        documentoRNLocal.create(this.getDocumento());
    }

    public void edit() throws Exception {
        documentoRNLocal.edit(this.getDocumento());
    }

    public void remove() throws Exception {
        documentoRNLocal.remove(this.getDocumento());
    }
    
}
