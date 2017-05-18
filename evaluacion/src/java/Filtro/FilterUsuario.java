/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtro;

import java.io.IOException;
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
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         this.filterConfig = filterConfig;
    }//fin init

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession(false);
        
           

        if(session != null){
             int iUser = (session.getAttribute("user_rol") == null ? -1 :Integer.parseInt((String)session.getAttribute("user_rol")));
             
             //es usuario
             if(iUser == 1){
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
