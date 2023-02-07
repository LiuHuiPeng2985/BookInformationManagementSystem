package service;

import entity.Books;

import java.util.List;

public interface BooksService {
    //查
    List<Books> queryAllBook();
    //添
    int addBook(Books books);
    //改
    int updateBook(Books books);
    //根据名字查询
    Books queryBookByName(String bookName);

    int deleteBookById(int id);
}
