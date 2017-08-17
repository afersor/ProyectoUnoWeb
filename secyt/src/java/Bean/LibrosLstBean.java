/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.PublicacionFacadeLocal;
import entidades.proyecto.resultado.Libro;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author alumno
 */
@ManagedBean
@SessionScoped
public class LibrosLstBean implements Serializable {
private List<Libro> lstLibros;
private Libro libroSelect;
 private List<SelectItem> lstSILibros;
     private int iActionBtnSelect;

 @EJB
    private PublicacionFacadeLocal publicacionFacadeLocal;
    /**
     * Creates a new instance of LibrosLstBean
     */
    public LibrosLstBean() {
        lstLibros = new ArrayList<Libro>();
    }

    public List<Libro> getLstLibros() {
        return lstLibros;
    }

    public void setLstLibros(List<Libro> lstLibros) {
        this.lstLibros = lstLibros;
       
    }

    public List<SelectItem> getLstSILibros() {
        return lstSILibros;
    }

    public void setLstSILibros(List<SelectItem> lstSILibros) {
        this.lstSILibros = lstSILibros;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public PublicacionFacadeLocal getPublicacionFacadeLocal() {
        return publicacionFacadeLocal;
    }

    public void setPublicacionFacadeLocal(PublicacionFacadeLocal publicacionFacadeLocal) {
        this.publicacionFacadeLocal = publicacionFacadeLocal;
    }

    public Libro getLibroSelect() {
        return libroSelect;
    }

    public void setLibroSelect(Libro libroSelect) {
        this.libroSelect = libroSelect;
    }
    
      public void cargar_libros() {
        try {
              this.setLstLibros(publicacionFacadeLocal.getLibros());
              System.out.println("trae libros" + lstLibros);
        } catch (Exception ex) {
            System.out.println("Error al cargar Libros " + ex.toString());
        }
        this.cargar_SI_libros();
    }

    public void cargar_SI_libros() {
        this.setLstSILibros(new ArrayList<SelectItem>());

        for (Libro a : this.getLstLibros()) {
            SelectItem si = new SelectItem(a, a.getTitulo() +"-" + a.getAnioPublicacion());
             
            this.getLstSILibros().add(si);
           
        }
    }
}
