package servlet_examples;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/genericServletDemo")
public class GenericServletDemo extends GenericServlet {
    private ServletConfig servletConfig;
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("Service method of GenericServletDemo servlet called.");
        response.getWriter().println("Hello! This is GenericServletDemo servlet. Check the console for output.");
    }

    public String getServletInfo() {
        return "GenericServletDemo";
    }

    public void init(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
        System.out.println("GenericServletDemo servlet initialized");
    }

    public void destroy() {
        System.out.println("GenericServletDemo servlet destroyed");
    }
}
