package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import DAO.ProductDao;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDao.delete(id);
        response.sendRedirect("view");
    }
}
