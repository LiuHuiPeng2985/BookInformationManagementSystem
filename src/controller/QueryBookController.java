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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryBookController",urlPatterns = "/QueryBookController")
public class QueryBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String bookName = req.getParameter("bookName");
        BooksService booksService = new BooksServiceImpl();
        Books books = booksService.queryBookByName(bookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if (books!=null){
            req.setAttribute("allbooks",list);
            req.getRequestDispatcher("/allBook.jsp").forward(req,resp);
        }else {
            List<Books> allbooks = booksService.queryAllBook();
            req.setAttribute("allbooks",allbooks);
            req.getRequestDispatcher("/allBook.jsp").forward(req,resp);
        }
    }
}
