import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hiddenForm")
public class HiddenFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String username = request.getParameter("username");
        pw.printf("""
                <form action="second" method="get">
                    <input type="hidden" name="username" value="%s">
                    <input type="submit" value="GO">
                </form>
                """, username);

        pw.close();
    }
}
