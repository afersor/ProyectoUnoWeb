/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.resultado.RN;

import DAO.PublicacionFacadeLocal;
import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.CapituloLibro;
import entidades.proyecto.resultado.Congreso;
import entidades.proyecto.resultado.Libro;
import entidades.proyecto.resultado.Publicacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author AFerSor
 */
@Stateless
public class PublicacionRN implements PublicacionRNLocal {

    @EJB
    private PublicacionFacadeLocal publicacionFacadeLocal;
    
    @Override
    public List<Publicacion> findByInvestigador(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        return publicacionFacadeLocal.findByInvestigador(idProyecto,idInvestigador, tipo);
    }

    @Override
    public void create(Publicacion publicacion, String clase) throws Exception {
        if(!"CapituloLibro".equals(clase)){
        this.validar(publicacion, 0, clase);       
        }
         this.publicacionFacadeLocal.create(publicacion);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void edit(Publicacion publicacion, String clase) throws Exception {
       if(!"CapituloLibro".equals(clase)){
        this.validar(publicacion, 0, clase);       
        }
        this.publicacionFacadeLocal.edit(publicacion);
    }

    @Override
    public void activate(Publicacion al, Boolean bEstado) throws Exception {
        this.publicacionFacadeLocal.activate(al, bEstado);
}

    @Override
    public void remove(Publicacion publicacion) throws Exception {
        this.publicacionFacadeLocal.remove(publicacion);
    }

    private void validar(Publicacion p, int op, String clase) throws Exception {
        System.out.println("ENTRO A VALIDAR la clase es ---->" + clase);
        
        if (clase.equals("ArticuloRevista")) {
            ArticuloRevista ar = (ArticuloRevista) p;

            if (ar.getNombreRevista().trim().length() == 0) {
                throw new Exception("Debe ingresar un nombre de revista");
            }
            if (ar.getVolumen().trim().length() == 0) {
                throw new Exception("Debe ingresar el volumen");
            }
            if (!cadenas.es_numero(ar.getVolumen())) {
                throw new Exception("El volumen del articulo debe contener solo caracteres numéricos");
            }

            if (validateIsbn13(ar.getISBN()) != true) {
                throw new Exception("El número de ISBN ingresado no es correcto");
            }

        }
        if (clase.equals("Libro")) {
            Libro libro = (Libro) p;

            if (libro.getEditor().trim().length() == 0) {
                throw new Exception("Debe ingresar un Editor");
            }
            if (libro.getAnioPublicacion().trim().length() == 0) {
                throw new Exception("Debe ingresar el año de publicación");
            }
            if (!cadenas.es_numero(libro.getAnioPublicacion())) {
                throw new Exception("El año de publicación del libro debe contener solo caracteres numéricos");
            }
            if (libro.getLugarPublicacion().trim().length() == 0) {
                throw new Exception("Debe ingresar un lugar de publicación");
            }

        }

        if (clase.equals("Congreso")) {
            Congreso con = (Congreso) p;

            if (con.getNombreEvento().trim().length() == 0) {
                throw new Exception("Debe ingresar un nombre de evento");
            }
            if (con.getTitulo().trim().length() == 0) {
                throw new Exception("Debe ingresar el tema");
            }
            if (!cadenas.es_numero(con.getVolumen())) {
                throw new Exception("El volumen del Congreso debe contener solo caracteres numéricos");
            }
            if (!cadenas.es_numero(con.getAnio())) {
                throw new Exception("El Año del Congreso debe contener solo caracteres numéricos");
            }
            if (!cadenas.es_numero(con.getPagina())) {
                throw new Exception("La Pagina del Congreso debe contener solo caracteres numéricos");
            }
            if (con.getInvestigadores() == null) {
                throw new Exception("Debe contener al menos un participante");
            }
            if (con.getReferato() == null) {
                throw new Exception("Debe Seleccionar un Tipo en Referato");
            }
            if (con.getCaracter() == null) {
                throw new Exception("Debe Seleccionar Tipo de Caracter");
            }
            if (con.getPublicadoEnActas() == null) {
                throw new Exception("Debe Seleccionar un Valor en Actas Mmemorias");
            }

        }
        if (clase.equals("CapituloLibro")) {
            System.out.println("entro en clase" + "capituloLibro");
            CapituloLibro cap = (CapituloLibro) p;

            if (cap.getNombreLibro().trim().length() == 0) {
                throw new Exception("Debe ingresar el Nombre del Libro");
            }
            if (cap.getLibro()== null){
            throw new Exception("Debe ingresar un Libro");
            }
            if (cap.getTitulo().trim().length() == 0) {
                throw new Exception("Debe ingresar el Titulo");
            }
            if (cap.getEditor().trim().length() == 0) {
                throw new Exception("Debe ingresar el Editor");
            }

            if (!cadenas.es_numero(cap.getAnioPublicacion())) {
                throw new Exception("El Año del Capitulo debe contener solo caracteres numéricos");
            }
            if(cap.getFechaAceptado()== null){
            throw new Exception("Ingrese Fecha Aceptado");
            }
             if(cap.getFechaEnviado()== null){
            throw new Exception("Ingrese Fecha Enviado");
            }
              if(cap.getFechaPublicado()== null){
            throw new Exception("Ingrese Fecha Publicado");
            }
            if (cap.getInvestigadores() == null) {
                throw new Exception("Debe seleccionar al menos un Participante");
            }
            if (!cadenas.validateIsbn13(cap.getISBN())) {
                throw new Exception("Verificar Formato de Codigo ISBN");
            }

        }

    }//fin validar

    public boolean validateIsbn13(String isbn) {
        if (isbn == null) {
            return false;
        }

        //remove any hyphens
        isbn = isbn.replaceAll("-", "");

        //must be a 13 digit ISBN
        if (isbn.length() != 13) {
            return false;
        }

        try {
            int tot = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
            }

            //checksum must be 0-9. If calculated as 10 then = 0
            int checksum = 10 - (tot % 10);
            if (checksum == 10) {
                checksum = 0;
            }

            return checksum == Integer.parseInt(isbn.substring(12));
        } catch (NumberFormatException nfe) {
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
    }

}
