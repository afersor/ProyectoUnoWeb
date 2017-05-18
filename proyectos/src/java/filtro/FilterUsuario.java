/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import beanProyecto.ProyectoWebBean;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AFerSor
 */
public class FilterUsuario implements Filter{

     FilterConfig filterConfig = null;
     
     @ManagedProperty("#{proyectoWebBean}")
     private ProyectoWebBean proyectoWebBean;

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
     
     
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         this.filterConfig = filterConfig;
    }//fin init

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest srequest = (HttpServletRequest) request;
        HttpServletResponse sResponse = (HttpServletResponse) response;
        
        HttpSession session = srequest.getSession(false);
        
        String url = ((HttpServletRequest)request).getRequestURL().toString();
        
        
        System.out.println("Url: " + url);
        
        
        

        if(session != null){
             int iUser = (session.getAttribute("user_rol") == null ? -1 :Integer.parseInt((String)session.getAttribute("user_rol")));
             
             //es usuario
             if(iUser == 1){
                 //StringBuilder forward = new StringBuilder();                        
            /*forward.append(url);
            forward.append(srequest.getQueryString());*/
               //  System.out.println("filtro: " + forward.toString());
            //request.getRequestDispatcher(forward.toString()).forward(request, response);

                 //sResponse.setStatus(301);
                         request.setCharacterEncoding("UTF-8");
                 
                    chain.doFilter(request, response);
              

                 
             }else{
                 ((HttpServletResponse) response).sendRedirect("../login.xhtml");
             }
        }//fin if
    }//fin doFilter

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}//fin clase
