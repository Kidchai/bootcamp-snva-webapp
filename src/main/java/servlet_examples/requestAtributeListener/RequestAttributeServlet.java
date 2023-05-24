package servlet_examples.requestAtributeListener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requestAttributeServlet")
public class RequestAttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Hello! This is requestAttributeServlet servlet. Check the console for output.");

        request.setAttribute("user", "Anastasia");
        request.removeAttribute("user");

        request.setAttribute("city", "Moscow");
        request.setAttribute("city", "Philadelphia");
    }
}
