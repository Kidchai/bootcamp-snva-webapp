import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/filterServlet")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter pw = response.getWriter();

        pw.println("Before<br>");
        chain.doFilter(request, response);
        pw.println("After");
    }
}
