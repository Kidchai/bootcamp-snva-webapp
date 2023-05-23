package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import DAO.ProductDao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        pw.println("<a href='new.html'>Add product</a>");
        pw.println("<h2>Products</h2>");
        pw.println("""
                <table border="1" width="80%">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th></th>
                    <th></th>
                </tr>""");
        for (Product product : ProductDao.getAll()) {
            pw.printf("""
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>$%d</td>
                        <td>%d</td>
                        <td><a href='edit?id=%d'>Edit</a></td>
                        <td><a href='delete?id=%d'>Delete</a></td>
                    </tr>
                    """, product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity(), product.getId(), product.getId());
        }
        pw.println("</table>");
        pw.close();
    }
}
