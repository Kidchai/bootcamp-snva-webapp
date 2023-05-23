package controller;

import DAO.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product(name, description, price, quantity);

        int status = ProductDao.save(product);

        if (status > 0) {
            pw.println("<p>Product saved successfully!</p>");
            request.getRequestDispatcher("new.html").include(request, response);
        } else {
            pw.println("<p>Sorry! Unable to save product</p>");
        }
    }
}
