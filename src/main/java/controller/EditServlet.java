package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import DAO.ProductDao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDao productDao = new ProductDao();
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<h1>Edit Product</h1>");

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productDao.get(id);

        pw.printf("""
                <form action='edit2' method='post'>
                    <table>
                        <tr>
                            <td></td>
                            <td><input type='hidden' name='id' value='%d'></td>
                        <tr>
                            <td>Name:</td>
                            <td><input type='text' name='name' value='%s'></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><input type='text' name='description' value='%s'></td>
                        </tr>
                        <tr>
                            <td>Price:</td>
                            <td><input type='text' name='price' value='%d'></td>
                        </tr>
                        <tr>
                            <td>Quantity:</td>
                            <td><input type='text' name='quantity' value='%d'></td>
                        </tr>
                        <tr>
                            <td colspan='2'><input type='submit' value='Save'></td>
                        </tr>
                    </table>
                """, product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
        pw.close();
    }
}
