package controller;

import DAO.ProductDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit2")
public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product(name, description, price, quantity);

        int status = ProductDao.update(product);
        if (status > 0) {
            response.sendRedirect("view");
        } else {
            pw.println("<p>Sorry! Unable to update product</p>");
        }
    }
}
