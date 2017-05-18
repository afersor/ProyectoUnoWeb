/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.Documento;
import entidades.RN.DocumentoRNLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class DocumentoLstBean implements Serializable {

    private List<Documento> lstDocumento;

    private Documento documento;
    @EJB
    private DocumentoRNLocal documentoRNLocal;

    public DocumentoLstBean() {
        documento = new Documento();
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Documento> getLstDocumento() {
        return lstDocumento;
    }

    public void setLstDocumento(List<Documento> lstDocumento) {
        this.lstDocumento = lstDocumento;
    }

    public void findLikeByDocumento(String cadena) throws Exception {
        //this.setLstDocumento(documentoRNLocal.findLikeBy(cadena.trim().toLowerCase()));
    }

}
