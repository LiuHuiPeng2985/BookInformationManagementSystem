package dao;

import entity.Books;

import java.util.List;

public interface BooksDao {

    List<Books> queryAllBook();

    int addBook(Books books);

    int updateBook(Books books);

    Books queryBookByName(String bookName);

    int deleteBookById(int id);
}
