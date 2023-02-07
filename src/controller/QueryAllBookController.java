package controller;

import entity.Books;
import service.BooksService;
import service.impl.BooksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllBookController",urlPatterns = "/queryAllBooksController")
public class QueryAllBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BooksService booksService = new BooksServiceImpl();
        List<Books> allbooks = booksService.queryAllBook();
        req.setAttribute("allbooks",allbooks);
        req.getRequestDispatcher("/allBook.jsp").forward(req,resp);
    }
}
