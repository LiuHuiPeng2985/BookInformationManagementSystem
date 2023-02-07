package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User select(String username) throws SQLException;

    //注册
    Integer addUser(String username, String password);
}
