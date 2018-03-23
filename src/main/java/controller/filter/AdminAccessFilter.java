/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.filter;

import controller.user.LoginController;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.User;

/**
 *
 * @author Mariam
 */
@WebFilter(filterName = "CustomerAccessFilter", urlPatterns = {"/admin/*"})
public class AdminAccessFilter implements Filter {
    private FilterConfig filterConfig = null;
    
    public AdminAccessFilter() {
    }    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session  = httpRequest.getSession(false);
        if(session == null || session.getAttribute(LoginController.USER_DATA)== null)
        {
            httpResponse.sendRedirect("../register.jsp");
        }else
        {
            User user  = (User)session.getAttribute(LoginController.USER_DATA);
            int userRole = user.getRole();
            if(userRole==1)
            {
                chain.doFilter(request, response);
            }else
            {
                System.out.println("you are not admin");
               httpResponse.sendRedirect("../NotAuthorized.jsp");
               //should put the equivlant page
            }
        }
            
      
       
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
       
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("CustomerAccessFilter()");
        }
        StringBuffer sb = new StringBuffer("CustomerAccessFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    

    
}
