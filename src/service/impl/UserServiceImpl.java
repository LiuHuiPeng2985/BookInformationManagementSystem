package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.sql.SQLException;

//实现UserService
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /***
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        //根据用户名去数据库中查询
        User user = null;
        try {
            user = userDao.select(username);
            if (user!=null&&user.getPassword().equals(password)){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addUser(String username, String password) {
        Integer result = 0;
        try {
            result = userDao.addUser(username,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}