package controller;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginController",urlPatterns = "/login")
public class UserLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");
        //校验验证码
        HttpSession session = req.getSession();
        String codes = (String) session.getAttribute("codes");
        if (codes != null && codes.equals(inputVcode)){
            //验证码正确
            UserService userService = new UserServiceImpl();
            User user = userService.login(username,password);
            //正确账号密码
            if (user != null){
                System.out.println("登录成功");
                resp.sendRedirect(req.getContextPath()+"/queryAllBooksController");
            }
            //用户账号密码不正确
            else {
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }
        }
        else{
            //跳转到登录界面
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
    }
}
