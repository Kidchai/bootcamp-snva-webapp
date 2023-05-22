import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/configDemo"},
        initParams = {
                @WebInitParam(name = "driver", value = "com.mysql.jdbc.driver"),
                @WebInitParam(name = "dbName", value = "TestDb"),
                @WebInitParam(name = "userName", value = "root"),
                @WebInitParam(name = "password", value = "root")
        })
public class ConfigDemoServlet extends HttpServlet {
    private String driver;
    private String dbName;
    private String userName;
    private String password;

    public void init() throws ServletException {
        driver = getServletConfig().getInitParameter("driver");
        dbName = getServletConfig().getInitParameter("dbName");
        userName = getServletConfig().getInitParameter("userName");
        password = getServletConfig().getInitParameter("password");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.printf("""
                <h3>Driver: %s</h3>
                <h3>Database Name: %s</h3>
                <h3>User Name: %s</h3>
                <h3>Password: %s</h3>
                """, driver, dbName, userName, password);

        pw.close();
    }
}
