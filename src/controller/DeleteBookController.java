package controller;

import service.BooksService;
import service.impl.BooksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteBookController",urlPatterns = "/deleteBook")
public class DeleteBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("bookId"));
        BooksService booksService = new BooksServiceImpl();
        booksService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/queryAllBooksController");
    }
}
