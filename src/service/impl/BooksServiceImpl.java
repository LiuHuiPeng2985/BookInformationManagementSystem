package service.impl;

import dao.BooksDao;
import dao.impl.BooksDaoImpl;
import entity.Books;
import service.BooksService;

import java.util.ArrayList;
import java.util.List;

//实现BooksService
public class BooksServiceImpl implements BooksService {

    @Override
    public List<Books> queryAllBook() {
        List<Books> allbooks = new ArrayList<>();
        try {
            BooksDaoImpl booksDao = new BooksDaoImpl();
            List<Books> temps = booksDao.queryAllBook();
            if (temps != null){
                allbooks = temps;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allbooks;
    }

    @Override
    public int addBook(Books books) {
        int result = 0;
        try {
            BooksDaoImpl booksDao = new BooksDaoImpl();
            result = booksDao.addBook(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBook(Books books) {
        int result = 0;
        try {
            BooksDaoImpl booksDao = new BooksDaoImpl();
            result = booksDao.updateBook(books);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Books queryBookByName(String bookName) {
        Books books = null;
        try {
            BooksDaoImpl booksDao = new BooksDaoImpl();
            books = booksDao.queryBookByName(bookName);
        } catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int deleteBookById(int id) {
        int result = 0;
        try {
            BooksDaoImpl booksDao = new BooksDaoImpl();
            result = booksDao.deleteBookById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
