package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3p0Utils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User select(String username) {
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        String sql = "select * from user where username = ?";
        User user = null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer addUser(String username, String password) {
        try {
            return queryRunner.update("insert into user(username,password) values(?,?)",username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
