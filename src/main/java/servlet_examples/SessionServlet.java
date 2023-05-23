package servlet_examples;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String username = request.getParameter("username");
        pw.printf("Welcome, %s!", username);

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        pw.printf("<a href='sessionServlet2'>Go to the servlet_examples.SessionServlet2</a>");
        pw.close();
    }
}
