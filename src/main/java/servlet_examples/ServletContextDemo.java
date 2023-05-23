package servlet_examples;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletContext")
public class ServletContextDemo extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        context.setAttribute("message", "Hi there! I am a message from the servlet context.");
        context.setAttribute("day", "Friday");

        String message = (String) context.getAttribute("message");
        String day = (String) context.getAttribute("day");

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        pw.printf("""
                <html>
                    <head>
                        <title>Servlet Context Demo</title>
                    </head>
                    <body>
                        <h1>Servlet Context Demo</h1>
                            <p>%s</p>
                            <p>Today is %s</p>
                    </body>
                </html>
                """, message, day);
        pw.close();
    }
}
