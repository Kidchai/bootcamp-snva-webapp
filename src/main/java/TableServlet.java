import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/table")
public class TableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<table border=\"1\">" +
                "<tr>" +
                    "<th>Id</th>" +
                    "<th>Name</th>" +
                    "<th>Price</th>" +
                "</tr>" +
                "<tr>" +
                    "<td>1</td>" +
                    "<td>Milk</td>" +
                    "<td>$3.99</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>2</td>" +
                    "<td>Bread</td>" +
                    "<td>$2.49</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>3</td>" +
                    "<td>Butter</td>" +
                    "<td>$1.99</td>" +
                "</tr>" +
                    "<td>4</td>" +
                    "<td>Cheese</td>" +
                    "<td>$4.99</td>" +
                "</table>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<table border=\"1\">" +
                "<tr>" +
                    "<th>Id</th>" +
                    "<th>Name</th>" +
                    "<th>Price</th>" +
                "</tr>" +
                "<tr>" +
                    "<td>1</td>" +
                    "<td>Milk</td>" +
                    "<td>$3.99</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>2</td>" +
                    "<td>Bread</td>" +
                    "<td>$2.49</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>3</td>" +
                    "<td>Butter</td>" +
                    "<td>$1.99</td>" +
                "</tr>" +
                    "<td>4</td>" +
                    "<td>Cheese</td>" +
                    "<td>$4.99</td>" +
                "</table>");

        pw.close();
    }
}
