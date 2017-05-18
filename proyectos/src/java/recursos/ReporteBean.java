/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class ReporteBean {

    /**
     * Creates a new instance of ReporteBean
     */
    public ReporteBean() {
    }

    public void preProcessPDF(Object document) throws IOException, DocumentException {

        final Document pdf = (Document) document;


        pdf.setPageSize(PageSize.A4.rotate());

        pdf.open();




        PdfPTable pdfTable = new PdfPTable(7);
        pdfTable.setWidthPercentage(20f);
        pdfTable.setHorizontalAlignment(0);
        pdf.add(pdfTable);

//        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        final Phrase phrase = new Phrase(formatoDeFecha.format(new Date()));

//        pdf.add(phrase);
    }

    public void postProcessPDF(Object document) throws IOException, DocumentException {
        final Document pdf = (Document) document;
        pdf.setPageSize(PageSize.A4.rotate());

    }
}
