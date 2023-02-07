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

@WebServlet(name = "UpdateBookController",urlPatterns = "/UpdateBookController")
public class UpdateBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        String bookName = req.getParameter("bookName");
        Integer bookCounts = Integer.valueOf(req.getParameter("bookCounts"));
        String detail = req.getParameter("detail");
        Books books = new Books(bookId,bookName,bookCounts,detail);
        BooksService booksService = new BooksServiceImpl();
        booksService.updateBook(books);
        resp.sendRedirect(req.getContextPath()+"/queryAllBooksController");
    }
}
