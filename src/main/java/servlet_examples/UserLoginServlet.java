package servlet_examples;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (password.equals("admin")) {
            RequestDispatcher rd = request.getRequestDispatcher("welcome");
            rd.forward(request, response);
        } else {
            pw.println("Sorry incorrect name or password! Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("/userlogin.html");
            rd.include(request, response);
        }

        pw.close();
    }
}
