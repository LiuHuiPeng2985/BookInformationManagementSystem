package dao.impl;

import dao.BooksDao;
import entity.Books;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;

public class BooksDaoImpl implements BooksDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
    @Override
    public List<Books> queryAllBook() {
        try {
            //开启下划线->驼峰转换所用
            BeanProcessor bean = new GenerousBeanProcessor();
            RowProcessor processor = new BasicRowProcessor(bean);

            return queryRunner.query("select * from books",new BeanListHandler<>(Books.class,processor));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public int addBook(Books books) {
        try {
            return queryRunner.update("insert into books(book_name,book_counts,detail)values(?,?,?)", books.getBookName(), books.getBookCounts(), books.getDetail());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateBook(Books books) {
        try {
            return queryRunner.update("update books set book_name=?,book_counts=?,detail=?where book_id=?", books.getBookName(), books.getBookCounts(), books.getDetail(), books.getBookId());
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return 0;
    }

    @Override
    public Books queryBookByName(String bookName) {
        try {
            BeanProcessor bean = new GenerousBeanProcessor();
            RowProcessor processor = new BasicRowProcessor(bean);
            return queryRunner.query("select * from books where book_name=?",new BeanHandler<>(Books.class,processor),bookName);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteBookById(int id) {
        try {
            return queryRunner.update("delete from books where book_id=?",id);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return 0;
    }
}
