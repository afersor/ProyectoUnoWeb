/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AFerSor
 */
public class FileDownload {
    public static void descargarArchivo(byte[] archivo, String nombre) throws Exception{
         try {
             
             System.out.println("archivo: " + archivo + "  " + nombre);
             
            File archivoDescarga = File.createTempFile( "tmp",nombre);
            archivoDescarga.deleteOnExit();
            
            FileOutputStream fos = 
                  new FileOutputStream(archivoDescarga); 
            fos.write(archivo);
            fos.close();
            
            if(archivoDescarga.exists()){
                FacesContext context = FacesContext.getCurrentInstance();  
                ExternalContext externalContext = context.getExternalContext();  
                HttpServletResponse httpServletResponse = (HttpServletResponse) externalContext  
                        .getResponse();  
                String path="";// Assuming you have a fixed path of a file you want to download...  

                BufferedInputStream bufferedInputStream = null;  
                BufferedOutputStream bufferedOutputStream = null;  

                try {  
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(  
                            archivoDescarga));  
                    httpServletResponse.reset();  
                    httpServletResponse.setContentType("application/force-download");  
                    httpServletResponse.setContentLength((int) archivoDescarga.length());  
                    httpServletResponse  
                            .setHeader("Content-disposition", "attachment; filename=\""  
                                    + nombre + "\"");  
                    bufferedOutputStream = new BufferedOutputStream(httpServletResponse  
                            .getOutputStream());  
                   // byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];  
                     byte[] buffer = new byte[8 * 1024];
                    int length;  
                    while ((length = bufferedInputStream.read(buffer)) > 0) {  
                        bufferedOutputStream.write(buffer, 0, length);  
                    }  
                    // Finalize task.  
                    bufferedOutputStream.flush();  
                } finally {  
                    // Gently close streams.  
                    bufferedOutputStream.close();  
                    bufferedInputStream.close();  
                }  


                context.responseComplete();  
            }//fin if
            
        } //fin descargarArchivo
        catch (IOException ex) {
            throw new Exception("Se ha producido un error al descargar " + nombre);
        }
    }//fin descargarArchivo
    
}//FIN CLASE
