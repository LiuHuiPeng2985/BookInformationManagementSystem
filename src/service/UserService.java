package service;

import entity.User;

public interface UserService {
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    //注册
    Integer addUser(String username, String password);
}
