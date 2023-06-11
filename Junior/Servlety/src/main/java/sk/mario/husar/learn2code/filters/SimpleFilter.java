package sk.mario.husar.learn2code.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/*"},
        filterName = "SimpleFilter",
        initParams = {@WebInitParam(name = "name",value = "Mario")})
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("I am in filter");
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("name"));
        filterConfig.getServletContext().setAttribute("filter","ChangedContext");

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getSession().setAttribute("filterAttribute","filterPassed");
        filterChain.doFilter(request,servletResponse);
    }
}
